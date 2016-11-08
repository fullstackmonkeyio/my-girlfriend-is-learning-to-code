package io.fullstackmonkey.mgiltc;


public class Foo {

    private final String strField;
    private final long longField;

    public Foo(String strField, long longField) {
        this.strField = strField;
        this.longField = longField;
    }

    public String getStrField() {
        return strField;
    }

    public long getLongField() {
        return longField;
    }

    @Override
    public boolean equals(Object other) {

        // quick check if we are the same instance
        if (this == other) return true;

        // test if the other object is null or of a different type
        if (other == null || getClass() != other.getClass()) return false;

        // we can safely cast as we know that 'other' is an instance of Foo
        Foo foo = (Foo) other;

        // compare each of the properties
        if (longField != foo.longField) return false;
        return strField.equals(foo.strField);

    }

    @Override
    public int hashCode() {
        int result = strField.hashCode();
        result = 31 * result + (int) (longField ^ (longField >>> 32));
        return result;
    }
}
