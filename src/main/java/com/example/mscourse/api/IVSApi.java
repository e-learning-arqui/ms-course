package com.example.mscourse.api;

import com.amazonaws.services.ivs.AmazonIVS;
import com.amazonaws.services.ivs.model.*;
import com.example.mscourse.bl.CourseBl;
import com.example.mscourse.bl.IVSBl;
import com.example.mscourse.dto.CreateStreamDto;
import com.example.mscourse.dto.ResponseDto;
import com.example.mscourse.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/course")
public class IVSApi {
    @Autowired
    private AmazonIVS amazonIVS;
    @Autowired
    private IVSBl ivsBl;
    @Autowired
    private CourseBl courseBl;

        @PostMapping("/{courseId}/create-channel")
    public Map<String, String> createChannelAndGetStreamKey(@PathVariable Long courseId) {
        //obtener course
        CourseEntity course = courseBl.findEntityById(courseId);

        CreateChannelResult channelResult = createChannel(course);

        // Obtener la lista de resúmenes de claves de transmisión para el canal
        ListStreamKeysRequest listStreamKeysRequest = new ListStreamKeysRequest()
                .withChannelArn(channelResult.getChannel().getArn());
        ListStreamKeysResult listStreamKeysResult = amazonIVS.listStreamKeys(listStreamKeysRequest);
        List<StreamKeySummary> streamKeySummaries = listStreamKeysResult.getStreamKeys();

        // Asumir que solo hay una clave de transmisión por canal
        StreamKeySummary streamKeySummary = streamKeySummaries.get(0);

        // Obtener el valor de la clave de transmisión
        GetStreamKeyRequest getStreamKeyRequest = new GetStreamKeyRequest()
                .withArn(streamKeySummary.getArn());
        GetStreamKeyResult getStreamKeyResult = amazonIVS.getStreamKey(getStreamKeyRequest);
        String streamKeyValue = getStreamKeyResult.getStreamKey().getValue();

        // Construir y devolver la respuesta
        Map<String, String> response = new HashMap<>();
        response.put("ChannelArn", channelResult.getChannel().getArn());
        response.put("IngestEndpoint", channelResult.getChannel().getIngestEndpoint());
        response.put("PlaybackUrl", channelResult.getChannel().getPlaybackUrl());
        response.put("StreamKeyArn", streamKeySummary.getArn());
        response.put("StreamKeyValue", streamKeyValue);
        ivsBl.saveChannelAndStreamKey(response, courseId);
        return response;
    }

    //crear canal
    private CreateChannelResult createChannel(CourseEntity course) {
        String name= course.getTitle()+ course.getCourseId().toString();
        CreateChannelRequest request = new CreateChannelRequest()
                .withName(name.replace(" ","")) // Nombre del canal
                .withLatencyMode(ChannelLatencyMode.LOW) // Configuración de latencia
                .withAuthorized(false); // Definir si el canal es público o privado

        Map<String, String> tags = new HashMap<>();
        tags.put("Project", "Course1");
        tags.put("Environment", "Desarrollo");
        request.withTags(tags);

        return amazonIVS.createChannel(request);
    }

/*
    @PostMapping("/create-channel")
    public CreateChannelResult createChannel() {
        CreateChannelRequest request = new CreateChannelRequest()
                .withName("MiCanal") // Nombre del canal
                .withLatencyMode(ChannelLatencyMode.LOW) // Configuración de latencia
                .withAuthorized(false); // Definir si el canal es público o privad

        Map<String, String> tags = new HashMap<>();
        tags.put("Project", "Test1");
        tags.put("Environment", "Desarrollo");
        request.withTags(tags);
        return amazonIVS.createChannel(request);
    }*/

    // obtener el streamKey y ingestEndpoint por arn
    @GetMapping("/get-stream-key/{channelArn}")
    public ListStreamKeysResult getStreamKey(@PathVariable String channelArn) {
        ListStreamKeysRequest request = new ListStreamKeysRequest()
                .withChannelArn(channelArn);
        return amazonIVS.listStreamKeys(request);
    }


    // verifica si el canal ya fue creado
    @GetMapping("/{courseId}/channel/verification")
    public ResponseDto<Boolean> isChannelCreated(@PathVariable Long courseId) {
        ResponseDto<Boolean> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(ivsBl.isChannelCreated(courseId));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

    //obtener el streamKey y ingestEndpoint
    @GetMapping("/{courseId}/channel/stream")
    public ResponseDto<CreateStreamDto> getStreamKey(@PathVariable Long courseId) {
        ResponseDto<CreateStreamDto> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(ivsBl.getStreamKey(courseId));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

    //obtener el playbackURL
    @GetMapping("/{courseId}/channel/playback")
    public ResponseDto<String> getPlaybackUrl(@PathVariable Long courseId) {
        ResponseDto<String> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(ivsBl.getPlaybackUrl(courseId));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }
}
