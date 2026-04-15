package com.ia.aispring.entity.dto;

import java.util.List;

public record GeminiResponse(List<Candidate> candidates) {

    public record Candidate(Content content) {}

    public record Content(List<Part> parts) {}

    public record Part(String text) {}

    public String getTextoResposta() {
        if (candidates != null && !candidates.isEmpty()) {
            Content content = candidates.get(0).content();
            if (content != null && content.parts() != null && !content.parts().isEmpty()) {
                return content.parts().get(0).text();
            }
        }
        return "";
    }
}