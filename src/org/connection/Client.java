package org.connection;

import org.consumer.ConsumerThread;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zach on 9/9/2015.
 * <p>
 * Creating a new Client object will attempt to establish a socket with the server at
 * the specified ip address. If the socket is established successfully, the Client object
 * can be used to send and receive data at any time.
 * <p>
 * This implementation uses one thread for sending data, and one thread for receiving data.
 * The
 */
public class Client {
    // This is the port to use
    private final int port = 38200;
    // The ip address to connect to
    private final String ipAddress = "127.0.0.1";
    //private final String ipAddress = "192.168.10.102";
    // Socket object to establish a connection
    private Socket socket;
    // The receive thread is in charge or putting received data in to a inbound queue to be processed later
    private ReceiveThread receiveThread;
    // The send thread is in charge of putting messages in to an outbound queue to send
    private SendThread sendThread;
    // The consumer thread consumes received data
    private ConsumerThread consumerThread;

    /**
     * Default constructor
     */
    public Client() {
        try {
            // Attempt to establish a new socket
            this.socket = new Socket(ipAddress, port);

            // Create the new threads
            this.receiveThread = new ReceiveThread(socket);
            this.sendThread = new SendThread(socket);
            this.consumerThread = new ConsumerThread(receiveThread);

            // Start the new threads
            this.receiveThread.start();
            this.sendThread.start();
            this.consumerThread.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Kills the client and all threads within the client.
     * This method will also attempt to close the socket.
     */
    public void killClient() {
        System.out.println("Killing all threads...");
        // Call kill methods for all threads
        this.receiveThread.kill();
        this.sendThread.kill();
        this.consumerThread.kill();
        // Attempt to close the socket
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets a message from the inbound queue, if one exist.
     *
     * @return the message that has been in the inbound queue the longest.
     * if the queue is empty, null is returned.
     */
    public String getMessage() {
        return this.receiveThread.getMessage();
    }

    /**
     * Adds a message to the outbound queue for this connection.
     * The messages are sent out over the socket in the order that they are added to the queue.
     *
     * @param message the message to add to the outbound queue
     */
    public void sendMessage(String message) {
        this.sendThread.sendMessage(message);
    }

    public void moveBaseHorizontalTo(int angle){
        this.sendMessage("Move:0:" + angle);
    }

    public void moveShoulderTo(int angle){
        this.sendMessage("Move:1:" + angle);
    }

    public void moveElbowTo(int angle){
        this.sendMessage("Move:2:" + angle);
    }

    public void moveWristOneTo(int angle){
        this.sendMessage("Move:3:" + angle);
    }

    public void moveWristTwoTo(int angle){
        this.sendMessage("Move:4:" + angle);
    }

    public void moveWristThreeTo(int angle){
        this.sendMessage("Move:5:" + angle);
    }
}