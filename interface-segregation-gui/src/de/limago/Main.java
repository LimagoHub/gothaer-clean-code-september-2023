package de.limago;

import java.awt.*;
import java.awt.event.*;


public class Main extends Frame {


    public Main() {


        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->ausgabe());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                beenden();
            }
        });

        add(button);
    }

    private void ausgabe() {
        System.out.println("Button gedrueckt");
    }

    private void beenden() {
        dispose();
    }

    public static void main(String[] args) {

        new Main().setVisible(true);
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {
           ausgabe();
        }
    }
}
