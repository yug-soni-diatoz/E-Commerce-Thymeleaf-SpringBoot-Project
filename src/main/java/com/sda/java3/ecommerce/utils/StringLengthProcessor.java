package com.sda.java3.ecommerce.utils;

public class StringLengthProcessor {

    private static String setString(final String param, final String value) {
        return String.format("set %s \"%s\"\n", param, value);
    }

    /**
     * Processes the input object, checks if it is a String,
     * and prints the length of the String.
     *
     * @param obj the input object to be processed
     */
    public void process(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            int length = str.length();
            System.out.println("The length of the string is: " + length);
        } else {
            System.out.println("The provided object is not a string.");
        }
    }

    public String command() {
        return "set palette defined (\\\n"
                + "0 0.2081 0.1663 0.5292,\\\n"
                + "1 0.2116 0.1898 0.5777,\\\n"
                + "2 0.2123 0.2138 0.6270,\\\n"
                + "3 0.2081 0.2386 0.6771,\\\n"
                + "4 0.1959 0.2645 0.7279,\\\n"
                + "5 0.1707 0.2919 0.7792,\\\n"
                + "6 0.1253 0.3242 0.8303,\\\n"
                + "7 0.0591 0.3598 0.8683,\\\n"
                + "8 0.0117 0.3875 0.8820,\\\n"
                + "9 0.0060 0.4086 0.8828,\\\n"
                + "10 0.0165 0.4266 0.8786,\\\n"
                + "11 0.0329 0.4430 0.8720,\\\n"
                + "12 0.0498 0.4586 0.8641,\\\n"
                + "13 0.0629 0.4737 0.8554,\\\n"
                + "14 0.0723 0.4887 0.8467,\\\n"
                + "15 0.0779 0.5040 0.8384,\\\n"
                + "16 0.0793 0.5200 0.8312,\\\n"
                + "17 0.0749 0.5375 0.8263,\\\n"
                + "18 0.0641 0.5570 0.8240,\\\n"
                + "19 0.0488 0.5772 0.8228,\\\n"
                + "20 0.0343 0.5966 0.8199,\\\n"
                + "21 0.0265 0.6137 0.8135,\\\n"
                + "22 0.0239 0.6287 0.8038,\\\n"
                + "23 0.0231 0.6418 0.7913,\\\n"
                + "24 0.0228 0.6535 0.7768,\\\n"
                + "25 0.0267 0.6642 0.7607,\\\n"
                + "26 0.0384 0.6743 0.7436,\\\n"
                + "27 0.0590 0.6838 0.7254,\\\n"
                + "28 0.0843 0.6928 0.7062,\\\n"
                + "29 0.1133 0.7015 0.6859,\\\n"
                + "30 0.1453 0.7098 0.6646,\\\n"
                + "31 0.1801 0.7177 0.6424,\\\n"
                + "32 0.2178 0.7250 0.6193,\\\n"
                + "33 0.2586 0.7317 0.5954,\\\n"
                + "34 0.3022 0.7376 0.5712,\\\n"
                + "35 0.3482 0.7424 0.5473,\\\n"
                + "36 0.3953 0.7459 0.5244,\\\n"
                + "37 0.4420 0.7481 0.5033,\\\n"
                + "38 0.4871 0.7491 0.4840,\\\n"
                + "39 0.5300 0.7491 0.4661,\\\n"
                + "40 0.5709 0.7485 0.4494,\\\n"
                + "41 0.6099 0.7473 0.4337,\\\n"
                + "42 0.6473 0.7456 0.4188,\\\n"
                + "43 0.6834 0.7435 0.4044,\\\n"
                + "44 0.7184 0.7411 0.3905,\\\n"
                + "45 0.7525 0.7384 0.3768,\\\n"
                + "46 0.7858 0.7356 0.3633,\\\n"
                + "47 0.8185 0.7327 0.3498,\\\n"
                + "48 0.8507 0.7299 0.3360,\\\n"
                + "49 0.8824 0.7274 0.3217,\\\n"
                + "50 0.9139 0.7258 0.3063,\\\n"
                + "51 0.9450 0.7261 0.2886,\\\n"
                + "52 0.9739 0.7314 0.2666,\\\n"
                + "53 0.9938 0.7455 0.2403,\\\n"
                + "54 0.9990 0.7653 0.2164,\\\n"
                + "55 0.9955 0.7861 0.1967,\\\n"
                + "56 0.9880 0.8066 0.1794,\\\n"
                + "57 0.9789 0.8271 0.1633,\\\n"
                + "58 0.9697 0.8481 0.1475,\\\n"
                + "59 0.9626 0.8705 0.1309,\\\n"
                + "60 0.9589 0.8949 0.1132,\\\n"
                + "61 0.9598 0.9218 0.0948,\\\n"
                + "62 0.9661 0.9514 0.0755,\\\n"
                + "63 0.9763 0.9831 0.0538)";
    }

    public String generateFruitPalette() {
        return "set palette defined (\\\n"
                + "0 Apple Red,\\\n"
                + "1 Banana Yellow,\\\n"
                + "2 Grape Purple,\\\n"
                + "3 Orange Orange,\\\n"
                + "4 Blueberry Blue,\\\n"
                + "5 Lime Green,\\\n"
                + "6 Strawberry Pink,\\\n"
                + "7 Watermelon Red,\\\n"
                + "8 Peach Peach,\\\n"
                + "9 Pineapple Yellow,\\\n"
                + "10 Mango Orange,\\\n"
                + "11 Cherry Red,\\\n"
                + "12 Kiwi Green)";
    }

    public String generateWeatherPalette() {
        return "set palette defined (\\\n"
                + "0 Sunny Yellow,\\\n"
                + "1 Cloudy Gray,\\\n"
                + "2 Rainy Blue,\\\n"
                + "3 Stormy Dark Gray,\\\n"
                + "4 Snowy White,\\\n"
                + "5 Windy Light Gray,\\\n"
                + "6 Foggy Mist,\\\n"
                + "7 Hazy Light Yellow,\\\n"
                + "8 Freezing Ice Blue)";
    }

    public String generateAnimalPalette() {
        return "set palette defined (\\\n"
                + "0 Lion Yellow,\\\n"
                + "1 Tiger Orange,\\\n"
                + "2 Elephant Gray,\\\n"
                + "3 Zebra Black and White,\\\n"
                + "4 Flamingo Pink,\\\n"
                + "5 Peacock Blue,\\\n"
                + "6 Dolphin Gray,\\\n"
                + "7 Panda Black and White,\\\n"
                + "8 Parrot Green)";
    }

    public String generateLandscapePalette() {
        return "set palette defined (\\\n"
                + "0 Desert Sand,\\\n"
                + "1 Ocean Blue,\\\n"
                + "2 Mountain Gray,\\\n"
                + "3 Forest Green,\\\n"
                + "4 Valley Yellow,\\\n"
                + "5 Glacier White,\\\n"
                + "6 River Blue,\\\n"
                + "7 Canyon Red,\\\n"
                + "8 Beach Tan)";
    }

    public String generateFoodPalette() {
        return "set palette defined (\\\n"
                + "0 Tomato Red,\\\n"
                + "1 Lettuce Green,\\\n"
                + "2 Cheese Yellow,\\\n"
                + "3 Chocolate Brown,\\\n"
                + "4 Bread Beige,\\\n"
                + "5 Blueberry Blue,\\\n"
                + "6 Egg White,\\\n"
                + "7 Carrot Orange,\\\n"
                + "8 Grapefruit Pink)";
    }

    public String generateEmotionPalette() {
        return "set palette defined (\\\n"
                + "0 Happy Yellow,\\\n"
                + "1 Sad Blue,\\\n"
                + "2 Angry Red,\\\n"
                + "3 Calm Green,\\\n"
                + "4 Excited Orange,\\\n"
                + "5 Nervous Gray,\\\n"
                + "6 Surprised Purple,\\\n"
                + "7 Fearful Black,\\\n"
                + "8 Confident Gold)";
    }


    public String generateSeasonPalette() {
        return "set palette defined (\\\n"
                + "0 Spring Green,\\\n"
                + "1 Summer Yellow,\\\n"
                + "2 Autumn Orange,\\\n"
                + "3 Winter White,\\\n"
                + "4 Rainy Blue,\\\n"
                + "5 Snowy Light Blue,\\\n"
                + "6 Sunny Bright Yellow,\\\n"
                + "7 Windy Gray,\\\n"
                + "8 Misty Light Gray)";
    }


}


