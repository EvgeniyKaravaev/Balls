import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class BallPanel extends JPanel {

    Random random = new Random();
    ArrayList <Ball> ballsPanels;
    int size = 25;
    private Timer timer;
    private int delay = 33;

    public BallPanel(){
        timer = new Timer(delay, new Ball());
        ballsPanels = new ArrayList<>();
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
        setFocusable(true);
        ballStart();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball b : ballsPanels) {
            b.draw(g);
        }
    }

    public void ballStart(){
        for(int i = 0;i < 15;i ++){
            int x = random.nextInt(500);
            int y = random.nextInt(400);
            int size = 45;
            ballsPanels.add(new Ball(x,y,size));
        }
        repaint();
    }

        private class Ball implements ActionListener {
        private int x;
        private int y;
        private int size;
        private Color color;
        private int x_speed,y_speed;
        private final int SPEED = 5;

        public Ball(){}

        public Ball(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
            color = new Color(random.nextInt(128),
                    random.nextInt(128),random.nextInt(128));
            x_speed = random.nextInt(SPEED * 5 + 1) - SPEED;
            y_speed = random.nextInt(SPEED * 5 + 1) - SPEED;

        }

        public void draw(Graphics graphics){
            graphics.setColor(color);
            graphics.fillOval(x - size/2,y - size/2,size,size);
            graphics.setColor(color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Ball b: ballsPanels) {
                b.update();
                repaint();
            }
        }

        private void update() {
            //y -= 5;
            x += x_speed;
            y += y_speed;
            if(x - size/2 <= 0 || x + size/2 >= getWidth()) x_speed = -x_speed;
            if(y - size/2 <= 0 || y + size/2 >= getHeight()) y_speed = -y_speed;
        }
    }
}

