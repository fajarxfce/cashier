package com.fajar.onboarding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.fajar.feature.onboarding.R
import com.fajar.feature.onboarding.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : Fragment() {

    lateinit var binding: FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextBtn.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewPager)?.apply {
                currentItem = ++currentItem
            }
        }
        binding.previusBtn.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewPager)?.apply {
                currentItem = --currentItem
            }

        }
    }
}