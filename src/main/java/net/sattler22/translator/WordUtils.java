package net.sattler22.translator;

/**
 * English to Ancient Text Language Translator Word Utilities
 *
 * @author Pete Sattler
 * @version 17 February 2014
 */
final class WordUtils {

    private static final char[] VOWELS_LOWER_CASE = { 'a', 'e', 'i', 'o', 'u', 'y' };

    private WordUtils() {
        throw new AssertionError("Class cannot be instantiated");
    }

    /**
     * Letters existence check
     *
     * @param word The word to check
     */
    static boolean hasLetters(String word) {
        for (final char character : word.toCharArray())
            if (Character.isLetter(character))
                return true;
        return false;
    }

    /**
     * Consonants only check
     *
     * @param word The word to check
     */
    static boolean hasOnlyConsonants(String word) {
        for (final char character : word.toLowerCase().toCharArray())
            for (final char vowel : VOWELS_LOWER_CASE)
                if (character == vowel)
                    return false;
        return true;
    }

    /**
     * Vowel check
     *
     * @param character The character to check
     */
    static boolean isVowel(char character) {
        for (final char vowel : VOWELS_LOWER_CASE)
            if (character == vowel)
                return true;
        return false;
    }
}
