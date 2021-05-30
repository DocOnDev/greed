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
    public void score_Given_TripleNonOneDigit_Return_DigitTimes100() {
        assertThat(greed.score(makeTriple(3)), is(equalTo(300)));
    }

    @Test
    public void score_Given_Quad_Return_TripleTime2() {
        assertThat(greed.score(makeQuad(1)), is(equalTo(2000)));
        assertThat(greed.score(makeQuad(3)), is(equalTo(600)));
    }

    @Test
    public void score_Given_Quint_Return_TripleTimes4() {
        assertThat(greed.score(makeQuint(1)), is(equalTo(4000)));
        assertThat(greed.score(makeQuint(3)), is(equalTo(1200)));
    }

    private Integer[] makeQuad(int value) { return makeSet(4, value); }

    private Integer[] makeQuint(int value) { return makeSet(5, value); }

    private Integer[] makeSingle(int value) { return makeSet(1, value); }

    private Integer[] makeTriple(int value) { return makeSet(3, value); }

    private Integer[] makeSet(int setSize, int value) {
        Integer[] set = new Integer[setSize];
        for (int idx=0; idx<setSize; idx++) {
            set[idx] = value;
        }
        return set;
    }
}
