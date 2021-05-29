package docondev;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

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
    public void score_Given_1_Return_100() {
        assertThat(greed.score(makeSingle(1)), is(equalTo(100)));
    }

    @Test
    public void score_Given_5_Return_50() {
        assertThat(greed.score(makeSingle(5)), is(equalTo(50)));
    }

    @Test
    public void score_Given_NonScoringSingle_Return_0() {
        assertThat(greed.score(makeSingle(3)), is(equalTo(0)));
    }

    @Test(expected = InvalidParameterException.class)
    public void score_Given_GreaterThan6_Throw_ParameterError() {
        assertThat(greed.score(makeSingle(7)), is(equalTo(0)));
    }

    @Test(expected = InvalidParameterException.class)
    public void score_Given_LessThan1_Throw_ParameterError() {
        assertThat(greed.score(makeSingle(0)), is(equalTo(0)));
    }

    @Test
    public void score_Given_TripleOne_Return_1000() {
        assertThat(greed.score(makeTriple(1)), is(equalTo(1000)));
    }

    @Test
    public void score_Given_TripleTwo_Return_200() {
        assertThat(greed.score(makeTriple(2)), is(equalTo(200)));
    }

    @Test
    public void score_Given_TripleThree_Return_300() {
        assertThat(greed.score(makeTriple(3)), is(equalTo(300)));
    }

    private Integer[] makeSingle(int value) {
        return new Integer[]{value};
    }

    private Integer[] makeTriple(int value) {
        return new Integer[]{value, value, value};
    }
}
