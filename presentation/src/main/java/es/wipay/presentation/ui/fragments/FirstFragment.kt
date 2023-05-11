/*
 * Copyright (c) 2023.
 */

package es.wipay.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import es.wipay.core.utils.showConfirmationDialogYesNo
import es.wipay.presentation.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

	private var _binding: FragmentFirstBinding? = null

	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		_binding = FragmentFirstBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		oneTapBack()
		binding.listButton.setOnClickListener {
			Toast.makeText(context, "Listando elementos...", Toast.LENGTH_SHORT).show()
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}


	private fun oneTapBack() {
		val callback = object : OnBackPressedCallback(true) {
			override fun handleOnBackPressed() {
				showConfirmationDialogYesNo(
					"Salir",
					"¿Seguro de que quieres salir de la aplicación?",
					"Salir",
					"Cancelar",
					{ requireActivity().finish() }
				)
			}
		}

		requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
	}
}