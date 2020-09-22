package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("010 I'd better put some digits in this string, right?12");
        assertEquals(2, mycustomstring.countNumbers());
    }//string starts and ends with number

    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("01 43 28 5670954683 12     12 56  898070689967512   ");
        assertEquals(8, mycustomstring.countNumbers());
    }//string with all number 

    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("I'd better put some digits in this string, right?");
        assertEquals(0, mycustomstring.countNumbers());
    }//string with no digit

    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("  ");
        assertEquals(0, mycustomstring.countNumbers());
    }//empty string

    @Test (expected = NullPointerException.class)
    public void testCountNumbers6() {
        assertEquals(2, mycustomstring.countNumbers());
    }//NullPointerException

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }//string contains letters and digits, n is odd, startFromEnd = true

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(" tps 1ih5nrt", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, false));
    }//string contains letters and digits, n is even, startFromEnd = false

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'3rtm1s sr,g", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, true));
    }//string contains letters and digits, n is even, startFromEnd = true

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }//string contains letters and digits, n = 1, startFromEnd = false

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }//string contains letters and digits, n = 1, startFromEnd = true

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(60, false));
    }//string contains letters and digits, n > length of the string, startFromEnd = false

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(60, true));
    }//string contains letters and digits, n > length of the string, startFromEnd = true

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(60, true));
    }//empty string

    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false));
    }//IllegalArgumentException, n = 0, startFromEnd = false

    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false));
    }//IllegalArgumentException, n = 0, startFromEnd = true

    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-2, false));
    }//IllegalArgumentException, n < 0, startFromEnd = false

    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-2, true));
    }//IllegalArgumentException, n < 0, startFromEnd = true

    @Test (expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }//NullPointerException

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(22, 22);
        assertEquals("I'd b3tt3r put s0me dOne61ts in this 5tr1n6, right?", mycustomstring.getString());
    }//string contains letters and digits, startPosition = endPosition

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("I'd better put some digits in this string, right?");
        mycustomstring.convertDigitsToNamesInSubstring(10, 22);
        assertEquals("I'd better put some digits in this string, right?", mycustomstring.getString());
    }//string contains no digit, startPosition < endPosition

    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(1, mycustomstring.getString().length());
        assertEquals("I'd bThreettThreer put sZerome dOneSixOnets in this FivetrOnenSix, right?", mycustomstring.getString());
    }//string contains letters and digits, startPosition = 1 and endPosition = length of string

    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(20, 18);
        assertEquals("I'd bThreettThreer put sZerome dOneSixOnets in this FivetrOnenSix, right?", mycustomstring.getString());
    }//IllegalArgumentException, startPosition > endPosition

    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(0, 25);
        assertEquals("I'd bThreettThreer put sZerome dOneSixOnets in this FivetrOnenSix, right?", mycustomstring.getString());
    }//MyIndexOutOfBoundsException, startPosition < 1

    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(3, mycustomstring.getString().length() + 1);
        assertEquals("I'd bThreettThreer put sZerome dOneSixOnets in this FivetrOnenSix, right?", mycustomstring.getString());
    }//MyIndexOutOfBoundsException, endPosition > length of string

    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.convertDigitsToNamesInSubstring(30, 38);
        assertEquals("I'd bThreettThreer put sZerome dOneSixOnets in this FivetrOnenSix, right?", mycustomstring.getString());
    }//NullPointerException

}
