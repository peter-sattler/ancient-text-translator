package net.sattler22.translator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * English to Ancient Text Language Translator Unit Tests
 *
 * @author Pete Sattler
 * @version 17 February 2014
 */
final class English2AncientTextTranslatorTest {

    @Test
    void stopTestCase() {
        checkAssertionsImpl("Stop", "Opstay");
    }

    @Test
    void noLitteringTestCase() {
        checkAssertionsImpl("No littering", "Onay itteringlay");
    }

    @Test
    void noShirtsShoesServiceTestCase() {
        checkAssertionsImpl("No shirts, no shoes, no service", "Onay irtsshay, onay oesshay, onay ervicesay");
    }

    @Test
    void noPersonsUnder14AdmittedTestCase() {
        checkAssertionsImpl("No persons under 14 admitted", "Onay ersonspay underay 14 admitteday");
    }

    @Test
    void heyBuddyGetAwayFromMyCarTestCase() {
        checkAssertionsImpl("Hey buddy, get away from my car!", "Eyhay uddybay, etgay awayay omfray ymay arcay!");
    }

    @Test
    void consonantsOnlyTestCase() {
        checkAssertionsImpl("bcd is misspelled!!!", "bcdyay isay isspelledmay!!!");
    }

    private static void checkAssertionsImpl(String source, String expected) {
        final var translator = new English2AncientTextTranslator(source);
        final var actual = translator.translate();
        assertEquals(expected, actual);
    }
}
