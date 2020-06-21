package finalAss2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Menu implements ActionListener {

    private static JFrame frame;
    private JMenuBar menubar;
    private JMenu typeServiceMenu, feedbackMenu, contactMenu, helpMenu;
    private JMenuItem nextDayMenuItem, sameDayMenuItem, prepaidMenuItem, expressMenuItem;
    private JLabel titleLable;
    private JPanel historyPanel;
    private JTextArea historyTextArea;
    private JScrollPane historyScroll;
    private JButton printReceiptButton;
    private JLayeredPane mainPanel, textPanel;
    private NextDay nextDay;
    private SameDay sameDay;
    private PrepaidBox_Envelope prepaidBox_envelope;
    private PosExpress posExpress;

    public Menu() {
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

//        textColourBackground
        textPanel = new JLayeredPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                Color color1 = new Color(255, 166, 77);
                Color color2 = new Color(255, 255, 203);
                GradientPaint gp = new GradientPaint(0, 0, color1, 500, 500, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        textPanel.setBounds(127,105,430,275);


//        menuBar
        menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

//        first menu
        typeServiceMenu = new JMenu("Type of Service");
        menubar.add(typeServiceMenu);

        nextDayMenuItem = new JMenuItem("Next Day Delivery");
        nextDayMenuItem.addActionListener(this);
        typeServiceMenu.add(nextDayMenuItem);

        sameDayMenuItem = new JMenuItem("Same Day Delivery");
        sameDayMenuItem.addActionListener(this);
        typeServiceMenu.add(sameDayMenuItem);

        prepaidMenuItem = new JMenuItem("Prepaid Box or Envelope");
        prepaidMenuItem.addActionListener(this);
        typeServiceMenu.add(prepaidMenuItem);

        expressMenuItem = new JMenuItem("Pos Express");
        expressMenuItem.addActionListener(this);
        typeServiceMenu.add(expressMenuItem);

//        second menu
        feedbackMenu = new JMenu("Feedback");
        feedbackMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://efeedback.pos.com.my/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        menubar.add(feedbackMenu);

//        third menu
        contactMenu = new JMenu("Contact Us");
        contactMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.pos.com.my/contact-us/"));
                } catch (IOException | URISyntaxException e2) {
                    e2.printStackTrace();
                }
            }
        });
        menubar.add(contactMenu);

//        fourth menu
        helpMenu = new JMenu("FAQ");
        helpMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.pos.com.my/faq/e-commerce-solutions/"));
                } catch (IOException | URISyntaxException e3) {
                    e3.printStackTrace();
                }
            }
        });
        menubar.add(helpMenu);

//        labelHistory
        titleLable = new JLabel("History of Pos Laju");
        titleLable.setFont(new Font("Book Antiqua",Font.BOLD,25));
        titleLable.setBounds(240,35,250,50);
        mainPanel.add(titleLable);

//        historyTextArea
        historyTextArea = new JTextArea(12,26);
        historyTextArea.setText("      The history of Pos Malaysia Berhad can be traced back to the early 1800s with the"+
                " establishment of postal services first in the Straits Settlements in Penang, Malacca and Singapore"+
                " expanding through the rest of Malaya by the early 20th century. Letters were then conveyed through"+
                " dispatch riders or special messengers. Instead of postage stamps, fees were collected when letters"+
                " were handed in at the Post Office. Letters posted were given a receipt.\n" +
                "\n" +
                "  The system later changed when the Indian stamps overprinted with crown and Straits' stamps"+
                " overprinted with dollars and cents were introduced in 1867. The first inaugural set of postage"+
                " stamps was introduced in 1901.");
        historyTextArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
        historyTextArea.setLineWrap(true);
        historyTextArea.setEditable(false);
        historyTextArea.setWrapStyleWord(true);
        historyTextArea.setOpaque(false);

        historyScroll = new JScrollPane(historyTextArea);
        historyScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        historyScroll.setOpaque(false);
        historyScroll.getViewport().setOpaque(false);

        historyPanel = new JPanel();
        historyPanel.setBounds(123,100,440,280);
        historyPanel.add(historyScroll);
        historyPanel.setOpaque(false);
        mainPanel.add(historyPanel);
        mainPanel.add(textPanel);



//        printReceiptButton
        printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.setBackground(Color.white);
        printReceiptButton.addActionListener(this);
        printReceiptButton.setBounds(270,420,150,40);
        mainPanel.add(printReceiptButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(nextDayMenuItem)) {

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    nextDay.frameMethod();
                }
            });
        }else if(e.getSource().equals(sameDayMenuItem)) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    sameDay.frameMethod();
                }
            });

        }else if(e.getSource().equals(prepaidMenuItem)) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    prepaidBox_envelope.frameMethod();
                }
            });

        }else if(e.getSource().equals(expressMenuItem)) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    posExpress.frameMethod();
                }
            });

        }else {
            try {
                new Receipt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        frame.dispose();
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }

    public static void frameMethod() {
        frame = new JFrame("Pos Laju Malaysia");
        frame.getContentPane().add(new Menu().getMainPanel());
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
