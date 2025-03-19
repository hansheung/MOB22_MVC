package com.hansheung.mob22.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.hansheung.mob22.R
import com.hansheung.mob22.controller.HomeController
import com.hansheung.mob22.controller.LoginController
import com.hansheung.mob22.databinding.FragmentLoginBinding
import com.hansheung.mob22.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {

    private lateinit var binding: FragmentLoginBinding
    private val controller = LoginController(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            controller.login(
                binding.etLogin.text.toString(),
                binding.etPassword.text.toString()
            )
        }
    }

    override fun navigateHome() {
        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        findNavController().navigate(action)
    }

    override fun showErrorMsg(msg: String, success:Boolean) {
        Snackbar.make(requireView(), msg, Snackbar.LENGTH_LONG).apply {
            if(!success){
                setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.black))
            }
        }.show()
    }

//    override fun LoginAction(response: Boolean) {
//        if(response){
//            val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
//            findNavController().navigate(action)
//        }else{
//            Snackbar.make(requireView(), "Invalid Login", Snackbar.LENGTH_LONG).show()
//        }
//    }


}

interface LoginView {
    //fun LoginAction(response: Boolean)

    fun navigateHome()
    fun showErrorMsg(msg: String, success: Boolean=false)
}