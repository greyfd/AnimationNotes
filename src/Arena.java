import javax.swing.*;
import java.awt.*;

public class Arena extends JPanel {

 public Ball[] makeBalls(int amount) {
   Ball[] balls = new Ball[amount];
   for (int i = 0; i < amount; i++) {
     balls[i] = new Ball(this);
   }
   return balls;
  }


    Ball[] balls = makeBalls(1000);

    public Ball[] getBalls() {
        return balls;
    }

    public Arena() {
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {

        for (Ball ball : balls) {
            ball.draw(g);
            ball.move(this);
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
