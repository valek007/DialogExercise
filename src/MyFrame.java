import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private String[] firstSelection = {"Message", "Confirmation", "Option", "Entry"};

    private JPanel panel = new JPanel();
    private MyPanel panelType = new MyPanel("Type",firstSelection);

    public MyFrame() {

        panel.setLayout(new GridLayout(2,3));

        panel.add(panelType);
        add(panel);

        setTitle("Dialog Exercise");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,800,600);
        setVisible(true);

    }
}
