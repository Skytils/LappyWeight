package skytils.lappyweight.weightcalc

internal val skillNames = linkedMapOf(
    "experience_skill_enchanting" to "skyblock_augmentation",
    "experience_skill_taming" to "skyblock_domesticator",
    "experience_skill_alchemy" to "skyblock_concoctor",
    "experience_skill_mining" to "skyblock_excavator",
    "experience_skill_farming" to "skyblock_harvester",
    "experience_skill_foraging" to "skyblock_gatherer",
    "experience_skill_combat" to "skyblock_combat",
    "experience_skill_fishing" to "skyblock_angler"
)
internal val dungeonExperienceTable = listOf(
    0,
    50,
    125,
    235,
    395,
    625,
    955,
    1425,
    2095,
    3045,
    4385,
    6275,
    8940,
    12700,
    17960,
    25340,
    35640,
    50040,
    70040,
    97640,
    135640,
    188140,
    259640,
    356640,
    488640,
    668640,
    911640,
    1239640,
    1684640,
    2284640,
    3084640,
    4149640,
    5559640,
    7459640,
    9959640,
    13259640,
    17559640,
    23159640,
    30359640,
    39559640,
    51559640,
    66559640,
    85559640,
    109559640,
    139559640,
    177559640,
    225559640,
    285559640,
    360559640,
    453559640,
    569809640,
    2147483647
)
internal val dungeonMaxXP = 569809640.0
internal val dungeonOverall = 0.81522766192742
internal val dungeonCompletionWorth = listOf(
    0.0827,
    2.1034,
    4.5966,
    7.9383,
    13.4018,
    23.1071,
    43.7857,
    63.3437,
    24.0,
    33.5,
    46.575,
    81.9553,
    99.6368,
    154.4188
)
internal val dungeonCompletionBuffs = linkedMapOf(
    "1" to 125,
    "2" to 250,
    "3" to 450,
    "4" to 775,
    "5" to 1000,
    "6" to 1400,
    "7" to 1750
)
internal val skillXPPerLevel = listOf(
    0,
    50,
    125,
    200,
    300,
    500,
    750,
    1000,
    1500,
    2000,
    3500,
    5000,
    7500,
    10000,
    15000,
    20000,
    30000,
    50000,
    75000,
    100000,
    200000,
    300000,
    400000,
    500000,
    600000,
    700000,
    800000,
    900000,
    1000000,
    1100000,
    1200000,
    1300000,
    1400000,
    1500000,
    1600000,
    1700000,
    1800000,
    1900000,
    2000000,
    2100000,
    2200000,
    2300000,
    2400000,
    2500000,
    2600000,
    2750000,
    2900000,
    3100000,
    3400000,
    3700000,
    4000000,
    4300000,
    4600000,
    4900000,
    5200000,
    5500000,
    5800000,
    6100000,
    6400000,
    6700000,
    7000000
)
internal val skillMaxXP = 111672425.0
internal val skillOverflowMultipliers = listOf(
    6.3207,
    9.2003,
    4.1641,
    77.2840,
    123.5962,
    163.0884,
    227.5907,
    504.2361
)
internal val skillFactors = listOf(
    0.8970917856434051,
    0.9038421238097485,
    0.88836322872987277,
    0.929383683888072,
    0.9329795030275141,
    0.9348318885884501,
    0.9368106217543707,
    0.9401081007640278
)
internal val skillRatioWeight = listOf(
    "enchanting" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        40.0
    ),
    "taming" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        45.0
    ),
    "alchemy" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        50.0
    ),
    "mining" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        80.0
    ),
    "farming" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        85.0
    ),
    "foraging" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        95.0
    ),
    "combat" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        95.0
    ),
    "fishing" to listOf(
        0.0,
        0.025,
        0.05,
        0.075,
        0.1,
        0.125,
        0.15,
        0.175,
        0.2,
        0.225,
        0.25,
        0.275,
        0.3,
        0.325,
        0.35,
        0.375,
        0.4,
        0.425,
        0.45,
        0.475,
        0.5,
        0.525,
        0.55,
        0.575,
        0.6,
        0.625,
        0.65,
        0.675,
        0.7,
        0.725,
        0.75,
        0.775,
        0.8,
        0.825,
        0.85,
        0.875,
        0.9,
        0.925,
        0.95,
        0.975,
        1.0,
        1.025,
        1.05,
        1.075,
        1.1,
        1.125,
        1.15,
        1.175,
        1.2,
        1.225,
        1.25,
        1.28125,
        1.3125,
        1.34375,
        1.375,
        1.40625,
        1.4375,
        1.46875,
        1.5,
        1.53125,
        1.5625,
        100.0
    )
)
internal val slayerDeprecationScaling = listOf(
    0.82030106128,
    0.8248013266,
    0.83460185724,
    0.8507026532
)
