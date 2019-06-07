//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package balltalk;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
    ArrayList clientOutputStreams;
    static int numOfClient = 1;

    public Server() {
    }

    public static void main(String[] var0) {
        System.out.println("Chatting server started on port 4242");
        (new Server()).go();
    }

    public void go() {
        this.clientOutputStreams = new ArrayList();

        try {
            ServerSocket var1 = new ServerSocket(4242);

            while(true) {
                Socket var2 = var1.accept();
                ObjectOutputStream var3 = new ObjectOutputStream(var2.getOutputStream());
                this.clientOutputStreams.add(var3);
                Thread var4 = new Thread(new balltalk.ClientHandler(this, var2));
                var4.start();
                System.out.println("got a connection");
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public void tellEveryone(Ball var1) {
        Iterator var2 = this.clientOutputStreams.iterator();

        while(var2.hasNext()) {
            try {
                ObjectOutputStream var3 = (ObjectOutputStream) var2.next();
                var3.writeObject(var1);
                var3.flush();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

    }
}
