// Test du module max_tab(rst, clk, cal, ad1[7..0], ad2[7..0] : adRam[7..0], max[31..0], adMax[7..0], InitAd, InitMax, CalMax, Fini)
// Attention : il faut que le module testé ait exactement les mêmes signaux
// d'entrée et de sortie, en respectant la casse.

set rst 1
set rst 0
set cal 0
set clk 0

// Initialisation
check InitAd 1
check InitMax 0
check CalMax 0
check Fini 0
check adRam[7..0] 00000000
check adMax[7..0] 00000000
check max[31..0] 00000000000000000000000001101011

// cal=0 : rien ne doit evoluer sauf adCour qui est initialisé avec ad1
set ad1[7..0] 00001000
set ad2[7..0] 00000100


set clk 1

check InitAd 1
check InitMax 0
check CalMax 0
check Fini 0
check adRam[7..0] 00001000
check adMax[7..0] 00000000
check max[31..0] 00000000000000000000000001101011

// cal=1 : Verif InitAd -> InitMax
// ad1 modifié pour bien tester l'initialisation
set ad1[7..0] 00000001
set clk 0
set cal 1
set clk 1

check InitAd 0
check InitMax 1
check CalMax 0
check Fini 0
check adRam[7..0] 00000001
check adMax[7..0] 00000000
check max[31..0] 00000000000000000000000001101011

// Verif InitMax -> CalMax
set clk 0

set clk 1

check InitAd 0
check InitMax 0
check CalMax 1
check Fini 0
check adRam[7..0] 00000010
check adMax[7..0] 00000000
check max[31..0] 00000000000000000000000001101011

// Verif CalMax -> CalMax avec maj du max
set clk 0

set clk 1

check InitAd 0
check InitMax 0
check CalMax 1
check Fini 0
check adRam[7..0] 00000011
check adMax[7..0] 00000011
check max[31..0] 00000000000000000000000001101101

// Verif CalMax -> CalMax sans maj du max
set clk 0

set clk 1

check InitAd 0
check InitMax 0
check CalMax 1
check Fini 0
check adRam[7..0] 00000100
check adMax[7..0] 00000011
check max[31..0] 00000000000000000000000001101101

// Verif CalMax -> Fini sans maj du max
set clk 0

set clk 1

check InitAd 0
check InitMax 0
check CalMax 0
check Fini 1
check adRam[7..0] 00000100
check adMax[7..0] 00000011
check max[31..0] 00000000000000000000000001101101

// Verif Fini -> Fini si cal=1
set clk 0
set clk 1

check InitAd 0
check InitMax 0
check CalMax 0
check Fini 1
check adRam[7..0] 00000100
check adMax[7..0] 00000011
check max[31..0] 00000000000000000000000001101101

// Verif Fini -> InitAd si cal=0
set cal 0
set clk 0
set clk 1

check InitAd 1
check InitMax 0
check CalMax 0
check Fini 0



