public class Main{
    public static void main(String[] args) {
        VisualizeFrame vf = new VisualizeFrame();
        System.out.println(vf.getPreferredSize());
        System.out.println(vf.sortingPanel.getPreferredSize().height);
    }
}