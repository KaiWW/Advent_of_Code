import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(Parameterized.class)
public class SecondTest {

    private int first_input;
    private int second_input;
    private int multiplication_expected;
    private int addition_expected;
    private String input_string;
    private Integer[] int_input_expected;
    private Integer[] input_list;
    private Integer[] expected_list;
    private Integer[] expected_one_two_list;


    public SecondTest (int first_input, int second_input, int multiplication_expected, int addition_expected, String input_string, Integer[] int_input_expected, Integer[] input_list, Integer[] expected_list, Integer[] expected_one_two_list){
        this.first_input = first_input;
        this.second_input = second_input;
        this.multiplication_expected = multiplication_expected;
        this.addition_expected = addition_expected;
        this.input_string = input_string;
        this.int_input_expected = int_input_expected;
        this.input_list = input_list;
        this.expected_list = expected_list;
        this.expected_one_two_list = expected_one_two_list;
    }

    @Parameterized.Parameters(name = "{index}: Test with first_input = {0}, second_input = {1}")
    public static Collection<Object[]> parameters()
    {
        Object[][] parameter = new Object[][]{{2, 3, 6, 5, "5,3,1,3,5,6", new Integer[]{5,3,1,3,5,6}, new Integer[]{1,0,0,0,99}, new Integer[]{2,0,0,0,99}, new Integer[]{1,2,3,0,99}},
                                              {7, 2, 14, 9, "0,2,5,7,12", new Integer[]{0,2,5,7,12}, new Integer[]{2,3,0,3,99}, new Integer[]{2,3,0,6,99}, new Integer[]{2,7,2,3,99}},
                                              {10,58,580, 68, "20,43,54,12,32", new Integer[]{20,43,54,12,32}, new Integer[]{2,4,4,5,99,0}, new Integer[]{2,4,4,5,99,9801}, new Integer[]{2,10,58,5,99,0}},
                                              {9,10, 90,19, "4,5,6,1,3,4", new Integer[]{4,5,6,1,3,4}, new Integer[]{1,1,1,4,99,5,6,0,99}, new Integer[]{30,1,1,4,2,5,6,0,99}, new Integer[]{1,9,10,4,99,5,6,0,99}}};
        return Arrays.asList(parameter);
    }
    @Test
    public void test_multiplication(){
        Second second = new Second();
        assertEquals(multiplication_expected, second.multiplication(first_input, second_input));
    }

    @Test
    public void test_addition(){
        Second second = new Second();
        assertEquals(addition_expected, second.addition(first_input, second_input));
    }

    @Test
    public void test_convert_string_to_array(){
        Second second = new Second();
        Assert.assertArrayEquals(int_input_expected, second.convert_string_input(input_string));
    }

    @Test
    public void test_calculate_list(){
        Second second = new Second();
        Assert.assertArrayEquals(expected_list, second.calculate_list(input_list));
    }

    @Test
    public void test_insert_position_one_two(){
        Second second = new Second();
        Assert.assertArrayEquals(expected_one_two_list, second.insert_position_one_two(first_input,second_input,input_list));
    }
}