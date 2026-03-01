package com.shruti.projectgenerator.controller;

import com.shruti.projectgenerator.dto.IdeaRequest;
import com.shruti.projectgenerator.service.OpenRouterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class IdeaController {

    private final OpenRouterService hfService;

    public IdeaController(OpenRouterService hfService) {
        this.hfService = hfService;
    }

    @PostMapping("/generate")
    public String generateIdeas(@RequestBody IdeaRequest request) {

        String prompt = "Generate 3 unique project ideas for:\n" +
                "Tech Stack: " + request.getTechStack() + "\n" +
                "Domain: " + request.getDomain() + "\n" +
                "Experience Level: " + request.getLevel() + "\n" +
                "Interest: " + request.getInterest() + "\n\n" +
                "Each idea should include:\n" +
                "- Title\n" +
                "- Problem statement\n" +
                "\\n\\nPlease format the response using clear headings, bullet points, and double line breaks between sections so it is easy to read on a website." +
                "use headings for problem statements"+
                "- Key features\n" +
                "- Deployment suggestion";

        return hfService.generateText(prompt);
    }
}