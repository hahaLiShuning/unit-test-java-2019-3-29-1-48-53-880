package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private Answer correctAnswer;
    private Game game;

    @Before
    public void setUp() throws Exception {
        correctAnswer = Answer.createAnswer("1 2 3 4");
        AnswerGenerator mockAnswerGenerator = mock(AnswerGenerator.class);
        when(mockAnswerGenerator.generate()).thenReturn(correctAnswer);
        game = new Game(mockAnswerGenerator);
    }

    @Test
    public void should_get_success_when_answer_is_correct() {
        game.guess(Answer.createAnswer("1 2 3 4"));
        String status = game.checkStatus();
        Assert.assertEquals(status, "success");
    }

    @Test
    public void should_get_continue_when_answer_is_incorrect_and_in_6_times() {
        game.guess(Answer.createAnswer("5 6 7 8"));
        String status = game.checkStatus();
        Assert.assertEquals(status, "continue");
    }

    @Test
    public void should_get_fail_when_answer_is_incorrect_6_times() {
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        String status = game.checkStatus();
        Assert.assertEquals(status, "fail");
    }

    @Test
    public void should_get_guess_result_when_call_guess_history() {
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        List<GuessResult> guessResults = game.guessHistory();
        Assert.assertEquals(guessResults.get(0).getResult(), "0A0B");
        Assert.assertEquals(guessResults.get(1).getResult(), "4A0B");
        Assert.assertEquals(guessResults.size(), 2);
    }

}
