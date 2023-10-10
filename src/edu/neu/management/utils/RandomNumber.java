package edu.neu.management.utils;

import java.util.UUID;

public class RandomNumber {
    public static String generate() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 4);
    }


}
