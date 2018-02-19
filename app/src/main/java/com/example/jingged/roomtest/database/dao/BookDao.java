package com.example.jingged.roomtest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.jingged.roomtest.database.models.Book;

import java.util.List;

/**
 * Created by Rahul on 2/19/18.
 */
@Dao
public interface BookDao {
    @Query("SELECT * FROM books where id IN(:ids)")
    List<Book> getBooksByIds(int[] ids);
    @Query("SELECT * FROM books")
    List<Book> getBooks();
    @Query("SELECT * FROM books where id = :id")
    Book getBookById(int id);
    @Insert
    void insertBook(Book book);
    @Insert
    void insertBooks(List<Book> books);
}
