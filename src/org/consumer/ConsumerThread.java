package org.consumer;

import org.OpenBotGUI;
import org.connection.Client;

/**
 * Created by zach on 9/11/2015.
 * <p>
 * The consumer thread is where any data consumption should take place.
 * This thread should handle removing any data from the inbound queue
 * and using it as necessary.
 */
public class ConsumerThread extends Thread {
    // The receiveThread is where the inbound queue is, get data from here.
    private Client client;
    // boolean to keep the thread running
    private boolean shouldRun = true;
    // The instance of the UI
    private OpenBotGUI openBotGUI;

    /**
     * Default constructor
     *
     * @param client the instance of Client that is being used for communication
     */
    public ConsumerThread(Client client, OpenBotGUI openBotGUI) {
        this.client = client;
        this.openBotGUI = openBotGUI;
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
        while (this.shouldRun) {
            // Check if there are any messages in the clients inbound queue
            if (this.client.hasMessage()) {
                // Call processMessage() to handle the new message
                this.processMessage();
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
        String message = client.getMessage();
        if (message.contains(":")) {
            String[] splitMessage = message.split(":");
            switch (splitMessage.length) {
                case 3: // the message has 3 components
                    // This means that we received the position of a motor
                    if (splitMessage[0].equalsIgnoreCase("Pos")) { // Pos:motorNumber:currentPosition
                        // try to parse the joint number from the message (the joint that this is the position of)
                        int jointNumber = parseInt(splitMessage[1]);
                        // try to parse the updated position value from the message
                        int newPosition = parseInt(splitMessage[2]);
                        // if we successfully parsed the joint number and position
                        if (jointNumber != -1 && newPosition != -1) {
                            // update the UI to reflect the newly received values
                            this.openBotGUI.updateJointNumber(jointNumber, newPosition);
                        }
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

    private int parseInt(String text) {
        int parsedInt = -1;
        try {
            parsedInt = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Could not convert to int: " + text);
        }
        return parsedInt;
    }
}
