package com.hansheung.mob22.controller

import com.hansheung.mob22.model.User
import com.hansheung.mob22.model.UserRepo
import com.hansheung.mob22.view.LoginView

class LoginController(
    private val view: LoginView
) {
    //val UserRepo = UserRepo()

    fun login(username: String, pass:String) {
        val msg = verifyUserInfo(username, pass)
        if(msg.isNotEmpty()){
            view.showErrorMsg(msg,true)
            return
        }
        view.navigateHome()
    }

    fun verifyUserInfo(username: String, pass: String): String {
        if(username!= "fcuser") {
            return "username is invalid"
        }

        if(pass !="qwerqwer") {
            return "Wrong Password"
        }
        return ""
    }
    //********My solution***********************
//    fun loginUser(user: User){
          //********Using repo but not neccessary****
//        val response = UserRepo.login(user)
//        view.LoginAction(response)
          //*******************************

//        var response: Boolean = false
//        if(user.login =="fcuser" && user.pass =="qwerqwer"){
//            response = true
//        }

//        view.LoginAction(response)
//    }
    //***********************************************
}