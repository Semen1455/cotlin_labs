package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8.databinding.RecycleViewBinding


class LanguageAdapter (private val items: List<Pair<String, String?>>,
                       private val onItemClick: (position: Int) -> Unit):
                    RecyclerView.Adapter<LanguageAdapter.LanguageHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        val binding = RecycleViewBinding.inflate(LayoutInflater.from(parent.context))
        return LanguageHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        val languageName = items[position]
        holder.bind(languageName.first, languageName.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class LanguageHolder(private val binding: RecycleViewBinding,
                         private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.languageButton.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }

            fun bind(languageName: String, imageUrl: String?) {
                Glide.with(binding.imageView)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(binding.imageView.drawable)
                    .error(R.drawable.ic_launcher_background)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .into(binding.imageView)
                binding.languageButton.text = languageName
        }
    }
}