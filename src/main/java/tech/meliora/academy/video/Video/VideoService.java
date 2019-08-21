package tech.meliora.academy.video.Video;

import org.springframework.stereotype.Service;
import tech.meliora.academy.video.Video.dto.VideoMetadataDTO;

@Service
public class VideoService {
    public VideoMetadataDTO getVideoMetadata(String url){
        VideoMetadataDTO videoMetadataDTO = new VideoMetadataDTO();

        // do some checks and populate
        
        return videoMetadataDTO;
    }
}
