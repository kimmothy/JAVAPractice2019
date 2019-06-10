package balltalk;

import java.io.*;
import java.net.Socket;
import balltalk.Ball;
import balltalk.Sender;
import balltalk.Receiver;

public class ClientMain {
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Sender sender;
    private Receiver receiver;

    public static void main(String[] arg){
        new ClientMain().go();
        System.out.println("frame display !!!");
    }

    private void go(){
        setUpNetworking();
        sender = new Sender(this);
        receiver = new Receiver();
        sender.go();
        Thread recieveTread = new Thread(receiver);
        recieveTread.start();
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
    }

    private void setUpNetworking() {
        try {
            Socket s = new Socket("127.0.0.1", 4242);
            reader = new ObjectInputStream(s.getInputStream());
            writer = new ObjectOutputStream(s.getOutputStream());
            System.out.println("networking established");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    void sendBall(Ball b){
        try {
            writer.writeObject(b);
            writer.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    class IncomingReader implements Runnable{
        @Override
        public void run() {
            Ball ball;
            try {
                while ((ball = (Ball)reader.readObject()) != null){
                    receiver.add(ball);
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
