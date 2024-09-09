import java.io.*;

public class Filee {
    public static void main(String[] args) throws IOException {
//        Writer writer = new FileWriter("test.txt");
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        bufferedWriter.write("meow");
//        bufferedWriter.newLine();
//        bufferedWriter.write("!!");
//        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        String line = null;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
