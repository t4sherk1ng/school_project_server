package com.samsung.service;

import com.samsung.domain.Book;

import java.util.List;

public interface BookService {

    Book insert(String nameBook,
                String nameAuthor,
                String nameGenre,
                String nameUser,
                String description,
                String photo_path);

    Book update(int id,
                String nameBook,
                String nameGenre,
                String nameAuthor,
                String nameUser,
                String description,
                String photo_path);

    List<Book> getAll();

    Book getById(int id);

    Book getByName(String name);

    void deleteById(int id);
}