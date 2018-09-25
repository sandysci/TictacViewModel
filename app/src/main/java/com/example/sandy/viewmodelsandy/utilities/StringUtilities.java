package com.example.sandy.viewmodelsandy.utilities;

import android.util.Log;

public class StringUtilities {

    public static String stringFromNumbers(int... numbers) {
        StringBuilder sNumbers = new StringBuilder();
        for (int number : numbers)
            sNumbers.append(number);
        Log.i("REQUEST_TAG1","string");
        Log.i("REQUEST_TAG",sNumbers.toString());
        return sNumbers.toString();
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }
}


