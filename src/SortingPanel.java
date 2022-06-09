import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SortingPanel extends JPanel {
    MenuPanel menuPanel;
    SubmitPanel submitPanel;
    VisualizeFrame frame;
    
    public static JPanel[] box;
    private int SPWIDTH = 1366;
    private int SPHEIGHT = 599;
	

    public SortingPanel(VisualizeFrame frame,MenuPanel menuPanel, SubmitPanel submitPanel){
        this.frame = frame;
        this.menuPanel = menuPanel;
        this.submitPanel = submitPanel;
        this.setSize(new Dimension(SPWIDTH,SPHEIGHT));
        this.setBackground(Color.white);
        this.setLayout(null);
    }

    public void prePaint(ArrayList<Integer> source){
        box = new JPanel[source.size()] ;
		removeAll();
		// 90% of the windows height, divided by the size of the sorted array.
        int maxSize = SPHEIGHT / 4;
		int sizeModifier =  (int) ((SPWIDTH * 0.9)/(source.size()) * 0.5);
        if(sizeModifier > maxSize) sizeModifier = maxSize; 
		for(int i = 0; i< source.size(); i++){
            JLabel boxLabel = new JLabel();
            boxLabel.setText(Integer.toString(source.get(i)));
            boxLabel.setFont(new Font("Consolas",Font.BOLD,20));
            boxLabel.setForeground(Color.white);
            box[i] = new JPanel();
            box[i].setLayout(new GridBagLayout());
			box[i].setSize(sizeModifier,sizeModifier);
			box[i].setBackground(Color.blue);
            box[i].setLocation(SPWIDTH/2 - source.size() * sizeModifier / 2 + i *(sizeModifier),
                               SPHEIGHT/3);
            box[i].setBorder(BorderFactory.createLineBorder(Color.white, 10));
            box[i].add(boxLabel);
			add(box[i],BorderLayout.CENTER);
		}
        repaint();
		validate();
    }
    public void goDown(JPanel abox){
        Timer timer = new Timer(1000/60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(abox.getLocation().getY() < 350) {
                    abox.setLocation((int)abox.getLocation().getX(), (int)abox.getLocation().getY() + 1);
                    repaint();
                    validate();
                }
            }
        });
        timer.start();
    }
    public void goRight(JPanel abox, int index){
        Timer timer = new Timer(1000/60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(abox.getLocation().getX() <= box[index].getLocation().getX()) {
                    abox.setLocation((int)abox.getLocation().getX() + 1, (int)abox.getLocation().getY() );
                    repaint();
                    validate();
                }
            }
        });
        timer.start();
    }
    public void goLeft(JPanel abox, int index){
        Timer timer = new Timer(1000/60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(abox.getLocation().getX() >= box[index].getLocation().getX()) {
                    abox.setLocation((int)abox.getLocation().getX() - 1, (int)abox.getLocation().getY() );
                    repaint();
                    validate();
                }
            }
        });
        timer.start();
    }
    public void goUp(JPanel abox){
        Timer timer = new Timer(1000/60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(abox.getLocation().getY() >= SPHEIGHT/3  ) {
                    abox.setLocation((int)abox.getLocation().getX() + 1, (int)abox.getLocation().getY());
                    repaint();
                    validate();
                }
            }
        });
        timer.start();
    }
}
