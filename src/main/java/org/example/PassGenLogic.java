package org.example;

import java.util.Random;

//logic
public class PassGenLogic {
    //characters
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "012345679";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    private Random random = new Random();

    //lenght of the password to be generated
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                   boolean includeNumbers, boolean includeSpecialSymbols) {
        StringBuilder passwordBuilder = new StringBuilder();

        //valid characters (toggles)
        String validCharacters = "";
        if (includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if (includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        //password builder
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());

            char randomChar = validCharacters.charAt(randomIndex);

            passwordBuilder.append(randomChar);
        }
        //return password
        return passwordBuilder.toString();
    }
}