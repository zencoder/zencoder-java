package com.brightcove.zencoder.client.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.brightcove.zencoder.client.model.AACProfile;
import com.brightcove.zencoder.client.model.AspectMode;
import com.brightcove.zencoder.client.model.AsperaTransferPolicy;
import com.brightcove.zencoder.client.model.AudioCodec;
import com.brightcove.zencoder.client.model.ContainerFormat;
import com.brightcove.zencoder.client.model.CuePoint;
import com.brightcove.zencoder.client.model.EncryptionMethod;
import com.brightcove.zencoder.client.model.H264Level;
import com.brightcove.zencoder.client.model.H264Profile;
import com.brightcove.zencoder.client.model.Notification;
import com.brightcove.zencoder.client.model.OutputType;
import com.brightcove.zencoder.client.model.PackageFormat;
import com.brightcove.zencoder.client.model.S3AccessControl;
import com.brightcove.zencoder.client.model.SegmentedStream;
import com.brightcove.zencoder.client.model.SegmentingType;
import com.brightcove.zencoder.client.model.Thumbnail;
import com.brightcove.zencoder.client.model.VP6CompressionMode;
import com.brightcove.zencoder.client.model.VP6DeinterlaceMode;
import com.brightcove.zencoder.client.model.VP6Profile;
import com.brightcove.zencoder.client.model.VideoCodec;
import com.brightcove.zencoder.client.model.Watermark;

/**
 * @see https://app.zencoder.com/docs/api/encoding
 * @see https://app.zencoder.com/docs/api/encoding/job/outputs
 */
public class ZencoderOutput {

    // Metadata
    private Date created_at;
    private Date finished_at;
    private Date updated_at;
    private Date submitted_at;
    
    // General Output Settings - https://app.zencoder.com/docs/api/encoding/general-output-settings
    private OutputType type;
    private String label;
    private String url;
    private String secondary_url;
    private String base_url;
    private String filename;
    private String package_filename;
    private PackageFormat package_format;
    private String device_profile;
    private Boolean strict;
    private Boolean skip_video;
    private Boolean skip_audio;
    private String source;
    private String credentials;
    private Boolean generate_md5_checksum;
    private Integer parallel_upload_limit;
    private Map<String, String> headers;
    
    // Formats and Codecs - https://app.zencoder.com/docs/api/encoding/format-and-codecs
    private ContainerFormat format;
    private VideoCodec video_codec;
    private AudioCodec audio_codec;
    
    // Resolution - https://app.zencoder.com/docs/api/encoding/resolution
    private String size;
    private Integer width;
    private Integer height;
    private Boolean upscale;
    private AspectMode aspect_mode;
    
    // Rate Control - https://app.zencoder.com/docs/api/encoding/rate-control
    private Integer quality;
    private Integer video_bitrate;
    private Integer audio_quality;
    private Integer audio_bitrate;
    private Long max_video_bitrate;
    private Integer speed;
    private Long decoder_bitrate_cap;
    private Long decoder_buffer_size;
    private Boolean one_pass;
    private Boolean audio_constant_bitrate;
    
    // Frame Rate - https://app.zencoder.com/docs/api/encoding/frame-rate
    private Double frame_rate;
    private Double max_frame_rate;
    private Integer decimate;
    private Integer keyframe_interval;
    private Double keyframe_rate;
    private Boolean fixed_keyframe_interval;
    private Double forced_keyframe_rate;
    
    // Audio - https://app.zencoder.com/docs/api/encoding/audio
    private Long audio_sample_rate;
    private Long max_audio_sample_rate;
    private Integer audio_channels;

    // Thumbnails - https://app.zencoder.com/docs/api/encoding/thumbnails
    private List<Thumbnail> thumbnails = new ArrayList<Thumbnail>();
    
    // Watermarks - https://app.zencoder.com/docs/api/encoding/watermarks
    private List<Watermark> watermarks = new ArrayList<Watermark>();

    // Captions - https://app.zencoder.com/docs/api/encoding/captions
    private String caption_url;
    private Boolean skip_captions;

    // Live Streaming - https://app.zencoder.com/docs/api/encoding/live-streaming
    private Boolean live_stream;
    private Integer live_sliding_window_duration;
    
    // Video Processing
    private Integer rotate;
    private String deinterlace;
    private Boolean sharpen;
    private Boolean denoise;
    private Boolean autolevel;
    private Boolean deblock;

    // Audio Processing
    private Integer audio_gain;
    private Boolean audio_normalize;
    private Boolean audio_pre_normalize;
    private Boolean audio_post_normalize;
    private Integer audio_bass;
    private Integer audio_treble;
    private Integer audio_highpass;
    private Integer audio_lowpass;
    private Double audio_compression_ratio;
    private Integer audio_compression_threshold;
    private Double audio_expansion_ratio;
    private Integer audio_expansion_threshold;
    private Double audio_fade;
    private Double audio_fade_in;
    private Double audio_fade_out;
    private Boolean audio_karaoke_mode;

    // Clips
    // TODO: these should be a timecode (HH:MM:SS.S) or positive number indicating seconds
    private String start_clip;
    private String clip_length;

    // Notifications
    private List<Notification> notifications = new ArrayList<Notification>();

    // S3 settings - https://app.zencoder.com/docs/api/encoding/s3-settings
    @JsonProperty("public") private Boolean publicMode;
    private Boolean rrs;
    private S3AccessControl access_control;

    // Conditionals - https://app.zencoder.com/docs/api/encoding/conditional-outputs
    private String min_size;
    private String max_size;
    private Integer min_duration;
    private Integer max_duration;

    // Segmented Streaming - https://app.zencoder.com/docs/api/encoding/segmented-streaming
    private Integer segment_seconds;
    private Integer segment_size;
    private List<SegmentedStream> streams = new ArrayList<SegmentedStream>();
    private String segment_image_file;
    private Boolean segment_video_snapshots;
    private Integer max_hls_protocol_version;
    private Boolean hls_optimized_ts;
    private SegmentingType prepare_for_segmenting;
    private Boolean instant_play;
    private String smil_base_url;

    // Encryption - https://app.zencoder.com/docs/api/encoding/encryption
    private EncryptionMethod encryption_method;
    private String encryption_key;
    private String encryption_key_url;
    private Integer encryption_key_rotation_period;
    private String encryption_key_url_prefix;
    private String encryption_iv;
    private String encryption_password;

    // H264 - https://app.zencoder.com/docs/api/encoding/h264
    private String h264_reference_frames;
    private H264Profile h264_profile;
    private H264Level h264_level;
    private Integer h264_bframes;
    private String tuning;
    private Integer crf;

    // FLV - https://app.zencoder.com/docs/api/encoding/flv
    private List<CuePoint> cue_points = new ArrayList<CuePoint>();

    // VP6 - https://app.zencoder.com/docs/api/encoding/vp6
    private Integer vp6_temporal_down_watermark;
    private Boolean vp6_temporal_resampling;
    private Integer vp6_undershoot_pct;
    private VP6Profile vp6_profile;
    private VP6CompressionMode vp6_compression_mode;
    private Integer vp6_2pass_min_section;
    private Integer vp6_2pass_max_section;
    private Integer vp6_stream_prebuffer;
    private Integer vp6_stream_max_buffer;
    private VP6DeinterlaceMode vp6_deinterlace_mode;
    private Float vp6_denoise_level;

    // MP4 - https://app.zencoder.com/docs/api/encoding/mp4
    private Boolean hint;
    private Integer mtu_size;

    // AAC - https://app.zencoder.com/docs/api/encoding/aac
    private AACProfile max_aac_profile;
    private AACProfile force_aac_profile;

    // Aspera - https://app.zencoder.com/docs/api/encoding/aspera
    private AsperaTransferPolicy aspera_transfer_policy;
    private Integer transfer_minimum_rate;
    private Integer transfer_maximum_rate;

    // Transmuxing - https://app.zencoder.com/docs/api/encoding/transmuxing
    private Boolean copy_audio;
    private Boolean copy_video;

    /**
     * @see https://app.zencoder.com/docs/api/encoding
     */
    public ZencoderOutput() {
    }

    /**
     * @see https://app.zencoder.com/docs/api/encoding
     * @param url A S3, Cloud Files, FTP, FTPS, SFTP, Aspera, HTTP, or RTMP URL where we'll put the transcoded file.
     */
    public ZencoderOutput(String url) {
        this.url = url;
    }

    public S3AccessControl getAccessControl() {
        return access_control;
    }

    public void setAccessControl(S3AccessControl accessControl) {
        this.access_control = accessControl;
    }

    public AspectMode getAspectMode() {
        return aspect_mode;
    }

    public void setAspectMode(AspectMode aspectMode) {
        this.aspect_mode = aspectMode;
    }

    public Integer getAudioBass() {
        return audio_bass;
    }

    public void setAudioBass(Integer audioBass) {
        this.audio_bass = audioBass;
    }

    public Integer getAudioBitrate() {
        return audio_bitrate;
    }

    public void setAudioBitrate(Integer audioBitrate) {
        this.audio_bitrate = audioBitrate;
    }

    public Integer getAudioChannels() {
        return audio_channels;
    }

    public void setAudioChannels(Integer audioChannels) {
        this.audio_channels = audioChannels;
    }

    public AudioCodec getAudioCodec() {
        return audio_codec;
    }

    public void setAudioCodec(AudioCodec audioCodec) {
        this.audio_codec = audioCodec;
    }

    public Double getAudioCompressionRatio() {
        return audio_compression_ratio;
    }

    public void setAudioCompressionRatio(Double audioCompressionRatio) {
        this.audio_compression_ratio = audioCompressionRatio;
    }

    public Integer getAudioCompressionThreshold() {
        return audio_compression_threshold;
    }

    public void setAudioCompressionThreshold(Integer audioCompressionThreshold) {
        this.audio_compression_threshold = audioCompressionThreshold;
    }

    public Boolean getAudioConstantBitrate() {
        return audio_constant_bitrate;
    }

    public void setAudioConstantBitrate(Boolean audioConstantBitrate) {
        this.audio_constant_bitrate = audioConstantBitrate;
    }

    public Double getAudioExpansionRatio() {
        return audio_expansion_ratio;
    }

    public void setAudioExpansionRatio(Double audioExpansionRatio) {
        this.audio_expansion_ratio = audioExpansionRatio;
    }

    public Integer getAudioExpansionThreshold() {
        return audio_expansion_threshold;
    }

    public void setAudioExpansionThreshold(Integer audioExpansionThreshold) {
        this.audio_expansion_threshold = audioExpansionThreshold;
    }

    public Double getAudioFade() {
        return audio_fade;
    }

    public void setAudioFade(Double audioFade) {
        this.audio_fade = audioFade;
    }

    public Double getAudioFadeIn() {
        return audio_fade_in;
    }

    public void setAudioFadeIn(Double audioFadeIn) {
        this.audio_fade_in = audioFadeIn;
    }

    public Double getAudioFadeOut() {
        return audio_fade_out;
    }

    public void setAudioFadeOut(Double audioFadeOut) {
        this.audio_fade_out = audioFadeOut;
    }

    public Integer getAudioGain() {
        return audio_gain;
    }

    public void setAudioGain(Integer audioGain) {
        this.audio_gain = audioGain;
    }

    public Integer getAudioHighpass() {
        return audio_highpass;
    }

    public void setAudioHighpass(Integer audioHighpass) {
        this.audio_highpass = audioHighpass;
    }

    public Boolean getAudioKaraokeMode() {
        return audio_karaoke_mode;
    }

    public void setAudioKaraokeMode(Boolean audioKaraokeMode) {
        this.audio_karaoke_mode = audioKaraokeMode;
    }

    public Integer getAudioLowpass() {
        return audio_lowpass;
    }

    public void setAudioLowpass(Integer audioLowpass) {
        this.audio_lowpass = audioLowpass;
    }

    public Boolean getAudioNormalize() {
        return audio_normalize;
    }

    public void setAudioNormalize(Boolean audioNormalize) {
        this.audio_normalize = audioNormalize;
    }

    public Boolean getAudioPostNormalize() {
        return audio_post_normalize;
    }

    public void setAudioPostNormalize(Boolean audioPostNormalize) {
        this.audio_post_normalize = audioPostNormalize;
    }

    public Boolean getAudioPreNormalize() {
        return audio_pre_normalize;
    }

    public void setAudioPreNormalize(Boolean audioPreNormalize) {
        this.audio_pre_normalize = audioPreNormalize;
    }

    public Integer getAudioQuality() {
        return audio_quality;
    }

    public void setAudioQuality(Integer audioQuality) {
        this.audio_quality = audioQuality;
    }

    public Long getAudioSampleRate() {
        return audio_sample_rate;
    }

    public void setAudioSampleRate(Long audioSampleRate) {
        this.audio_sample_rate = audioSampleRate;
    }

    public Integer getAudioTreble() {
        return audio_treble;
    }

    public void setAudioTreble(Integer audioTreble) {
        this.audio_treble = audioTreble;
    }

    public Boolean getAutolevel() {
        return autolevel;
    }

    public void setAutolevel(Boolean autolevel) {
        this.autolevel = autolevel;
    }

    public String getBaseUrl() {
        return base_url;
    }

    public void setBaseUrl(String baseUrl) {
        this.base_url = baseUrl;
    }

    public String getCaptionUrl() {
        return caption_url;
    }

    public void setCaptionUrl(String captionUrl) {
        this.caption_url = captionUrl;
    }

    public String getClipLength() {
        return clip_length;
    }

    public void setClipLength(String clipLength) {
        this.clip_length = clipLength;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt;
    }

    public Boolean getDeblock() {
        return deblock;
    }

    public void setDeblock(Boolean deblock) {
        this.deblock = deblock;
    }

    public Integer getDecimate() {
        return decimate;
    }

    public void setDecimate(Integer decimate) {
        this.decimate = decimate;
    }

    public Long getDecoderBitrateCap() {
        return decoder_bitrate_cap;
    }

    public void setDecoderBitrateCap(Long decoderBitrateCap) {
        this.decoder_bitrate_cap = decoderBitrateCap;
    }

    public Long getDecoderBufferSize() {
        return decoder_buffer_size;
    }

    public void setDecoderBufferSize(Long decoderBufferSize) {
        this.decoder_buffer_size = decoderBufferSize;
    }

    public String getDeInterlace() {
        return deinterlace;
    }

    public void setDeInterlace(String deInterlace) {
        this.deinterlace = deInterlace;
    }

    public Boolean getDenoise() {
        return denoise;
    }

    public void setDenoise(Boolean denoise) {
        this.denoise = denoise;
    }

    public String getDeviceProfile() {
        return device_profile;
    }

    public void setDeviceProfile(String deviceProfile) {
        this.device_profile = deviceProfile;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPackageFilename() {
        return package_filename;
    }

    public void setPackageFilename(String packageFilename) {
        this.package_filename = packageFilename;
    }

    public PackageFormat getPackageFormat() {
        return package_format;
    }

    public void setPackageFormat(PackageFormat packageFormat) {
        this.package_format = packageFormat;
    }

    public Date getFinishedAt() {
        return finished_at;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finished_at = finishedAt;
    }

    public Boolean getFixedKeyframeInterval() {
        return fixed_keyframe_interval;
    }

    public void setFixedKeyframeInterval(Boolean fixedKeyframeInterval) {
        this.fixed_keyframe_interval = fixedKeyframeInterval;
    }

    public Double getForcedKeyframeRate() {
        return forced_keyframe_rate;
    }

    public void setForcedKeyframeRate(Double forcedKeyframeRate) {
        this.forced_keyframe_rate = forcedKeyframeRate;
    }

    public ContainerFormat getFormat() {
        return format;
    }

    public void setFormat(ContainerFormat format) {
        this.format = format;
    }

    public Double getFrameRate() {
        return frame_rate;
    }

    public void setFrameRate(Double frameRate) {
        this.frame_rate = frameRate;
    }

    public Boolean getGenerateMD5Checksum() {
        return generate_md5_checksum;
    }

    public void setGenerateMD5Checksum(Boolean generateMD5Checksum) {
        this.generate_md5_checksum = generateMD5Checksum;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * NOTE: Only certains HTTP Headers are allowed.
     * 
     * HTTP headers to send with your file when we upload it. This feature is currently supported
     * when using S3 and Cloud Files. Zencoder supports setting a limited subset of these headers:
     * Cache-Control Content-Disposition Content-Encoding Content-Type Expires x-amz-acl
     * x-amz-storage-class x-amz-server-side-encryption x-amz-meta-*
     * 
     * Headers will be ignored when an output location is not specified.
     * 
     * @see https://app.zencoder.com/docs/api/encoding/general-output-settings/headers
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getKeyframeInterval() {
        return keyframe_interval;
    }

    public void setKeyframeInterval(Integer keyframeInterval) {
        this.keyframe_interval = keyframeInterval;
    }

    public Double getKeyframeRate() {
        return keyframe_rate;
    }

    public void setKeyframeRate(Double keyframeRate) {
        this.keyframe_rate = keyframeRate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getMaxAudioSampleRate() {
        return max_audio_sample_rate;
    }

    public void setMaxAudioSampleRate(Long maxAudioSampleRate) {
        this.max_audio_sample_rate = maxAudioSampleRate;
    }

    public Double getMaxFrameRate() {
        return max_frame_rate;
    }

    public void setMaxFrameRate(Double maxFrameRate) {
        this.max_frame_rate = maxFrameRate;
    }

    public Long getMaxVideoBitrate() {
        return max_video_bitrate;
    }

    public void setMaxVideoBitrate(Long maxVideoBitrate) {
        this.max_video_bitrate = maxVideoBitrate;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Boolean getOnePass() {
        return one_pass;
    }

    public void setOnePass(Boolean onePass) {
        this.one_pass = onePass;
    }

    public Integer getParallelUploadLimit() {
        return parallel_upload_limit;
    }

    public void setParallelUploadLimit(Integer parallelUploadLimit) {
        this.parallel_upload_limit = parallelUploadLimit;
    }

    public Boolean getPublic() {
        return publicMode;
    }

    public void setPublic(Boolean publicMode) {
        this.publicMode = publicMode;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getRotate() {
        return rotate;
    }

    public void setRotate(Integer rotate) {
        this.rotate = rotate;
    }

    public Boolean getRrs() {
        return rrs;
    }

    public void setRrs(Boolean rrs) {
        this.rrs = rrs;
    }

    public Boolean getSharpen() {
        return sharpen;
    }

    public void setSharpen(Boolean sharpen) {
        this.sharpen = sharpen;
    }

    public String getSize() {
        return size;
    }

    public Boolean getSkipAudio() {
        return skip_audio;
    }

    public void setSkipAudio(Boolean skipAudio) {
        this.skip_audio = skipAudio;
    }

    public Boolean getSkipCaptions() {
        return skip_captions;
    }

    public void setSkipCaptions(Boolean skipCaptions) {
        this.skip_captions = skipCaptions;
    }

    public Boolean getSkipVideo() {
        return skip_video;
    }

    public void setSkipVideo(Boolean skipVideo) {
        this.skip_video = skipVideo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getStartClip() {
        return start_clip;
    }

    public void setStartClip(String startClip) {
        this.start_clip = startClip;
    }

    public Boolean getStrict() {
        return strict;
    }

    public void setStrict(Boolean strict) {
        this.strict = strict;
    }

    public Date getSubmittedAt() {
        return submitted_at;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submitted_at = submittedAt;
    }

    public OutputType getType() {
        return type;
    }

    public void setType(OutputType type) {
        this.type = type;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updated_at = updatedAt;
    }

    public Boolean getUpscale() {
        return upscale;
    }

    public void setUpscale(Boolean upscale) {
        this.upscale = upscale;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecondaryUrl() {
        return secondary_url;
    }

    public void setSecondaryUrl(String secondary_url) {
        this.secondary_url = secondary_url;
    }

    public Integer getVideoBitrate() {
        return video_bitrate;
    }

    public void setVideoBitrate(Integer videoBitrate) {
        this.video_bitrate = videoBitrate;
    }

    public VideoCodec getVideoCodec() {
        return video_codec;
    }

    public void setVideoCodec(VideoCodec videoCodec) {
        this.video_codec = videoCodec;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public List<Watermark> getWatermarks() {
        return watermarks;
    }

    public void setWatermarks(List<Watermark> watermarks) {
        this.watermarks = watermarks;
    }

    public String getMinSize() {
        return min_size;
    }

    public void setMinSize(String min_size) {
        this.min_size = min_size;
    }

    public String getMaxSize() {
        return max_size;
    }

    public void setMaxSize(String max_size) {
        this.max_size = max_size;
    }

    public Integer getMinDuration() {
        return min_duration;
    }

    public void setMinDuration(Integer min_duration) {
        this.min_duration = min_duration;
    }

    public Integer getMaxDuration() {
        return max_duration;
    }

    public void setMaxDuration(Integer max_duration) {
        this.max_duration = max_duration;
    }

    public Integer getSegmentSeconds() {
        return segment_seconds;
    }

    public void setSegmentSeconds(Integer segment_seconds) {
        this.segment_seconds = segment_seconds;
    }

    public Integer getSegmentSize() {
        return segment_size;
    }

    public void setSegmentSize(Integer segment_size) {
        this.segment_size = segment_size;
    }

    public List<SegmentedStream> getStreams() {
        return streams;
    }

    public void setStreams(List<SegmentedStream> streams) {
        this.streams = streams;
    }

    public String getSegmentImageFile() {
        return segment_image_file;
    }

    public void setSegmentImageFile(String segment_image_file) {
        this.segment_image_file = segment_image_file;
    }

    public Boolean getSegmentVideoSnapshots() {
        return segment_video_snapshots;
    }

    public void setSegmentVideoSnapshots(Boolean segment_video_snapshots) {
        this.segment_video_snapshots = segment_video_snapshots;
    }

    public Integer getMaxHlsProtocolVersion() {
        return max_hls_protocol_version;
    }

    public void setMaxHlsProtocolVersion(Integer max_hls_protocol_version) {
        this.max_hls_protocol_version = max_hls_protocol_version;
    }

    public Boolean getHlsOptimizedTs() {
        return hls_optimized_ts;
    }

    public void setHlsOptimizedTs(Boolean hls_optimized_ts) {
        this.hls_optimized_ts = hls_optimized_ts;
    }

    public SegmentingType getPrepareForSegmenting() {
        return prepare_for_segmenting;
    }

    public void setPrepareForSegmenting(SegmentingType prepare_for_segmenting) {
        this.prepare_for_segmenting = prepare_for_segmenting;
    }

    public Boolean getInstantPlay() {
        return instant_play;
    }

    public void setInstantPlay(Boolean instant_play) {
        this.instant_play = instant_play;
    }

    public String getSmilBaseUrl() {
        return smil_base_url;
    }

    public void setSmilBaseUrl(String smil_base_url) {
        this.smil_base_url = smil_base_url;
    }

    public EncryptionMethod getEncryptionMethod() {
        return encryption_method;
    }

    public void setEncryptionMethod(EncryptionMethod encryption_method) {
        this.encryption_method = encryption_method;
    }

    public String getEncryptionKey() {
        return encryption_key;
    }

    public void setEncryptionKey(String encryption_key) {
        this.encryption_key = encryption_key;
    }

    public String getEncryptionKeyUrl() {
        return encryption_key_url;
    }

    public void setEncryptionKeyUrl(String encryption_key_url) {
        this.encryption_key_url = encryption_key_url;
    }

    public Integer getEncryptionKeyRotationPeriod() {
        return encryption_key_rotation_period;
    }

    public void setEncryptionKeyRotationPeriod(Integer encryption_key_rotation_period) {
        this.encryption_key_rotation_period = encryption_key_rotation_period;
    }

    public String getEncryptionKeyUrlPrefix() {
        return encryption_key_url_prefix;
    }

    public void setEncryptionKeyUrlPrefix(String encryption_key_url_prefix) {
        this.encryption_key_url_prefix = encryption_key_url_prefix;
    }

    public String getEncryptionIv() {
        return encryption_iv;
    }

    public void setEncryptionIv(String encryption_iv) {
        this.encryption_iv = encryption_iv;
    }

    public String getEncryptionPassword() {
        return encryption_password;
    }

    public void setEncryptionPassword(String encryption_password) {
        this.encryption_password = encryption_password;
    }

    public String getH264ReferenceFrames() {
        return h264_reference_frames;
    }

    public void setH264ReferenceFrames(String h264_reference_frames) {
        this.h264_reference_frames = h264_reference_frames;
    }

    public H264Profile getH264Profile() {
        return h264_profile;
    }

    public void setH264Profile(H264Profile h264_profile) {
        this.h264_profile = h264_profile;
    }

    public H264Level getH264Level() {
        return h264_level;
    }

    public void setH264Level(H264Level h264_level) {
        this.h264_level = h264_level;
    }

    public Integer getH264Bframes() {
        return h264_bframes;
    }

    public void setH264Bframes(Integer h264_bframes) {
        this.h264_bframes = h264_bframes;
    }

    public String getTuning() {
        return tuning;
    }

    public void setTuning(String tuning) {
        this.tuning = tuning;
    }

    public Integer getCrf() {
        return crf;
    }

    public void setCrf(Integer crf) {
        this.crf = crf;
    }

    public List<CuePoint> getCuePoints() {
        return cue_points;
    }

    public void setCuePoints(List<CuePoint> cue_points) {
        this.cue_points = cue_points;
    }

    public Integer getVP6TemporalDownWatermark() {
        return vp6_temporal_down_watermark;
    }

    public void setVP6TemporalDownWatermark(Integer vp6_temporal_down_watermark) {
        this.vp6_temporal_down_watermark = vp6_temporal_down_watermark;
    }

    public Boolean getVP6TemporalResampling() {
        return vp6_temporal_resampling;
    }

    public void setVP6TemporalResampling(Boolean vp6_temporal_resampling) {
        this.vp6_temporal_resampling = vp6_temporal_resampling;
    }

    public Integer getVP6UndershootPct() {
        return vp6_undershoot_pct;
    }

    public void setVP6UndershootPct(Integer vp6_undershoot_pct) {
        this.vp6_undershoot_pct = vp6_undershoot_pct;
    }

    public VP6Profile getVP6Profile() {
        return vp6_profile;
    }

    public void setVP6Profile(VP6Profile vp6_profile) {
        this.vp6_profile = vp6_profile;
    }

    public VP6CompressionMode getVP6CompressionMode() {
        return vp6_compression_mode;
    }

    public void setVP6CompressionMode(VP6CompressionMode vp6_compression_mode) {
        this.vp6_compression_mode = vp6_compression_mode;
    }

    @JsonProperty("vp6_2pass_min_section")
    public Integer getVP6TwoPassMinSection() {
        return vp6_2pass_min_section;
    }

    @JsonProperty("vp6_2pass_min_section")
    public void setVP6TwoPassMinSection(Integer vp6_2pass_min_section) {
        this.vp6_2pass_min_section = vp6_2pass_min_section;
    }

    @JsonProperty("vp6_2pass_max_section")
    public Integer getVP6TwoPassMaxSection() {
        return vp6_2pass_max_section;
    }

    @JsonProperty("vp6_2pass_max_section")
    public void setVP6TwoPassMaxSection(Integer vp6_2pass_max_section) {
        this.vp6_2pass_max_section = vp6_2pass_max_section;
    }

    public Integer getVP6StreamPrebuffer() {
        return vp6_stream_prebuffer;
    }

    public void setVP6StreamPrebuffer(Integer vp6_stream_prebuffer) {
        this.vp6_stream_prebuffer = vp6_stream_prebuffer;
    }

    public Integer getVP6StreamMaxBuffer() {
        return vp6_stream_max_buffer;
    }

    public void setVP6StreamMaxBuffer(Integer vp6_stream_max_buffer) {
        this.vp6_stream_max_buffer = vp6_stream_max_buffer;
    }

    public VP6DeinterlaceMode getVP6DeinterlaceMode() {
        return vp6_deinterlace_mode;
    }

    public void setVP6DeinterlaceMode(VP6DeinterlaceMode vp6_deinterlace_mode) {
        this.vp6_deinterlace_mode = vp6_deinterlace_mode;
    }

    public Float getVP6DenoiseLevel() {
        return vp6_denoise_level;
    }

    public void setVP6DenoiseLevel(Float vp6_denoise_level) {
        this.vp6_denoise_level = vp6_denoise_level;
    }

    public Boolean getHint() {
        return hint;
    }

    public void setHint(Boolean hint) {
        this.hint = hint;
    }

    public Integer getMTUSize() {
        return mtu_size;
    }

    public void setMTUSize(Integer mtu_size) {
        this.mtu_size = mtu_size;
    }

    public AACProfile getMaxAACProfile() {
        return max_aac_profile;
    }

    public void setMaxAACProfile(AACProfile max_aac_profile) {
        this.max_aac_profile = max_aac_profile;
    }

    public AACProfile getForceAACProfile() {
        return force_aac_profile;
    }

    public void setForceAACProfile(AACProfile force_aac_profile) {
        this.force_aac_profile = force_aac_profile;
    }

    public AsperaTransferPolicy getAsperaTransferPolicy() {
        return aspera_transfer_policy;
    }

    public void setAsperaTransferPolicy(AsperaTransferPolicy aspera_transfer_policy) {
        this.aspera_transfer_policy = aspera_transfer_policy;
    }

    public Integer getTransferMinimumRate() {
        return transfer_minimum_rate;
    }

    public void setTransferMinimumRate(Integer transfer_minimum_rate) {
        this.transfer_minimum_rate = transfer_minimum_rate;
    }

    public Integer getTransferMaximumRate() {
        return transfer_maximum_rate;
    }

    public void setTransferMaximumRate(Integer transfer_maximum_rate) {
        this.transfer_maximum_rate = transfer_maximum_rate;
    }

    public Boolean getCopyAudio() {
        return copy_audio;
    }

    public void setCopyAudio(Boolean copy_audio) {
        this.copy_audio = copy_audio;
    }

    public Boolean getCopyVideo() {
        return copy_video;
    }

    public void setCopyVideo(Boolean copy_video) {
        this.copy_video = copy_video;
    }

    public Boolean getLiveStream() {
        return live_stream;
    }

    public void setLiveStream(Boolean live_stream) {
        this.live_stream = live_stream;
    }

    public Integer getLiveSlidingWindowDuration() {
        return live_sliding_window_duration;
    }

    public void setLiveSlidingWindowDuration(Integer live_sliding_window_duration) {
        this.live_sliding_window_duration = live_sliding_window_duration;
    }

}
