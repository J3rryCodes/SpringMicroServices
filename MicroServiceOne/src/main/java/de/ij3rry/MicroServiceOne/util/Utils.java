package de.ij3rry.MicroServiceOne.util;

import java.util.Random;

public class Utils {
    public static int getRandomSixDigitNumber() {
        Random random = new Random();
        return random.nextInt(900000) + 100000;
    }
}
