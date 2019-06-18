package tw.core.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    private RandomIntGenerator mockRandomIntGenerator;

    @Before
    public void setUp() {
        mockRandomIntGenerator = mock(RandomIntGenerator.class);
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throws_out_of_range_exception_when_input_number_id_not_vary_from_0_to_9() throws OutOfRangeAnswerException {
        //given
        when(mockRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 10");

        //when
        AnswerGenerator answerGenerator = new AnswerGenerator(mockRandomIntGenerator);
        answerGenerator.generate();
    }

    @Test
    public void should_generate_answer() throws OutOfRangeAnswerException {
        //given
        when(mockRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 4");

        //when
        AnswerGenerator answerGenerator = new AnswerGenerator(mockRandomIntGenerator);
        Answer answer = answerGenerator.generate();

        //then
        Assert.assertNotNull(answer);
    }
}

