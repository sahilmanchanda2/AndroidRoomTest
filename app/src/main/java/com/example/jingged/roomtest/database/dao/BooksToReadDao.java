package com.example.jingged.roomtest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.jingged.roomtest.database.models.BooksToRead;

import java.util.List;

/**
 * Created by Rahul on 2/19/18.
 */
@Dao
public interface BooksToReadDao {
    @Query("SELECT * FROM books_to_read")
    List<BooksToRead> getBooksToReads();
    @Insert
    void insert(BooksToRead book);

}
