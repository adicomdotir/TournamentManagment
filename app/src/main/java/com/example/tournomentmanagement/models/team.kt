package com.example.tournomentmanagement.models

class Team {
    var id: Int = 0
    var name: String? = null
    var tournamentId: Int? = null

    constructor(id: Int, name: String, tournamentId: Int) {
        this.id = id
        this.name = name
        this.tournamentId = tournamentId
    }

    constructor(name: String, tournamentId: Int) {
        this.name = name
        this.tournamentId = tournamentId
    }
}