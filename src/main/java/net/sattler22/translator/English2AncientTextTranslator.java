package net.sattler22.translator;

import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.BreakIterator;
import java.util.Locale;
import java.util.Objects;

/**
 * Translates a single sentence or phrase from English to Ancient text preserving both whitespace and punctuation
 *
 * @author Pete Sattler
 * @version 17 February 2014
 */
@Immutable
public final class English2AncientTextTranslator {

    private static final Logger logger = LoggerFactory.getLogger(English2AncientTextTranslator.class);
    private static final String ANCIENT_TEXT_DEFAULT_SUFFIX = "ay";
    private static final String ANCIENT_TEXT_CONSONANTS_SUFFIX = "yay";
    private final String sourceText;
    private final BreakIterator wordIterator;

    /**
     * Constructs a new English to Ancient text language translator
     */
    public English2AncientTextTranslator(String sourceText) {
        this.sourceText = Objects.requireNonNull(sourceText, "Source text is required");
        this.wordIterator = BreakIterator.getWordInstance(Locale.US);
        this.wordIterator.setText(sourceText);
    }

    /**
     * Translate the English text into Ancient text
     */
    public String translate() {
        final var ancientText = new StringBuilder();
        for (int start = wordIterator.first(), end = wordIterator.next(); end != BreakIterator.DONE; start = end, end = wordIterator.next()) {
            final var sourceWord = sourceText.substring(start, end);
            //Do not translate a word with no letters:
            if (!WordUtils.hasLetters(sourceWord))
                ancientText.append(sourceWord);
            //Word with consonants only get a special suffix:
            else if (WordUtils.hasOnlyConsonants(sourceWord)) {
                ancientText.append(sourceWord);
                ancientText.append(ANCIENT_TEXT_CONSONANTS_SUFFIX);
            }
            //Reverse the order of the prefix and stem and add the default suffix to the end:
            else if (Character.isLetterOrDigit(sourceWord.charAt(0))) {
                final var wordComponentParser = new WordComponentParser(sourceWord);
                final var stem = wordComponentParser.stem();
                if (wordComponentParser.isCapitalized()) {
                    ancientText.append(Character.toUpperCase(stem.charAt(0)));
                    ancientText.append(stem.substring(1).toLowerCase());
                } 
                else
                    ancientText.append(stem.toLowerCase());
                ancientText.append(wordComponentParser.prefix().toLowerCase());
                ancientText.append(ANCIENT_TEXT_DEFAULT_SUFFIX);
            }
            //Preserve whitespace and punctuation:
            else
                ancientText.append(sourceWord);
        }
        logger.info("Translated [{}] to [{}]", sourceText, ancientText);
        return ancientText.toString();
    }

    @Override
    public String toString() {
        return String.format("%s [sourceText=%s, wordIterator=%s]", getClass().getSimpleName(), sourceText, wordIterator);
    }
}
