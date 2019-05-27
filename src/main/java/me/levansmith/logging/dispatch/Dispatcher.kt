package me.levansmith.logging.dispatch

import me.levansmith.logging.AnalyticsEvent
import me.levansmith.logging.LogProvider
import java.io.Serializable
import java.util.Collections.emptyList

interface Dispatcher<M : Modifiers> {

    data class Delegate(
        var tag: String,
        var message: String = "",
        var format: String? = null,
        var error: Throwable? = null,
        var event: AnalyticsEvent? = null,
        var args: List<Any> = emptyList()
    ) : Serializable

    val modifiers: M?

    val defaultLevel: LogProvider.Level

    fun defaultModifiers(): M

    fun shouldDispatch(modifiers: M, delegate: Delegate): Boolean

    fun preDispatch(modifiers: M, delegate: Delegate)

    fun doDispatch(modifiers: M, delegate: Delegate): Int

    fun postDispatch(modifiers: M, delegate: Delegate)

    fun dispatch(level: LogProvider.Level?, delegate: Delegate): Int {
        val tempModifiers = modifiers
            ?.apply {
                logLevel = level ?: (modifiers?.logLevel) ?: defaultLevel
            }
            ?: defaultModifiers().apply {
                logLevel = level ?: defaultLevel
            }
        if (!shouldDispatch(tempModifiers, delegate)) return 0
        preDispatch(tempModifiers, delegate)
        val result = doDispatch(tempModifiers, delegate)
        postDispatch(tempModifiers, delegate)
        return result
    }
}