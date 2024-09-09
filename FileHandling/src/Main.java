import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // Converts byte stream to a char stream
        BufferedReader br = new BufferedReader(inputStreamReader); // A high level class for reading character streams
//        char[]arr = new char[5];
//         inputStreamReader.read(arr,0,5); // reading directly from console
//        System.out.println(Arrays.toString(arr));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(outputStreamWriter);
//        String s = br.readLine();
//        System.out.println(s);

        bw.write("asaasa");
        bw.flush();

    }
}
