// Sunucu sınıfı
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {
        // Sunucunun dinleyeceği port numarası
        int port = 1234;
        try (// Sunucunun soketi oluşturulur
        ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Sunucu " + port + " numaralı portta dinliyor...");

            while (true) {
                // Sunucu yeni bir istemci bağlantısı kabul eder
                Socket clientSocket = serverSocket.accept();
                System.out.println("Yeni bir istemci bağlandı: " + clientSocket);

                // İstemciden gelen verileri okumak için BufferedReader nesnesi oluşturulur
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // İstemciye veri göndermek için PrintWriter nesnesi oluşturulur
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // İstemciden gelen mesajı okur
                String message = in.readLine();
                System.out.println("İstemciden gelen mesaj: " + message);

                // İstemciye cevap verir
                out.println("Merhaba " + message);
                System.out.println("İstemciye cevap verildi.");

                // Bağlantıyı kapatır
                in.close();
                out.close();
                clientSocket.close();
            }
        }
    }
}
