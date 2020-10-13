package com.skillbox.android

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.commit
import com.example.fragments.extensions.toast
import com.example.fragments.fragments.LoginFragment
import com.example.fragments.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity(), InteractionActivity {

    companion object {
        const val KEY_STATE = "KEY_STATE"
        const val TAG_MAIN_FRAGMENT = "TAG_MAIN_FRAGMENT"
    }

    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("${hashCode()}")

        showLoginFragment()
    }

    private fun showLoginFragment() {
        Timber.d("${hashCode()}")
        val alreadyHasFragment = supportFragmentManager.findFragmentById(R.id.container) != null
        if (!alreadyHasFragment) {
            supportFragmentManager.commit {
                setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                replace(R.id.container, LoginFragment())
            }
        } else {
            Timber.d("${hashCode()} Уже есть фрагмент")
        }
    }

    override fun showProgressbar() {
        Timber.d("${hashCode()}")

        val bar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        bar.id = R.id.pb_progressBar
        layout.addView(bar)
        val set = ConstraintSet()
        with(set) {
            constrainHeight(bar.id, ConstraintSet.WRAP_CONTENT)
            constrainWidth(bar.id, ConstraintSet.WRAP_CONTENT)
            connect(bar.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0)
            connect(bar.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
            connect(bar.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
            connect(bar.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
            applyTo(layout)
        }
        progressBar = bar
    }

    override fun hideProgressbar() {
        Timber.d("${hashCode()}")

        layout.removeView(progressBar)
        progressBar = null
    }

    override fun showToast(text: String) {
        Timber.d("${hashCode()}")

        toast(text)
    }

    override fun loadMainFragment() {
        Timber.d("${hashCode()}")

        supportFragmentManager.commit {
            setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            replace(R.id.container, MainFragment(), TAG_MAIN_FRAGMENT)
        }
    }

    override fun onBackPressed() {
        Timber.d("${hashCode()}")

        val fragmentMain = supportFragmentManager.findFragmentByTag(TAG_MAIN_FRAGMENT)

        if (fragmentMain != null && fragmentMain.childFragmentManager.backStackEntryCount > 0) {
            fragmentMain.childFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}


