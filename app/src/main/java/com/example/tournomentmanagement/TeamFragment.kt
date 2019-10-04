package com.example.tournomentmanagement


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.tournomentmanagement.adapters.TeamsListViewAdapter
import com.example.tournomentmanagement.models.Team

/**
 * A simple [Fragment] subclass.
 */
class TeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teamList = ArrayList<Team>()
        teamList.add(Team("Ali", 1))
        teamList.add(Team("Hassan", 1))
        teamList.add(Team("Sajjad", 1))

        val teamListView = activity?.findViewById<ListView>(R.id.lv_teams)
        val adapter = TeamsListViewAdapter(activity?.applicationContext, teamList)
        teamListView?.adapter = adapter
    }
}
