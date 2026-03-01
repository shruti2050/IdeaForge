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

        String prompt = "You are an expert software project advisor. Generate exactly 5 unique project ideas based on the inputs below.\n\n" +
                "Tech Stack: " + request.getTechStack() + "\n" +
                "Domain: " + request.getDomain() + "\n" +
                "Experience Level: " + request.getLevel() + "\n" +
                "Interest: " + request.getInterest() + "\n\n" +

                "STRICT FORMAT RULES — follow exactly, no deviations:\n" +
                "- Do NOT use markdown bold (**), italics (*), or headers (###)\n" +
                "- Do NOT number the ideas outside the block\n" +
                "- Each idea MUST be wrapped in [IDEA] and [/IDEA] tags\n" +
                "- Every section heading must appear on its own line followed by a colon\n" +
                "- Every list item must start with a dash (-)\n\n" +

                "Use EXACTLY this structure for each idea:\n\n" +

                "[IDEA]\n" +
                "Title: <short project title>\n" +
                "Problem Statement: <2 to 3 sentences describing the real-world problem being solved>\n" +
                "Key Features:\n" +
                "- <feature 1>\n" +
                "- <feature 2>\n" +
                "- <feature 3>\n" +
                "- <feature 4>\n" +
                "- <feature 5>\n" +
                "Roadmap:\n" +
                "- <Phase 1: what to build first>\n" +
                "- <Phase 2: core feature development>\n" +
                "- <Phase 3: testing and refinement>\n" +
                "- <Phase 4: deployment and launch>\n" +
                "Deployment:\n" +
                "- <technology or platform 1>\n" +
                "- <technology or platform 2>\n" +
                "- <technology or platform 3>\n" +
                "- <technology or platform 4>\n" +
                "Future Scope:\n" +
                "- <future enhancement 1>\n" +
                "- <future enhancement 2>\n" +
                "- <future enhancement 3>\n" +
                "[/IDEA]\n\n" +

                "Now generate all 5 ideas using this exact format. Do not add any intro text, commentary, or conclusion outside the [IDEA] blocks.";
        return hfService.generateText(prompt);
    }
}