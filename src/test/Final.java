package test;

import javax.swing.*;
import java.awt.*;

public class Final {
    public Final() {
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color color1 = new Color(255, 85, 0);
                Color color2 = new Color(255, 255, 51);
                GradientPaint gp = new GradientPaint(0, 0,
                        color1, 0, getHeight(),
                        color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }

        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestPanel panel = new TestPanel();
                JFrame jFrame = new JFrame();
                jFrame.add(panel);
                jFrame.setTitle("Pos Laju Malaysia");
                jFrame.setSize(700, 600);
                jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
                jFrame.setLayout(null);
                jFrame.setLocationRelativeTo(null);
                jFrame.setVisible(true);
            }
        });
    }
}
