package io.github.a2kaido.grid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.a2kaido.grid.databinding.ItemRecyclerViewBinding

class RecyclerViewItemAdapter(
    private val items: List<String>,
) : RecyclerView.Adapter<RecyclerViewItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(
        val binding: ItemRecyclerViewBinding,
    ) : RecyclerView.ViewHolder(binding.root)
}