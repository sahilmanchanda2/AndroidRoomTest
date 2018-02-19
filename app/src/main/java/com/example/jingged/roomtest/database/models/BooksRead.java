package com.example.jingged.roomtest.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rahul on 2/19/18.
 */
@Entity(tableName = "books_read")
public class BooksRead {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "book_id")
    private int book_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
