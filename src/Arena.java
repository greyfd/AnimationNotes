import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Arena extends JPanel {

 public Ball[] makeBalls(int amount) {
   Ball[] balls = new Ball[amount];
   for (int i = 0; i < amount; i++) {
     balls[i] = new Ball(this);
   }
   return balls;
  }


    Ball[] balls = makeBalls(1);

    public Ball[] getBalls() {
        return balls;
    }

    Ball ball = new Ball(3,2,Color.RED,3,0,15);

    public Arena() {
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {

      for (int i = 0; i < balls.length; i++) {
        balls[i].draw(g);
        balls[i].move(this);
        if(balls[i].getX() == 0 && balls[i].getY() == 0) {
            setBackground(balls[i].getColor());
        }
      }
//
//      ball.draw(g);
//      ball.move(this);






        try {
            Thread.sleep(5);
        } catch(Exception e) {
            System.out.println(e);
        }
        repaint();
    }

}
