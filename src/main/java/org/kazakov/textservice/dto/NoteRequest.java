package org.kazakov.textservice.dto;

public record NoteRequest(
        String title,
        String content
) {
}
