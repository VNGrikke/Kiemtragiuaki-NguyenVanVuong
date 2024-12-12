package Kiemtragiuaki.b1;

import java.util.*;
import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket client = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        int n = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Nhap so n: ");
                n = sc.nextInt();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Nhap lai: ");
                sc.nextLine(); 
            }
        }

        byte[] guiData = String.valueOf(n).getBytes();
        InetAddress diaChi = InetAddress.getByName("localhost");
        int port = 1511;
        DatagramPacket guiPacket = new DatagramPacket(guiData, guiData.length, diaChi, port);
        client.send(guiPacket);

        byte[] nhanData = new byte[1000];
        DatagramPacket nhanPacket = new DatagramPacket(nhanData, nhanData.length);
        client.receive(nhanPacket);

        String result = new String(nhanPacket.getData(), 0, nhanPacket.getLength());
        System.out.println("Ket qua: " + result);

        client.close();
    }

}
