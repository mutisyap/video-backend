package tech.meliora.academy.video.Video.dto;

public class VideoMetadataDTO {
    
    private int length; // in seconds

    private int size; // in bytes

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
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
