package com.ai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ai.dto.SpringAiResponse;
import com.ai.service.SpringAiService;

@RestController
public class SpringAiController {

  private final SpringAiService aiService;

  public SpringAiController(SpringAiService aiService) {
    this.aiService = aiService;
  }

  @GetMapping("/v1/chat")
  public ResponseEntity<SpringAiResponse> generate(@RequestParam String prompt) {
    final SpringAiResponse response = aiService.generateMessage(prompt);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
