package org.kazakov.textservice.dto;

import java.time.LocalDateTime;

public record NoteResponse(
        Long id,
        String title,
        String content,
        Integer wordCount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
