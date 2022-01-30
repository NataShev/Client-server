import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 9091;

        try (Socket client = new Socket(host, port);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            answer(in, out);
            answer(in, out);
            answer(in, out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void answer(BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {
        String read = bufferedReader.readLine();
        System.out.println(read);
        printWriter.println(scanner.nextLine());
    }
}
