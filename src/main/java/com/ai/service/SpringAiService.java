package com.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import com.ai.dto.SpringAiResponse;

@Service
public class SpringAiService {

  private final ChatClient chatClient;

  public SpringAiService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  public SpringAiResponse generateMessage(String prompt) {
    String chatClientResponse =
            chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();

    SpringAiResponse response = new SpringAiResponse();
    response.setMessage(chatClientResponse);
    return response;
  }
}
