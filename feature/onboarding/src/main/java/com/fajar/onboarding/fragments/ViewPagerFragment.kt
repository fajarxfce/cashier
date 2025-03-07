package com.fajar.onboarding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fajar.feature.onboarding.databinding.FragmentViewPagerBinding
import com.fajar.onboarding.adapter.ViewPagerAdapter
import com.fajar.onboarding.fragments.FirstScreenFragment
import com.fajar.onboarding.fragments.SecondScreenFragment
import com.fajar.onboarding.fragments.ThirdScreenFragment

class ViewPagerFragment : Fragment() {

    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentsList = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )
        val adapter = ViewPagerAdapter(
            fragmentsList, requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter
    }
}