package net.sattler22.translator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * English to Ancient Text Language Translator Unit Tests
 *
 * @author Pete Sattler
 * @since 17 February 2014
 * @version May 2026
 */
final class English2AncientTextTranslatorTest {

    @Test
    void translate_whenSingleWord_thenSuccessful() {
        checkAssertions("Stop", "Opstay");
    }

    @Test
    void translate_whenCleanlinessRequirement_thenSuccessful() {
        checkAssertions("No littering", "Onay itteringlay");
    }

    @Test
    void translate_whenClothingMandatory_thenSuccessful() {
        checkAssertions("No shirts, no shoes, no service", "Onay irtsshay, onay oesshay, onay ervicesay");
    }

    @Test
    void translate_whenAgeVerified_thenSuccessful() {
        checkAssertions("No persons under 14 admitted", "Onay ersonspay underay 14 admitteday");
    }

    @Test
    void translate_whenStayAwayBuddy_thenSuccessful() {
        checkAssertions("Hey buddy, get away from my car!", "Eyhay uddybay, etgay awayay omfray ymay arcay!");
    }

    @Test
    void translate_whenConsonantsOnly_thenSuccessful() {
        checkAssertions("bcd is misspelled!!!", "bcdyay isay isspelledmay!!!");
    }

    private static void checkAssertions(String sourceText, String expected) {
        final String actual = English2AncientTextTranslator.translate(sourceText);
        assertEquals(expected, actual);
    }
}
