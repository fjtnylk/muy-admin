package com.muy.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/17.
 */
@Data
@Builder
public class UMCLoadDashboardVO implements Serializable {
  private List<SalesVO> sales;
  private CpuVO cpu;
  private List<BrowserVO> browser;
  private UserVO user;
  private List<CompletedVO> completed;
  private List<CommentsVO> comments;
  @JsonProperty("recentSales")
  private List<RecentSalesVO> recentSales;
  private QuoteVO quote;
  private List<NumbersVO> numbers;

  public void init() {
    init4Sales();
    initCPU();
    init4Browser();
    init4User();
    init4Completed();
    init4Comments();
    init4RecentSales();
    init4Quote();
    init4Number();
  }

  private void init4Sales() {
    this.sales =
        Lists.newArrayList(
            SalesVO.builder().name("2008").clothes("253").food("302").electronics("427").build(),
            SalesVO.builder().name("2009").clothes("459").food("186").electronics("357").build(),
            SalesVO.builder().name("2010").clothes("362").food("322").electronics("479").build(),
            SalesVO.builder().name("2011").clothes("500").food("373").electronics("464").build(),
            SalesVO.builder().name("2012").clothes("207").food("245").electronics("473").build());
  }

  private void initCPU() {
    this.cpu =
        CpuVO.builder()
            .usage(351)
            .space(825)
            .cpu(55)
            .data(
                Lists.newArrayList(
                    CpuVO.CPUData.builder().cpu("59").build(),
                    CpuVO.CPUData.builder().cpu("33").build(),
                    CpuVO.CPUData.builder().cpu("28").build(),
                    CpuVO.CPUData.builder().cpu("61").build(),
                    CpuVO.CPUData.builder().cpu("68").build()))
            .build();
  }

  private void init4Browser() {
    this.browser =
        Lists.newArrayList(
            BrowserVO.builder().name("Google Chrome").percent("43.3").status("1").build(),
            BrowserVO.builder().name("Mozilla Firefox").percent("33.4").status("2").build(),
            BrowserVO.builder().name("Apple Safari").percent("34.6").status("3").build(),
            BrowserVO.builder().name("Internet Explorer").percent("12.3").status("4").build(),
            BrowserVO.builder().name("Opera Mini").percent("3.3").status("1").build());
  }

  private void init4User() {
    this.user =
        UserVO.builder()
            .name("yanglikai")
            .email("fjtnylk@126.com")
            .sales(3241)
            .sold(3556)
            .avatar("http://tva4.sinaimg.cn/crop.0.0.996.996.180/6ee6a3a3jw8f0ks5pk7btj20ro0rodi0.jpg")
            .build();
  }

  private void init4Completed() {
    this.completed =
        Lists.newArrayList(
            CompletedVO.builder().name("2008").taskComplete("340").cardsComplete("942").build(),
            CompletedVO.builder().name("2009").taskComplete("773").cardsComplete("385").build(),
            CompletedVO.builder().name("2010").taskComplete("529").cardsComplete("622").build(),
            CompletedVO.builder().name("2012").taskComplete("504").cardsComplete("244").build(),
            CompletedVO.builder().name("2013").taskComplete("586").cardsComplete("545").build());
  }

  private void init4Comments() {
    this.comments =
        Lists.newArrayList(
            CommentsVO.builder().name("Williams").status("1").content("Hcnkh hhmyxlfo npslskun elldddl rxllsn vpm ohvuzxsbu qnjfus tnabkvv jpv cdtdkl vlwnponddb lvkxhxeny.").avatar("http://dummyimage.com/48x48/89f279/757575.png&text=W").date("2016-12-22 10:38:50").build(),
            CommentsVO.builder().name("Moore").status("1").content("Qnsbxoqgs vetayeuz ilrmdoyhs ryihgsjeq efdt hza qfjicpx tnucig shnfdjsvn oarl ibnqoct cmvaxrnj xjoncrydg tcojsw cxtwi mpnp rdzksc rgeipf.").avatar("http://dummyimage.com/48x48/89f279/757575.png&text=W").date("2016-12-22 10:38:50").build(),
            CommentsVO.builder().name("Rodriguez").status("2").content("Hcnkh hhmyxlfo npslskun elldddl rxllsn vpm ohvuzxsbu qnjfus tnabkvv jpv cdtdkl vlwnponddb lvkxhxeny.").avatar("http://dummyimage.com/48x48/89f279/757575.png&text=W").date("2016-12-22 10:38:50").build(),
            CommentsVO.builder().name("Davis").status("2").content("Hcnkh hhmyxlfo npslskun elldddl rxllsn vpm ohvuzxsbu qnjfus tnabkvv jpv cdtdkl vlwnponddb lvkxhxeny.").avatar("http://dummyimage.com/48x48/89f279/757575.png&text=W").date("2016-12-22 10:38:50").build(),
            CommentsVO.builder().name("Martin").status("1").content("Hcnkh hhmyxlfo npslskun elldddl rxllsn vpm ohvuzxsbu qnjfus tnabkvv jpv cdtdkl vlwnponddb lvkxhxeny.").avatar("http://dummyimage.com/48x48/89f279/757575.png&text=W").date("2016-12-22 10:38:50").build());
  }

  private void init4RecentSales() {
    this.recentSales =
        Lists.newArrayList(
            RecentSalesVO.builder().id("1").name("Johnson").status("2").price("57.34").date("2015-08-30 22:23:41").build(),
            RecentSalesVO.builder().id("2").name("Gonzalez").status("4").price("86.34").date("2015-08-30 22:23:41").build(),
            RecentSalesVO.builder().id("3").name("Anderson").status("2").price("57.34").date("2015-08-30 22:23:41").build(),
            RecentSalesVO.builder().id("4").name("Johnson").status("2").price("57.34").date("2015-08-30 22:23:41").build(),
            RecentSalesVO.builder().id("5").name("Miller").status("2").price("57.34").date("2015-08-30 22:23:41").build());
  }

  private void init4Quote() {
    this.quote =
        QuoteVO.builder()
            .name("Joho Doe")
            .title("Graphic Designer")
            .content("I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.")
            .avatar("http://img.hb.aicdn.com/bc442cf0cc6f7940dcc567e465048d1a8d634493198c4-sPx5BR_fw236")
            .build();
  }

  private void init4Number() {
    this.numbers =
        Lists.newArrayList(
            NumbersVO.builder().icon("pay-circle-o").color("#64ea91").title("Online Review").number(2781).build(),
            NumbersVO.builder().icon("team").color("#8fc9fb").title("New Customers").number(3241).build(),
            NumbersVO.builder().icon("message").color("#d897eb").title("Active Projects").number(253).build(),
            NumbersVO.builder().icon("shopping-cart").color("#f69899").title("Referrals").number(2781).build());
  }

  /**
   * 销售
   */
  @Data
  @Builder
  public static class SalesVO implements Serializable {
    private String name;
    @JsonProperty(value = "Clothes")
    private String clothes;
    @JsonProperty(value = "Food")
    private String food;
    @JsonProperty(value = "Electronics")
    private String electronics;
  }

  /**
   * CPU
   */
  @Data
  @Builder
  public static class CpuVO implements Serializable {
    private Integer usage;
    private Integer space;
    private Integer cpu;
    private List<CPUData> data;

    @Data
    @Builder
    public static class CPUData implements Serializable {
      private String cpu;
    }
  }

  /**
   * 浏览器
   */
  @Data
  @Builder
  public static class BrowserVO implements Serializable {
    private String name;
    private String percent;
    private String status;
  }

  /**
   * 用户
   */
  @Data
  @Builder
  public static class UserVO implements Serializable {
    private String name;
    private String email;
    private Integer sales;
    private Integer sold;
    private String avatar;
  }

  /**
   * 完成
   */
  @Data
  @Builder
  public static class CompletedVO implements Serializable {
    private String name;
    @JsonProperty("Task complete")
    private String taskComplete;
    @JsonProperty("Cards Complete")
    private String cardsComplete;
  }

  /**
   * 评论
   */
  @Data
  @Builder
  public static class CommentsVO implements Serializable {
    private String name;
    private String status;
    private String content;
    private String avatar;
    private String date;
  }

  /**
   * 最近销售
   */
  @Data
  @Builder
  public static class RecentSalesVO implements Serializable {
    private String id;
    private String name;
    private String status;
    private String price;
    private String date;
  }

  /**
   * 报价
   */
  @Data
  @Builder
  public static class QuoteVO implements Serializable {
    private String name;
    private String title;
    private String content;
    private String avatar;
  }

  /**
   * 数值
   */
  @Data
  @Builder
  public static class NumbersVO implements Serializable {
    private String icon;
    private String color;
    private String title;
    private Integer number;
  }
}
