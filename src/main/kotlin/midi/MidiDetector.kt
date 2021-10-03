package midi

import javax.sound.midi.MidiDevice
import javax.sound.midi.MidiSystem
import javax.sound.midi.MidiUnavailableException


class MidiDetector private constructor(){
    companion object {
        fun getMidiDevicesList() = MidiSystem.getMidiDeviceInfo()

        fun printMidiDevicesList() {
            getMidiDevicesList().forEach {
                val dev = MidiSystem.getMidiDevice(it)
                val canReceive = dev.maxReceivers != 0
                val canTransmit = dev.maxTransmitters != 0

                println("----------------------------------------------")
                println("Name        : ${it.name}")
                println("Description : ${it.description}")
                println("Vendor      : ${it.vendor}")
                println("Version     : ${it.version}")
                println("Transmitter : $canTransmit")
                println("Receiver    : $canReceive")
            }
        }

        fun getFirstAvailableDevice(): MidiDevice? {
            var device: MidiDevice? = null
            val availableDeviceInfos = MidiSystem.getMidiDeviceInfo()

            for (info in availableDeviceInfos) {
                try {
                    val aux = MidiSystem.getMidiDevice(info)
                    val canTransmit = aux.maxTransmitters != 0
                    val canRecieve = aux.maxReceivers != 0

                    if (canTransmit && canRecieve) {
                        device = aux
                        break;
                    }
                } catch (e: MidiUnavailableException) {
                    println("hi " + e.message)
                }
            }

            return device
        }

        fun findMidiReceiverAndTransmitterDeviceByName(targetName: String): MidiDevice? {
            var device: MidiDevice? = null
            val availableDeviceInfos = MidiSystem.getMidiDeviceInfo()

            for (info in availableDeviceInfos) {
                if (info.name == targetName) {
                    try {
                        val aux = MidiSystem.getMidiDevice(info)
                        val canTransmit = aux.maxTransmitters != 0
                        val canRecieve = aux.maxReceivers != 0

                        if (canTransmit && canRecieve) {
                            device = aux
                            break;
                        }
                    } catch (e: MidiUnavailableException) {
                        println(e.message)
                    }
                }
            }

            return device
        }

        fun findMidiReceiverDeviceByName(targetName: String): MidiDevice? {
            var device: MidiDevice? = null
            val availableDeviceInfos = MidiSystem.getMidiDeviceInfo()

            for (info in availableDeviceInfos) {
                if (info.name == targetName) {
                    try {
                        val aux = MidiSystem.getMidiDevice(info)
                        val canRecieve = aux.maxReceivers != 0

                        if (canRecieve) {
                            device = aux
                            break;
                        }
                    } catch (e: MidiUnavailableException) {
                        println(e.message)
                    }
                }
            }

            return device
        }

        fun findMidiTransmitterDeviceByName(targetName: String): MidiDevice? {
            var device: MidiDevice? = null
            val availableDeviceInfos = MidiSystem.getMidiDeviceInfo()

            for (info in availableDeviceInfos) {
                if (info.name == targetName) {
                    try {
                        val aux = MidiSystem.getMidiDevice(info)
                        val canTransmit = aux.maxTransmitters != 0

                        if (canTransmit) {
                            device = aux
                            break;
                        }
                    } catch (e: MidiUnavailableException) {
                        println(e.message)
                    }
                }
            }

            return device
        }

        fun findMidiReceiverAndTransmitterDeviceByDescription(targetDesc: String): MidiDevice? {
            var device: MidiDevice? = null
            val availableDeviceInfos = MidiSystem.getMidiDeviceInfo()

            for (info in availableDeviceInfos) {
                if (info.description == targetDesc) {
                    try {
                        val aux = MidiSystem.getMidiDevice(info)
                        val canTransmit = aux.maxTransmitters != 0
                        val canRecieve = aux.maxReceivers != 0

                        if (canTransmit && canRecieve) {
                            device = aux
                            break;
                        }
                    } catch (e: MidiUnavailableException) {
                        println(e.message)
                    }
                }
            }

            return device
        }
    }
}