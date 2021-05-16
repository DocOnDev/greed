package docondev;

import org.junit.Test;
import org.hamcrest.core.IsInstanceOf;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiceSetTest {
    @Test
    public void createDiceSet_SingleOne_SingleDiceSet() {
        ArrayList<Die> dieList = new ArrayList<Die>();
        dieList.add(new Die(1));
        DiceSet diceSet = DiceSet.createDiceSet(dieList);
        assertThat(diceSet, is(instanceOf(SingleDiceSet.class)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiceSet_SingleOneAndSingleTwo_Error() {
        ArrayList<Die> dieList = new ArrayList<Die>();
        dieList.add(new Die(1));
        dieList.add(new Die(2));
        DiceSet diceSet = DiceSet.createDiceSet(dieList);
    }
}
