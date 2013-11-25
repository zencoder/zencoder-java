package com.brightcove.zencoder.client.account;

public class ZencoderAccount {

    private String email;
    private Integer terms_of_service;
    private String password;

    /**
     * No-arg constructor needed for serialization/deserialization.
     */
    public ZencoderAccount() {
    }

    /**
     * All that is required is an email address and an agreement to the terms of service (http://zencoder.com/en/terms).
     * You can also send a password, but if you don't one will be generated.
     * New accounts will be created under the Test (Free) plan.
     *
     * @param email The email address for the account (must be unique).
     * @param terms_of_service By passing '1' you agree to the terms of service.
     * @see http://zencoder.com/en/terms
     */
    public ZencoderAccount(String email, Integer terms_of_service) {
        this.email = email;
        this.terms_of_service = terms_of_service;
    }

    /**
     * All that is required is an email address and an agreement to the terms of service (http://zencoder.com/en/terms).
     * You can also send a password, but if you don't one will be generated.
     * New accounts will be created under the Test (Free) plan.
     *
     * @param email The email address for the account (must be unique).
     * @param terms_of_service By passing '1' you agree to the terms of service.
     * @param password The password to use for this account.
     * @see http://zencoder.com/en/terms
     */
    public ZencoderAccount(String email, Integer terms_of_service, String password) {
        this.email = email;
        this.terms_of_service = terms_of_service;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTermsOfService() {
        return terms_of_service;
    }

    /**
     * @see http://zencoder.com/en/terms
     * @param terms_of_service By passing '1' you agree to the terms of service.
     */
    public void setTermsOfService(Integer terms_of_service) {
        this.terms_of_service = terms_of_service;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
