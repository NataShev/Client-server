import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 9091;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter print = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.printf("New connection accepted: Port: %d%n", clientSocket.getPort());

            dialog("Добрый день, напишите свое имя", print, in);
            dialog("Вам нравится изучать Java?", print, in);

            serverSocket.close();
        }

    }

    public static void dialog(String string, PrintWriter printWriter, BufferedReader bufferedReader) throws IOException {
        printWriter.println(string);
        final String answer = bufferedReader.readLine();
        if (answer.equals("Да")) {
            printWriter.println("Замечательно, не останавливайтесь на достигнутом, развивайтесь в этом направлении, удачи!");
        } else if (answer.equals("нет")) {
            printWriter.println("Советуем вам сменить тему для изучения!");
        }

    }

}
