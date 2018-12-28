package net.sattler22.translator;

import java.io.Serializable;
import java.util.Objects;

/**
 * Parses a word into its prefix and stem
 * 
 * @author Pete Sattler
 * @version 17 February 2014
 */
public final class WordComponentParser implements Serializable {

    private static final long serialVersionUID = -6834722824698841124L;
    private final String word;
    private final String prefix;
    private final String stem;
    private final boolean capitalized;

    /**
     * Constructs a new word component parser
     */
    public WordComponentParser(String word) {
        this.word = Objects.requireNonNull(word, "Word is required");
        boolean isPrefix = true;
        StringBuilder prefixBuilder = new StringBuilder();
        StringBuilder stemBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isPrefix && WordUtils.isVowel(c))
                isPrefix = false;
            if (isPrefix)
                prefixBuilder.append(c);
            else
                stemBuilder.append(c);
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
    public String getPrefix() {
        return prefix;
    }

    /**
     * Get the stem
     * 
     * @return The stem which is the rest of the word (no prefix)
     */
    public String getStem() {
        return stem;
    }

    /**
     * Capitalization check
     * 
     * @return True if the first letter is upper case. Otherwise, returns false.
     */
    public boolean isCapitalized() {
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
