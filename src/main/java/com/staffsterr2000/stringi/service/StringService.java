package com.staffsterr2000.stringi.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class StringService {

    private static final List<String> STRINGS = new ArrayList<>();
    private static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final Random RANDOM = new Random();
    private static final int STRINGS_QUANTITY = 10;
    private static final int CHAR_QUANTITY_LEFT_BOUND = 1;
    private static final int CHAR_QUANTITY_RIGHT_BOUND = 10;

    public List<String> getStrings() {
        return STRINGS;
    }

    public void generateStrings() {
        char fixedLetter = 'a';
        for (int i = 0; i < STRINGS_QUANTITY; ++i) {
            int charQuantity = RANDOM.nextInt(CHAR_QUANTITY_RIGHT_BOUND) + CHAR_QUANTITY_LEFT_BOUND;
            String string = generateString(charQuantity, fixedLetter);
            STRINGS.add(string);
        }
    }

    public void randomlyGenerateStrings() {
        for (int i = 0; i < STRINGS_QUANTITY; ++i) {
            int charQuantity = RANDOM.nextInt(CHAR_QUANTITY_RIGHT_BOUND) + CHAR_QUANTITY_LEFT_BOUND;
            String string = generateString(charQuantity);
            STRINGS.add(string);
        }
    }

    public String generateString(int charQuantity, char letter) {
        return String.valueOf(letter).repeat(charQuantity);
    }
    
    public String generateString(int charQuantity) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charQuantity; ++i) {
            int letterPosition = RANDOM.nextInt(LETTERS.length - 1);
            char letter = LETTERS[letterPosition];
            builder.append(letter);
        }
        return builder.toString();
    }

    public String compareStrings() {
        Map<String, Integer> map = new HashMap<>();
        for (String string : STRINGS) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                Integer value = map.get(string);
                map.put(string, ++value);
            }
        }
        return convertMapToString(map);
    }

    public String convertMapToString(Map<?, ?> map) {
        StringBuilder response = new StringBuilder("{");
        String entryOutputPattern = "\n\t\"%s\": %s";
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            String entryOutput = String.format(
                    entryOutputPattern, entry.getKey(), entry.getValue());
            response.append(entryOutput);
        }
        response.append("\n}");
        return response.toString();
    }

}
