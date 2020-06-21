package finalAss2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Welcome implements ActionListener {

    private static JFrame frame;
    private JLayeredPane mainPanel;
    private JButton menuButton, exitButton;
    private JTextArea welcomeTextArea;
    private JPanel welcomePanel;
    private JLabel logoLabel;
    private Menu menu;


    public Welcome() {
//        colourBackground
        mainPanel = new JLayeredPane() {
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
        };

//        logo
        try {
            logoLabel = new JLabel();
            logoLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("posLajuLogo.png")).getImage().getScaledInstance(160, 90, Image.SCALE_SMOOTH)));
            logoLabel.setBounds(260, 20, 260, 136);
        } catch (NullPointerException e) {
            System.out.println("No picture inserted");
        }
        mainPanel.add(logoLabel);

//        File file = new File("posEkspres.png");
//        System.out.println(file.getAbsoluteFile());

//        welcomeTextArea
        welcomeTextArea = new JTextArea(11,20);
        welcomeTextArea.setText("                    Welcome" +
                "\n\tto" +
                "\n    Pos laju online service centre");
        welcomeTextArea.setFont(new Font("Book Antiqua",Font.BOLD,30));
        welcomeTextArea.setLineWrap(true);
        welcomeTextArea.setEditable(false);
        welcomeTextArea.setWrapStyleWord(true);
        welcomeTextArea.setOpaque(false);
        welcomePanel = new JPanel();
        welcomePanel.setBounds(110,150,550,120);
        welcomePanel.setOpaque(false);
        welcomePanel.add(welcomeTextArea);
        mainPanel.add(welcomePanel);

//        menuButton
        menuButton = new JButton("MENU");
        menuButton.setBackground(Color.white);
        menuButton.addActionListener(this);
        menuButton.setBounds(190,375,100,50);
        mainPanel.add(menuButton);

//        exitButton
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.white);
        exitButton.addActionListener(this);
        exitButton.setBounds(400,375,100,50);
        mainPanel.add(exitButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuButton){
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    menu.frameMethod();
                }
            });
        }
        frame.dispose();
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }

    private static void frameMethod() {
        frame = new JFrame("Pos Laju Malaysia");
        frame.getContentPane().add(new Welcome().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frameMethod();
            }
        });
    }
}
