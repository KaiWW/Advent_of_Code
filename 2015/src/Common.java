import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Common {
    static String read_text(int date){
        String filepath = String.format("src\\2015_%02d.txt", date);

        String content = "";

        try{
            content = new String (Files.readAllBytes(Paths.get(filepath)));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return content;
    }
}
