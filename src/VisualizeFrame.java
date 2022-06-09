import java.awt.BorderLayout;


import javax.swing.JFrame;


public class VisualizeFrame extends JFrame{
    private MenuPanel menuPanel;
    public SortingPanel sortingPanel;
    private SubmitPanel submitPanel;
   
    
    VisualizeFrame(){
        super("Sorting Visualize");
    
        menuPanel = new MenuPanel(this);
        sortingPanel = new SortingPanel(this,menuPanel,submitPanel);
        submitPanel = new SubmitPanel(this,sortingPanel);    

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        //this.setSize(MAXIMIZED_HORIZ,MAXIMIZED_VERT);
        this.add(menuPanel, BorderLayout.SOUTH);
        this.add(sortingPanel,BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.NORTH);
        this.setVisible(true);
        
        
    }
    

}
