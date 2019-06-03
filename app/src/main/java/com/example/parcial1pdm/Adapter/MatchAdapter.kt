package com.example.parcial1pdm.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1pdm.R
import com.example.parcial1pdm.database.entities.Match
import kotlinx.android.synthetic.main.recyclerview_matches.view.*

class MatchAdapter (val click: (Match) -> Unit) : RecyclerView.Adapter<MatchAdapter.ViewHolder>(){

    private var matches = emptyList<Match>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (item: Match, click: (Match) -> Unit) = with(itemView){
            team_1.text = item.team1
            team_2.text = item.team2
            winner.text = item.winner
            this.setOnClickListener {
                click(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_matches, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) = holder.bind(matches[position], click)

    internal fun setMatches(matches: List<Match>){
        this.matches = matches
        notifyDataSetChanged()
    }

}