package com.example.resultactcal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.resultactcal.databinding.FragmentLogInBinding
import com.google.android.material.snackbar.Snackbar


class LogInFragment : Fragment(R.layout.fragment_log_in) {
    lateinit var binding: FragmentLogInBinding
    private val logInViewModel: LogInViewModel by viewModels()
    private val args: LogInFragmentArgs by navArgs()

    companion object {
        const val RESULT = "RESULT_OK"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity?.intent?.getStringExtra(LoginSignupActivity.RESET) == LoginSignupActivity.SIGN_OUT) {
            logInViewModel.clearSharePref(requireContext())
        }

        val intent = Intent(requireContext(), TaskManagementActivity::class.java)
        if (logInViewModel.checkLogIn(requireContext())) {
            startActivity(intent)
            requireActivity().finish()
        }

        setFragmentResultListener(
            RESULT
        ) { _, _ ->
            logInViewModel.setMainUsername(args.userName)
            logInViewModel.setMainPassword(args.password)
        }

        binding = FragmentLogInBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@LogInFragment
            this.logIngViewModelXML = logInViewModel


            logIn.setOnClickListener {
                Snackbar.make(
                    it,
                    logInViewModel.check(requireContext()),
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setAction("undo") {}.show()

                if (logInViewModel.whatStatus()) {
                    startActivity(intent)
                    requireActivity().finish()
                }
            }
            signUp.setOnClickListener {
                Navigation.findNavController(view).navigate(LogInFragmentDirections.actionLogInFragmentToSignUpFragment(
                        logInViewModel.userName.value!!,
                        logInViewModel.password.value!!
                    )
                )
            }

        }
    }
}