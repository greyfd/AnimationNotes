import java.awt.*;
import java.awt.geom.AffineTransform;

public class Ball {
    private int xSpeed;
    private int ySpeed;
    private Color color;
    private int x, y;
    private int size;
    private Boolean userControlled;
    private Boolean frozen = false;

    public Ball(int xSpeed, int ySpeed, Color color, int x,int y, int size) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
    }



    public Ball() {
        this.xSpeed = ((int)(Math.random() * 5) + 1);
        this.ySpeed = (int)(Math.random() * 6);
        this.color = (new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
        this.x = (int)(Math.random() * 400 + 50);
        this.y = (int)(Math.random() * 400 + 23);
        this.size = (int)((Math.random() * 45) + 5);
    }

    public Ball(Boolean userControlled) {
        this.xSpeed = ((int)(Math.random() * 5) + 1);
        this.ySpeed = (int)(Math.random() * 6);
        this.color = (new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
        this.x = (int)(Math.random() * 400 + 50);
        this.y = (int)(Math.random() * 400 + 23);
        this.size = (int)((Math.random() * 45) + 5);
        this.userControlled = userControlled;
    }

    public Ball(Arena a) {
        this.xSpeed = (int)(Math.random() * 6);
        this.ySpeed = (int)(Math.random() * 6);
        this.color = (new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
        this.size = (int)((Math.random() * 45) + 5);
        this.x = (int)(Math.random() * (a.getSize().getWidth() + (size)));
        this.y = (int)(Math.random() * (a.getSize().getHeight() + (size)));

    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);

    }



    public void move(Arena a, Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();

//        for(int i = 0; i < a.getBalls().length; i++) {
//
//            if (i != a.getBalls().length - 1) {
//                if (this != a.getBalls()[i]) {
//                    double distance = Math.sqrt(Math.pow((a.getBalls()[i].getX() - x), 2) + Math.pow((a.getBalls()[i].getY() - y), 2));
//                    System.out.println(distance);
//
//
//                    int radius = size / 2;
//                    int radius2 = (a.getBalls()[i].getSize()) / 2;
//
//                    if(distance <= (radius + radius2)) {
//                        int oldXSpeed = xSpeed;
//                        xSpeed = a.getBalls()[i].getXSpeed();
//                        a.getBalls()[i].setXSpeed(oldXSpeed);
//
//                        int oldYSpeed = ySpeed;
//                        ySpeed = a.getBalls()[i].getYSpeed();
//                        a.getBalls()[i].setYSpeed(oldYSpeed);
//                    }
//                }
//            }
//
//        }


        if(!frozen) {

       x += xSpeed;
       y += ySpeed;

        if(x > a.getSize().getWidth() - size) {
            xSpeed *= -1;
            g2d.rotate(Math.toRadians(Math.random() * 360));
        }


        if(x < 0) {
            xSpeed *= -1;
            g2d.rotate(Math.toRadians(Math.random() * 360));
        }

        if(y >= a.getSize().getHeight() - size) {
            ySpeed *= -1;
            g2d.rotate(Math.toRadians(Math.random() * 360));
        }


        if(y < 0) {
            ySpeed *= -1;
            g2d.rotate(Math.toRadians(Math.random() * 360));
        }
        }
        g2d.setTransform(old);
    }






}
