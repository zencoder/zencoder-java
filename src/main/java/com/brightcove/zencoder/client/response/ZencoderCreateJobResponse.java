package com.brightcove.zencoder.client.response;

import java.util.List;

/**
 * @see https://app.zencoder.com/docs/api/jobs/create
 */
public class ZencoderCreateJobResponse {

    private String id;
    private List<ZencoderOutputResponse> outputs;
    private Boolean test;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ZencoderOutputResponse> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<ZencoderOutputResponse> outputs) {
        this.outputs = outputs;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }
}
