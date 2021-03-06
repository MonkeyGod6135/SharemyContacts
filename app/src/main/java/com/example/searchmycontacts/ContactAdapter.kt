package com.example.searchmycontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(// declare a MutableList of Students
    var contact: MutableList<Contact>
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){

    // declare a ViewHolder that will hold the layout of an item in
    // the RecyclerView
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // declare TextView immutable field using null safety
    var nameTextView: TextView? = null)

    /**
     * Create a StudentViewHolder that references the li_main layout resource
     * and return it.
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactAdapter.ContactViewHolder {
        return  ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.li_main,
                parent,
                false
            ))
    }
    /**
     * Initialize each of the items in the RecyclerView and map the
     * data in the MutableList of Students to it.
     */
    override fun onBindViewHolder(holder: ContactAdapter.ContactViewHolder, position: Int) {
        // get current item in MutableList of Students and store it in
        // immutable variable
        val currentContact = contact[position]

        holder.itemView.apply {
            // make TextView refer to TextView in li_main layout resource
            nameTextView = findViewById<View>(R.id.nameTextView) as TextView
            // assign the name value in the current item to text attribute of
            // TextView
            nameTextView!!.text = currentContact.name
        }
    }

    /**
     * Return the number of items in the MutableList of ToDos
     */
    override fun getItemCount(): Int {
        return contact.size
    }

    /**
     * This method gets called by the search method in the MainActivity
     * when the family button is clicked.  It will call the DBHandler method
     * that searches for students based on the specified search criteria.
     */
    fun family(dbHandler: DBHandler, key: String, value: String) {
        dbHandler?.family(key, value)
        notifyDataSetChanged()
    }

    /**
     * This method gets called by the search method in the MainActivity
     * when the friends button is clicked.  It will call the DBHandler method
     * that searches for students based on the specified search criteria.
     */
    fun friends(dbHandler: DBHandler, key: String, value: String) {
        dbHandler?.friends(key, value)
        notifyDataSetChanged()
    }

    /**
     * This method gets called by the search method in the MainActivity
     * when the coworkers button is clicked.  It will call the DBHandler method
     * that searches for students based on the specified search criteria.
     */
    fun coworkers(dbHandler: DBHandler, key: String, value: String) {
        dbHandler?.coworkers(key, value)
        notifyDataSetChanged()
    }

}