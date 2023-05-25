package com.example.viewmodel_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_fragments.databinding.FragmentInputBinding
import com.example.viewmodel_fragments.databinding.FragmentResultBinding

class ResultFragment : Fragment() {


    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val mathViewModel: MathViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mathViewModel.result.observe(viewLifecycleOwner, Observer {
            binding.tvResultValue.text = it.toString()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
