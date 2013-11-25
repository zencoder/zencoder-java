package com.brightcove.zencoder.client.account;

/**
 * @see https://app.zencoder.com/docs/api/accounts/show
 */
public enum ZencoderAccountState {

    ACTIVE("active"),
    STOPPED("stopped"),
    SUSPENDED("suspended"),
    CANCELLED("cancelled");

    private String name;

    ZencoderAccountState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
