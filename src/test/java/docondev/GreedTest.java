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
    public void score_1_Return_100() {
        assertThat(greed.score(new Integer[] {1}), is(equalTo(100)));
    }

    @Test
    public void score_5_Return_50() {
        assertThat(greed.score(new Integer[] {5}), is(equalTo(50)));
    }
}
