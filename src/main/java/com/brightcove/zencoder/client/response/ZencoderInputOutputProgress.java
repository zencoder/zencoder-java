package com.brightcove.zencoder.client.response;

import com.brightcove.zencoder.client.model.Event;
import com.brightcove.zencoder.client.model.State;

/**
 * @see https://app.zencoder.com/docs/api/inputs/progress
 * @see https://app.zencoder.com/docs/api/outputs/progress
 */
public class ZencoderInputOutputProgress {

    private String id;
    private State state;
    private Event current_event;
    private Double current_event_progress;
    private Double progress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Event getCurrentEvent() {
        return current_event;
    }

    public void setCurrentEvent(Event currentEvent) {
        this.current_event = currentEvent;
    }

    public Double getCurrentEventProgress() {
        return current_event_progress;
    }

    public void setCurrentEventProgress(Double currentEventProgress) {
        this.current_event_progress = currentEventProgress;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

}
