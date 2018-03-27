package gaudrophone;

import gui.MainWindow;
import logique.GaudrophoneController;

public class Gaudrophone {

    public static void main(String[] args) {
        GaudrophoneController controller = new GaudrophoneController();
        MainWindow mainWindow = new MainWindow(controller);
        controller.setMainWindow(mainWindow);
        mainWindow.setVisible(true);
    }
}
