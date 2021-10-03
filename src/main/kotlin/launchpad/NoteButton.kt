package launchpad

import midi.Button

//Launchpad note buttons sorted by rows and columns starting top left

enum class NoteButton(override val num: Byte): Button {
    R1C1(81),
    R1C2(82),
    R1C3(83),
    R1C4(84),
    R1C5(85),
    R1C6(86),
    R1C7(87),
    R1C8(88),

    R2C1(71),
    R2C2(72),
    R2C3(73),
    R2C4(74),
    R2C5(75),
    R2C6(76),
    R2C7(77),
    R2C8(78),

    R3C1(61),
    R3C2(62),
    R3C3(63),
    R3C4(64),
    R3C5(65),
    R3C6(66),
    R3C7(67),
    R3C8(68),

    R4C1(51),
    R4C2(52),
    R4C3(53),
    R4C4(54),
    R4C5(55),
    R4C6(56),
    R4C7(57),
    R4C8(58),

    R5C1(41),
    R5C2(42),
    R5C3(43),
    R5C4(44),
    R5C5(45),
    R5C6(46),
    R5C7(47),
    R5C8(48),

    R6C1(31),
    R6C2(32),
    R6C3(33),
    R6C4(34),
    R6C5(35),
    R6C6(36),
    R6C7(37),
    R6C8(38),

    R7C1(21),
    R7C2(22),
    R7C3(23),
    R7C4(24),
    R7C5(25),
    R7C6(26),
    R7C7(27),
    R7C8(28),

    R8C1(11),
    R8C2(12),
    R8C3(13),
    R8C4(14),
    R8C5(15),
    R8C6(16),
    R8C7(17),
    R8C8(18),
}