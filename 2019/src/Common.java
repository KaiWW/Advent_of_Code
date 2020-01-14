import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Common {
    static String read_text (int date){
        String file = String.format("src\\2019_%02d.txt", date);

        String content = "";

        try{ content = new String(Files.readAllBytes(Paths.get(file)));}
        catch(IOException e){e.printStackTrace();}

        return content;
    }

    public static void main(String[] args) {
        System.out.println(read_text(1));
    }
}
