package com.example.myweather.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myweather.databinding.ItemLocationBinding
import com.example.myweather.model.vworld.Location


class LocationAdapter:ListAdapter<Location,LocationAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding:ItemLocationBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(location:Location){
            binding.locationTextView.text = location.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        private val diffUtil = object : DiffUtil.ItemCallback<Location>(){
            override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
                return oldItem.title == newItem.title
            }

        }
    }
}