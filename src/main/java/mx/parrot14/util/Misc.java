package mx.parrot14.util;

import java.util.Random;

public class Misc {
    private static final byte[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890".getBytes();
    private static final Random random = new Random();

    public static String generateRandomID(Integer size){
        StringBuilder stringBuilder = new StringBuilder();
        
        for(int i = 0; i < size;i++){
            Integer randomInteger = random.nextInt(stringBuilder.length());
            stringBuilder.append((char)characters[randomInteger]);
        }

        return stringBuilder.toString();
    }
}
