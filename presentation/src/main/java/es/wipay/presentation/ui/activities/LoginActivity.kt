/*
 * Copyright (c) 2023.
 */

package es.wipay.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.snackbar.Snackbar
import es.wipay.presentation.R
import es.wipay.presentation.databinding.ActivityLoginBinding
import es.wipay.presentation.ui.fragments.LoginFragment

class LoginActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLoginBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		WindowCompat.setDecorFitsSystemWindows(window, false)
		super.onCreate(savedInstanceState)

		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val fragmentContainer = binding.fragmentLogin
		val loginFragment = LoginFragment()

		supportFragmentManager.beginTransaction()
			.replace(fragmentContainer.id, loginFragment)
			.commit()

		binding.fab.setOnClickListener { view ->
			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				.setAnchorView(R.id.fab)
				.setAction("Action", null).show()
		}
	}
}