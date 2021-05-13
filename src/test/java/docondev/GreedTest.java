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

    @Test(expected = IllegalArgumentException.class)
    public void addDice_seven_ThrowError() {
        greed.addDice(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDice_negativeOne_ThrowError() {
        greed.addDice(-1);
    }

    @Test
    public void score_singleOne_onehundred() {
        greed.addDice(1);
        assertThat(greed.score(), is(equalTo(100)));
    }

    @Test
    public void score_singleFive_Fifty() {
        greed.addDice(5);
        assertThat(greed.score(), is(equalTo(50)));
    }

    @Test
    public void score_singleTwo_Zero() {
        greed.addDice(2);
        assertThat(greed.score(), is(equalTo(0)));
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

    @Test
    public void score_tripleTwo_TwoHundred() {
        addHowManyDieOfValue(3, 2);
        assertThat(greed.score(), is(equalTo(200)));
    }

    @Test
    public void score_tripleSix_SixHundred() {
        addHowManyDieOfValue(3, 6);
        assertThat(greed.score(), is(equalTo(600)));
    }

    @Test
    public void score_quadrupleFour_EightHundred() {
        addHowManyDieOfValue(4, 4);
        assertThat(greed.score(), is(equalTo(800)));
    }

    private void addHowManyDieOfValue(int howMany, Integer one) {
        rangeClosed(1, howMany).forEach(i -> greed.addDice(one));
    }
}
