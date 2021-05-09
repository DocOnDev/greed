package docondev;

import org.junit.Before;
import org.junit.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreedTest {

    private Greed greed;

    @Before
    public void setUp() throws Exception {
        greed = new Greed();
    }

    @Test
    public void score_one_onehundred() {
        greed.addDice(1);
        assertThat(greed.score(), is(equalTo(100)));
    }

    @Test
    public void score_five_Fifty() {
        greed.addDice(5);
        assertThat(greed.score(), is(equalTo(50)));
    }

    @Test
    public void score_doubleOne_TwoHundred() {
        addHowManyDieOfValue(2, 1);
        assertThat(greed.score(), is(equalTo(200)));
    }

    @Test
    public void score_tripleOne_OneThousand() {
        addHowManyDieOfValue(3, 1);
        assertThat(greed.score(), is(equalTo(1000)));
    }

    private void addHowManyDieOfValue(int howMany, Integer one) {
        rangeClosed(1, howMany).forEach(i -> greed.addDice(one));
    }
}
