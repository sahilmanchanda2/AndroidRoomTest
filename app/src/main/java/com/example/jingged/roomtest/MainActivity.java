package com.example.jingged.roomtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jingged.roomtest.database.AppDatabase;
import com.example.jingged.roomtest.database.models.Book;
import com.example.jingged.roomtest.database.models.BooksRead;
import com.example.jingged.roomtest.database.models.BooksToRead;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static String TAG = MainActivity.class.getSimpleName();
    AppDatabase app;
    private void addBooks() {
        List<Book> bookInsert = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Book b = new Book();
            b.setName(String.format("Book %d", i));
            b.setAuthor(String.format("Author %d", i));
            bookInsert.add(b);
        }
        app.bookDao().insertBooks(bookInsert);
        List<Book> getBooks = app.bookDao().getBooks();
        print("Books", getBooks);
    }

    public void addBooksToRead() {
        BooksToRead b1 = new BooksToRead();
        b1.setBook_id(3);
        BooksToRead b2 = new BooksToRead();
        b2.setBook_id(4);
        app.booksToReadDao().insert(b1);
        app.booksToReadDao().insert(b2);
    }

    private void addBooksRead() {
        BooksRead b1 = new BooksRead();
        b1.setBook_id(1);
        BooksRead b2 = new BooksRead();
        b2.setBook_id(2);
        app.booksReadDao().insert(b1);
        app.booksReadDao().insert(b2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = AppDatabase.getAppDatabase(this);
        addBooks();
        addBooksToRead();
        addBooksRead();
        printBooksToRead();
        printBooksRead();
    }

    private void print(String className, List<Book> books) {
        for (Book m : books) {
            Log.e(TAG, String.format("%s %s", className, m.toString()));
        }
    }

    private void printBooksRead() {
        List<BooksRead> theList = app.booksReadDao().getBooksRead();
        int ids[] = new int[theList.size()];
        for (int i = 0; i < theList.size(); i++) {
            ids[i] = theList.get(i).getBook_id();
        }
        List<Book> booksToRead = app.bookDao().getBooksByIds(ids);
        print("BooksRead", booksToRead);
    }


    private void printBooksToRead() {
        List<BooksToRead> theList = app.booksToReadDao().getBooksToReads();
        int ids[] = new int[theList.size()];
        for (int i = 0; i < theList.size(); i++) {
            ids[i] = theList.get(i).getBook_id();
        }
        List<Book> booksToRead = app.bookDao().getBooksByIds(ids);
        print("BooksToRead", booksToRead);
    }
}
