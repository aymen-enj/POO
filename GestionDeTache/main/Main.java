package main;

import controler.TaskController;
import view.TaskView;

public class Main {
    public static void main(String[] args) {
        TaskController controller = new TaskController();
        TaskView view = new TaskView(controller);
        view.setVisible(true);
    }
}
