package com.example.resultactcal

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.resultactcal.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding: FragmentSignUpBinding
    private val signUpViewMode: SignUpViewModel by viewModels()
    private val args: SignUpFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@SignUpFragment
            signUpViewModelXML = signUpViewMode
            signUpViewMode.userName.value = args.userName
            signUpViewMode.password.value = args.password
            signUp.setOnClickListener {
                if (signUpViewMode.checkSend()) {
                    setFragmentResult(LogInFragment.RESULT, bundleOf("Result" to "OK"))
                    Navigation.findNavController(view).navigate(SignUpFragmentDirections.actionSignUpFragmentToLogInFragment(
                            signUpViewMode.userName.value!!,
                            signUpViewMode.password.value!!
                        )
                    )
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Your username or password is empty :(",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}