package com.brightcove.zencoder.client.model;


/**
 * @see https://app.zencoder.com/docs/api/encoding/resolution/aspect-mode
 */
public enum AspectMode {

    PRESERVE("preserve"),
    STRETCH("stretch"),
    CROP("crop"),
    PAD("pad");

    private String name;

    AspectMode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}