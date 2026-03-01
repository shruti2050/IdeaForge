package com.shruti.projectgenerator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OpenRouterService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String generateText(String prompt) {

        String url = "https://openrouter.ai/api/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("HTTP-Referer", "http://localhost:8080");
        headers.set("X-Title", "Project Idea Generator");

        // Request Body
        Map<String, Object> request = new HashMap<>();
        request.put("model", "google/gemini-2.0-flash-001");

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        messages.add(message);
        request.put("messages", messages);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(request, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.postForEntity(url, entity, String.class);

            if (response.getStatusCode().is2xxSuccessful()
                    && response.getBody() != null) {

                JsonNode root = objectMapper.readTree(response.getBody());

                JsonNode contentNode = root
                        .path("choices")
                        .get(0)
                        .path("message")
                        .path("content");

                if (!contentNode.isMissingNode()) {
                    return contentNode.asText();
                } else {
                    return "No content received from AI.";
                }
            } else {
                return "Unexpected response from OpenRouter: "
                        + response.getStatusCode();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling OpenRouter API: " + e.getMessage();
        }
    }
}