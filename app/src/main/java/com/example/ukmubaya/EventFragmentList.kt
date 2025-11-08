package com.example.ukmubaya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

private val ARG_EVENTS = "events"
class EventFragmentList : ListFragment() {
    private var events : ArrayList<Event> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            events = it.getParcelableArrayList<Event>(ARG_EVENTS)
                    as ArrayList<Event>

            listAdapter = ArrayAdapter(requireContext(),
                android.R.layout.simple_list_item_1,
                events)
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var fragmentDetail = EventDetailFragment.newInstance(events[position])
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.apply {
                fragmentDetail.show(this, "dialog")
                //replace(R.id.container, fragmentDetail)
                //addToBackStack(null)
                //commit()
            }
    }

    companion object {
        @JvmStatic
        fun newInstance(events : ArrayList<Event>) =
            EventFragmentList().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_EVENTS, events)
                    // key - value pair
                }
            }
    }
}