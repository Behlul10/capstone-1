package com.pluralsight;

public class AsciiArtSequence {
    public String pcAsciiArt = """
            ::::==========:::::::::::::::::::::::::::::::::::::::::::::::::::::::
            :::::::=========::::::.---------------.:::::::::::::::::::::::::::::::
            :::=============::::::| .-----------. |:::::::::::::::::::::::::::::
            ::::==========::::::::| | === == == | |:::::::::::::::::::::::::::::::::
            ::::==========::::::::| | 260 ED OO | |:::::::::::::::::::::::::::::::
            :::::::=========='::::| |  urgent!  | |:::::::::::::::::::::::::::::
            :::===========::::::::| |___________| |::::::((;):::::::::::::::::::::
            ""\""============""\"""\"|___________oo__|"")""\"";(""\"""\"""\"""\"""\"""\"""\""
              ==========='           ___)___(___,o  (   .---._
                 ===========        |___________| 8  \\  |TEA|_)    .+-------+.
              ===========                     o8o8    ) |___|    .' |_______| `.
                =============      __________8___    (          /  /         \\  \\
             |\\`==========='/|   .'= --------- --`.   `.       |\\ /           \\ /|
             | "-----------" |  / ooooooooooooo  oo\\   _\\_     | "-------------" |
             |______I_N______| /  oooooooooooo[] ooo\\  |=|     |_______OUT_______|
                              / O O =========  O OO  \\ "-"   .-------,
                              `""\"""\"""\"""\"""\"""\"""\""'      /~~~~~~~/
            _______________________________________________/_   ~~~/_______________
            hjw.......................................... \\/_____/..desk at 17:30..
            """;
    public String eyeAsciiArt = """
            .           ..         .           .       .           .           .
                  .         .            .          .       .
                        .         ..xxxxxxxxxx....               .       .             .
                .             MWMWMWWMWMWMWMWMWMWMWMWMW                       .
                          IIIIMWMWMWMWMWMWMWMWMWMWMWMWMWMttii:        .           .
             .      IIYVVXMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWxx...         .           .
                 IWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMx..
               IIWMWMWMWMWMWMWMWMWBY%ZACH%AND%OWENMWMWMWMWMWMWMWMWMWMWMWMWMx..        .
                ""MWMWMWMWMWM""\"""\""".  .:..   .""\"""MWMWMWMWMWMWMWMWMWMWMWMWMWti.
             .     ""   . `  .: . :. : .  . :.  .  . . .  ""\""MWMWMWMWMWMWMWMWMWMWMWMWMti=
                    . .   :` . :   .  .'.' '....xxxxx...,'. '   ' .""\"YWMWMWMWMWMWMWMWMWMW+
                 ; . ` .  . : . .' :  . ..XXXXXXXXXXXXXXXXXXXXx.    `     . "YWMWMWMWMWMWMW
            .    .  .  .    . .   .  ..XXXXXXXXWWWWWWWWWWWWWWWWXXXX.  .     .     ""\"""\""
                    ' :  : . : .  ...XXXXXWWW"   W88N88@888888WWWWWXX.   .   .       . .
               . ' .    . :   ...XXXXXXWWW"    M88N88GGGGGG888^8M "WMBX.          .   ..  :
                     :     ..XXXXXXXXWWW"     M88888WWRWWWMW8oo88M   WWMX.     .    :    .
                       "XXXXXXXXXXXXWW"       WN8888WWWWW  W8@@@8M    BMBRX.         .  : :
              .       XXXXXXXX=MMWW":  .      W8N888WWWWWWWW88888W      XRBRXX.  .       .
                 ....  ""XXXXXMM::::. .        W8@889WWWWWM8@8N8W      . . :RRXx.    .
                     ``...'''  MMM::.:.  .      W888N89999888@8W      . . ::::"RXV    .  :
             .       ..'''''      MMMm::.  .      WW888N88888WW     .  . mmMMMMMRXx
                  ..' .            ""MMmm .  .       WWWWWWW   . :. :,miMM""\"  : ""`    .
               .                .       ""MMMMmm . .  .  .   ._,mMMMM""\"  :  ' .  :
                           .                  ""MMMMMMMMMMMMM""\" .  : . '   .        .
                      .              .     .    .                      .         .
            .                                         .          .         .
            
            """;

    public static void startSequence() {

        try {
            Thread.sleep(2000);
            System.out.print("N");
            Thread.sleep(2000);
            System.out.print("e");
            Thread.sleep(2000);
            System.out.println("o");
            Thread.sleep(2000);
            System.out.println(pcAsciiArt);
            Thread.sleep(3000);
            System.out.println(eyeAsciiArt);
            Thread.sleep(2000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }

}
