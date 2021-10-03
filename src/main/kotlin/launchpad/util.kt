package launchpad

fun String.toAsciiByteArray() = ByteArray(this.length) { this[it].toByte() }
