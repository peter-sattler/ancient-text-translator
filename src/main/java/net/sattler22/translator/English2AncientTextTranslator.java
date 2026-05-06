package net.sattler22.translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * English to Ancient text language translator
 * <p>
 * Translates a single sentence or phrase from English to Ancient text preserving both whitespace and punctuation
 * </p>
 *
 * @author Pete Sattler
 * @since 17 February 2014
 * @version May 2026
 */
public final class English2AncientTextTranslator {

    private static final Logger logger = LoggerFactory.getLogger(English2AncientTextTranslator.class);
    private static final String ANCIENT_TEXT_DEFAULT_SUFFIX = "ay";
    private static final String ANCIENT_TEXT_CONSONANTS_SUFFIX = "yay";

    private English2AncientTextTranslator() {
        throw new AssertionError("Class cannot be instantiated");
    }

    /**
     * Translate the English text into Ancient text
     */
    public static String translate(String sourceText) {
        if (sourceText == null || sourceText.isBlank())
            throw new IllegalArgumentException("Source text is required");
        final BreakIterator wordIterator = BreakIterator.getWordInstance(Locale.US);
        wordIterator.setText(sourceText);
        final StringBuilder ancientText = new StringBuilder();
        for (int start = wordIterator.first(), end = wordIterator.next(); end != BreakIterator.DONE; start = end, end = wordIterator.next()) {
            final String sourceWord = sourceText.substring(start, end);
            //Do not translate a word with no letters:
            if (!WordUtils.hasLetters(sourceWord))
                ancientText.append(sourceWord);
            //Word with consonants only get a special suffix:
            else if (WordUtils.containsOnlyConsonants(sourceWord)) {
                ancientText.append(sourceWord);
                ancientText.append(ANCIENT_TEXT_CONSONANTS_SUFFIX);
            }
            //Reverse the order of the prefix and stem and add the default suffix to the end:
            else if (Character.isLetterOrDigit(sourceWord.charAt(0))) {
                final WordComponentParser wordComponentParser = new WordComponentParser(sourceWord);
                final String stem = wordComponentParser.stem();
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
}
