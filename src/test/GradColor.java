package test;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GradColor {
    private static final Color ulColor = new Color(50, 50, 255);
    private static final Color lrColor = new Color(0, 0, 60);

    private JTextField nameField = new JTextField();
    private JButton getButton = new JButton("Get Name");

    JLayeredPane mainPanel = new JLayeredPane() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = getWidth();
            int y = getHeight();
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new GradientPaint(new Point(0, 0), ulColor,
                    new Point(x, y), lrColor, false));
            g2.fillRect(0, 0, x, y);
        }
    };

    public GradColor() {
        mainPanel.setPreferredSize(new Dimension(400, 200));
        nameField.setBounds(10, 10, 200, 20);
        getButton.setBounds(10, 40, 100, 20);
        mainPanel.add(nameField, 0);
        mainPanel.add(getButton, 0);
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("GradColor");
        frame.getContentPane().add(new GradColor().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}
