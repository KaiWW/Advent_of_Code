import java.util.Arrays;

public class Second {

    private int pointer = 0;

    int multiplication (int first_input, int second_input){
        return first_input * second_input;
    }

    int addition(int first_input, int second_input){
        return first_input + second_input;
    }

    void update_pointer_by_four(){
        this.pointer += 4;
    }
    Integer[] one_two_zero_one(Integer[] input_int_list){
        input_int_list[1] = 12;
        input_int_list[2] = 2;
        return input_int_list;
    }

    Integer[] insert_position_one_two(Integer one, Integer two, Integer[] input_int_list){
        input_int_list[1] = one;
        input_int_list[2] = two;
        //System.out.println("Insert Position List: " + Arrays.toString(input_int_list));
        return input_int_list;
    }


    Integer[] convert_string_input(String input_string){
        String[] string_number_list = input_string.split(",");
        Integer[] int_list = new Integer[string_number_list.length];
        for(int i=0; i<string_number_list.length;i++){
            int_list[i] = Integer.parseInt(string_number_list[i]);
        }
        return int_list;
    }

    Integer[] calculate_list(Integer[] input_list){
        this.pointer = 0;
        int temp_number;
        int first_input, second_input;
        while(this.pointer < input_list.length-1){
            if(input_list[this.pointer] == 99){
                System.out.println("Method Calculate List: " + Arrays.toString(input_list));
                return input_list;
            }
            first_input = input_list[input_list[this.pointer + 1]];
            second_input = input_list[input_list[this.pointer +2]];
            if(input_list[this.pointer] == 1){
                temp_number = addition(first_input,second_input);
                input_list[input_list[this.pointer+3]] = temp_number;
            }
            else if(input_list[this.pointer] == 2){
                temp_number = multiplication(first_input,second_input);
                input_list[input_list[this.pointer+3]] = temp_number;
            }
            update_pointer_by_four();
        }

        return input_list;
    }

    public static void main(String[] args) {
        Second second = new Second();

        Integer[] input_list = second.convert_string_input(Common.read_text(2));
        System.out.println("Part One: " + (second.calculate_list(second.one_two_zero_one(input_list))[0]));


        Second new_second = new Second();
        //Integer[] new_input_list = new_second.convert_string_input(Common.read_text(2));
        Integer[] calculated_list = new Integer[input_list.length];
        System.out.println("Original List: "+ Arrays.toString(input_list));
        entireloop:
        for(int i = 0; i <= 99; i++){
            for(int j = 0; j<=99; j++){
                //System.out.println(Arrays.toString(new_second.calculate_list(new_second.insert_position_one_two(i , j, new_input_list))));

                calculated_list = new_second.calculate_list(new_second.insert_position_one_two(i , j, new_second.convert_string_input(Common.read_text(2))));
                if (calculated_list[0] == 19690720) break entireloop;
            }
        }
        System.out.println("Stopped List: " + Arrays.toString(calculated_list));
        System.out.printf("Noun: %d Verb: %d", calculated_list[1], calculated_list[2]);
        System.out.printf("\n100 * Noun + Verb = %d", (100*calculated_list[1]+calculated_list[2]));


    }

}
