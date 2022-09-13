package CS151HW3.view;

import CS151HW3.controller.Message;
import CS151HW3.controller.UpdateMessage;
import CS151HW3.controller.ResetMessage;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame {
    BlockingQueue<Message> queue;
    JTextField red;
    JTextField green;
    JTextField blue;

    JButton updateButton;
    JButton resetButton;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;



    BarGraph bars;


    String rvalue;
    String gvalue;
    String bvalue;


    public View(BlockingQueue<Message> queue) {
        this.queue = queue;

        this.redLabel = new JLabel("Red:");
        this.greenLabel = new JLabel("Green:");
        this.blueLabel = new JLabel("Blue:");


        this.red = new JTextField("0",10);
        this.green = new JTextField("0",10);
        this.blue = new JTextField("0",10);


        this.updateButton = new JButton("Update numbers of each color.");
        this.resetButton = new JButton("Reset all numbers to 0.");

        rvalue="0";
        gvalue="0";
        bvalue="0";

        bars=new BarGraph(rvalue,gvalue,bvalue);

        resetButton.addActionListener(e -> {
            try {
                Message msg = new UpdateMessage("0","0","0");
                queue.put(msg);
            } catch (InterruptedException exception) {
                // do nothing
            }
        });

        updateButton.addActionListener(e -> {
             rvalue = red.getText();
            gvalue = green.getText();
            bvalue = blue.getText();
            try {
                Message msg = new UpdateMessage(rvalue,gvalue,bvalue);
                queue.put(msg);

            } catch (InterruptedException exception) {
                // do nothing
            }
        });

bars=new BarGraph(rvalue,gvalue,bvalue);



        this.add(redLabel);
        this.add(red);
        this.add(greenLabel);
        this.add(green);
        this.add(blueLabel);
        this.add(blue);
        this.add(updateButton);
        this.add(resetButton);
       this.getContentPane().add(bars);




        this.setSize(500, 500);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateRed(String value) {

        this.red.setText(value);

    }

    public void updateGreen(String value) {
        this.green.setText(value);
    }

    public void updateBlue(String value) {
        this.blue.setText(value);
    }
    public void updateBars(String rValue, String gValue, String bValue) {
        //update values in
        this.bars.update(rValue, gValue, bValue);

    }


}



