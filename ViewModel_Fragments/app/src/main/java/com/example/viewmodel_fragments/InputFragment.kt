package com.example.viewmodel_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.viewmodel_fragments.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!
    private val mathViewModel: MathViewModel by activityViewModels()

    // Start
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("InputFragment","onCreateView")
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Apply changes
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Button settings
        binding.btnCalculate.setOnClickListener {
            // Pick data
            Log.d("values",binding.firstNumEditText.text.toString())
            val number1: Double = try {
                binding.firstNumEditText.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                0.0  // or handle the error in a different way
            }
            val number2: Double = try {
                binding.secondNumEditText.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                0.0  // or handle the error in a different way
            }
            val operation = binding.operationSpinner.selectedItem.toString()
            Log.d("degerler",number1.toString())
            // Fragment settings
            val resultFragment = ResultFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            mathViewModel.calculate(number1,number2,operation)

            fragmentTransaction.replace(R.id.fragment_container,resultFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

        override fun onDestroyView() {
            Log.d("InputFragment", "onDestroyView")
            super.onDestroyView()
            _binding = null
        }
    }