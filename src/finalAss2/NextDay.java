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

public class NextDay implements ActionListener {

    private static JFrame frame;
    private JLayeredPane mainPanel;
    private JLabel tableLabel, typeLabel, zoneLabel, weightLabel, quantityLabel, weightComment, quantityComment;
    private JPanel packagePanel, zonePanel, checkBoxPanel;
    private JRadioButton z1, z2, z3, z4, z5, documentRadiaButton, parcelRadiaButton;
    private ButtonGroup zoneButtonGroup, typeButtonGroup;
    private JTextField weightTextField, quantityTextField;
    private JCheckBox confirmCheckBox;
    private JButton menuButton, printReceiptButton;
    private Menu menu;
    protected double charge1;
    private ArrayList arrayList = new ArrayList();
    private File file;
    private DecimalFormat df;

    public NextDay (double charge1){
        this.charge1 = charge1;
    }

    public NextDay() {
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
            tableLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("\nextDay.png")).getImage().getScaledInstance(677, 258, Image.SCALE_SMOOTH)));
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

//        packagePanel for document&parcel RadioButton
        packagePanel = new JPanel();
        packagePanel.setBounds(35, 330, 200, 40);
        packagePanel.setOpaque(false);
        mainPanel.add(packagePanel);

//        document&parcel radioButton
        documentRadiaButton = new JRadioButton("Document", false);
        documentRadiaButton.setOpaque(false);
        documentRadiaButton.setFont(new Font("serif", Font.PLAIN, 18));
        parcelRadiaButton = new JRadioButton("Parcel", false);
        parcelRadiaButton.setOpaque(false);
        parcelRadiaButton.setFont(new Font("serif", Font.PLAIN, 18));
        packagePanel.add(documentRadiaButton);
        packagePanel.add(parcelRadiaButton);

//        typeButtonGroup
        typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(documentRadiaButton);
        typeButtonGroup.add(parcelRadiaButton);

//        zoneLabel
        zoneLabel = new JLabel("Choose the zone");
        zoneLabel.setFont(new Font("serif", Font.BOLD, 20));
        zoneLabel.setBounds(50, 390, 500, 20);
        mainPanel.add(zoneLabel);

//        zonePanel for zoneRadioButton
        zonePanel = new JPanel();
        zonePanel.setBounds(20, 420, 450, 30);
        zonePanel.setOpaque(false);
        mainPanel.add(zonePanel);

//        zoneRadioButton
        z1 = new JRadioButton("Zone 1", false);
        z1.setOpaque(false);
        z1.setFont(new Font("serif", Font.PLAIN, 18));
        z2 = new JRadioButton("Zone 2", false);
        z2.setOpaque(false);
        z2.setFont(new Font("serif", Font.PLAIN, 18));
        z3 = new JRadioButton("Zone 3", false);
        z3.setOpaque(false);
        z3.setFont(new Font("serif", Font.PLAIN, 18));
        z4 = new JRadioButton("Zone 4", false);
        z4.setOpaque(false);
        z4.setFont(new Font("serif", Font.PLAIN, 18));
        z5 = new JRadioButton("Zone 5", false);
        z5.setOpaque(false);
        z5.setFont(new Font("serif", Font.PLAIN, 18));
        zonePanel.add(z1);
        zonePanel.add(z2);
        zonePanel.add(z3);
        zonePanel.add(z4);
        zonePanel.add(z5);

//        zoneButtonGroup
        zoneButtonGroup = new ButtonGroup();
        zoneButtonGroup.add(z1);
        zoneButtonGroup.add(z2);
        zoneButtonGroup.add(z3);
        zoneButtonGroup.add(z4);
        zoneButtonGroup.add(z5);

//        weight
        weightLabel = new JLabel("Insert package weight");
        weightLabel.setBounds(50, 490, 300, 25);
        weightLabel.setFont(new Font("serif", Font.BOLD, 20));
        mainPanel.add(weightLabel);

//        weight comment
        weightComment = new JLabel("(Only integer is allowed)");
        weightComment.setBounds(50, 550, 300, 25);
        weightComment.setFont(new Font("serif", Font.BOLD, 15));
        mainPanel.add(weightComment);

        weightTextField = new JTextField("");
        PlainDocument doc = (PlainDocument) weightTextField.getDocument();
        doc.setDocumentFilter(new MyIntFilter());
        weightTextField.setBounds(50, 530, 100, 25);
        mainPanel.add(weightTextField);

//        quantity
        quantityLabel = new JLabel("Insert package quantity");
        quantityLabel.setBounds(450, 490, 300, 25);
        quantityLabel.setFont(new Font("serif", Font.BOLD, 20));
        mainPanel.add(quantityLabel);

//        quantity comment
        quantityComment = new JLabel("(Only integer is allowed)");
        quantityComment.setBounds(450, 550, 300, 25);
        quantityComment.setFont(new Font("serif", Font.BOLD, 15));
        mainPanel.add(quantityComment);

        quantityTextField = new JTextField("");
        PlainDocument doc1 = (PlainDocument) quantityTextField.getDocument();
        doc1.setDocumentFilter(new MyIntFilter());
        quantityTextField.setBounds(450, 530, 100, 25);
        mainPanel.add(quantityTextField);

//        checkBoxPanel
        checkBoxPanel = new JPanel();
        checkBoxPanel.setBounds(45, 590, 300, 35);
        checkBoxPanel.setOpaque(false);
        mainPanel.add(checkBoxPanel);

//        confirmCheckBox
        confirmCheckBox = new JCheckBox("Tick if you have confirm your order");
        confirmCheckBox.setOpaque(false);
        confirmCheckBox.setFont(new Font("serif", Font.BOLD, 18));
        checkBoxPanel.add(confirmCheckBox);

//        menuButton
        menuButton = new JButton("Menu");
        menuButton.setBounds(45, 650, 100, 30);
        menuButton.setBackground(Color.white);
        menuButton.addActionListener(this);
        mainPanel.add(menuButton);

//        printReceiptButton
        printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.setBounds(150, 650, 130, 30);
        printReceiptButton.setBackground(Color.white);
        printReceiptButton.addActionListener(this);
        mainPanel.add(printReceiptButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        df = new DecimalFormat("0.00");

        if (z1.isSelected()) {
            String weightS1 = weightTextField.getText();
            double weight = Double.parseDouble(weightS1);
            String quantityS1 = quantityTextField.getText();
            int quantity = Integer.parseInt(quantityS1);
            NextCal nextCal = new NextCal(charge1);
            charge1 = nextCal.zone1(weight, quantity);
            arrayList.add(quantity);
            arrayList.add(df.format(charge1/quantity));
            arrayList.add(df.format(charge1));

        } else if (z2.isSelected()) {
            String weightS2 = weightTextField.getText();
            double weight = Double.parseDouble(weightS2);
            String quantityS2 = quantityTextField.getText();
            int quantity = Integer.parseInt(quantityS2);
            NextCal nextCal = new NextCal(charge1);
            charge1 = nextCal.zone2(weight, quantity);
            arrayList.add(quantity);
            arrayList.add(df.format(charge1/quantity));
            arrayList.add(df.format(charge1));

        } else if (z3.isSelected()) {
            String weightS3 = weightTextField.getText();
            double weight = Double.parseDouble(weightS3);
            String quantityS3 = quantityTextField.getText();
            int quantity = Integer.parseInt(quantityS3);
            NextCal nextCal = new NextCal(charge1);
            charge1 = nextCal.zone3(weight, quantity);
            arrayList.add(quantity);
            arrayList.add(df.format(charge1/quantity));
            arrayList.add(df.format(charge1));

        } else if (z4.isSelected()) {
            String weightS4 = weightTextField.getText();
            double weight = Double.parseDouble(weightS4);
            String quantityS4 = quantityTextField.getText();
            int quantity = Integer.parseInt(quantityS4);
            NextCal nextCal = new NextCal(charge1);
            charge1 = nextCal.zone4(weight, quantity);
            arrayList.add(quantity);
            arrayList.add(df.format(charge1/quantity));
            arrayList.add(df.format(charge1));

        } else if (z5.isSelected()) {
            String weightS5 = weightTextField.getText();
            double weight = Double.parseDouble(weightS5);
            String quantityS5 = quantityTextField.getText();
            int quantity = Integer.parseInt(quantityS5);
            NextCal nextCal = new NextCal(charge1);
            charge1 = nextCal.zone5(weight, quantity);
            arrayList.add(quantity);
            arrayList.add(df.format(charge1/quantity));
            arrayList.add(df.format(charge1));
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
        file = new File("NextDay.txt");
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
        frame = new JFrame("Next Day Delivery");
        frame.getContentPane().add(new NextDay().getMainPanel());
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