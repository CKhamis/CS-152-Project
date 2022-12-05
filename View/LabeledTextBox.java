package View;

import javax.swing.*;
import java.awt.*;

public class LabeledTextBox extends JPanel{
    public LabeledTextBox(JLabel label, JComponent comp, JPanel parent) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(parent.getBackground());
        this.add(label);
        this.add(comp);
    }
}
