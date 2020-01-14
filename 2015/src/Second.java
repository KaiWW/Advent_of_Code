import java.util.*;

public class Second {

    private int width;
    private int height;
    private int length;
    private int[] listOfDimensions = new int[3];

    Second(String input){
        String [] listOfNumbers = input.split("x");
        listOfDimensions[0] = Integer.parseInt(listOfNumbers[0]);
        listOfDimensions[1] = Integer.parseInt(listOfNumbers[1]);
        listOfDimensions[2] = Integer.parseInt(listOfNumbers[2]);
        this.length = listOfDimensions[0];
        this.width = listOfDimensions[1];
        this.height = listOfDimensions[2];
        Arrays.sort(this.listOfDimensions);
    }

    int presentDimension(){
        return (2 * this.length * this.width +
                2 * this.length * this.height +
                2 * this.width * this.height);
    }

    int slackDimension(){
        return listOfDimensions[0] * listOfDimensions[1];
    }

    int totalWrapDimension(){
        return presentDimension() + slackDimension();
    }

    int ribbonDimension (){
        return 2*this.listOfDimensions[0] + 2*this.listOfDimensions[1];
    }

    int bowDimension (){ return this.length * this.height * this.width;}

    int totalBowDimension (){
        return ribbonDimension() + bowDimension();
    }

    public static void main(String[] args) {
        String[] stringInput = Common.read_text(2).split("\\r?\\n");
        int partOneResult = 0;
        int partTwoResult = 0;
        for (String s : stringInput) {
            Second second = new Second(s);
            partTwoResult += second.totalBowDimension();
            partOneResult += second.totalWrapDimension();
        }
        System.out.printf("Wrap dimension : %s", partOneResult);
        System.out.printf("\nBow dimension: %s", partTwoResult);
    }
}
