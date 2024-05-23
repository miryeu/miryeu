package com.example.days8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class NewsAdapter(context: Context, private val newsList: List<News>) :
    ArrayAdapter<News>(context, 0, newsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false)
        }

        val news = newsList[position]

        val titleTextView = view!!.findViewById<TextView>(R.id.r_title)
        titleTextView.text = news.title

        val imageView = view.findViewById<ImageView>(R.id.r_img)
        Glide.with(context)
            .load(news.img)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)


        return view
    }
}