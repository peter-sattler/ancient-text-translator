package net.sattler22.translator;

/**
 * English to Ancient Text Language Translator Word Utilities
 *
 * @author Pete Sattler
 * @since 17 February 2014
 * @version May 2026
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
     * @return True if the word contains letters (no digits or symbols). Otherwise, returns false.
     */
    static boolean hasLetters(String word) {
        for (final char character : word.toCharArray()) {
            if (Character.isLetter(character))
                return true;
        }
        return false;
    }

    /**
     * Consonants only existence check
     *
     * @param word The word to check
     * @return True if the word contains only constants. Otherwise, returns false.
     */
    static boolean containsOnlyConsonants(String word) {
        for (final char character : word.toLowerCase().toCharArray()) {
            for (final char vowel : VOWELS_LOWER_CASE) {
                if (!Character.isLetter(character))
                    return false;
                if (character == vowel)
                    return false;
            }
        }
        return true;
    }

    /**
     * Vowel existence check
     *
     * @param word The word to check
     * @return True if the word contains at least one vowel. Otherwise, returns false.
     */
    static boolean containsVowel(String word) {
        for (final char character : word.toCharArray()) {
            if (isVowel(character))
                return true;
        }
        return false;
    }

    /**
     * Vowel condition check
     *
     * @param character The character to check
     * @return True if the character is a vowel. Otherwise, returns false;
     */
    static boolean isVowel(char character) {
        final char lower = Character.toLowerCase(character);
        for (final char vowel : VOWELS_LOWER_CASE) {
            if (lower == vowel)
                return true;
        }
        return false;
    }
}
