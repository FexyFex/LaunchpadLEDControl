package launchpad

import midi.Button

enum class SideBarButton(override val num: Byte): Button {
    VOLUME(89),
    PAN(79),
    SEND_A(69),
    SEND_B(59),
    STOP(49),
    MUTE(39),
    SOLO(29),
    RECORD_ARM(19)
}