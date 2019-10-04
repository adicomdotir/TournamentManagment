package com.example.tournomentmanagement

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tournomentmanagement.models.Match
import com.example.tournomentmanagement.models.Team
import com.example.tournomentmanagement.models.Tournament

class AppDBOpenHelper(context: Context,
                      factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME,
        factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TOURNAMENT_TABLE = ("CREATE TABLE " +
                TABLE_TOURNAMENT + "("
                + COLUMN_TOURNAMENT_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_TOURNAMENT_NAME + " TEXT,"
                + COLUMN_TOURNAMENT_PASS + " TEXT"
                + ")")
        db.execSQL(CREATE_TOURNAMENT_TABLE)

        val CREATE_TEAM_TABLE = ("CREATE TABLE " +
                TABLE_TEAM + "("
                + COLUMN_TEAM_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_TEAM_NAME + " TEXT,"
                + COLUMN_TEAM_TOUR_ID + " INTEGER"
                + ")")
        db.execSQL(CREATE_TEAM_TABLE)

        val CREATE_MATCH_TABLE = ("CREATE TABLE " +
                TABLE_MATCH + "("
                + COLUMN_MATCH_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_MATCH_TEAM_HOME_ID + " INTEGER,"
                + COLUMN_MATCH_TEAM_AWAY_ID + " INTEGER,"
                + COLUMN_MATCH_TEAM_HOME_SCORE + " INTEGER,"
                + COLUMN_MATCH_TEAM_AWAY_SCORE + " INTEGER,"
                + COLUMN_MATCH_WEEK + " INTEGER"
                + ")")
        db.execSQL(CREATE_MATCH_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOURNAMENT)
        onCreate(db)
    }

    fun addTournament(tournament: Tournament) {
        val values = ContentValues()
        values.put(COLUMN_TOURNAMENT_NAME, tournament.name)
        values.put(COLUMN_TOURNAMENT_PASS, tournament.password)
        val db = this.writableDatabase
        db.insert(TABLE_TOURNAMENT, null, values)
        db.close()
    }

    fun getAllTournament(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_TOURNAMENT", null)
    }

    fun addTeam(team: Team) {
        val values = ContentValues()
        values.put(COLUMN_TEAM_NAME, team.name)
        values.put(COLUMN_TEAM_TOUR_ID, team.tournamentId)
        val db = this.writableDatabase
        db.insert(TABLE_TEAM, null, values)
        db.close()
    }

    fun getAllTeam(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_TEAM", null)
    }

    fun addMatch(match: Match) {
        val values = ContentValues()
        values.put(COLUMN_MATCH_TEAM_AWAY_ID, match.teamAwayId)
        values.put(COLUMN_MATCH_TEAM_HOME_ID, match.teamHomeId)
        values.put(COLUMN_MATCH_TEAM_AWAY_SCORE, match.teamAwayScore)
        values.put(COLUMN_MATCH_TEAM_HOME_SCORE, match.teamHomeScore)
        values.put(COLUMN_MATCH_WEEK, match.week)
        val db = this.writableDatabase
        db.insert(TABLE_MATCH, null, values)
        db.close()
    }

    fun getAllMatch(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_MATCH", null)
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "App.db"

        val TABLE_TOURNAMENT = "tournaments"
        val COLUMN_TOURNAMENT_ID = "id"
        val COLUMN_TOURNAMENT_NAME = "name"
        val COLUMN_TOURNAMENT_PASS = "password"

        val TABLE_TEAM = "teams"
        val COLUMN_TEAM_ID = "id"
        val COLUMN_TEAM_NAME = "name"
        val COLUMN_TEAM_TOUR_ID = "tour_id"

        val TABLE_MATCH = "matches"
        val COLUMN_MATCH_ID = "id"
        val COLUMN_MATCH_TEAM_HOME_ID = "team_home_id"
        val COLUMN_MATCH_TEAM_AWAY_ID = "team_away_id"
        val COLUMN_MATCH_TEAM_HOME_SCORE = "team_home_score"
        val COLUMN_MATCH_TEAM_AWAY_SCORE = "team_away_score"
        val COLUMN_MATCH_WEEK = "week"
    }
}