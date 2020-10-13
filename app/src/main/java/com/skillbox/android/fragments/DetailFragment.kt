package com.example.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.extensions.withArguments
import com.skillbox.android.R
import kotlinx.android.synthetic.main.fragment_detail.*
import timber.log.Timber

class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        private const val KEY_TEXT = "KEY_TEXT"

        fun newInstance(text: String): DetailFragment {
            return DetailFragment().withArguments {
                putString(KEY_TEXT, text)
            }
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("${hashCode()}")

        tv_text.text = requireArguments().getString(KEY_TEXT)
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
