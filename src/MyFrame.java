import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MyFrame extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelButton = new JPanel();
    private JButton showButton = new JButton("Show Message");
    private MyPanel panelType = new MyPanel("Type",new String[]{
        "Message", "Confirmation", "Option", "Input"
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
    private MyPanel panelInput = new MyPanel("Input",new String[]{
        "Text Field", "Combo"
    });

    private String stringMessage = "String Message";
    private Icon iconMessage = new ImageIcon("resources/heart.png");
    private Object objectMessage = new Date();
    private Component componetMessage = new ExampleSheet();

    public MyFrame() {

        setLayout(new BorderLayout());

        panel.setLayout(new GridLayout(2,3));

        panel.add(panelType);
        panel.add(panelTypeMessage);
        panel.add(panelMessage);
        panel.add(panelTypeOption);
        panel.add(panelOption);
        panel.add(panelInput);
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

//            System.out.println(panelType.getSelection());

            if(panelType.getSelection().equals("Message")){
                JOptionPane.showMessageDialog(MyFrame.this,"Message","Title",0);
            }else if(panelType.getSelection().equals("Confirmation")){
                JOptionPane.showConfirmDialog(MyFrame.this,"Message","Title",0,0);
            }else if(panelType.getSelection().equals("Option")){
                JOptionPane.showOptionDialog(MyFrame.this,"Message","Title",0,0,null,null,null);
            }else if(panelType.getSelection().equals("Input")){
                JOptionPane.showInputDialog(MyFrame.this,"Message","Title",0);
            }
        }
    }
}


