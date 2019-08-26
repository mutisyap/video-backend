package tech.meliora.academy.video.Video.dto;

public class VideoMetadataDTO {
    
    private long length; // in seconds

    private long size; // in bytes

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "VideoMetadataDTO{" +
                "length=" + length +
                ", size=" + size +
                '}';
    }
}
