package test;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestPanel extends JPanel {

/*//    text
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        int w = getWidth();
//        int h = getHeight();
        Color color1 = new Color(255, 191, 128);
        Color color2 = new Color(255, 255, 203);
        GradientPaint gp = new GradientPaint(0, 0, color1, 500, 500, color2);
        g2d.setPaint(gp);
//        g2d.fill
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }*/

//    background
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        Color color1 = new Color(255, 85, 0);
        Color color2 = new Color(255, 255, 51);
        GradientPaint gp = new GradientPaint(0, 0, color1, 700, 700, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestPanel panel = new TestPanel();
                JFrame frame = new JFrame();
                frame.add(panel);
                frame.setSize(800, 800);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}