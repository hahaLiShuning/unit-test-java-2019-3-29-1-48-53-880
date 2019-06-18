package tw.core;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setUp() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_digitmax_less_then_number_needed() {
        randomIntGenerator.generateNums(3, 4);
    }

    @Test
    public void should_get_3_numbers_that_less_than_10() {
        String nums = randomIntGenerator.generateNums(9, 3);
        Assert.assertEquals(nums.length(), 5);
    }

}