package org.consumer;

import org.connection.ReceiveThread;

/**
 * Created by zach on 9/11/2015.
 * <p>
 * The consumer thread is where any data consumption should take place.
 * This thread should handle removing any data from the inbound queue
 * and using it as necessary.
 */
public class ConsumerThread extends Thread {
    // The receiveThread is where the inbound queue is, get data from here.
    private ReceiveThread receiveThread;
    // boolean to keep the thread running
    private boolean shouldRun = true;

    /**
     * Default constructor
     *
     * @param receiveThread the receive thread that is being used by the client
     */
    public ConsumerThread(ReceiveThread receiveThread) {
        this.receiveThread = receiveThread;
    }

    /**
     * Override the run method for this thread.
     * <p>
     * This method should not be changed. This method called
     * processMessage, that is where any message processing should
     * take place.
     */
    @Override
    public void run() {
        while (shouldRun) {
            // Check if there are any messages in the clients inbound queue
            if (receiveThread.hasMessage()) {
                // Call processMessage() to handle the new message
                processMessage();
            }
        }
        // If this prints out, the thread has been killed
        System.out.println("Consumer Thread Stopped");
    }

    /**
     * Any message processing should take place in here.
     * Remove messages from the inbound queue here, and use
     * them as appropriate.
     */
    private void processMessage() {
        String message = receiveThread.getMessage();
        if(message.contains(":")){
            String[] splitMessage = message.split(":");
            switch (splitMessage.length){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    // This means that we received the position of a motor
                    if(splitMessage[0].equalsIgnoreCase("Pos")){
                        System.out.println(message);
                    }
                    break;
            }
        }
    }

    /**
     * Kills the thread (stops running the thread)
     * <p>
     * Do not call this method directly, instead kill the client using
     * Client#killClient(), which will handle killing all other threads.
     */
    public void kill() {
        this.shouldRun = false;
    }
}
