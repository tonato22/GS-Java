package br.com.workconnect.controller;

import br.com.workconnect.service.AIService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class AIController {

    private final AIService aiService;

    @PostMapping("/summary")
    public TextResponse summary(@RequestBody TextRequest request) {
        String result = aiService.generateSummary(request.getContent());
        return new TextResponse(result);
    }

    @PostMapping("/title")
    public TextResponse title(@RequestBody TextRequest request) {
        String result = aiService.suggestTitle(request.getContent());
        return new TextResponse(result);
    }

    @Data
    public static class TextRequest {
        private String content;
    }

    @Data
    public static class TextResponse {
        private final String result;
    }
}
