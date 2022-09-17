package com.example.lab_02_mail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Create member variables for any view that will be set
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        // as you render a row.

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            //  Store each of the layout's views into
            senderTextView = itemView.findViewById(R.id.sender)
            titleTextView = itemView.findViewById(R.id.emailTitle)
            summaryTextView = itemView.findViewById(R.id.emailSummary)
        // the public final member variables created above
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}