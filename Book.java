package library.record;

import java.lang.String;

public class Book extends Record {
    private String author;
    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
}

