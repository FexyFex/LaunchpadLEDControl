package launchpad

import midi.Button

enum class OptionButton(override val num: Byte, val columnNum: Byte): Button {
    // Options Buttons
    UP(104, 0),
    DOWN(105, 1),
    LEFT(106, 2),
    RIGHT(107, 3),
    SESSION(108, 4),
    USER_1(109, 5),
    USER_2(110, 6),
    MIXER(111, 7),
}