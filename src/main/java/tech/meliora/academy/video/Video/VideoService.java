package tech.meliora.academy.video.Video;

import org.springframework.stereotype.Service;
import tech.meliora.academy.video.Video.dto.VideoMetadataDTO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class VideoService {
    public VideoMetadataDTO getVideoMetadata(String url){
        if (url == null || url.isEmpty()){
            url = "/home/meliora/Videos/domie/jhi.mp4";
        }
        url = "/home/meliora/Videos/domie/jhi.mp4";
        

        File file = new File(url);

        VideoMetadataDTO videoMetadataDTO = new VideoMetadataDTO();
        
        videoMetadataDTO.setLength(file.length());

        // do some checks and populate
        
        return videoMetadataDTO;
    }
}
