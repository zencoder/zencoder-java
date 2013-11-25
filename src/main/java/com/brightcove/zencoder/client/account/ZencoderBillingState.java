package com.brightcove.zencoder.client.account;


/**
 * @see https://app.zencoder.com/docs/api/accounts/show
 */
public enum ZencoderBillingState {

    ACTIVE("active"),
    PAST_DUE("past_due"),
    CANCELLED("cancelled"),
    NONE("none");

    private String name;

    ZencoderBillingState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
