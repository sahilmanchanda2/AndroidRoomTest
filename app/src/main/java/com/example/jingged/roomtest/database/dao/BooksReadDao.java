package com.example.jingged.roomtest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.jingged.roomtest.database.models.BooksRead;

import java.util.List;

/**
 * Created by Rahul on 2/19/18.
 */
@Dao
public interface BooksReadDao {
    @Query("SELECT * FROM books_read")
    List<BooksRead> getBooksRead();
    @Insert
    void insert(BooksRead book);
}
