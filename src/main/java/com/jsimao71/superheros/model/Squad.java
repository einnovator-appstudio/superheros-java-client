package com.jsimao71.superheros.model;

public enum Squad {

    MARVEL("Marvel"), DC("DC");

    private String displayValue;

    private Squad(String displayValue) {
        this.displayValue = displayValue;
    }

    /**
     * Set value of property {@code displayValue}.
     *
     * @param displayValue the value of displayValue
     */
    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    /**
     * Get value of property {@code displayValue}.
     *
     * @return displayValue the {@code displayValue}
     */
    public String getDisplayValue() {
        return this.displayValue;
    }
}
