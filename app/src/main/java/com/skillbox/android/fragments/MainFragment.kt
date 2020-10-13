package com.example.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.skillbox.android.R
import timber.log.Timber


class MainFragment : Fragment(R.layout.fragment_main), InteractionParentFragment {
    private var isTablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("${hashCode()}")

        isTablet = resources.getBoolean(R.bool.isTablet)
        if (savedInstanceState == null) when (isTablet) {
            false -> loadListFragment()
            true -> loadDetailFragment("""nothing ¯\_(ツ)_/¯""")
        }

    }

    override fun loadListFragment() {
        Timber.d("${hashCode()}")

        childFragmentManager.commit {
            replace(R.id.fragment_main_container, ListFragment())
        }
    }


    override fun loadDetailFragment(text: String) {
        Timber.d("${hashCode()}")

        childFragmentManager.commit {
            setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            replace(R.id.fragment_main_container, DetailFragment.newInstance(text))
            if (!isTablet) addToBackStack("loadDetailFragment")
        }
    }


    // Logs
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("${hashCode()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("${hashCode()}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("${hashCode()}")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
