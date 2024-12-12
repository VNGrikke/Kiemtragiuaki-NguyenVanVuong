package Kiemtragiuaki.b2;

import java.util.*;
import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1511)) {
            System.out.println("Da ket noi voi server.");

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);

            System.out.print("Nhap ma sv: ");
            String maSinhVien = sc.nextLine();
            output.println(maSinhVien);

            String sumEven = input.readLine();
            String primes = input.readLine();

            System.out.println(sumEven);
            System.out.println(primes);

        } catch (IOException e) {
            System.err.println("Lỗi client: " + e.getMessage());
        }
    }
}
