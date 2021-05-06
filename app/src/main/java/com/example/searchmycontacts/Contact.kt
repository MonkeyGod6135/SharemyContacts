package com.example.searchmycontacts

/**
 * The Contact data class has four fields that map to the
 * columns in the student table in the database.  It will be used
 * to exchange data between the database and the RecylerView.
 */
data class Contact(
    // declare an immutable Int to store the student id
    val id: Int,
    // declare an immutable String to store the student name
    val name: String,
    // declare an immutable String to store the student major
    val email: String,
    // declare an immutable String to store the student major
    val group_name: String
)