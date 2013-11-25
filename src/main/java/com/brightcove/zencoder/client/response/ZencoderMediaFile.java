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

import com.brightcove.zencoder.client.model.AudioCodec;
import com.brightcove.zencoder.client.model.ContainerFormat;
import com.brightcove.zencoder.client.model.State;
import com.brightcove.zencoder.client.model.ThumbnailCollection;
import com.brightcove.zencoder.client.model.VideoCodec;

/**
 * @see https://app.zencoder.com/docs/api/jobs/show
 */
public class ZencoderMediaFile {

    private Date created_at;
    private Date finished_at;
    private Date updated_at;
    private Date submitted_at;

    private String id;
    private String label;
    private String url;
    private String job_id;
    private Boolean privacy;
    private Boolean test;
    private State state;
    private String error_message;
    private String error_class;
    private Boolean backup_server_used;
    private String primary_upload_error_link;
    private String primary_upload_error_message;
    private String primary_thumbnail_upload_error_link;
    private String primary_thumbnail_upload_error_message;

    private ContainerFormat format;
    private Long duration_in_ms;
    private Integer total_bitrate_in_kbps;

    private Long file_size_in_bytes;
    private String md5_checksum;

    private Integer height;
    private Integer width;
    private VideoCodec video_codec;
    private Integer video_bitrate_in_kbps;
    private Double frame_rate;

    private AudioCodec audio_codec;
    private Integer audio_bitrate_in_kbps;
    private Integer audio_sample_rate;
    private Integer channels;

    private List<ThumbnailCollection> thumbnails;

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt;
    }

    public Date getFinishedAt() {
        return finished_at;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finished_at = finishedAt;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updated_at = updatedAt;
    }

    public Date getSubmittedAt() {
        return submitted_at;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submitted_at = submittedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJobId() {
        return job_id;
    }

    public void setJobId(String job_id) {
        this.job_id = job_id;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getErrorMessage() {
        return error_message;
    }

    public void setErrorMessage(String error_message) {
        this.error_message = error_message;
    }

    public String getErrorClass() {
        return error_class;
    }

    public void setErrorClass(String error_class) {
        this.error_class = error_class;
    }

    public Boolean getBackupServerUsed() {
        return backup_server_used;
    }

    public void setBackupServerUsed(Boolean backup_server_used) {
        this.backup_server_used = backup_server_used;
    }

    public String getPrimaryUploadErrorLink() {
        return primary_upload_error_link;
    }

    public void setPrimaryUploadErrorLink(String primary_upload_error_link) {
        this.primary_upload_error_link = primary_upload_error_link;
    }

    public String getPrimaryUploadErrorMessage() {
        return primary_upload_error_message;
    }

    public void setPrimaryUploadErrorMessage(String primary_upload_error_message) {
        this.primary_upload_error_message = primary_upload_error_message;
    }

    public String getPrimaryThumbnailUploadErrorLink() {
        return primary_thumbnail_upload_error_link;
    }

    public void setPrimaryThumbnailUploadErrorLink(String primary_thumbnail_upload_error_link) {
        this.primary_thumbnail_upload_error_link = primary_thumbnail_upload_error_link;
    }

    public String getPrimaryThumbnailUploadErrorMessage() {
        return primary_thumbnail_upload_error_message;
    }

    public void setPrimaryThumbnailUploadErrorMessage(String primary_thumbnail_upload_error_message) {
        this.primary_thumbnail_upload_error_message = primary_thumbnail_upload_error_message;
    }

    public ContainerFormat getFormat() {
        return format;
    }

    public void setFormat(ContainerFormat format) {
        this.format = format;
    }

    public Long getDurationInMs() {
        return duration_in_ms;
    }

    public void setDurationInMs(Long duration_in_ms) {
        this.duration_in_ms = duration_in_ms;
    }

    public Integer getTotalBitrateInKbps() {
        return total_bitrate_in_kbps;
    }

    public void setTotalBitrateInKbps(Integer total_bitrate_in_kbps) {
        this.total_bitrate_in_kbps = total_bitrate_in_kbps;
    }

    /**
     * NOTE: file_size_in_bytes and file_size_bytes are identical.
     * This is an API naming consistency issue that will be resolved in v3.
     */
    public Long getFileSizeBytes() {
        return file_size_in_bytes;
    }

    /**
     * NOTE: file_size_in_bytes and file_size_bytes are identical.
     * This is an API naming consistency issue that will be resolved in v3.
     */
    public void setFileSizeBytes(Long file_size_bytes) {
        this.file_size_in_bytes = file_size_bytes;
    }

    /**
     * NOTE: file_size_in_bytes and file_size_bytes are identical.
     * This is an API naming consistency issue that will be resolved in v3.
     */
    public Long getFileSizeInBytes() {
        return file_size_in_bytes;
    }

    /**
     * NOTE: file_size_in_bytes and file_size_bytes are identical.
     * This is an API naming consistency issue that will be resolved in v3.
     */
    public void setFileSizeInBytes(Long file_size_bytes) {
        this.file_size_in_bytes = file_size_bytes;
    }

    public String getMd5Checksum() {
        return md5_checksum;
    }

    public void setMd5Checksum(String md5_checksum) {
        this.md5_checksum = md5_checksum;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public VideoCodec getVideoCodec() {
        return video_codec;
    }

    public void setVideoCodec(VideoCodec video_codec) {
        this.video_codec = video_codec;
    }

    public Integer getVideoBitrateInKbps() {
        return video_bitrate_in_kbps;
    }

    public void setVideoBitrateInKbps(Integer video_bitrate_in_kbps) {
        this.video_bitrate_in_kbps = video_bitrate_in_kbps;
    }

    public Double getFrameRate() {
        return frame_rate;
    }

    public void setFrameRate(Double frame_rate) {
        this.frame_rate = frame_rate;
    }

    public AudioCodec getAudioCodec() {
        return audio_codec;
    }

    public void setAudioCodec(AudioCodec audio_codec) {
        this.audio_codec = audio_codec;
    }

    public Integer getAudioBitrateInKbps() {
        return audio_bitrate_in_kbps;
    }

    public void setAudioBitrateInKbps(Integer audio_bitrate_in_kbps) {
        this.audio_bitrate_in_kbps = audio_bitrate_in_kbps;
    }

    public Integer getAudioSampleRate() {
        return audio_sample_rate;
    }

    public void setAudioSampleRate(Integer audio_sample_rate) {
        this.audio_sample_rate = audio_sample_rate;
    }

    public Integer getChannels() {
        return channels;
    }

    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    public List<ThumbnailCollection> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<ThumbnailCollection> thumbnails) {
        this.thumbnails = thumbnails;
    }

}
