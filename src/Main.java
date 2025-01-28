import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        //ELEMENTS
        JFrame frame = new JFrame();
        Arena panel = new Arena();
        JPanel controls = new JPanel();
        JButton freezeButton = new JButton("Freeze Balls");
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
        controls.add(freezeButton);
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