package com.example.backend.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.backend.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_helper.view.*

class RvAdapter: ListAdapter<NewsItem,ViewHolder>(DiffUtilCalback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_helper, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(getItem(position))
    }
}




class DiffUtilCalback : DiffUtil.ItemCallback<NewsItem >(){
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return  oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: NewsItem , newItem: NewsItem ): Boolean {
        return oldItem.desc  == newItem.desc
                && oldItem.title  == newItem.title
                && oldItem.image == newItem.image

    }
}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(item: NewsItem){
        itemView.tvOne.text = item.desc
        itemView.tvTwo.text = item.title
        Picasso.get().load(item.image).into(itemView.imageShow)

    }
}