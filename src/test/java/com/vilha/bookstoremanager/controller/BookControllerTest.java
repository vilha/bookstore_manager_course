package com.vilha.bookstoremanager.controller;

import com.vilha.bookstoremanager.dto.MessageResponseDTO;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController cookController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(((viewName, locale) -> new MappingJackson2JsonView()))
                .build();
    }

    @Test
    void testWhenPOSTisCalledThenABookShouldBeCreated() throws Exception {
        BookDTO bookDTO = BookUtils.createFakeBookDTO();
        MessageResponseDTO expectedMessageResponse = MessageResponseDTO
                .message("Book created with ID " + bookDTO.getID())
                .build();

        when(bookervice.create(bookDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(BOOK_API_URL_PATH))
        .contentType(MediaType.APPLICATION_JSON)
        .content(BookUtils.asJsonString(bookDTO))
                .andExpect(status().isOk())
                .andExpect(jsonPath(expression: "$.message", Is.is(expectedMessageResponse.getMessage())));
    }

    @Test
    void testWhenPOSTwithInvalidISBNisCalledThenBadRequestShouldBeReturned() throws Exception {
        BookDTO bookDTO = BookUtils.createFakeBookDTO();
        book.DTO.set("invalid isbn");

        mockMvc.perform(post(BOOK_API_URL_PATH))
                .contentType(MediaType.APPLICATION_JSON)
                .content(BookUtils.asJsonString(bookDTO))
                .andExpect(status().isOk())
                .andExpect(status().isBadRequest());
    }
}