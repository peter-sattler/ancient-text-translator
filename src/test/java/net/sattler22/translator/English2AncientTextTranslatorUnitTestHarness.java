package net.sattler22.translator;

import org.junit.Assert;
import org.junit.Test;

/**
 * English to Ancient Text Language Translator Unit Test Harness
 * 
 * @author Pete Sattler
 * @version 17 February 2014
 */
public final class English2AncientTextTranslatorUnitTestHarness {

    @Test
    public void stopTestCase() {
        checkAssertionsImpl("Stop", "Opstay");
    }

    @Test
    public void noLitteringTestCase() {
        checkAssertionsImpl("No littering", "Onay itteringlay");
    }

    @Test
    public void noShirtsShoesServiceTestCase() {
        checkAssertionsImpl("No shirts, no shoes, no service", "Onay irtsshay, onay oesshay, onay ervicesay");
    }

    @Test
    public void noPersonsUnder14AdmittedTestCase() {
        checkAssertionsImpl("No persons under 14 admitted", "Onay ersonspay underay 14 admitteday");
    }

    @Test
    public void heyBuddyGetAwayFromMyCarTestCase() {
        checkAssertionsImpl("Hey buddy, get away from my car!", "Eyhay uddybay, etgay awayay omfray ymay arcay!");
    }

    @Test
    public void consonantsOnlyTestCase() {
        checkAssertionsImpl("bcd is misspelled!!!", "bcdyay isay isspelledmay!!!");
    }

    private void checkAssertionsImpl(String source, String expected) {
        final English2AncientTextTranslator translator = new English2AncientTextTranslator(source);
        final String actual = translator.translate();
        Assert.assertEquals(expected, actual);
    }
}
