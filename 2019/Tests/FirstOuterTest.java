import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class FirstOuterTest {

    private String input;
    private Integer[] list_result;

    public FirstOuterTest(String input, Integer[] list_result){
        this.input = input;
        this.list_result = list_result;
    }

    @Parameterized.Parameters(name = "{index}: Test with Strings input = {0}")
    public static Collection<Object[]> input_string(){
        Object[][] data = new Object[][]{{"2345\n456\n234\n765", new Integer[]{2345, 456, 234, 765}},
                                         {"876\n23409\n654\n2342\n123\n3\n87", new Integer[]{876, 23409,654, 2342, 123, 3, 87}}
        };
        return Arrays.asList(data);
    }

    @Test
    public void test_list_of_mass (){
        First first = new First();
        Assert.assertArrayEquals(list_result, first.list_of_mass(input));
    }

}