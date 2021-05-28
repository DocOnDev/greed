package docondev;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreedTest {

    @Test
    public void score_one_onehundred() {
        Greed greed = new Greed();
        assertThat(greed.score(1), is(equalTo(100)));
    }

    @Test
    public void score_five_fifty() {
        Greed greed = new Greed();
        assertThat(greed.score(5), is(equalTo(50)));
    }
}
