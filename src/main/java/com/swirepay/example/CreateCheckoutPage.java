package com.swirepay.example;

import java.util.List;

public class CreateCheckoutPage {
    private Long amount;

    private CurrencyCode currencyCode;

    private List<String> paymentMethodType;

    private String redirectUri;

    private Integer sessionTimeout;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<String> getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(List<String> paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
