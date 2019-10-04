package com.example.tournomentmanagement.models

class Match {
    var id: Int = 0
    var teamHomeId: Int? = null
    var teamAwayId: Int? = null
    var teamHomeScore: Int? = null
    var teamAwayScore: Int? = null
    var week: Int? = null

    constructor(id: Int, teamHomeId: Int, teamAwayId: Int, teamHomeScore: Int, teamAwayScore: Int, week: Int) {
        this.id = id
        this.teamHomeId = teamHomeId
        this.teamAwayId = teamAwayId
        this.teamHomeScore = teamHomeScore
        this.teamAwayScore = teamAwayScore
        this.week = week
    }

    constructor(teamHomeId: Int, teamAwayId: Int, teamHomeScore: Int, teamAwayScore: Int, week: Int) {
        this.teamHomeId = teamHomeId
        this.teamAwayId = teamAwayId
        this.teamHomeScore = teamHomeScore
        this.teamAwayScore = teamAwayScore
        this.week = week
    }
}