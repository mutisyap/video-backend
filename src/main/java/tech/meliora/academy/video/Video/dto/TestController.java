package tech.meliora.academy.video.Video.dto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

@Controller
public class TestController {

    @RequestMapping("/")
    public StreamingResponseBody handleRequest() {

        StreamingResponseBody streamingResponseBody = (OutputStream out) -> {
            for (int i = 0; i < 10000; i++) {
                out.write((i + " - ")
                        .getBytes());
                out.flush();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        return streamingResponseBody;
    }
}