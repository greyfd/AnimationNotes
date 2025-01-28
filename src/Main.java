import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        //ELEMENTS
        Boolean frozen = false;
        JFrame frame = new JFrame();
        Arena panel = new Arena();
        JPanel controls = new JPanel();
        JButton freezeButton = new JButton("Freeze Balls");
        //Modify Elements
        panel.setPreferredSize(new Dimension(400,400));
        freezeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Freeze Action
                Ball[] balls = panel.getBalls();
               for(int i = 0; i < balls.length; i++) {
                   if(balls[i].getFrozen()) {
                       balls[i].setFrozen(false);
                       freezeButton.setText("Freeze Balls");
                   } else {
                       balls[i].setFrozen(true);
                       freezeButton.setText("Unfreeze Balls");
                   }
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