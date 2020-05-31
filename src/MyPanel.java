import javax.swing.*;

public class MyPanel extends JPanel {

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton radioButton;

    public MyPanel(String title, String[] option) {

        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        for (int i = 0; i < option.length; i++) {
            radioButton = new JRadioButton(option[i]);
            add(radioButton);
            buttonGroup.add(radioButton);
            radioButton.setSelected(i==0);
        }
    }
}
