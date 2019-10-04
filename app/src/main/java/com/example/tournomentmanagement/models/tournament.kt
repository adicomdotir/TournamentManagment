package com.example.tournomentmanagement.models

import android.text.Editable

class Tournament {
    var id: Int = 0
    var name: String? = null
    var password: String? = null

    constructor(id: Int, name: String, password: String) {
        this.id = id
        this.name = name
        this.password = password
    }

    constructor(name: String?, password: String?) {
        this.name = name
        this.password = password
    }
}