package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="Book")
@Table(name="books")


public class Book {
    private String title;
    private String author;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int id;
    private String isbn;

    @Column(name="publication_year")
    private int publicationYear;


    /**
     * Instantiates a new Book.
     */
    public Book() {

    }


    /**
     * Instantiates a new Book.
     *
     * @param title           the title
     * @param author          the author
     * @param id              the id
     * @param isbn            the isbn
     * @param publicationYear the publication year
     */
    public Book(String title, String author, int id, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }


    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }


    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets publication year.
     *
     * @return the publication year
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets publication year.
     *
     * @param publicationYear the publication year
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }



}