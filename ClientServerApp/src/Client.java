// İstemci sınıfı
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        // Sunucunun IP adresi ve port numarası
        String host = "127.0.0.1";
        int port = 1234;
        // İstemcinin soketi oluşturulur ve sunucuya bağlanır
        Socket socket = new Socket(host, port);
        System.out.println("Sunucuya bağlandı: " + socket);

        // Sunucuya veri göndermek için PrintWriter nesnesi oluşturulur
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // Sunucudan gelen verileri okumak için BufferedReader nesnesi oluşturulur
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Klavyeden veri girmek için BufferedReader nesnesi oluşturulur
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        // Klavyeden bir mesaj girer
        System.out.print("Sunucuya gönderilecek mesaj: ");
        String message = stdIn.readLine();

        // Mesajı sunucuya gönderir
        out.println(message);
        System.out.println("Mesaj sunucuya gönderildi.");

        // Sunucudan gelen cevabı okur
        String response = in.readLine();
        System.out.println("Sunucudan gelen cevap: " + response);

        // Bağlantıyı kapatır
        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}
