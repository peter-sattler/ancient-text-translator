package net.sattler22.translator;

import net.jcip.annotations.Immutable;

import java.util.Objects;

/**
 * Parses a word into its prefix and stem
 *
 * @author Pete Sattler
 * @version 17 February 2014
 */
@Immutable
final class WordComponentParser {

    private final String word;
    private final String prefix;
    private final String stem;
    private final boolean capitalized;

    /**
     * Constructs a new word component parser
     */
    WordComponentParser(String word) {
        this.word = Objects.requireNonNull(word, "Word is required");
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
        if (other == null)
            return false;
        if (this.getClass() != other.getClass())
            return false;
        final WordComponentParser that = (WordComponentParser) other;
        return Objects.equals(this.word, that.word);
    }

    @Override
    public String toString() {
        return String.format("%s [word=%s, prefix=%s, stem=%s, capitalized=%s]", getClass().getSimpleName(), word, prefix, stem, capitalized);
    }
}
