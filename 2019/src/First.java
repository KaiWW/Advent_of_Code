import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class First {
    //unnecessary class
    static class part_one{
        static int fuel_calculation(int mass){
            return (mass / 3)-2;
        }
    }

    static class part_two{
        static int fuel_of_fuel_calculation(int fuel){
            if(fuel < 0){return 0;}
            else{
                return fuel_of_fuel_calculation(First.part_one.fuel_calculation(fuel))+fuel;
            }
        }
        static int fuel_of_fuel_final(int fuel){
            return fuel_of_fuel_calculation(fuel) - fuel;
        }
    }

    Integer[] list_of_mass(String input_mass){
        String[] string_masses = input_mass.split("\\r?\\n");
        Integer[] int_masses = new Integer[string_masses.length];
        for(int i=0; i<string_masses.length; i++){
            int_masses[i] = Integer.parseInt(string_masses[i]);
        }
        return int_masses;
    }
    int sum_of_masses(Integer[] integer_mass){
        int sum_of_fuel = 0;
        for(int masses: integer_mass){
            sum_of_fuel += First.part_one.fuel_calculation(masses);//apply fuel calculation per mass
        }
        return sum_of_fuel;
    }

    int sum_of_fuel_of_fuel(Integer[] integer_mass){
        int sum_of_fuel = 0;
        for(int masses: integer_mass){
            sum_of_fuel += First.part_two.fuel_of_fuel_final(masses);//apply fuel calculation per mass
        }
        return sum_of_fuel;
    }

    public static void main(String[] args) {
        String list_of_input_fuel = Common.read_text(1);
        First first = new First();
        System.out.printf("Fuel Required: %d", first.sum_of_masses(first.list_of_mass(list_of_input_fuel)));
        System.out.printf("\nFuel of fuel required: %d", first.sum_of_fuel_of_fuel(first.list_of_mass(list_of_input_fuel)));

    }


}
