package com.samsung.rest.dto;

import com.samsung.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private int id;

    private String name;

    private AuthorDto authorDto;

    private GenreDto genreDto;

    private UserDto userDto;

    private String description;

    private String photo_path;


    public static Book toDomainObject(BookDto bookDto) {

        return new Book(
                bookDto.getId(),
                bookDto.getName(),
                AuthorDto.toDomainObject(bookDto.getAuthorDto()),
                GenreDto.toDomainObject(bookDto.getGenreDto()),
                UserDto.toDomainObject(bookDto.getUserDto()),
                bookDto.getDescription(),
                bookDto.getPhoto_path()
        );
    }

    public static BookDto toDto(Book book) {

        return new BookDto(
                book.getId(),
                book.getName(),
                AuthorDto.toDto(book.getAuthor()),
                GenreDto.toDto(book.getGenre()),
                UserDto.toDto(book.getUser()),
                book.getDescription(),
                book.getPhoto_path()
        );

    }
}