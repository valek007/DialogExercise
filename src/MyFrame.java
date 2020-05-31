import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private MyPanel panel = new MyPanel();

    public MyFrame() {

        panel.setLayout(new GridLayout(2,3));
        add(panel);

        setTitle("Dialog Exercise");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,800,600);
        setVisible(true);

    }
}
