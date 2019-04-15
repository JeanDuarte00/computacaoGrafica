package miniGame.model.utils;

import javax.swing.*;

public class WindowEvent {

    public void close(JFrame frame) {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                System.exit(0);

            }
        });
    }

}
