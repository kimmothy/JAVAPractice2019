//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package balltalk;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    ObjectInputStream reader;
    Socket sock;
    String clientName;
    Server server;

    public ClientHandler(Server var1, Socket var2) {
        this.server = var1;

        try {
            this.clientName = "Client_" + (Server.numOfClient++);
            this.sock = var2;
            System.out.println(this.clientName + ": " + this.sock);
            this.reader = new ObjectInputStream(this.sock.getInputStream());
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public void run() {
        while(true) {
            try {
                Ball var1;
                if ((var1 = (Ball)this.reader.readObject()) != null) {
                    System.out.println("read " + var1);
                    this.server.tellEveryone(var1);
                    continue;
                }
            } catch (Exception var5) {
                var5.printStackTrace();

                try {
                    this.reader.close();
                    this.sock.close();
                } catch (Exception var4) {
                    var4.printStackTrace();
                }
            }
            return;
        }
    }
}