package com.fuint.application.enums;

/**
 * 订单类型
 * Created by FSQ
 * Contact wx fsq_better
 * Site https://www.fuint.cn
 */
public enum OrderTypeEnum {
    PAYMENT("payment", "付款订单"),
    GOOGS("goods", "商品订单"),
    RECHARGE("recharge", "充值订单"),
    PRESTORE("prestore", "预存卡订单"),
    MEMBER("member", "会员升级订单");

    private String key;

    private String value;

    OrderTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
