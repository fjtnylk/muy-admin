package com.muy.security.core.authentication.sms;

import com.muy.security.core.SecurityConstant;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 短信登录过滤器.
 * <p>
 * Created by yanglikai on 2018/5/25.
 */
public class SMSAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  public static final String SPRING_SECURITY_FORM_MOBILE = "mobile";

  private String mobileParameter = SPRING_SECURITY_FORM_MOBILE;
  private boolean postOnly = true;

  public SMSAuthenticationFilter() {
    super(new AntPathRequestMatcher(SecurityConstant.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE, "POST"));
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
    if (postOnly && !request.getMethod().equals("POST")) {
      throw new AuthenticationServiceException(
          "Authentication method not supported: " + request.getMethod());
    }

    String mobile = obtainMobile(request);

    if (mobile == null) {
      mobile = "";
    }

    mobile = mobile.trim();

    SMSAuthenticationToken authRequest = new SMSAuthenticationToken(mobile);

    setDetails(request, authRequest);

    return this.getAuthenticationManager().authenticate(authRequest);
  }

  protected String obtainMobile(HttpServletRequest request) {
    return request.getParameter(mobileParameter);
  }

  protected void setDetails(HttpServletRequest request, SMSAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }
}
