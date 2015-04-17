package com.brightcove.zencoder.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @see https://app.zencoder.com/docs/api/encoding/thumbnails
 */
public class Thumbnail {

    private Long id;
    private String url;
    private Date created_at;
    private Date updated_at;
    private Long file_size_bytes;

    private String label;
    private String format;
    private Integer number;
    private Boolean start_at_first_frame;
    private Double interval;
    private Double interval_in_frames;
    private List<Integer> times = new ArrayList<Integer>();
    private AspectMode aspect_mode;
    private String size;
    private Integer width;
    private Integer height;
    private String base_url;
    private String prefix;
    private String filename;
    @JsonProperty("public") private Boolean publicMode;
    private List<S3AccessControl> access_control = new ArrayList<S3AccessControl>();
    private Boolean rrs;
    private Map<String, String> headers;
    private String credentials;
    private Integer parallel_upload_limit;

    /**
     * No-arg constructor needed for serialization/deserialization.
     */
    public Thumbnail() {
    }

    /**
     * @see https://app.zencoder.com/docs/api/encoding/thumbnails/thumbnails
     * @param label The label for this group of thumbnails
     */
    public Thumbnail(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Long getFileSizeBytes() {
        return file_size_bytes;
    }

    public void setFileSizeBytes(Long file_size_bytes) {
        this.file_size_bytes = file_size_bytes;
    }

    public List<S3AccessControl> getAccessControl() {
        return access_control;
    }

    public void setAccessControl(List<S3AccessControl> accessControl) {
        this.access_control = accessControl;
    }

    public AspectMode getAspectMode() {
        return aspect_mode;
    }

    public void setAspectMode(AspectMode aspectMode) {
        this.aspect_mode = aspectMode;
    }

    public String getBaseUrl() {
        return base_url;
    }

    public void setBaseUrl(String baseUrl) {
        this.base_url = baseUrl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getInterval() {
        return interval;
    }

    public void setInterval(Double interval) {
        this.interval = interval;
    }

    public Double getIntervalInFrames() {
        return interval_in_frames;
    }

    public void setIntervalInFrames(Double intervalInFrames) {
        this.interval_in_frames = intervalInFrames;
    }

    /**
     * NOTE: label and group_label are the same field.
     */
    public String getLabel() {
        return label;
    }

    /**
     * NOTE: label and group_label are the same field.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * NOTE: label and group_label are the same field.
     */
    public String getGroupLabel() {
        return label;
    }

    /**
     * NOTE: label and group_label are the same field.
     */
    public void setGroupLabel(String label) {
        this.label = label;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getParallelUploadLimit() {
        return parallel_upload_limit;
    }

    public void setParallelUploadLimit(Integer parallelUploadLimit) {
        this.parallel_upload_limit = parallelUploadLimit;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Boolean getPublicMode() {
        return publicMode;
    }

    public void setPublicMode(Boolean publicMode) {
        this.publicMode = publicMode;
    }

    public Boolean getRrs() {
        return rrs;
    }

    public void setRrs(Boolean rrs) {
        this.rrs = rrs;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getStartAtFirstFrame() {
        return start_at_first_frame;
    }

    public void setStartAtFirstFrame(Boolean startAtFirstFrame) {
        this.start_at_first_frame = startAtFirstFrame;
    }

    public List<Integer> getTimes() {
        return times;
    }

    public void setTimes(List<Integer> times) {
        this.times = times;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    
    public String getCredentials() {
        return credentials;
    }
    
    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getDimensions() {
        return width + "x" + height;
    }

    public void setDimensions(String dimensions) {
        if (dimensions != null && dimensions.contains("x")) {
            String[] pieces = dimensions.split("x");
            width = Integer.parseInt(pieces[0]);
            height = Integer.parseInt(pieces[1]);
        }
    }
}
