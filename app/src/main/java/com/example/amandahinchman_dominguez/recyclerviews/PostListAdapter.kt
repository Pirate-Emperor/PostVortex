// Pirate-Emperor - Author
// This is a Kotlin Adapter class for displaying a list of gaming-themed posts using RecyclerView

package com.example.gamingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Adapter class to bind the data to RecyclerView
class PostListAdapter(private val postList: List<Post>)
    : RecyclerView.Adapter<PostViewHolder>() {

    // Inflate the item layout and create the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PostViewHolder(inflater, parent)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post: Post = postList[position]
        holder.bind(post)
    }

    // Return the total count of items
    override fun getItemCount(): Int = postList.size
}

// ViewHolder class to hold and bind the views
class PostViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    
    private var titleTextView: TextView? = null
    private var descriptionTextView: TextView? = null
    private var postImageView: ImageView? = null

    // Initialize the views from the item layout
    init {
        titleTextView = itemView.findViewById(R.id.list_title)
        descriptionTextView = itemView.findViewById(R.id.list_description)
        postImageView = itemView.findViewById(R.id.list_image)
    }

    // Bind the Post data to the views
    fun bind(post: Post) {
        titleTextView?.text = post.title
        descriptionTextView?.text = post.description
        Glide.with(itemView.context)
            .load(post.imageUrl)
            .into(postImageView)
    }
}
