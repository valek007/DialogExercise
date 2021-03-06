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
        "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE","QUESTION_MESSAGE", "PLAIN_MESSAGE"
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

    public Object getMessage(){

        String s = panelMessage.getSelection();

        if(s.equals("String")) return stringMessage;
        else if(s.equals("Icon")) return iconMessage;
        else if(s.equals("Component")) return componetMessage;
        else if(s.equals("Others")) return objectMessage;
        else if(s.equals("Object[ ]")) return new Object[]{stringMessage,iconMessage,componetMessage,objectMessage};
        else return null;
    }

    public int getTypeMessage(MyPanel panel){

        String s = panel.getSelection();

        if(s.equals("ERROR_MESSAGE")||s.equals("YES_NO_OPTION")) return 0;
        else if(s.equals("INFORMATION_MESSAGE")||s.equals("YES_NO_CANCEL_OPTION")) return 1;
        else if(s.equals("WARNING_MESSAGE")||s.equals("OK_CANCEL_OPTION")) return 2;
        else if(s.equals("QUESTION_MESSAGE")) return 3;
        else if(s.equals("PLAIN_MESSAGE")||s.equals("DEFAULT_OPTION")) return -1;
        else return 0;
    }

    public Object[] getOptions(MyPanel panel){

        String s = panel.getSelection();

        if(s.equals("String[ ]")) return new String[]{"Mask","Pill","Heart"};
        else if(s.equals("Icon[ ]")) return new Icon[]{new ImageIcon("resources/mask.png"),
                                                        new ImageIcon("resources/pill.png"),
                                                          new ImageIcon("resources/heart.png")};
        else if(s.equals("Object[ ]")) return new Object[]{stringMessage,iconMessage,componetMessage,objectMessage};
        else return null;
    }

    private class showAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

//            System.out.println(panelType.getSelection());

            if(panelType.getSelection().equals("Message")){
                JOptionPane.showMessageDialog(MyFrame.this,getMessage(),"Title",getTypeMessage(panelTypeMessage));
            }else if(panelType.getSelection().equals("Confirmation")){
                JOptionPane.showConfirmDialog(MyFrame.this,getMessage(),"Title",getTypeMessage(panelTypeOption),getTypeMessage(panelTypeMessage));
            }else if(panelType.getSelection().equals("Input")){
                if(panelInput.getSelection().equals("Text Field")) JOptionPane.showInputDialog(MyFrame.this,getMessage(),"Title",getTypeMessage(panelTypeMessage));
                else JOptionPane.showInputDialog(MyFrame.this,getMessage(),"Title",getTypeMessage(panelTypeMessage),null,
                                                                                            new String[ ]{"Mask","Pill","Heart"},"Mask");
            }else if(panelType.getSelection().equals("Option")){
                JOptionPane.showOptionDialog(MyFrame.this,getMessage(),"Title",1,getTypeMessage(panelTypeOption),null,getOptions(panelOption),null);
            }
        }
    }
}


