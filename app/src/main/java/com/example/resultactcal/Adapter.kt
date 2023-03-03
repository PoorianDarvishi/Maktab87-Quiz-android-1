package com.example.resultactcal


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val items: MutableList<Task>,
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tv_title)
        val itemDate: TextView = itemView.findViewById(R.id.tv_date)
        val itemInfo: TextView = itemView.findViewById(R.id.tv_info)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_re, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = items[position].title
        holder.itemDate.text = items[position].date
        holder.itemInfo.text = items[position].info
    }


    override fun getItemCount(): Int {
        return items.size
    }
}