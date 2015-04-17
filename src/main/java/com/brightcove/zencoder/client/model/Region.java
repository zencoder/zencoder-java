package com.brightcove.zencoder.client.model;


/**
 * @see https://app.zencoder.com/docs/api/encoding/job/region
 */
public enum Region {

    US("us"),
    EUROPE("europe"),
    ASIA("asia"),
    SA("sa"),
    US_VIRGINIA("us-virginia"),
    US_OREGON("us-oregon"),
    US_N_CALIFORNIA("us-n-california"),
    EU_DUBLIN("eu-dublin"),
    ASIA_SINGAPORE("asia-singapore"),
    ASIA_TOKYO("asia-tokyo"),
    AUSTRALIA_SYDNEY("australia-sydney"),
    SA_SAOPAULO("sa-saopaulo");

    private String name;

    Region(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
