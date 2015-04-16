package com.brightcove.zencoder.client.model;


/**
 * Job states include pending, waiting, processing, finished, failed, and cancelled.
 * Input states include pending, waiting, processing, finished, failed, and cancelled.
 * Output states include waiting, queued, assigning, ready, processing, finished, failed, cancelled and no input.
 * 
 * @see https://app.zencoder.com/docs/api/jobs/show
 * @see https://app.zencoder.com/docs/api/outputs/progress
 */
public enum State {

    PENDING("pending"),
    WAITING("waiting"),
    QUEUED("queued"),
    ASSIGNING("assigning"),
    READY("ready"),
    PROCESSING("processing"),
    FINISHED("finished"),
    FAILED("failed"),
    CANCELLED("cancelled"),
    NO_INPUT("no_input"),
    UPLOADING("uploading"),
    SKIPPED("skipped");

    private String name;

    State(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
