import org.junit.Test;

import static org.junit.Assert.*;

public class OneTest {

    @Test
    public void partOne(){
        One one = new One();
        int result;

        result= one.whatFloor("(())");
        assertEquals(0, result);

        result = one.whatFloor("()()");
        assertEquals(0, result);

        result = one.whatFloor("(((");
        assertEquals(3, result);

        result = one.whatFloor("(()(()(");
        assertEquals(3, result);

        result = one.whatFloor("))(((((");
        assertEquals(3, result);

        result = one.whatFloor("())");
        assertEquals(-1, result);

        result = one.whatFloor("))(");
        assertEquals(-1, result);

        result = one.whatFloor(")))");
        assertEquals(-3, result);

        result = one.whatFloor(")())())");
        assertEquals(-3, result);
    }

    @Test
    public void partTwo(){
        One one = new One();
        int result;
        result= one.whatPosition(")");
        assertEquals(1, result);

        result = one.whatPosition("()())");
        assertEquals(5, result);
    }


}