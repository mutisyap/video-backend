package tech.meliora.academy.video.Video;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import tech.meliora.academy.video.Video.dto.VideoMetadataDTO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;

@Service
public class VideoService {
    public VideoMetadataDTO getVideoMetadata(String url){
        File file = new File("/apps/video/" + url);

        VideoMetadataDTO videoMetadataDTO = new VideoMetadataDTO();
        
        videoMetadataDTO.setLength(file.length());

        // do some checks and populate
        
        return videoMetadataDTO;
    }


    public byte[] getFile(String fileName, int start, int end) throws IOException {
        String absoluteFileName = "/apps/video/" + fileName;
        RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFileName, "r");

        int length = end - start;
        byte[] buffer = new byte[length];
        randomAccessFile.seek(start);
        randomAccessFile.readFully(buffer);

        return buffer;
    }

    public Resource getVideoResource(String fileName) throws MalformedURLException {
        String absoluteFileName = "/apps/video/" + fileName;


        return new UrlResource("file:" + absoluteFileName);
    }

}
