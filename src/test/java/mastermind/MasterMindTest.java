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

    @Test
    public void getsOneWhiteOneRed() {

        // given
        Character[] code = { 'R', 'B', 'R', 'G' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'Y', 'B', 'G', 'Y' };

        // when
        Character[] feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactlyInAnyOrder('W', 'R');
    }

    @Test
    public void perfectMatchGetsAllRed() {

        // given
        Character[] code = { 'B', 'B', 'B', 'B' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'B', 'B', 'B', 'B'  };

        // when
        Character[] feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactlyInAnyOrder('R', 'R', 'R', 'R');
    }


}
