package me.levansmith.logging

/** Create a simple, compact String representation of the given class */
inline fun <reified T> T.logTag(): String {
    return T::class.java.simpleName
}

inline fun <reified T> Class<T>.logTag(): String {
    return simpleName
}
