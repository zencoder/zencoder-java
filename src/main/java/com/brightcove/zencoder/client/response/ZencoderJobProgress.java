package com.brightcove.zencoder.client.response;

import java.util.List;

import com.brightcove.zencoder.client.model.State;

/**
 * @see https://app.zencoder.com/docs/api/jobs/progress
 * @see https://app.zencoder.com/docs/api/inputs/progress
 * @see https://app.zencoder.com/docs/api/outputs/progress
 */
public class ZencoderJobProgress {

    private State state;

    private Double progress;

    private ZencoderInputOutputProgress input;

    private List<ZencoderInputOutputProgress> outputs;

    public ZencoderInputOutputProgress getInput() {
        return input;
    }

    public void setInput(ZencoderInputOutputProgress input) {
        this.input = input;
    }

    public List<ZencoderInputOutputProgress> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<ZencoderInputOutputProgress> outputs) {
        this.outputs = outputs;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
