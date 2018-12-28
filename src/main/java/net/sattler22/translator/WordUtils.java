package net.sattler22.translator;

/**
 * English to Ancient Text Language Translator Word Utilities
 * 
 * @author Pete Sattler
 * @version 17 February 2014
 */
public final class WordUtils {

    private static final char[] VOWELS_LOWER_CASE = { 'a', 'e', 'i', 'o', 'u', 'y' };

    private WordUtils() {
        throw new AssertionError("Class can not be instantiated");
    }

    /**
     * Letters existence check
     */
    public static boolean hasLetters(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c))
                return true;
        }
        return false;
    }

    /**
     * Consonants only check
     */
    public static boolean hasOnlyConsonants(String word) {
        for (char c : word.toLowerCase().toCharArray()) {
            for (char vowel : VOWELS_LOWER_CASE) {
                if (c == vowel)
                    return false;
            }
        }
        return true;
    }

    /**
     * Vowel check
     */
    public static boolean isVowel(char c) {
        for (char vowel : VOWELS_LOWER_CASE) {
            if (c == vowel)
                return true;
        }
        return false;
    }
}
