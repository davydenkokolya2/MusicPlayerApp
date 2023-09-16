package com.example.musicplayerapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerapp.databinding.ItemCardBinding
import com.example.musicplayerapp.domain.Song


class SongViewAdapter(data: List<Song>, private val onClick:(song: Song) -> Unit) : RecyclerView.Adapter<SongViewAdapter.StringViewHolder>() {

    var list: List<Song> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class StringViewHolder(
        val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)

        return StringViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val item = list[position]
        holder.binding.ivImageSong.setImageResource(item.image)
        holder.binding.tvAuthorSong.setText(item.author)
        holder.binding.tvTitleSong.setText(item.title)
        holder.binding.tvNumberSong.text = "${position + 1}"
        holder.binding.imageView4.setOnClickListener {
            onClick(item)
        }

    }
}

