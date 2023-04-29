package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Book {
    private String id;
    private String author;
    private String title;
    private String genre;
    private String price;
    private String publishDate;
    private String description;
}
