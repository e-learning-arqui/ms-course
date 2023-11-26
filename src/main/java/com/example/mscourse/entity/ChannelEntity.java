package com.example.mscourse.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "CHANNEL")
public class ChannelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHANNEL_ID", nullable = false)
    private Long channelId;

    @Column(name = "ARN", nullable = false, length = 400)
    private String arn;

    @Column(name = "INGEST_ENDPOINT", nullable = false, length = 400)
    private String ingestEndpoint;

    @Column(name = "PLAYBACK_URL", nullable = false, length = 400)
    private String playbackUrl;

    @Column(name = "ARN_STREAM", nullable = false, length = 400)
    private String arnStream;

    @Column(name = "STREAM_KEY", nullable = false, length = 100)
    private String streamKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false, referencedColumnName = "COURSE_ID")
    private CourseEntity courseId;
    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    //
    public ChannelEntity() {}
    public ChannelEntity(String arn, String ingestEndpoint, String playbackUrl, String arnStream, String streamKey, CourseEntity courseId, Boolean status) {
        this.arn = arn;
        this.ingestEndpoint = ingestEndpoint;
        this.playbackUrl = playbackUrl;
        this.arnStream = arnStream;
        this.streamKey = streamKey;
        this.courseId = courseId;
        this.status = status;
    }
    // Getters and Setters
    public Long getChannelId() {
        return channelId;
    }
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
    public String getArn() {
        return arn;
    }
    public void setArn(String arn) {
        this.arn = arn;
    }
    public String getIngestEndpoint() {
        return ingestEndpoint;
    }
    public void setIngestEndpoint(String ingestEndpoint) {
        this.ingestEndpoint = ingestEndpoint;
    }
    public String getPlaybackUrl() {
        return playbackUrl;
    }
    public void setPlaybackUrl(String playbackUrl) {
        this.playbackUrl = playbackUrl;
    }
    public String getArnStream() {
        return arnStream;
    }
    public void setArnStream(String arnStream) {
        this.arnStream = arnStream;
    }
    public String getStreamKey() {
        return streamKey;
    }
    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }
    public CourseEntity getCourseId() {
        return courseId;
    }
    public void setCourseId(CourseEntity courseId) {
        this.courseId = courseId;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "ChannelEntity [arn=" + arn + ", arnStream=" + arnStream + ", channelId=" + channelId + ", courseId="
                + courseId + ", ingestEndpoint=" + ingestEndpoint + ", playbackUrl=" + playbackUrl + ", status="
                + status + ", streamKey=" + streamKey + "]";
    }

}
