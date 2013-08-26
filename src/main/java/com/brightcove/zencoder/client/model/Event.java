package com.brightcove.zencoder.client.model;


/**
 * @see https://app.zencoder.com/docs/api/inputs/progress
 * @see https://app.zencoder.com/docs/api/outputs/progress
 */
public enum Event {

    DOWNLOADING("Downloading"),
    INSPECTING("Inspecting"),
    TRANSCODING("Transcoding"),
    UPLOADING("Uploading");

    private String name;

    Event(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
