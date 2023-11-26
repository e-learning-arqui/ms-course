package com.example.mscourse.bl;

import com.example.mscourse.dao.ChannelRepository;
import com.example.mscourse.dto.CreateStreamDto;
import com.example.mscourse.entity.ChannelEntity;
import com.example.mscourse.entity.CourseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IVSBl {
    @Autowired
    private ChannelRepository channelRepository;

    private final Logger logger = LoggerFactory.getLogger(IVSBl.class);

    public void saveChannelAndStreamKey(Map<String, String> streamKeyResult, Long courseId ){
        ChannelEntity channelEntity = new ChannelEntity();
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(courseId);

        channelEntity.setArn(streamKeyResult.get("ChannelArn"));
        channelEntity.setIngestEndpoint(streamKeyResult.get("IngestEndpoint"));
        channelEntity.setPlaybackUrl(streamKeyResult.get("PlaybackUrl"));
        channelEntity.setArnStream(streamKeyResult.get("StreamKeyArn"));
        channelEntity.setStreamKey(streamKeyResult.get("StreamKeyValue"));
        channelEntity.setCourseId(courseEntity);
        channelEntity.setStatus(true);
        channelRepository.saveAndFlush(channelEntity);
    }

    public Boolean isChannelCreated(Long courseId){
        logger.info("Checking if channel is created:"+ courseId);
        return channelRepository.isChannelCreated(courseId);
    }

    public CreateStreamDto getStreamKey(Long courseId){
        logger.info("Getting channel by courseId:"+ courseId);
        ChannelEntity channelEntity = channelRepository.getChannelByCourseId(courseId);
        CreateStreamDto createStreamDto = new CreateStreamDto();
        createStreamDto.setStreamKey(channelEntity.getStreamKey());
        createStreamDto.setIngestEndpoint(channelEntity.getIngestEndpoint());
        return createStreamDto;
    }


    public String getPlaybackUrl(Long courseId){
        logger.info("Getting channel by courseId:"+ courseId);
        ChannelEntity channelEntity = channelRepository.getChannelByCourseId(courseId);
        return channelEntity.getPlaybackUrl();
    }
}
