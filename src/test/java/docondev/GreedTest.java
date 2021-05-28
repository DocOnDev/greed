package docondev;

import org.junit.Before;
import org.junit.Test;

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
        assertThat(greed.score(new Integer[] {1}), is(equalTo(100)));
    }

    @Test
    public void score_Given_5_Return_50() {
        assertThat(greed.score(new Integer[] {5}), is(equalTo(50)));
    }

    @Test
    public void score_Given_NonScoringSingle_Return_0() {
        assertThat(greed.score(new Integer[] {3}), is(equalTo(0)));
    }

    @Test
    public void score_Given_TripleOne_Return_1000() {
        assertThat(greed.score(new Integer[] {1,1,1}), is(equalTo(1000)));
    }

    @Test
    public void score_Given_TripleTwo_Return_200() {
        assertThat(greed.score(new Integer[] {2,2,2}), is(equalTo(200)));
    }
}
