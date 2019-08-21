package tech.meliora.academy.video.Video;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.meliora.academy.video.Video.dto.VideoMetadataDTO;

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

    @GetMapping("/video/get/{url}")
    public ResponseEntity<byte[]> getFile(@PathVariable String url, @RequestParam Long from, @RequestParam Long to) {

        HttpHeaders httpHeaders = new HttpHeaders();

        byte[] rawFile = null;

        httpHeaders.setContentType(MediaType.valueOf("image/svg+xml"));
        // rawFile = mediaItemService.getDefault(AlbumType.GENERAL);

        return new ResponseEntity<>(rawFile, httpHeaders, HttpStatus.OK);
    }
}
