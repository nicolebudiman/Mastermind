package mastermind;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MasterMindTest {

    @Test
    public void thisTestPasses() {
        assertThat(true).isTrue();
    }

    @Test
    public void noMatchesGetsNoFeedback() {

        // given
        List<Character> code = new LinkedList<>();
        code.add('R');
        code.add('R');
        code.add('R');
        code.add('R');

        MasterMind masterMind = new MasterMind(code);

        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('Y');
        guess.add('Y');
        guess.add('Y');
        guess.add('Y');

        // when
        List<Character> feedback = masterMind.play(guess);

        // then
        assertThat(feedback).isEmpty();
    }

    @Test
    public void correctColorIncorrectPositionGetsOneWhite() {

        // given
        ArrayList<Character> code = new ArrayList<Character>();
        code.add('R');
        code.add('B');
        code.add('R');
        code.add('R');

        MasterMind masterMind = new MasterMind(code);

        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('Y');
        guess.add('Y');
        guess.add('B');
        guess.add('Y');

        // when
        List<Character> feedback = masterMind.play(guess);

        // then
        assertThat(code).containsExactly('R', 'B', 'R', 'R');
        assertThat(feedback).containsExactly('W');
    }


    @Test
    public void correctColorCorrectPositionGetsOneRed() {

        // given
        ArrayList<Character> code = new ArrayList<Character>();
        code.add('R');
        code.add('B');
        code.add('R');
        code.add('R');

        MasterMind masterMind = new MasterMind(code);

        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('Y');
        guess.add('B');
        guess.add('Y');
        guess.add('Y');

        // when
        List<Character> feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactly('R');
    }

    @Test
    public void getsOneWhiteOneRed() {

        // given
        ArrayList<Character> code = new ArrayList<Character>();
        code.add('R');
        code.add('B');
        code.add('R');
        code.add('G');

        MasterMind masterMind = new MasterMind(code);

        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('Y');
        guess.add('B');
        guess.add('G');
        guess.add('Y');

        // when
        List<Character> feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactlyInAnyOrder('W', 'R');
    }

    @Test
    public void perfectMatchGetsAllRed() {

        // given
        ArrayList<Character> code = new ArrayList<Character>();
        code.add('B');
        code.add('B');
        code.add('B');
        code.add('B');

        MasterMind masterMind = new MasterMind(code);

        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('B');
        guess.add('B');
        guess.add('B');
        guess.add('B');

        // when
        List<Character> feedback = masterMind.play(guess);

        // then
        assertThat(feedback).containsExactlyInAnyOrder('R', 'R', 'R', 'R');
    }

    @Test
    public void sameGuessTwiceGetsSameFeedback() {

        // given
        ArrayList<Character> code = new ArrayList<Character>();
        code.add('Y');
        code.add('B');
        code.add('Y');
        code.add('Y');

        MasterMind masterMind = new MasterMind(code);

        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('Y');
        guess.add('G');
        guess.add('G');
        guess.add('G');


        // when
        List<Character> firstFeedback = masterMind.play(guess);

        // then
        assertThat(firstFeedback).containsExactly('R');

        // and when
        List<Character> secondFeedback = masterMind.play(guess);

        // then
        assertThat(secondFeedback).containsExactly('R');
    }

    @Test
    public void tenFailedGuessesLosesTheGame() {

        // given
        ArrayList<Character> code = new ArrayList<Character>();
        code.add('Y');
        code.add('Y');
        code.add('Y');
        code.add('Y');

        MasterMind masterMind = new MasterMind(code);

        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('G');
        guess.add('G');
        guess.add('G');
        guess.add('G');

        // given ten failed attempts
        for(int i = 0; i < 10; i++) {
            masterMind.play(guess);
        }

        // when an eleventh attempt
        try {

            masterMind.play(guess); // this should throw an exception
            fail("should have thrown an exception");

        } catch(RuntimeException e) {
            // then
            assertThat(e.getMessage()).isEqualTo("Game over, you lost!");
        }

    }

}
