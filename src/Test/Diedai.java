package Test;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by YLL on 2015/12/4.
 */
public class Diedai {
//    static int count = 0;
//    public static void main(String[] args) {
//        int j = x(x(8));
//        System.out.println(j);
//        System.out.print(count);
//    }
//    public static int x(int n) {
//        count++;
//        if(n <= 3) {
//            return 1;
//        }
//        else {
//            return x(n - 2) + x(n - 4) +1;
//        }
//    }
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9090);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress());

        InputStream input = s.getInputStream();
        byte[] buff = new byte[1024];
        int len = input.read(buff);
        String text = new String(buff, 0, len);
        System.out.println(text);

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(" <font size='7' color='green'>注册成功</font> ");

        s.close();
        ss.close();
    }
}