import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelButton = new JPanel();
    private JButton showButton = new JButton("Show Message");
    private MyPanel panelType = new MyPanel("Type",new String[]{
        "Message", "Confirmation", "Option", "Entry"
    });
    private MyPanel panelTypeMessage = new MyPanel("Type Message",new String[]{
        "ERROR_MESSAGE", "INFORMATION_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"
    });
    private MyPanel panelMessage = new MyPanel("Message",new String[]{
        "String", "Icon", "Component", "Others","Object[ ]"
    });
    private MyPanel panelTypeOption = new MyPanel("Confirmation",new String[]{
        "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"
    });
    private MyPanel panelOption = new MyPanel("Option",new String[]{
        "String[ ]", "Icon[ ]", "Object[ ]"
    });
    private MyPanel panelEntry = new MyPanel("Entry",new String[]{
        "Text Field", "Combo"
    });

    public MyFrame() {

        setLayout(new BorderLayout());

        panel.setLayout(new GridLayout(2,3));

        panel.add(panelType);
        panel.add(panelTypeMessage);
        panel.add(panelMessage);
        panel.add(panelTypeOption);
        panel.add(panelOption);
        panel.add(panelEntry);
        add(panel, BorderLayout.CENTER);

        showButton.addActionListener(new showAction());
        panelButton.add(showButton);
        add(panelButton, BorderLayout.SOUTH);

        setTitle("Dialog Exercise");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,600,450);
        setVisible(true);

    }

    private class showAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            System.out.println(panelType.getSelection());
        }
    }
}
