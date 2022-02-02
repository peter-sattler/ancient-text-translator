package net.sattler22.translator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * English to Ancient Text Language Translator Unit Test Harness
 *
 * @author Pete Sattler
 * @version 17 February 2014
 */
final class English2AncientTextTranslatorUnitTest {

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

    private void checkAssertionsImpl(String source, String expected) {
        final var translator = new English2AncientTextTranslator(source);
        final var actual = translator.translate();
        assertEquals(expected, actual);
    }
}
