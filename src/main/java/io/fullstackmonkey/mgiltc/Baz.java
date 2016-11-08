package io.fullstackmonkey.mgiltc;


public class Baz {

    private final int booleanField;
    private final String strField;

    public Baz(int booleanField, String strField) {
        this.booleanField = booleanField;
        this.strField = strField;
    }

    public int getBooleanField() {
        return booleanField;
    }

    public String getStrField() {
        return strField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Baz baz = (Baz) o;

        if (booleanField != baz.booleanField) return false;
        return strField.equals(baz.strField);

    }

    @Override
    public int hashCode() {
        int result = booleanField;
        result = 31 * result + strField.hashCode();
        return result;
    }
}
