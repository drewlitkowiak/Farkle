import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * This handles the current roll for the player. It keeps
 * track of what dice are currently in play and keeps tab
 * on the score, as well as finding any combos, such
 * as straights and "5 of a Kind," to name a few.
 */
class Turn {

    class Dice {

        int value;

        int roll() {
            value = (int) Math.round(6 * Math.random());
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() == this.getClass()) {
                return ((Dice) obj).value == this.value;
            } else {
                return false;
            }
        }
    }

    static final int SIX_OF_A_KIND = 3000;
    static final int TWO_TRIPLETS = 2500;
    static final int FIVE_OF_A_KIND = 2000;
    static final int STRAIGHT = 1500;
    static final int THREE_PAIRS = 1500;
    static final int FOUR_OF_A_KIND_WITH_A_PAIR = 1500;
    static final int FOUR_OF_A_KIND = 1000;

    /**
     * The score, which is all or nothing dependent on a Farkle.
     */
    private int score = 0;

    /**
     * The current dice that can be rerolled.
     */
    private Dice[] rollable;

    /**
     * The log generated for the turn. My idea is to use this
     * for debugging.
     */
    ArrayList log = new ArrayList<String>();

    /**
     * Starts a new turn with
     */
    Turn() {
        rollable = new Dice[6];
        for(int i = 0; i < rollable.length; i++) {
            rollable[i] = new Dice();
        }
    }

    /**
     * Starts the turn for the player.
     * @param player The player whose turn is being taken.
     * @return The total score from this turn.
     */
    int takeTurn(Player player) {
        if (player == null) {
            throw new InvalidParameterException();
        }
        rollDice();
        scoreRoll();
        //Change before testing
        return 0;
    }

    /**
     * Roll the set of rollable dice.
     */
    void rollDice() {
        for (int i = 0; i < rollable.length; i++) {
            rollable[i].roll();
        }
    }

    /**
     * This scores the current set of rollable dice as they are, and
     * will add to the turn score as well as reduce the size of rollable
     * dice as neccessary.
     */
    void scoreRoll() {
        //Compiles a list of unique values found.
        Integer[] list = new Integer[0];
        {
            ArrayList <Integer> arrayList = new ArrayList <>();
            for (int i = 0; i < rollable.length; i++) {
                if (!arrayList.contains(rollable[i].value)) {
                    arrayList.add(rollable[i].value);
                }
            }
            list = arrayList.toArray(list);
        }
        if (rollable.length == 6) {
            if (list.length == 1) {
                score += SIX_OF_A_KIND;
                rollable = new Dice[0];
                return;
            }
            if (list.length == 2) {
                int first = 0;
                int second = 0;
                for (int i = 0; i < rollable.length; i++) {
                    if (rollable[i].value == list[0]) {
                        first++;
                    } else {
                        second++;
                    }
                }
                
            }
        }

    }
}