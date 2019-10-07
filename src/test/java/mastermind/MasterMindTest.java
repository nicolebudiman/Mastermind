package mastermind;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class MasterMindTest {

    @Test
    public void thisTestPasses() {
        assertThat(true).isTrue();
    }

    @Test
    public void noMatchesGetsNoFeedback() throws Exception {

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
    public void correctColorIncorrectPositionGetsOneWhite() throws Exception {

        // given
        Character[] code = { 'R', 'B', 'R', 'R' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'Y', 'Y', 'B', 'Y' };

        // when
        Character[] feedback = masterMind.play(guess);

        // then
        assertThat(code).containsExactly('R', 'B', 'R', 'R');
        assertThat(feedback).containsExactly('W');
    }


    @Test
    public void correctColorCorrectPositionGetsOneRed() throws Exception {

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
    public void getsOneWhiteOneRed() throws Exception {

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
    public void perfectMatchGetsAllRed() throws Exception {

        // given
        Character[] code = { 'B', 'B', 'B', 'B' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'B', 'B', 'B', 'B' };

        // when
        Character[] feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactlyInAnyOrder('R', 'R', 'R', 'R');
    }

    @Test
    public void perfectMatchWinsAndEndsTheGame() throws Exception {

        // given
        Character[] code = { 'B', 'B', 'B', 'B' };
        MasterMind masterMind = new MasterMind(code);

        // given a guess which matches the code
        masterMind.play(code);

        // when another guess is made
        try {

            masterMind.play(code); // this should throw an exception
            fail("should have thrown an exception");

        } catch(GameOverException e) {
            // then
            assertThat(e.getMessage()).isEqualTo("Game over, you won!");
        }

    }

    @Test
    public void sameGuessThatDoesNotMatchTheCodeGetsSameFeedback() throws Exception {

        // given
        Character[] code = { 'Y', 'B', 'Y', 'Y' };

        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'Y', 'G', 'G', 'G' };

        // when
        Character[] firstFeedback = masterMind.play(guess);

        // then
        assertThat(firstFeedback).containsExactly('R');

        // and when
        Character[] secondFeedback = masterMind.play(guess);

        // then
        assertThat(secondFeedback).containsExactly('R');
    }

    @Test
    public void tenFailedGuessesLosesTheGame() throws Exception {

        // given
        Character[] code = { 'Y', 'Y', 'Y', 'Y' };
        MasterMind masterMind = new MasterMind(code);

        Character[] guess = { 'G', 'G', 'G', 'G' };

        // given ten failed attempts
        for(int i = 0; i < 10; i++) {
            masterMind.play(guess);
        }

        // when an eleventh attempt
        try {

            masterMind.play(guess); // this should throw an exception
            fail("should have thrown an exception");

        } catch(GameOverException e) {
            // then
            assertThat(e.getMessage()).isEqualTo("Game over, you lost!");
        }

    }

}
