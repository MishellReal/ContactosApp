package com.epnfis.contactosapp

class contact {

    var id: Int = 0
    var name: String? = null
    var phone_number: String? = null

    constructor() {}
    constructor(myId: Int, myName: String?, phone_number: String) {
        this.id = myId
        this.name = myName
        this.phone_number = phone_number

    }

    constructor(myName: String?, phone_number: String) {
        this.name = myName
        this.phone_number = phone_number
    }
}