package com.example.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fragments.data.LoginState
import com.example.fragments.extensions.hideKeyboard
import com.skillbox.android.InteractionActivity
import com.skillbox.android.Loginator
import com.skillbox.android.MainActivity.Companion.KEY_STATE
import com.skillbox.android.R
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        const val URL_LOGO =
            "https://sun9-7.userapi.com/z8u-rfVxboQ3SK-nnhU6d7PszQCS8EiyTR59bg/x4wd-36gtGE.jpg"
        const val MIN_PASSWORD_LENGTH = 4
    }

    private val listUiElements = mutableListOf<View>()
    private var loginState = LoginState()

    private var handler: Handler? = null
    private var runnable: Runnable? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("${hashCode()}")

        loadCover()
        imageView.requestFocus()

        listUiElements.addAll(listOf(edit_email, edit_password, checkBox, progressButton))
        buttonLoginUpdateStatus()

        edit_email.doAfterTextChanged { buttonLoginUpdateStatus() }
        edit_password.doAfterTextChanged { buttonLoginUpdateStatus() }
        checkBox.setOnCheckedChangeListener { _, _ ->
            hideKeyboard()
            buttonLoginUpdateStatus()
        }

        progressButton.setOnClickListener {
            hideKeyboard()
            login()
        }
    }

    private fun login() {
        Timber.d("${hashCode()}")

        disableUiElements()
        val actInteraction = activity as InteractionActivity
        actInteraction.showProgressbar()
        loginState = loginState.copy(isAuthProgress = true)

        runnable = Runnable {
            val result = Loginator().login(edit_email.toString(), edit_password.toString())
            loginState = loginState.copy(isAuthProgress = false)
            actInteraction.hideProgressbar()

            if (result) {
                actInteraction.showToast("Вы успешно залогинились")
                actInteraction.loadMainFragment()
            } else {
                actInteraction.showToast("Что-то пошло не так. Проверьте логин и пароль")
                enableUiElements()
            }
        }

        handler = Handler()
        actInteraction.showToast("Авторизация долгая, можно пока поубивать процесс...")
        handler!!.postDelayed(runnable!!, 5000)
    }


    private fun disableUiElements() = listUiElements.forEach { it.isEnabled = false }

    private fun enableUiElements() = listUiElements.forEach { it.isEnabled = true }

    private fun loadCover() {
        Glide
            .with(this)
            .load(URL_LOGO)
            .placeholder(R.drawable.ic_android_gray_72dp)
            .into(imageView)
    }

    private fun buttonLoginUpdateStatus() {
        progressButton.isEnabled = isValidEmail(edit_email.text.toString()) and
                isValidPassword(edit_password.text.toString()) and
                checkBox.isChecked
    }


    private fun isValidEmail(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                place_email.error = ""
                false
            }
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                place_email.error = ""
                return true
            }
            else -> {
                place_email.error = resources.getString(R.string.et_email_invalidate)
                false
            }
        }
    }

    private fun isValidPassword(pass: String): Boolean {
        return when {
            pass.isEmpty() -> {
                place_password.error = ""
                false
            }
            pass.length > pass.trim().length -> {
                place_password.error = resources.getString(R.string.et_password_spaces)
                false
            }
            pass.length < MIN_PASSWORD_LENGTH -> {
                place_password.error = resources.getString(
                    R.string.et_password_length,
                    MIN_PASSWORD_LENGTH
                )
                false
            }
            else -> {
                place_password.error = ""
                true
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.d("${hashCode()}")

        val email = edit_email.text.toString()
        val password = edit_password.text.toString()
        val isAgree: Boolean = checkBox.isChecked
        val state = loginState.copy(email = email, password = password, isAgree = isAgree)
        outState.putParcelable(KEY_STATE, state)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.d("${hashCode()}")

        loginState = savedInstanceState?.getParcelable(KEY_STATE) ?: LoginState()
        edit_email.setText(loginState.email)
        edit_password.setText(loginState.password)
        checkBox.isChecked = loginState.isAgree

        if (loginState.isAuthProgress) login()
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

    override fun onStop() {
        super.onStop()
        Timber.d("${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${hashCode()}")

        handler?.removeCallbacks(runnable)
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
