package Kiemtragiuaki.b1;

import java.util.*;
import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(1511);
        System.out.println("Server dang chay");

        byte[] nhanData = new byte[1000];
        DatagramPacket nhanPacket = new DatagramPacket(nhanData, nhanData.length);
        server.receive(nhanPacket);

        int n = Integer.parseInt(new String(nhanPacket.getData(), 0, nhanPacket.getLength()));

        StringBuilder result = new StringBuilder();
        for (int i = 2; i < n; i++) {
            if (isPrime(i) && i % 5 == 0) {
                result.append(i).append(" ");
            }
        }

        byte[] guiData = result.toString().getBytes();
        DatagramPacket guiPacket = new DatagramPacket(guiData, guiData.length, nhanPacket.getAddress(),
                nhanPacket.getPort());
        server.send(guiPacket);

        System.out.println("Da tra ve ket qua client.");
        server.close();
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