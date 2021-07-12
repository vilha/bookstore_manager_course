package com.vilha.bookstoremanager.service;

import com.vilha.bookstoremanager.dto.MessageResponseDTO;
import com.vilha.bookstoremanager.entity.Book;
import com.vilha.bookstoremanager.mapper.BookMapper;
import com.vilha.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper mookmMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }
}
