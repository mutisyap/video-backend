package tech.meliora.academy.video.Video;

import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import tech.meliora.academy.video.Video.dto.VideoMetadataDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

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

    @GetMapping("/video/get-by-range/{filename}")
    public ResponseEntity<byte[]> getFileByRange(@PathVariable String filename, @RequestParam(required = false) Integer start, @RequestParam(required = false) Integer end) {


        try {
            byte[] rawFile = videoService.getFile(filename, start, end);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf("video/mp4"));
            return new ResponseEntity<>(rawFile, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/video/full/{url}")
    public ResponseEntity<Resource> getVideo(@PathVariable String url) throws MalformedURLException {

        Resource video = videoService.getVideoResource(url);

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.valueOf("video/mp4")))
                .body(video);
    }
}
