package io.fullstackmonkey.mgiltc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class ComparisonsTest {

    @Test
    public void referenceEqualityTest(){

        final int foo = 12;
        final int bar = 12;
        final int baz = 13;

        assertTrue(foo == bar);
        assertFalse(foo == baz);
        assertTrue(foo != baz);

    }

    @Test
    public void referenceEqualityStringsTest(){

        final String foo = "Hello";
        final String bar = "Hello";
        final String baz = "World";

        assertTrue(foo == bar);         // String literals are interned which means this will work
        assertFalse(foo == baz);
        assertTrue(foo != baz);

        assertTrue(foo.equals(bar));    // To ensure you are checking the contents of the string and not just the
        assertFalse(foo.equals(baz));   // the reference you need to use the Object.equals() method

    }


    /**
     * When comparing a primitive type with it's object counterpart the JVM will perform something called 'Autoboxing' and
     * 'Unboxing':
     *
     *  Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding
     *  object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. If the conversion
     *  goes the other way, this is called unboxing.
     *
     */
    @Test
    public void autoboxingTest(){

        assertTrue((byte) 12 == Byte.valueOf((byte) 12));       // byte
        assertTrue((short) 13 == Short.valueOf((short) 13));    // short
        assertTrue(14 == Integer.valueOf(14));                  // integer
        assertTrue(15L == Long.valueOf(15L));                   // long
        assertTrue(16.0f == Float.valueOf(16.0f));              // float
        assertTrue(17.0 == Double.valueOf(17.0));               // double
        assertTrue(true == Boolean.valueOf(true));              // boolean
        assertTrue('B' == Character.valueOf('B'));              // character

        // works just the same in reverse

        assertTrue(Byte.valueOf((byte) 12) == (byte) 12);       // byte
        assertTrue(Short.valueOf((short) 13) == (short) 13);    // short
        assertTrue(Integer.valueOf(14) == 14);                  // integer
        assertTrue(Long.valueOf(15L) == 15L);                   // long
        assertTrue(Float.valueOf(16.0f) == 16.0f);              // float
        assertTrue(Double.valueOf(17.0) == 17.0);               // double
        assertTrue(Boolean.valueOf(true) == true);              // boolean
        assertTrue(Character.valueOf('B') == 'B');              // character

        // doesn't just apply to == but also !=, <, <=, >, >=

        assertTrue((byte) 12 < Byte.valueOf((byte) 13));        // byte
        assertTrue((short) 13 >= Short.valueOf((short) 13));    // short
        assertTrue(14 > Integer.valueOf(1));                    // integer
        assertTrue(15L >= Long.valueOf(15L));                   // long
        assertTrue(16.0f < Float.valueOf(25.1f));               // float
        assertTrue(17.0 <= Double.valueOf(23.0));               // double
        assertTrue(true != Boolean.valueOf(false));             // boolean
        assertTrue('B' != Character.valueOf('F'));              // character
    }

    @Test
    public void objectEqualityTest(){

        final Foo helloFoo = new Foo("hello", 1L);
        final Foo worldFoo = new Foo("world", 2L);

        final Bar fiveBar = new Bar(5, 2.1f);
        final Bar tenBar = new Bar(10, 1.1f);

        assertTrue(helloFoo.equals(helloFoo));                  // equal to itself (identity comparison)
        assertFalse(helloFoo.equals(worldFoo));                 // not equal to same object with different properties
        assertFalse(helloFoo.equals(fiveBar));                  // not equal to different type of object

        assertTrue(fiveBar.equals(fiveBar));                    // equal to itself (identity comparison)
        assertFalse(fiveBar.equals(tenBar));                    // not equal to same object with different properties
        assertFalse(fiveBar.equals(helloFoo));                  // not equal to different type of object
    }




}
