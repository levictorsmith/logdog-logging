package me.levansmith.logging

import me.levansmith.logging.dispatch.Dispatcher
import me.levansmith.logging.dispatch.Modifiers


interface Option<M : Modifiers, out L : Dispatcher<M>> {
    /** Send the message to the configured analytics service */
    val send: L get() = withLogger { willSend = true }
    /** Output the log despite all configurations */
    val force: L get() = withLogger { willForce = true }
    /** Prevent log output despite all configurations, except <pre>force</pre> */
    val hide: L get() = withLogger { willHide = true }
    /** Show thread info */
    val showThread: L get() = withLogger { showThreadInfo = true }

    /** Add specific extra parameters for options or usage later on down the line */
    fun <T : Any> extra(key: String, value: T) = withLogger { extras[key] = value }

    fun withLogger(with: M.() -> Unit = {}): L
}
