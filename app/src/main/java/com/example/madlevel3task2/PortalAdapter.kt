package com.example.madlevel3task2

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PortalAdapter(private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun databind(reminder: Portal) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}