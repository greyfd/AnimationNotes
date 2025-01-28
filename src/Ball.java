import java.awt.*;

public class Ball {
    private int xSpeed;
    private int ySpeed;
    private Color color;
    private int x, y;
    private int size;
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
        this.xSpeed = (int)(Math.random() * 5) + 1;
        this.ySpeed = (int)(Math.random() * 6);
        this.color = (new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
        this.x = (int)(Math.random() * 400);
        this.y = (int)(Math.random() * 400);
        this.size = (int)((Math.random() * 45) + 5);

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

    public void move(Arena a) {

        if(!frozen) {

       x += xSpeed;
       y += ySpeed;

        if(x > a.getSize().getWidth() - size) {
            xSpeed *= -1;
        }


        if(x < 0) {
            xSpeed *= -1;
        }

        if(y >= a.getSize().getHeight() - size) {
            ySpeed *= -1;
        }


        if(y < 0) {
            ySpeed *= -1;
        }
        }
    }






}
