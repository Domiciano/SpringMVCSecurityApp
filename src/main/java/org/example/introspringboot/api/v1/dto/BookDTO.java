package org.example.introspringboot.api.v1.dto;

public class BookDTO {

    private Integer id;
    private String title;
    private int publicationYear;
    private String genre;
    private Integer authorId;

    public BookDTO() {
    }

    public BookDTO(Integer id, String title, int publicationYear, String genre, Integer authorId) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.authorId = authorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
