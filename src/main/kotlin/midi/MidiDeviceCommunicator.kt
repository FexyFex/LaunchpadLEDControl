package midi

import javax.sound.midi.InvalidMidiDataException
import javax.sound.midi.MidiUnavailableException
import javax.sound.midi.SysexMessage


class MidiDeviceCommunicator(private val name: String) {
    private val device = MidiDetector.findMidiReceiverDeviceByName(name) ?: throw MidiDeviceNotFoundException(name)
    private val receiver = device.receiver

    private val isConnected: Boolean
        get() = MidiDetector.findMidiReceiverDeviceByName(name) != null


    fun open(): MidiDeviceCommunicator {
        device.open()
        println("Output device $name opened")
        return this
    }

    /**
     * Sends a message to the Midi Device.
     * Returns true on success, otherwise false.
     */
    fun sendSysexMsg(vararg bytes: Byte, timestamp: Long = -1L): Boolean {
        val msg = SysexMessage()
        msg.setMessage(bytes, bytes.size)

        try {
            if (isConnected) {
                //println("${msg.length} bytes sent")
                receiver.send(msg, timestamp)
            }
        } catch (e: MidiUnavailableException) {
            println("Midi device unavailable")
            return false
        } catch (e: InvalidMidiDataException) {
            return false
        }

        return true
    }

    fun close() {
        device.close()
        println("Output device $name closed")
    }
}