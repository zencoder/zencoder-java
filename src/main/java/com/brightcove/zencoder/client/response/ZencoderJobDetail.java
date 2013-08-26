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

import java.util.Date;
import java.util.List;

import com.brightcove.zencoder.client.model.State;
import com.brightcove.zencoder.client.model.Thumbnail;

/**
 * @see https://app.zencoder.com/docs/api/jobs/show
 */
public class ZencoderJobDetail {

    private Date created_at;
    private Date finished_at;
    private Date updated_at;
    private Date submitted_at;

    private String id;
    private String pass_through;
    private Boolean test;
    private Boolean privacy;
    private State state;

    private ZencoderMediaFile input_media_file;
    private List<ZencoderMediaFile> output_media_files;
    private List<Thumbnail> thumbnails;

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getFinishedAt() {
        return finished_at;
    }

    public void setFinishedAt(Date finished_at) {
        this.finished_at = finished_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getSubmittedAt() {
        return submitted_at;
    }

    public void setSubmittedAt(Date submitted_at) {
        this.submitted_at = submitted_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassThrough() {
        return pass_through;
    }

    public void setPassThrough(String pass_through) {
        this.pass_through = pass_through;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ZencoderMediaFile getInputMediaFile() {
        return input_media_file;
    }

    public void setInputMediaFile(ZencoderMediaFile input_media_file) {
        this.input_media_file = input_media_file;
    }

    public List<ZencoderMediaFile> getOutputMediaFiles() {
        return output_media_files;
    }

    public void setOutputMediaFiles(List<ZencoderMediaFile> output_media_files) {
        this.output_media_files = output_media_files;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }
}
