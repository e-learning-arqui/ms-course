package com.example.mscourse.dto;

public class CreateStreamDto {
    private String streamKey;
    private String ingestEndpoint;

    //Constructores
    public CreateStreamDto() {}

    public CreateStreamDto(String streamKey, String ingestEndpoint) {
        this.streamKey = streamKey;
        this.ingestEndpoint = ingestEndpoint;
    }


    // getters setters y to string
    public String getStreamKey() {return streamKey;}

    public void setStreamKey(String streamKey) {this.streamKey = streamKey;}

    public String getIngestEndpoint() {return ingestEndpoint;}

    public void setIngestEndpoint(String ingestEndpoint) {this.ingestEndpoint = ingestEndpoint;}

    @Override
    public String toString() {
        return "IVS{" +
                "streamKey=" + streamKey +
                ", ingestEndpoint='" + ingestEndpoint + '\'' +
                '}';
    }

}
