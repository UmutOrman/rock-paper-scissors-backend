package com.rabobank.demo.model;

/**
 * @author horman
 */
public enum GameResult {
    WIN("WIN"),
    DRAW("DRAW"),
    LOSS("LOSS");

    private final String value;

    /**
     * @param value
     */
    GameResult(final String value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return value;
    }
}
