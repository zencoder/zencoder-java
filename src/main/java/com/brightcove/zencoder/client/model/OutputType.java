package com.brightcove.zencoder.client.model;


/**
 * @see https://app.zencoder.com/docs/api/encoding/general-output-settings/type
 */
public enum OutputType {

    STANDARD("standard"),
    SEGMENTED("segmented"),
    PLAYLIST("playlist"),
    TRANSFER_ONLY("transfer-only");

    private String name;

    OutputType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
