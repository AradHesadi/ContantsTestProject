package com.example.contactstestproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.contactstestproject.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Contact.class, version = 1, exportSchema = false)
public abstract class ContactsRoomDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "contacts.db";
    private static final int NUMBER_OF_THREADS = 2;

    public static ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(2);

    public abstract ContactsDAO getContactsDAO();

    public static ContactsRoomDatabase getDatabase(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                ContactsRoomDatabase.class,
                ContactsRoomDatabase.DATABASE_NAME).build();
    }
}
