import javax.swing.*;

public class StartWindow extends JFrame {

    public StartWindow(){
        setTitle(" Ball ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocation(250,50);
        add(new BallPanel());
        setVisible(true);

    }

    public static void main(String[] args) { new StartWindow(); }
}
