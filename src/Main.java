import javax.swing.*;
import java.awt.*;

//Working from Home!
public class Main {
    public static void main(String[] args) {
        //ELEMENTS
        JFrame frame = new JFrame();
        Arena panel = new Arena();
        JPanel controls = new JPanel();
        JButton freezeButton = new JButton("Freeze Balls");
        JButton increaseXSpeedButton = new JButton("Increase X Speed");

        //Modify Elements
        panel.setPreferredSize(new Dimension(400,400));
        freezeButton.addActionListener(e -> {
            //Freeze Action
            Ball[] balls = panel.getBalls();
            for (Ball ball : balls) {
                if (ball.getFrozen()) {
                    ball.setFrozen(false);
                    freezeButton.setText("Freeze Balls");
                } else {
                    ball.setFrozen(true);
                    freezeButton.setText("Unfreeze Balls");
                }
            }
        });
        increaseXSpeedButton.addActionListener(e -> {
            //Freeze Action
            Ball[] balls = panel.getBalls();
            for (Ball ball : balls) {
                    ball.setXSpeed(ball.getXSpeed() + 1);
            }
        });
        controls.add(freezeButton);
        controls.add(increaseXSpeedButton);
        controls.setSize(400, 20);
        frame.setLayout(new BorderLayout());

        //Add Elements
        frame.add(controls, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.NORTH);
        //Show Frame
        frame.pack();
        frame.setVisible(true);
    }
}