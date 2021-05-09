package docondev;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreedTest {

    @Test
    public void score_one_onehundred() {
        Greed greed = new Greed();
        greed.addDice(1);
        assertThat(greed.score(), is(equalTo(100)));
    }

    @Test
    public void score_five_Fifty() {
        Greed greed = new Greed();
        greed.addDice(5);
        assertThat(greed.score(), is(equalTo(50)));
    }
}
