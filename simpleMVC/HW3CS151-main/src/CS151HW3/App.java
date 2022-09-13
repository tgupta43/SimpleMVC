package CS151HW3;


import CS151HW3.controller.Controller;
import CS151HW3.controller.Message;
import CS151HW3.model.Model;
import CS151HW3.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        Model model = new Model();
        View view = new View(queue);
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}

