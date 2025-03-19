package com.hansheung.mob22.model

class UserRepo {

    fun login(user: User): Boolean{
        if(user.login == "fcuser" && user.pass =="qwerqwer") return true
        return false
    }
}