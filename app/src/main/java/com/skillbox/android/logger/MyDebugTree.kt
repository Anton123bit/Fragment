package com.example.fragments.logger

import timber.log.Timber

class MyDebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        super.createStackElementTag(element)
        return "$LOG_TAG \t Class: ${element.className.split(".")
            .last().split("$").first()}; \t Method: ${element.methodName} "
    }
}
