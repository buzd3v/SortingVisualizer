import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuPanel extends JPanel{
    private VisualizeFrame frame;
    public static final int MENUHEIGHT = 50;
    public static final int DEFAULT_SPEED = 50;
    private JButton startButton;
    private JButton pauseButton;
    private JSlider speedSlider;
    private JComboBox chooseComboBox;
    private String[] s = {"Bubble Sort", "Merge Sort", "Quick Sort"};
    public MenuPanel(VisualizeFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(100000, MENUHEIGHT));
        setBackground(Color.white);
        chooseComboBox = new JComboBox<>(s);
        speedSlider = new JSlider(50, 1000, DEFAULT_SPEED);
        
        JLabel speedLabel = new JLabel("Speed " + speedSlider.getValue() + "ms");
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        speedSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO Auto-generated method stub
                speedLabel.setText("Speed " + speedSlider.getValue() + "ms");
            }
            
        });
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setMajorTickSpacing(500);
        speedSlider.setMinorTickSpacing(10);

        add(speedLabel);
        add(speedSlider);
        add(pauseButton);
        add(startButton);
        add(chooseComboBox);
    }

}   