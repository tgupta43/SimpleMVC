package CS151HW3.controller;


import CS151HW3.controller.UpdateMessage;
import CS151HW3.controller.Message;
import CS151HW3.controller.ResetMessage;
import CS151HW3.model.Model;
import CS151HW3.view.View;

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    Model model;
    View view;

    public Controller(BlockingQueue<Message> queue, Model model, View view) {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    public void mainLoop() {
        while (view.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                // do nothing
            }

            if(message.getClass() == ResetMessage.class) {
                // button reset  was clicked
                ResetMessage numMessage = (ResetMessage) message;
                model.setBlueNum(numMessage.getName());
                model.setRedNum(numMessage.getName());
                model.setGreenNum(numMessage.getName());
                view.updateRed(numMessage.getName());
                view.updateGreen(numMessage.getName());
                view.updateBlue(numMessage.getName());// update view
            }
            else if(message.getClass() == UpdateMessage.class) {
                // button update was clicked
                // update model and view
                UpdateMessage numMessage = (UpdateMessage) message;
                model.setBlueNum(numMessage.getBNumber());
                model.setRedNum(numMessage.getRNumber());
                model.setGreenNum(numMessage.getGNumber());
                view.updateRed(numMessage.getRNumber());
                view.updateGreen(numMessage.getGNumber());
                view.updateBlue(numMessage.getBNumber());// update view
                view.updateBars(numMessage.getRNumber(), numMessage.getGNumber(),numMessage.getBNumber() ); //update bar view
            }

        }
    }
}


