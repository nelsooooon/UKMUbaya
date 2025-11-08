package com.example.ukmubaya

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.ukmubaya.databinding.FragmentEventDetailBinding

private val ARG_EVENT = "event"

class EventDetailFragment : DialogFragment() {
    private var event : Event ?= null
    private lateinit var binding : FragmentEventDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            event = it.getParcelable(ARG_EVENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventDetailBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        
        /*
        binding.txtTitle.text = event?.name
        binding.txtDesc.text = event?.description
        binding.progressCrew.max = event?.crewNeed ?: 0
        binding.progressCrew.progress = event?.total ?: 0
        binding.imgEvent.setImageResource(event?.pictureID ?: R.drawable.programming)
        */

        event?.apply {
            with(binding) {
                txtTitle.text = name
                txtDesc.text = description
                progressCrew.max = crewNeed
                progressCrew.progress = total
                imgEvent.setImageResource(pictureID)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(event : Event) =
            EventDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_EVENT, event)
                }
            }
    }
}