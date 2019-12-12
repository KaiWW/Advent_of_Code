public class One {
    static int whatFloor(String parenthesis){
        int floor = 0;
        char chara;
        for(int i = 0; i<parenthesis.length(); i++){
            chara = parenthesis.charAt(i);
            if(chara=='(') floor++;
            else if(chara == ')') floor--;
        }
        return floor;
    }

    static int whatPosition(String parenthesis){
        int floor = 0, position = 1;
        char chara;

        for(int i = 0; i < parenthesis.length(); i++){
            chara = parenthesis.charAt(i);
            if(chara == '(') floor++;
            else if(chara == ')') floor--;
            if(floor == -1) break;
            position++;
        }
        return position;
    }

    public static void main(String[] args) {
        String input = Common.read_text(1);
        int partOneResult = One.whatFloor(input);
        System.out.println(partOneResult);
        int partTwoResult = One.whatPosition(input);
        System.out.println(partTwoResult);

    }

}
