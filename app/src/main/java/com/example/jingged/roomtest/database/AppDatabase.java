package com.example.jingged.roomtest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.jingged.roomtest.database.models.Book;
import com.example.jingged.roomtest.database.models.BooksRead;
import com.example.jingged.roomtest.database.models.BooksToRead;
import com.example.jingged.roomtest.database.dao.BookDao;
import com.example.jingged.roomtest.database.dao.BooksReadDao;
import com.example.jingged.roomtest.database.dao.BooksToReadDao;

/**
 * Created by Rahul on 2/19/18.
 */
@Database(entities = {Book.class,BooksRead.class,BooksToRead.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract BookDao bookDao();
    public abstract BooksReadDao booksReadDao();
    public abstract BooksToReadDao booksToReadDao();



    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
