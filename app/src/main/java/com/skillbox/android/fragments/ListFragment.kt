package com.example.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.skillbox.android.R
import kotlinx.android.synthetic.main.fragment_list.*
import timber.log.Timber

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("${hashCode()}")

        val listItem = List(20) { "Item $it" }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listItem)
        list_view.adapter = adapter

        list_view.setOnItemClickListener { _, _, position, _ ->
            (parentFragment as InteractionParentFragment).loadDetailFragment(listItem[position])
        }
    }


    // Logs
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("${hashCode()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("${hashCode()}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("${hashCode()}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("${hashCode()}")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.d("${hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("${hashCode()}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.d("${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${hashCode()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("${hashCode()}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("${hashCode()}")
    }
}
