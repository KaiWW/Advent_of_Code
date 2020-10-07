import java.util.Arrays;
import java.util.Collections;

public class Third {
    String[] splitInstruction(String input){
        return input.split(",");
    }
    String[] direction(String[] instruction){
        String[] directions = new String[instruction.length];
        for (int i=0; i<instruction.length; i++) {
            directions[i] = instruction[i].substring(0,1);
        }
        return directions;
    }
    int[] numbers(String[] instruction){
        int[] numbers = new int[instruction.length];
        for (int i=0; i<instruction.length; i++) {
            numbers[i] = Integer.parseInt(instruction[i].substring(1));
        }
        return numbers;
    }
    int maxvalue(int[] numbers){
        return Arrays.stream(numbers).min().getAsInt();
    }

    public static void main(String[] args){

    }

}
