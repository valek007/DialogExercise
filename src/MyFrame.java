import javax.swing.*;

public class MyFrame extends JFrame {

    private MyPanel panel = new MyPanel();

    public MyFrame() {

        add(panel);

        setTitle("Dialog Exercise");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,800,600);
        setVisible(true);

    }
}
