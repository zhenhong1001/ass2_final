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

public class PrepaidBox_Envelope implements ActionListener {

    private static JFrame frame;
    private JLayeredPane mainPanel;
    private JLabel tableLabel, typeLabel, weightLabel, quantityLabel, weightComment, quantityComment;
    private JRadioButton envelope_S, envelope_M, prepaidBoxS, prepaidBoxM, prepaidBoxL;
    private ButtonGroup typeButtonGroup;
    private JTextField weightTextField, quantityTextField;
    private JCheckBox confirmCheckBox;
    private JPanel typePanel, checkBoxPanel;
    private JButton menuButton, printReceiptButton;
    private Menu menu;
    protected double totalPrice;
    private ArrayList arrayList = new ArrayList();
    private File file;
    private DecimalFormat df;

    public PrepaidBox_Envelope (double totalPrice){
        this.totalPrice = totalPrice;
    }

    public PrepaidBox_Envelope() {
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
            tableLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/prepaidBox_Envelope.png")).getImage().getScaledInstance(677, 258, Image.SCALE_SMOOTH)));
            tableLabel.setBounds(50, 20, 677, 258);
        } catch (NullPointerException e) {
            System.out.println("No picture inserted");
        }
        mainPanel.add(tableLabel);

//        typeLabel
        typeLabel = new JLabel("Choose package type");
        typeLabel.setFont(new Font("serif", Font.BOLD, 20));
        typeLabel.setBounds(50, 300, 500, 25);
        mainPanel.add(typeLabel);

//        typePanel for radioButton
        typePanel = new JPanel();
        typePanel.setBounds(-12, 330, 700, 40);
        typePanel.setOpaque(false);
        mainPanel.add(typePanel);

//        type of radioButton
        envelope_S = new JRadioButton("Envelope S", false);
        envelope_S.setOpaque(false);
        envelope_S.setFont(new Font("serif", Font.PLAIN, 19));
        envelope_M = new JRadioButton("Envelope L", false);
        envelope_M.setOpaque(false);
        envelope_M.setFont(new Font("serif", Font.PLAIN, 19));
        prepaidBoxS = new JRadioButton("Prepaid Box S", false);
        prepaidBoxS.setOpaque(false);
        prepaidBoxS.setFont(new Font("serif", Font.PLAIN, 19));
        prepaidBoxM = new JRadioButton("Prepaid M", false);
        prepaidBoxM.setOpaque(false);
        prepaidBoxM.setFont(new Font("serif", Font.PLAIN, 19));
        prepaidBoxL = new JRadioButton("Prepaid L", false);
        prepaidBoxL.setOpaque(false);
        prepaidBoxL.setFont(new Font("serif", Font.PLAIN, 19));
        typePanel.add(envelope_S);
        typePanel.add(envelope_M);
        typePanel.add(prepaidBoxS);
        typePanel.add(prepaidBoxM);
        typePanel.add(prepaidBoxL);

//        typeButtonGroup
        typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(envelope_S);
        typeButtonGroup.add(envelope_M);
        typeButtonGroup.add(prepaidBoxS);
        typeButtonGroup.add(prepaidBoxM);
        typeButtonGroup.add(prepaidBoxL);

//        weight
        weightLabel = new JLabel("Insert package weight");
        weightLabel.setBounds(50, 430, 500, 25);
        weightLabel.setFont(new Font("serif", Font.BOLD, 20));
        mainPanel.add(weightLabel);

//        weight comment
        weightComment = new JLabel("(Only integer is allowed)");
        weightComment.setBounds(50, 495, 300, 25);
        weightComment.setFont(new Font("serif", Font.BOLD, 15));
        mainPanel.add(weightComment);

        weightTextField = new JTextField("");
        PlainDocument doc = (PlainDocument) weightTextField.getDocument();
        doc.setDocumentFilter(new MyIntFilter());
        weightTextField.setBounds(50, 470, 100, 25);
        mainPanel.add(weightTextField);

//        quantity
        quantityLabel = new JLabel("Insert package quantity");
        quantityLabel.setBounds(450, 430, 300, 25);
        quantityLabel.setFont(new Font("serif", Font.BOLD, 20));
        mainPanel.add(quantityLabel);

//        quantity comment
        quantityComment = new JLabel("(Only integer is allowed)");
        quantityComment.setBounds(450, 495, 300, 25);
        quantityComment.setFont(new Font("serif", Font.BOLD, 15));
        mainPanel.add(quantityComment);

        quantityTextField = new JTextField("");
        PlainDocument doc1 = (PlainDocument) quantityTextField.getDocument();
        doc1.setDocumentFilter(new MyIntFilter());
        quantityTextField.setBounds(450, 470, 100, 25);
        mainPanel.add(quantityTextField);

//        checkBox
        checkBoxPanel = new JPanel();
        mainPanel.add(checkBoxPanel);
        checkBoxPanel.setBounds(50, 550, 300, 35);
        checkBoxPanel.setOpaque(false);

//        confirmCheckBox
        confirmCheckBox = new JCheckBox("Tick if you have confirm your order");
        confirmCheckBox.setOpaque(false);
        confirmCheckBox.setFont(new Font("serif", Font.BOLD, 18));
        checkBoxPanel.add(confirmCheckBox);

//        menu Button
        menuButton = new JButton("Menu");
        menuButton.setBounds(50, 610, 100, 30);
        menuButton.setBackground(Color.white);
        menuButton.addActionListener(this);
        mainPanel.add(menuButton);

//        Receipt Button
        printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.setBounds(155, 610, 130, 30);
        printReceiptButton.setBackground(Color.white);
        printReceiptButton.addActionListener(this);
        mainPanel.add(printReceiptButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        df = new DecimalFormat("0.00");

        String weightS = weightTextField.getText();
        double weight = Double.parseDouble(weightS);
        String quantityS= quantityTextField.getText();
        int quantity = Integer.parseInt(quantityS);
        PrepaidCal prepaidCal = new PrepaidCal(totalPrice);
        totalPrice = prepaidCal.prepaidCal(weight, quantity);
        arrayList.add(quantity);
        arrayList.add(df.format(totalPrice/quantity));
        arrayList.add(df.format(totalPrice));

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
        file = new File("PrepaidBox.txt");
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

    public JComponent getMainPanel() {
        return mainPanel;
    }

    public static void frameMethod() {
        frame = new JFrame("Prepaid Box & Envelope");
        frame.getContentPane().add(new PrepaidBox_Envelope().getMainPanel());
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