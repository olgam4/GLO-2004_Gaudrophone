package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import utils.Drawer;

public class DrawingPanel extends JPanel {

    private Dimension dimension;
    private MainWindow mainWindow;
    private Drawer drawer;

    public DrawingPanel() {
    }

    public DrawingPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setBorder(new javax.swing.border.BevelBorder(BevelBorder.LOWERED));

        int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        setPreferredSize(new Dimension(width, 1));
        int height = (int) (width * 0.5);
        dimension = new Dimension(width, height);

        setVisible(true);
    }

    public Drawer getDrawer() {
        return drawer;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (mainWindow != null) {
            super.paintComponent(g);
            this.drawer = new Drawer(mainWindow.getController(), dimension);
            this.drawer.draw(g);
        }
    }

}
