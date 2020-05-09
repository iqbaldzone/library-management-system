package com.dz.librarymanagementsystem.response;

import com.dz.librarymanagementsystem.model.Author;
import com.dz.librarymanagementsystem.model.Book;
import com.dz.librarymanagementsystem.model.Publication;
import com.dz.librarymanagementsystem.model.Department;

public class BookResponse extends Book {

    private Author author;

    private Publication publication;

    private Department department;
}
