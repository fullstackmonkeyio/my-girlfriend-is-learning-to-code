package io.fullstackmonkey.mgiltc;


public class Bar {

    private final int intField;
    private final float floatField;

    public Bar(int intField, float floatField) {
        this.intField = intField;
        this.floatField = floatField;
    }

    public int getIntField() {
        return intField;
    }

    public float getFloatField() {
        return floatField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        if (intField != bar.intField) return false;
        return Float.compare(bar.floatField, floatField) == 0;

    }

    @Override
    public int hashCode() {
        int result = intField;
        result = 31 * result + (floatField != +0.0f ? Float.floatToIntBits(floatField) : 0);
        return result;
    }

}
