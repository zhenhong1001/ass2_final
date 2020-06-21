package finalAss2;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SameDay implements ActionListener {

    private static JFrame frame;
    private JLayeredPane mainPanel;
    private JRadioButton localRadioButton, crossRadioButton;
    private ButtonGroup townButtonGroup;
    private JLabel tableLabel, townLabel, weightLabel, quantityLabel, weightComment, quantityComment;
    private JTextField weightTextField, quantityTextField;
    private JCheckBox confirmCheckBox;
    private JPanel townPanel, checkBoxPanel;
    private JButton menuButton, printReceiptButton;
    private Menu menu;
    protected double payment;
    private ArrayList arrayList = new ArrayList();
    private File file;
    private DecimalFormat df;

    public SameDay(double payment) {
        this.payment = payment;
    }

    public SameDay() {
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

//        table's Image
        try {
            tableLabel = new JLabel();
            tableLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/sameDay.png")).getImage().getScaledInstance(677, 258, Image.SCALE_SMOOTH)));
            tableLabel.setBounds(50, 20, 677, 258);
        } catch (NullPointerException e) {
            System.out.println("No picture inserted");
        }
        mainPanel.add(tableLabel);

//        townLabel
        townLabel = new JLabel("Choose Town-type");
        townLabel.setFont(new Font("serif", Font.BOLD, 20));
        townLabel.setBounds(50, 300, 500, 25);
        mainPanel.add(townLabel);

//        townPanel for local&cross RadioButton
        townPanel = new JPanel();
        townPanel.setBounds(20, 330, 200, 40);
        townPanel.setOpaque(false);
        mainPanel.add(townPanel);

//        local&cross RadioButton
        localRadioButton = new JRadioButton("Local", false);
        localRadioButton.setOpaque(false);
        localRadioButton.setFont(new Font("serif", Font.PLAIN, 19));
        crossRadioButton = new JRadioButton("Cross", false);
        crossRadioButton.setOpaque(false);
        crossRadioButton.setFont(new Font("serif", Font.PLAIN, 19));
        townPanel.add(localRadioButton);
        townPanel.add(crossRadioButton);

//        townButtonGroup
        townButtonGroup = new ButtonGroup();
        townButtonGroup.add(localRadioButton);
        townButtonGroup.add(crossRadioButton);

//        weight
        weightLabel = new JLabel("Insert package weight");
        weightLabel.setBounds(50, 420, 500, 25);
        weightLabel.setFont(new Font("serif", Font.BOLD, 20));
        mainPanel.add(weightLabel);

//        weight comment
        weightComment = new JLabel("(Only integer is allowed)");
        weightComment.setBounds(50, 490, 300, 25);
        weightComment.setFont(new Font("serif", Font.BOLD, 15));
        mainPanel.add(weightComment);

        weightTextField = new JTextField("");
        PlainDocument doc = (PlainDocument) weightTextField.getDocument();
        doc.setDocumentFilter(new MyIntFilter());
        weightTextField.setBounds(50, 465, 100, 25);
        mainPanel.add(weightTextField);

//        quantity
        quantityLabel = new JLabel("Insert package quantity");
        quantityLabel.setBounds(450, 420, 300, 25);
        quantityLabel.setFont(new Font("serif", Font.BOLD, 20));
        mainPanel.add(quantityLabel);

//        quantity comment
        quantityComment = new JLabel("(Only integer is allowed)");
        quantityComment.setBounds(450, 490, 300, 25);
        quantityComment.setFont(new Font("serif", Font.BOLD, 15));
        mainPanel.add(quantityComment);

        quantityTextField = new JTextField("");
        PlainDocument doc1 = (PlainDocument) quantityTextField.getDocument();
        doc1.setDocumentFilter(new MyIntFilter());
        quantityTextField.setBounds(450, 465, 100, 25);
        mainPanel.add(quantityTextField);

//        checkBoxPanel
        checkBoxPanel = new JPanel();
        mainPanel.add(checkBoxPanel);
        checkBoxPanel.setBounds(50, 550, 300, 35);
        checkBoxPanel.setOpaque(false);

//        confirmCheckBox
        confirmCheckBox = new JCheckBox("Tick if you have confirm your order");
        confirmCheckBox.setOpaque(false);
        confirmCheckBox.setFont(new Font("serif", Font.BOLD, 18));
        checkBoxPanel.add(confirmCheckBox);

//        menuButton
        menuButton = new JButton("Menu");
        menuButton.setBounds(45, 610, 100, 30);
        menuButton.setBackground(Color.white);
        menuButton.addActionListener(this);
        mainPanel.add(menuButton);

//        printReceiptButton
        printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.setBounds(150, 610, 130, 30);
        printReceiptButton.setBackground(Color.white);
        printReceiptButton.addActionListener(this);
        mainPanel.add(printReceiptButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        df = new DecimalFormat("0.00");

        if (localRadioButton.isSelected()) {
            String weightS = weightTextField.getText();
            double weight = Double.parseDouble(weightS);
            String quantityS = quantityTextField.getText();
            int quantity = Integer.parseInt(quantityS);
            SameCal sameCal = new SameCal(payment);
            payment = sameCal.Local(weight, quantity);
            arrayList.add(quantity);
            arrayList.add(df.format(payment/quantity));
            arrayList.add(df.format(payment));

        } else if (crossRadioButton.isSelected()) {
            String weightS = weightTextField.getText();
            double weight = Double.parseDouble(weightS);
            String quantityS = quantityTextField.getText();
            int quantity = Integer.parseInt(quantityS);
            SameCal sameCal = new SameCal(payment);
            payment = sameCal.Cross(weight, quantity);
            arrayList.add(quantity);
            arrayList.add(df.format(payment/quantity));
            arrayList.add(df.format(payment));
        }

        this.fileMethod();

        if (e.getSource() == menuButton) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    menu.frameMethod();
                }
            });
        } else {
            try {
                new Receipt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        frame.dispose();
    }

    public void fileMethod(){
        file = new File("SameDay.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int i = 0; i < arrayList.size(); i++) {
            printWriter.println(arrayList.get(i));
        }

        printWriter.flush();
        printWriter.close();
    }

    public JComponent getMainPanel () {
        return mainPanel;
    }

    public static void frameMethod () {
        frame = new JFrame("Same Day Delivery");
        frame.getContentPane().add(new SameDay().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
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