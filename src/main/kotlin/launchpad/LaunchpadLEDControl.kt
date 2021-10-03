package launchpad

import midi.Button
import midi.MidiDeviceCommunicator


class LaunchpadLEDControl(launchpadMidiName: String) {
    private val communicator = MidiDeviceCommunicator(launchpadMidiName)

    fun lightLED(button: Button, color: Color) = lightLED(button.num, color.num)
    fun lightLED(button: Button, color: Byte) = lightLED(button.num, color)
    fun lightLED(buttonNum: Byte, color: Color) = lightLED(buttonNum, color.num)
    fun lightLED(buttonNum: Byte, color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 10, buttonNum, color)
    }

    fun lightLEDrbg(button: Button, r: Byte, g: Byte, b: Byte) = lightLEDrbg(button.num, r, g, b)
    fun lightLEDrbg(buttonNum: Byte, r: Byte, g: Byte, b: Byte): Boolean {
        if (r !in permittedRGBRange || g !in permittedRGBRange || b !in permittedRGBRange) return false
        return sendMsg(*ledControlPrefix, 11, buttonNum, r, b, g)
    }

    fun turnLEDOff(button: Button) = turnLEDOff(button.num)
    fun turnLEDOff(buttonNum: Byte): Boolean {
        return lightLED(buttonNum, Color.BLACK)
    }

    fun flashLED(button: Button, color: Color) = flashLED(button.num, color.num)
    fun flashLED(button: Button, color: Byte) = flashLED(button.num, color)
    fun flashLED(buttonNum: Byte, color: Color) = flashLED(buttonNum, color.num)
    fun flashLED(buttonNum: Byte, color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 35, buttonNum, color)
    }

    fun pulseLED(button: Button, color: Color) = pulseLED(button.num, color.num)
    fun pulseLED(button: Button, color: Byte) = pulseLED(button.num, color)
    fun pulseLED(button: Byte, color: Color) = pulseLED(button, color.num)
    fun pulseLED(buttonNum: Byte, color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 40, buttonNum, color)
    }

    fun lightColumn(colNum: Byte, color: Color) = lightColumn(colNum, color.num)
    fun lightColumn(colNum: Byte, color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 12, colNum, color)
    }

    fun lightRow(rowNum: Byte, color: Color) = lightRow(rowNum, color.num)
    fun lightRow(rowNum: Byte, color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 13, rowNum, color)
    }

    fun lightAllLED(color: Color) = lightAllLED(color.num)
    fun lightAllLED(color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 14, color)
    }

    fun resetAllLED() = lightAllLED(Color.BLACK)

    fun scrollText(text: String, color: Color) = scrollText(text, color.num)
    fun scrollText(text: String, color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 20, color, 0, *text.toAsciiByteArray())
    }

    fun scrollTextLooped(text: String, color: Color) = scrollTextLooped(text, color.num)
    fun scrollTextLooped(text: String, color: Byte): Boolean {
        if (color !in permittedColorRange) return false
        return sendMsg(*ledControlPrefix, 20, color, 1, *text.toAsciiByteArray())
    }


    private fun sendMsg(vararg instructions: Byte) = communicator.sendSysexMsg(sysexPrefix, *instructions, sysexSuffix)


    fun open(): LaunchpadLEDControl {
        communicator.open()
        return this
    }
    fun close() = communicator.close()


    companion object {
        private val permittedColorRange = 0..127
        private val permittedRGBRange = 0..63
        private const val sysexPrefix: Byte = 240.toByte()
        private const val sysexSuffix: Byte = 247.toByte()

        private val ledControlPrefix = byteArrayOf(0, 32, 41, 2, 24)
    }
}