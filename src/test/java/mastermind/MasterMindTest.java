package mastermind;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;


public class MasterMindTest {

    @Test
    public void thisTestPasses() {
        assertThat(true).isTrue();
    }

    @Test
    public void noMatchesGetsNoFeedback() {

        // given
        Character[] code = { 'R', 'R', 'R', 'R' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'Y', 'Y', 'Y', 'Y' };

        // when
        Character[] feedback = masterMind.play(guess);

        // then
        assertThat(feedback).isEmpty();
    }

    @Test
    public void correctColorIncorrectPositionGetsOneWhite() {

        // given
        Character[] code = { 'R', 'B', 'R', 'R' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'Y', 'Y', 'B', 'Y' };

        // when
        Character[] feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactly('W');
    }


    @Test
    public void correctColorCorrectPositionGetsOneRed() {

        // given
        Character[] code = { 'R', 'B', 'R', 'R' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'Y', 'B', 'Y', 'Y' };

        // when
        Character[] feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactly('R');
    }


}
