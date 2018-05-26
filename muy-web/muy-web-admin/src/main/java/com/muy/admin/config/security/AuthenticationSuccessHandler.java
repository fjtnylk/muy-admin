package com.muy.admin.config.security;

import com.muy.util.json.JSONUtil;
import com.muy.util.wrapper.WrapMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Slf4j
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {

    logger.info("登录成功");

    //String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    //
    //if (header == null || !header.startsWith(BEARER_TOKEN_TYPE)) {
    //	throw new UnapprovedClientAuthenticationException("请求头中无client信息");
    //}
    //
    //String[] tokens = RequestUtil.extractAndDecodeHeader(header);
    //assert tokens.length == 2;
    //
    //String clientId = tokens[0];
    //String clientSecret = tokens[1];
    //
    //ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
    //
    //if (clientDetails == null) {
    //	throw new UnapprovedClientAuthenticationException("clientId对应的配置信息不存在:" + clientId);
    //} else if (!StringUtils.equals(clientDetails.getClientSecret(), clientSecret)) {
    //	throw new UnapprovedClientAuthenticationException("clientSecret不匹配:" + clientId);
    //}
    //
    //TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId, clientDetails.getScope(), "custom");
    //
    //OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
    //
    //OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
    //
    //OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
    //SecurityUser principal = (SecurityUser) authentication.getPrincipal();
    //uacUserService.handlerLoginData(token, principal, request);

    //log.info("用户【 {} 】记录登录日志", principal.getUsername());

    String token = "token";
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(JSONUtil.toJSON(WrapMapper.ok(token)));
  }
}
