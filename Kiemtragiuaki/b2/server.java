package Kiemtragiuaki.b2;

import java.util.*;
import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1511);
        System.out.println("Server dang chay");

        Socket clientSocket = serverSocket.accept();
        System.out.println("ket noi tu client: " + clientSocket.getInetAddress().getHostAddress());

    }



    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
