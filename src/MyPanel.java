import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MyPanel extends JPanel {

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton radioButton;

    public MyPanel(String title, String[] option) {

        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        for (int i = 0; i < option.length; i++) {
            radioButton = new JRadioButton(option[i]);
            radioButton.setActionCommand(option[i]); //Work with Action Listener
            add(radioButton);
            buttonGroup.add(radioButton);
            radioButton.setSelected(i==0);
        }
    }

    public String getSelection(){

        ButtonModel myButton = buttonGroup.getSelection();
        String str = myButton.getActionCommand();

        //return buttonGroup.getSelection().getActionCommand();
        return str;
    }
}

class ExampleSheet extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangle =  new Rectangle2D.Double(0,0,getWidth(),getHeight());
        g2.setPaint(Color.YELLOW);
        g2.fill(rectangle);
    }
}
