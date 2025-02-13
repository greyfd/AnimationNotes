import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Arena extends JPanel {

 public Ball[] makeBalls(int amount) {
   Ball[] balls = new Ball[amount];
   for (int i = 0; i < amount; i++) {
     balls[i] = new Ball(this);
   }
   return balls;
  }

    Ball ball = new Ball(0,0,Color.PINK,100,100,50);

    Ball[] balls = makeBalls(0);

    public Ball[] getBalls() {
        return balls;
    }

    public Arena() {
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                if(e.getKeyCode() == 39) {
                    ball.setX(ball.getX() + 1);
                } else if (e.getKeyCode() == 37) {
                    ball.setX(ball.getX() - 1);
                } else if (e.getKeyCode() == 40) {
                    ball.setY(ball.getY() + 1);
                } else if (e.getKeyCode() == 38) {
                    ball.setY(ball.getY() - 1);
                }
            }
        });
    }



    @Override
    public void paintComponent(Graphics g) {
        ball.draw(g);
        for (Ball ball : balls) {
            ball.draw(g);
            ball.move(this, g);
            if (ball.getX() == 0 && ball.getY() == 0) {
                setBackground(ball.getColor());
            }
        }

        try {
            Thread.sleep(5);
        } catch(Exception e) {
            System.out.println(e);
        }
        repaint();
    }

}
