package com.example.searchmycontacts

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler (context: Context?, cursorFactory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, cursorFactory, DATABASE_VERSION) {

    companion object {
        // initialize constants for the DB name and version
        private const val DATABASE_NAME = "searchmycontacts.db"
        private const val DATABASE_VERSION = 1

        // initialize constants for the student table
        private const val TABLE_CONTACT = "contact"
        private const val COLUMN_CONTACT_ID = "_id"
        private const val COLUMN_CONTACT_NAME = "name"
        private const val COLUMN_CONTACT_EMAIL = "email"
        private const val COLUMN_CONTACT_GROUP = "group_name"
    }


    /**
     * Creates database table
     * @param db reference to the searchmycontacts database
     */
    override fun onCreate(db: SQLiteDatabase) {
        // define create statement for contact table
        val query = "CREATE TABLE " + TABLE_CONTACT + "(" +
                COLUMN_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CONTACT_NAME + " TEXT, " +
                COLUMN_CONTACT_EMAIL + " TEXT, " +
                COLUMN_CONTACT_GROUP + " TEXT);"

        // execute create statement
        db.execSQL(query)
    }

    /**
     * Creates a new version of the database.
     * @param db reference to chcsearchapp database
     * @param oldVersion old version of the database
     * @param newVersion new version of the database
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        // define drop statement for the student table
        val query = "DROP TABLE IF EXISTS " + TABLE_CONTACT

        // execute the drop statement
        db.execSQL(query)

        // call method that creates the table
        onCreate(db)
    }
    /**
     * This method gets called by the MainActivity when the app launches.
     * It inserts a new row in the contact table.
     * @param name contact name
     * @param email contact email
     * @param group_name contact group
     */
    fun addContact(name: String?, email: String?, group_name: String?){

        // get reference to searchMyContacts database
        val db = writableDatabase

        // initialize a ContentValues object
        val values = ContentValues()

        // put data into the ContentValues object
        values.put(COLUMN_CONTACT_NAME, name)
        values.put(COLUMN_CONTACT_EMAIL, email)
        values.put(COLUMN_CONTACT_GROUP, group_name)

        // insert data in ContentValues object into student table
        db.insert(TABLE_CONTACT, null, values)

        // close database connection
        db.close()
    }

    /**
     * This method gets called by the family method in the ContactsAdapter.
     * It will select the contactss from the database that satisfy
     * the specified search criteria.
     */
    fun family(key: String, value: String?) : MutableList<Contact> {
        // get a reference to the searchmycontactsapp database
        val db = writableDatabase

        // initialize query String
        var query = ""

        if (key.equals("family")) {
            // define select statement and store it in query String
            query = "SELECT * FROM " + TABLE_CONTACT +
                    " WHERE " + COLUMN_CONTACT_GROUP + " = " + "'" + value + "'"
        } else {
            // define select statement and store it in query String
            query = "SELECT * FROM " + TABLE_CONTACT +
                    " WHERE " + COLUMN_CONTACT_GROUP + " = " + "'" + value + "'"
        }

        // execute the select statement and store its return in an
        // immutable Cursor
        val c = db.rawQuery(query, null)

        // create MutableList of Contacts that will be
        // returned by the method
        val list: MutableList<Contact> = ArrayList()

        // loop through the rows in the Cursor
        while (c.moveToNext()) {
            // create an immutable Contact using the data in the current
            // row in the Cursor
            val contact: Contact = Contact(c.getInt(c.getColumnIndex("_id")),
                c.getString(c.getColumnIndex("name")),
                c.getString(c.getColumnIndex("email")),
                c.getString(c.getColumnIndex("group_name")));
            // add the Student that was just created into the MutableList
            // of Students
            list.add(contact)
        }

        // close database reference
        db.close()

        // return the MutableList of Students
        return list
    }
    /**
     * This method gets called by the contact method in the ContatcsAdapter.
     * It will select the contacts from the database that satisfy
     * the specified search criteria.
     */
    fun friends(key: String, value: String?) : MutableList<Contact> {
        // get a reference to the searchmycontactsapp database
        val db = writableDatabase

        // initialize query String
        var query = ""

        if (key.equals("friends")) {
            // define select statement and store it in query String
            query = "SELECT * FROM " + TABLE_CONTACT +
                    " WHERE " + COLUMN_CONTACT_GROUP + " = " + "'" + value + "'"
        } else {
            // define select statement and store it in query String
            query = "SELECT * FROM " + TABLE_CONTACT +
                    " WHERE " + COLUMN_CONTACT_GROUP + " = " + "'" + value + "'"
        }

        // execute the select statement and store its return in an
        // immutable Cursor
        val c = db.rawQuery(query, null)

        // create MutableList of Contacts that will be
        // returned by the method
        val list: MutableList<Contact> = ArrayList()

        // loop through the rows in the Cursor
        while (c.moveToNext()) {
            // create an immutable Contact using the data in the current
            // row in the Cursor
            val contact: Contact = Contact(c.getInt(c.getColumnIndex("_id")),
                c.getString(c.getColumnIndex("name")),
                c.getString(c.getColumnIndex("email")),
                c.getString(c.getColumnIndex("group_name")));
            // add the Student that was just created into the MutableList
            // of Contacts
            list.add(contact)
        }

        // close database reference
        db.close()

        // return the MutableList of Contacts
        return list
    }

    /**
     * This method gets called by the family method in the ContactAdapter.
     * It will select the contacts from the database that satisfy
     * the specified search criteria.
     */
    fun coworkers(key: String, value: String?) : MutableList<Contact> {
        // get a reference to the searchmycontactsapp database
        val db = writableDatabase

        // initialize query String
        var query = ""

        if (key.equals("coworkers")) {
            // define select statement and store it in query String
            query = "SELECT * FROM " + TABLE_CONTACT +
                    " WHERE " + COLUMN_CONTACT_GROUP + " = " + "'" + value + "'"
        } else {
            // define select statement and store it in query String
            query = "SELECT * FROM " + TABLE_CONTACT +
                    " WHERE " + COLUMN_CONTACT_GROUP + " = " + "'" + value + "'"
        }

        // execute the select statement and store its return in an
        // immutable Cursor
        val c = db.rawQuery(query, null)

        // create MutableList of Contacts that will be
        // returned by the method
        val list: MutableList<Contact> = ArrayList()

        // loop through the rows in the Cursor
        while (c.moveToNext()) {
            // create an immutable Contact using the data in the current
            // row in the Cursor
            val contact: Contact = Contact(c.getInt(c.getColumnIndex("_id")),
                c.getString(c.getColumnIndex("name")),
                c.getString(c.getColumnIndex("email")),
                c.getString(c.getColumnIndex("group_name")));
            // add the Student that was just created into the MutableList
            // of Students
            list.add(contact)
        }

        // close database reference
        db.close()

        // return the MutableList of Contacts
        return list
    }

}