package tech.meliora.academy.video.Video;

import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import tech.meliora.academy.video.Video.dto.VideoMetadataDTO;

import java.io.*;

@RestController
@RequestMapping("/api")
public class VideoResource {
    private final VideoService videoService;

    public VideoResource(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/video/get-metadata/{url}")
    public VideoMetadataDTO getVideoMetadata(@PathVariable String url) {
        return videoService.getVideoMetadata(url);
    }

    // @RequestParam (required = false) Long from, @RequestParam Long to (ADD)
    @GetMapping("/video")
    public ResponseEntity<byte[]> getFile() {

        HttpHeaders headers = new HttpHeaders();

        File file = new File("/apps/video/jhi.mp4");
        try {
            InputStream targetStream = new FileInputStream(file);
            byte[] media = StreamUtils.copyToByteArray(targetStream);
            headers.setContentType(MediaType.valueOf("video/mp4"));

            return new ResponseEntity<>(media, headers, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>(null, headers, HttpStatus.OK);
        }
    }


    @GetMapping("/video/full/{url}")
    public ResponseEntity<ResourceRegion> getVideo(@PathVariable String url) {

        return null;

    }
}
