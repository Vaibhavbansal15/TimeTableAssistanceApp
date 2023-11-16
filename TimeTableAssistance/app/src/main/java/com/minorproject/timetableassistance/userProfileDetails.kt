package com.minorproject.timetableassistance

data class UserProfileDetails(val email : String , val enroll : String,
                              val sem : String, val branch : String,
                              val batch : String, val pass : String  ){

    constructor() : this("","","","","","")
}
