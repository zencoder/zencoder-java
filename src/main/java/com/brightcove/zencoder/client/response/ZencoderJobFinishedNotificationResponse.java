/**
 * Copyright (C) 2013 Brightcove Inc. All Rights Reserved. No use, copying or distribution of this
 * work may be made except in accordance with a valid license agreement from Brightcove Inc. This
 * notice must be included on all copies, modifications and derivatives of this work.
 * 
 * Brightcove Inc MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BRIGHTCOVE SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS
 * SOFTWARE OR ITS DERIVATIVES.
 * 
 * "Brightcove" is a registered trademark of Brightcove Inc.
 */
package com.brightcove.zencoder.client.response;

import java.util.Collection;

import com.brightcove.zencoder.client.request.ZencoderOutput;
import com.brightcove.zencoder.client.response.ZencoderJobDetail;
import com.brightcove.zencoder.client.response.ZencoderMediaFile;

public class ZencoderJobFinishedNotificationResponse {

    private ZencoderJobDetail job;
    private Collection<ZencoderOutput> outputs;
    private ZencoderMediaFile input;

    public void setJob(ZencoderJobDetail jobDetail) {
        this.job = jobDetail;
    }

    public ZencoderJobDetail getJob() {
        return job;
    }

    public void setOutputs(Collection<ZencoderOutput> outputs) {
        this.outputs = outputs;
    }

    public Collection<ZencoderOutput> getOutputs() {
        return outputs;
    }

    public void setInput(ZencoderMediaFile mediaFile) {
        this.input = mediaFile;
    }

    public ZencoderMediaFile getInput() {
        return input;
    }
}
