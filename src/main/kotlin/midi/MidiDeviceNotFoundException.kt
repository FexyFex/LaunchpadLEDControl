package midi

import kotlin.Exception


class MidiDeviceNotFoundException(deviceName: String): Exception(deviceName)