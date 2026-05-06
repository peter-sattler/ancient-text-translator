package net.sattler22.translator;

import net.jcip.annotations.Immutable;

import java.util.Objects;

/**
 * Parses a word into its prefix and stem
 *
 * @author Pete Sattler
 * @since 17 February 2014
 * @version May 2026
 */
@Immutable
final class WordComponentParser {

    private final String word;
    private final String prefix;
    private final String stem;
    private final boolean capitalized;

    /**
     * Constructs a new word component parser
     *
     * @param word The word to parse
     */
    WordComponentParser(String word) {
        if (word == null || word.isBlank())
            throw new IllegalArgumentException("Word is required");
        if (!WordUtils.containsVowel(word))
            throw new IllegalArgumentException("Word must contain at least one vowel");
        this.word = word;
        boolean isPrefix = true;
        final StringBuilder prefixBuilder = new StringBuilder();
        final StringBuilder stemBuilder = new StringBuilder();
        for (final char character : word.toCharArray()) {
            if (isPrefix && WordUtils.isVowel(character))
                isPrefix = false;
            if (isPrefix)
                prefixBuilder.append(character);
            else
                stemBuilder.append(character);
        }
        this.prefix = prefixBuilder.toString();
        this.stem = stemBuilder.toString();
        this.capitalized = Character.isUpperCase(word.charAt(0));
    }

    /**
     * Get the prefix
     *
     * @return The prefix which extends from the beginning of the word up to, but not including, the first vowel
     */
    String prefix() {
        return prefix;
    }

    /**
     * Get the stem
     *
     * @return The stem which is the rest of the word (no prefix)
     */
    String stem() {
        return stem;
    }

    /**
     * Capitalization check
     *
     * @return True if the first letter is upper case. Otherwise, returns false.
     */
    boolean isCapitalized() {
        return capitalized;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof WordComponentParser that))
            return false;
        return Objects.equals(this.word, that.word);
    }

    @Override
    public String toString() {
        return "%s [word=%s, prefix=%s, stem=%s, capitalized=%s]".formatted(getClass().getSimpleName(), word, prefix, stem, capitalized);
    }
}
