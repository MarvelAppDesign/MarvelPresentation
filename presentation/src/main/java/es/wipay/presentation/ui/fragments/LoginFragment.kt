/*
 * Copyright (c) 2023.
 */

package es.wipay.presentation.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import es.wipay.presentation.databinding.FragmentLoginBinding
import es.wipay.presentation.ui.activities.MainActivity

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

	private var _binding: FragmentLoginBinding? = null

	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		_binding = FragmentLoginBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.loginButton.setOnClickListener {
			checkLogin()
		}

		binding.passwordEditText.doOnTextChanged { text, _, _, _ ->
			if (!text.isNullOrEmpty()) {
				binding.passwordTextInputLayout.isEndIconVisible = true
			}
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	private fun checkLogin() {
		val username = binding.usernameEditText.text?.toString()
		val password = binding.passwordEditText.text?.toString()

		if (username.isNullOrEmpty()) {
			binding.usernameEditText.error = "Se necesita un nombre de usuario"
			return
		}

		if (password.isNullOrEmpty()) {
			binding.passwordTextInputLayout.isEndIconVisible = false
			binding.passwordEditText.error = "Se necesita una contraseña"
			return
		}

		val intent = Intent(requireContext(), MainActivity::class.java)
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
		startActivity(intent)
	}
}