package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.util.ArrayList;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private Game mockGame;
    private GameView mockGameView;
    private GameController gameController;
    private AnswerGenerator mockAnserGenerator;
    private Answer correctAnswer;
    private Answer wrongAnswer;
    private InputCommand mockCommand;

    @Before
    public void setUp() throws Exception {
        mockGame = mock(Game.class);
        mockGameView = mock(GameView.class);
        mockAnserGenerator = mock(AnswerGenerator.class);
        mockCommand = mock(InputCommand.class);

        correctAnswer = Answer.createAnswer("1 2 3 4");
        wrongAnswer = Answer.createAnswer("1, 3, 5, 7");
        when(mockAnserGenerator.generate()).thenReturn(correctAnswer);

        gameController = new GameController(mockGame, mockGameView);
    }

    @Test
    public void should_begin_game_when_call_begin_game() throws Exception {
        //when
        gameController.beginGame();

        //then
        verify(mockGameView).showBegin();
    }

    @Test
    public void should_display_result_when_call_play() throws Exception {
        //given
        when(mockGame.checkCoutinue()).thenReturn(true, false);
        when(mockCommand.input()).thenReturn(correctAnswer);
        when(mockGame.guessHistory()).thenReturn(new ArrayList<>());
        when(mockGame.guess(correctAnswer)).thenReturn(new GuessResult("", correctAnswer));

        //when
        gameController.play(mockCommand);

        //then
        verify(mockGameView).showGuessResult(any());
        verify(mockGameView).showGuessHistory(anyList());
    }

    @Test
    public void should_display_end_msg_when_failed_and_run_out_of_times() throws Exception {
        //given
        when(mockCommand.input()).thenReturn(wrongAnswer);
        when(mockGame.checkCoutinue()).thenReturn(false);
        when(mockGame.checkStatus()).thenReturn("");

        //when
        gameController.play(mockCommand);

        //then
        verify(mockGameView).showGameStatus(anyString());
    }
}