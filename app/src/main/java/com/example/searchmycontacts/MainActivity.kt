package com.example.searchmycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // declare DBHandler as mutable field using null safety
    var dbHandler: DBHandler? = null

    // declare RecyclerView as mutable field using null safety
    var contactRecyclerView: RecyclerView? = null

    // declare a StudentAdapter as a mutable field
    // specify that it will be initialized later
    lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fully initialize dbHandler
        dbHandler = DBHandler(this, null)

        // make RecyclerView refer to actual RecyclerView in activity_main layout resource
        contactRecyclerView = findViewById<View>(R.id.contactRecyclerView) as RecyclerView

        // initialize a MutableList of contacts
        var contact: MutableList<Contact> = ArrayList()

        // initialize the SAdapter
        contactAdapter = ContactAdapter(contact)

        // tell Kotlin that RecyclerView isn't null and set the contactAdapter on it
        contactRecyclerView!!.adapter = contactAdapter

        // tell Kotlin that the RecylerView isn't null and apply a LinearLayout to it
        contactRecyclerView!!.layoutManager = LinearLayoutManager(this)

        // populate the contact table in the database
        // these lines of code should be commented out after the
        // app is run the first time
        addContact("Family Contact 1", "fam1@chciedu", "Family")
        addContact("Family Contact 2", "fam2@chciedu", "Family")
        addContact("Friend Contact 1", "fri1@chciedu", "Friends")
        addContact("Friend Contact 2", "fam2@chciedu", "Friends")
        addContact("Coworker Contact 1", "co1@chciedu", "Coworker")

    }
    /**
     * This method populates a contact in the database.  It gets called when
     * the app launches.
     * @param name contact name
     * @param email contact major
     * @param group_name contact group
     */
    fun addContact(name: String, email: String, group_name: String) {
        dbHandler?.addContact(name, email, group_name)
    }
    /**
     * This method gets called when the Search button is clicked.  It
     * searches for students based on the specified search criteria and
     * refreshes the StudentAdapter with the retrieved data so that it
     * may be displayed in the RecyclerView.
     * @param view MainActivity
     */
    fun family(view: View?){

                // call search by year in ContactAdapter
                ContactAdapter.family(dbHandler!!, "group_name", family)
                // refresh StudentAdapter Mutable List
                contactAdapter.contact = dbHandler!!.family("group_name", family)

    }

    fun friends(view: View?){

        // call search by year in ContactAdapter
        ContactAdapter.friends(dbHandler!!, "group_name", friends)
        // refresh StudentAdapter Mutable List
        contactAdapter.contact = dbHandler!!.family("group_name", friends)

    }

    fun coworkers(view: View?){

        // call search by year in ContactAdapter
        ContactAdapter.coworkers(dbHandler!!, "group_name", coworkers)
        // refresh StudentAdapter Mutable List
        contactAdapter.contact = dbHandler!!.family("group_name", coworkers)

    }
}