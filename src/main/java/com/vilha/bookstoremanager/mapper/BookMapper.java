package com.vilha.bookstoremanager.mapper;

import com.vilha.bookstoremanager.dto.BookDTO;
import com.vilha.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
