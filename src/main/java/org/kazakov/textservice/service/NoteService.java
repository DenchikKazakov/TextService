package org.kazakov.textservice.service;

import lombok.RequiredArgsConstructor;
import org.kazakov.textservice.dto.NoteRequest;
import org.kazakov.textservice.dto.NoteResponse;
import org.kazakov.textservice.model.Note;
import org.kazakov.textservice.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteResponse createNote(NoteRequest request) {
        Note note = new Note();
        note.setTitle(request.title());
        note.setContent(request.content());
        return toDTO(noteRepository.save(note));
    }

    public List<NoteResponse> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public NoteResponse getNoteById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        return toDTO(note);
    }

    @Transactional
    public NoteResponse updateNote(Long id, NoteRequest request) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setTitle(request.title());
        note.setContent(request.content());
        return toDTO(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public List<NoteResponse> searchNotes(String query) {
        return noteRepository.searchByText(query)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Long getTotalNotesCount() {
        return noteRepository.count();
    }

    private NoteResponse toDTO(Note note) {
        return new NoteResponse(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getWordCount(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }
}
