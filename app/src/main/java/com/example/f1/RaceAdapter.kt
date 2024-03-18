package com.example.f1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RaceAdapter : RecyclerView.Adapter<RaceAdapter.RaceViewHolder>() {
    private var races: List<Race> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_race, parent, false)
        return RaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: RaceViewHolder, position: Int) {
        val race = races[position]
        holder.bind(race)
    }

    override fun getItemCount(): Int {
        return races.size
    }

    fun setData(races: List<Race>) {
        this.races = races
        notifyDataSetChanged()
    }

    class RaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val raceName: TextView = itemView.findViewById(R.id.raceName)
        private val date: TextView = itemView.findViewById(R.id.date)
        private val time: TextView = itemView.findViewById(R.id.time)

        fun bind(race: Race) {
            raceName.text = race.raceName
            date.text = race.date
            time.text = race.time
        }
    }
}
