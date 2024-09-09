import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static final String path = "folder"; // /folder becomes absolute
    public static final String path1 = "folder/inside";

    public static void main(String[] args)throws IOException {
        Path p = Paths.get(path1);
        Files.createDirectories(p);
    }

}
