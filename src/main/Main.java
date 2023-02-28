package main;
import java.awt.Container;
import java.awt.LayoutManager;
import javax.swing.JFrame;



public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Formula-1");

        DataPanel dataPanel = new DataPanel();
        window.add(dataPanel);

        window.pack(); // causes this window to be sied to fit the preffered size and layouts of its subcomponents
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        dataPanel.startGameThread();

    }
}

