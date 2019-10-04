package com.example.tournomentmanagement.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tournomentmanagement.R
import com.example.tournomentmanagement.models.Team

class TeamsListViewAdapter (private val context: Context?, teamsList: List<Team>) : BaseAdapter() {

    private var teamsList = ArrayList<Team>()

    init {
        this.teamsList = teamsList as ArrayList
    }

    override fun getCount(): Int {
        return teamsList.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    @SuppressLint("InflateParams", "ViewHolder")
    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View {
        var vi: View? = convertView
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        vi = inflater.inflate(R.layout.team_row, null)
        val title = vi.findViewById<TextView>(R.id.tv_name)
        title.text = teamsList[i].name
        return vi
    }
}