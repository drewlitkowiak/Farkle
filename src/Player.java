class Player {

    /**
     * This number is between -1 and 1 and will be added to the
     * most "greedy" choice. A negative number means that the
     * player is more likely to "cash out" and a positive number
     * means the player is more likely to go for more points.
     */
    private float risk;

    /**
     * This creates a new player object, with no risk. In other words,
     * This player will take the most probable outcome.
     */
    Player() {
        risk = 0;
    }

    /**
     * This creates a Player with a defined "Risk" value.
     * @param risk This number is between -1 and 1 and will be added to the
     *             most "greedy" choice. A negative number means that the
     *             player is more likely to "cash out" and a positive number
     *             means the player is more likely to go for more points.
     */
    Player(int risk) {
        this.risk = risk;
    }

    float getRisk() {
        return risk;
    }
}
