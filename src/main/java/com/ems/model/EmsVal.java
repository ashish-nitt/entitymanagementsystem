package com.ems.model;

/**
 * Created by Ashish on 27-01-2018.
 */
public class EmsVal {
    private Boolean isAttribute;
    private String value;

    private EmsVal(String value) {
        this.isAttribute = true;
        this.value = value;
    }

    private EmsVal(Long value) {
        this.isAttribute = false;
        this.value = String.valueOf(value);
    }

    public EmsVal() {
    }

    public static EmsVal newAttributeValue(String value) {
        return new EmsVal(value);
    }

    public static EmsVal newEntityValue(Long value) {
        return new EmsVal(value);
    }

    public Boolean isEntityReference() {
        return ! isAttribute;
    }

    public Boolean isAttribute() {
        return isAttribute;
    }

    public String getValue() {
        return value;
    }

    public Long getEntityReference() {
        return Long.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmsVal)) return false;

        EmsVal that = (EmsVal) o;

        if (!isAttribute.equals(that.isAttribute)) return false;
        return value.equals(that.value);

    }

    @Override
    public int hashCode() {
        int result = isAttribute.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
