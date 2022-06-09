import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubmitPanel extends JPanel{
    VisualizeFrame frame;
    SortingPanel sortingPanel;
    
    private JButton submitButton;
    private JTextField submitTextField;
    public static ArrayList<Integer> sortingSource = new ArrayList<>();

    public SubmitPanel(VisualizeFrame frame,SortingPanel sortingPanel) {
        this.frame = frame;
        this.sortingPanel = sortingPanel;
        this.setPreferredSize(new Dimension(100,50));
        submitButton = new JButton("Submit");
        submitTextField = new JTextField();
        submitTextField.setPreferredSize(new Dimension(200,40));
        JLabel submitLabel = new JLabel("Input array: ");
        submitLabel.setPreferredSize(new Dimension(100,40)); 
        
        this.add(submitLabel);
        this.add(submitTextField);
        this.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if(e.getSource() == submitButton){
                    sortingSource.removeAll(sortingSource);
                    String stringList = submitTextField.getText().toString();
                    String[] splitString; 
                    splitString = stringList.split(" ");
                    for(String a : splitString){
                        sortingSource.add(Integer.parseInt(a));
                    }
                    sortingPanel.prePaint(sortingSource);
                    sortingPanel.goDown(sortingPanel.box[0]);
                    sortingPanel.goRight(sortingPanel.box[0],1);
                }
            }
        });
        
        
    }

}
