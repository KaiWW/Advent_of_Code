import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class FirstTest {
    private int mass;
    private int expected, fuel_expected, fuel_final_expected;

    public FirstTest(int mass, int expected, int fuel_expected, int fuel_final_expected) {
        this.mass = mass;
        this.expected = expected;
        this.fuel_expected = fuel_expected;
        this.fuel_final_expected = fuel_final_expected;
    }


    @Parameterized.Parameters(name = "{index}: Test with mass = {0}, result is {1}")
    public static Collection<Object[]> parameters() {
        Object[][] data = new Object[][]{{12, 2, 14, 2},
                                         {14, 2, 16, 2},
                                         {1969, 654, 2935, 966},
                                         {100756, 33583, 151102, 50346},
                                         };
        return Arrays.asList(data);
    }

    @Test
    public void test_fuel_calculation() {
        assertEquals(expected, First.part_one.fuel_calculation(mass));
    }

    @Test
    public void test_sum_of_masses(){
        First first = new First();
        int result;

        result = first.sum_of_masses(first.list_of_mass("12\n14\n1969\n100756"));
        assertEquals(34241, result);
    }

    @Test
    public void test_fuel_of_fuel_calculation(){
        assertEquals(fuel_expected, First.part_two.fuel_of_fuel_calculation(mass));
    }

    @Test
    public  void test_fuel_of_fuel_final(){
        assertEquals(fuel_final_expected, First.part_two.fuel_of_fuel_final(mass));

    }

    @Test
    public void test_sum_of_fuel_of_fuel(){
        First first = new First();
        int result;
        result = first.sum_of_fuel_of_fuel(first.list_of_mass("14\n1969\n100756"));
        assertEquals(51314, result);
    }

}

