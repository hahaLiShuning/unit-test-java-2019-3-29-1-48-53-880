package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer correctAnswer;

    @Before
    public void setUp() {
        correctAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_get_1A0B_when_input_1_5_6_7() {
        checkAnswer("1 5 6 7", "1A0B");
    }

    @Test
    public void should_get_0A2B_when_input_2_4_7_8() {
        checkAnswer("2 4 7 8", "0A2B");
    }

    @Test
    public void should_get_1A2B_when_input_0_3_2_4() {
        checkAnswer("0 3 2 4", "1A2B");
    }

    @Test
    public void should_get_0A0B_when_input_5_6_7_8() {
        checkAnswer("5 6 7 8", "0A0B");
    }

    @Test
    public void should_get_0A4B_when_input_4_3_2_1() {
        checkAnswer("4 3 2 1", "0A4B");
    }

    @Test
    public void should_get_4A0B_when_input_1_2_3_4() {
        checkAnswer("1 2 3 4", "4A0B");
    }

    private void checkAnswer(String inputAnswer, String expectedAnswer) {
        Answer answer = Answer.createAnswer(inputAnswer);
        Record record = correctAnswer.check(answer);
        Assert.assertEquals(record.getValue(), expectedAnswer);
    }

}