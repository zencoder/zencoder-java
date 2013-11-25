package com.brightcove.zencoder.client.account;

/**
 * @see https://app.zencoder.com/docs/api/accounts/show
 */
public class ZencoderAccountDetails {

    private ZencoderAccountState account_state;
    private String plan;
    private Long minutes_used;
    private Long minutes_included;
    private ZencoderBillingState billing_state;
    private Boolean integration_mode;

    /**
     * No-arg constructor needed for serialization/deserialization.
     */
    public ZencoderAccountDetails() {
    }

    public ZencoderAccountState getAccountState() {
        return account_state;
    }

    public void setAccountState(ZencoderAccountState account_state) {
        this.account_state = account_state;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Long getMinutesUsed() {
        return minutes_used;
    }

    public void setMinutesUsed(Long minutes_used) {
        this.minutes_used = minutes_used;
    }

    public Long getMinutesIncluded() {
        return minutes_included;
    }

    public void setMinutesIncluded(Long minutes_included) {
        this.minutes_included = minutes_included;
    }

    public ZencoderBillingState getBillingState() {
        return billing_state;
    }

    public void setBillingState(ZencoderBillingState billing_state) {
        this.billing_state = billing_state;
    }

    public Boolean getIntegrationMode() {
        return integration_mode;
    }

    public void setIntegrationMode(Boolean integration_mode) {
        this.integration_mode = integration_mode;
    }

}
