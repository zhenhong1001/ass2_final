package finalAss2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Receipt extends JFrame implements ActionListener {

    private JLabel titleLabel, timeLabel, imageLabel;
    private JTextArea indicateTextArea, priceTextArea;
    private JPanel indicatePanel,pricePanel;
    private JButton menuButton, printReceiptButton;
    private ImageIcon backgroundImage;
    private String time;
    private Menu menu;
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private ArrayList<String> arrayList1 = new ArrayList<>();
    private ArrayList <String> arrayList2 = new ArrayList<>();
    private ArrayList <String> arrayList3 = new ArrayList<>();
    private ArrayList <String> arrayList4 = new ArrayList<>();

    public Receipt() throws IOException {

        this.fileMethod();

//        background Image
        try {
            backgroundImage = new ImageIcon(this.getClass().getResource("receiptBackgroundImage.jpg"));
        } catch (NullPointerException e) {
            System.out.println("No picture inserted");
        }
        imageLabel = new JLabel(backgroundImage);
        imageLabel.setSize(700,500);
        add(imageLabel);

//        titleLabel
        titleLabel = new JLabel();
        titleLabel.setText("Pos Laju Malaysia");
        titleLabel.setFont(new Font("Book Antiqua",Font.BOLD,25));
        titleLabel.setBounds(220,100,300,30);
        imageLabel.add(titleLabel);

//        time
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time = formatter.format(ts);
        timeLabel = new JLabel(time);
        timeLabel.setBounds(450,90, 200, 50);
        timeLabel.setFont(new Font("serif",Font.BOLD,15));
        imageLabel.add(timeLabel);

//        indicateTextArea
        indicateTextArea = new JTextArea(30,40);
        indicateTextArea.setText("Description\t         Quantity    Price    Amount"+
                                 "\n-----------------------------------------------------------------------------"+
                                 "\nNext Day Delivery \nSame Day Delivery \nPrepaid Box And Envelope \nPos Express"+
                                 "\n-----------------------------------------------------------------------------"+
                                 "\n\t\t\tTotal:" +
                                 "\n-----------------------------------------------------------------------------"+
                                 "\n\n*****************Thank You. Please come again*****************");
        indicateTextArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
        indicateTextArea.setLineWrap(true);
        indicateTextArea.setEditable(false);
        indicateTextArea.setWrapStyleWord(true);
        indicateTextArea.setOpaque(false);

        indicatePanel = new JPanel();
        indicatePanel.add(indicateTextArea);
        indicatePanel.setBounds(70,150,700,300);
        indicatePanel.setOpaque(false);
        imageLabel.add(indicatePanel);

        /*"0          0.00         0.00"+
                "\n0          0.00         0.00"+
                "\n0          0.00         0.00"+
                "\n0          0.00         0.00 \n\n\t 0.00"*/

//        priceTextArea
        priceTextArea = new JTextArea(10,20);
        priceTextArea.setText(String.format("%d",Integer.parseInt(arrayList1.get(0))) +
                              String.format("%13.2f",Double.parseDouble(arrayList1.get(1))) +
                              String.format("%12.2f",Double.parseDouble(arrayList1.get(2))) +

                              String.format("\n%d",Integer.parseInt(arrayList2.get(0))) +
                              String.format("%13.2f",Double.parseDouble(arrayList2.get(1))) +
                              String.format("%12.2f",Double.parseDouble(arrayList2.get(2))) +

                              String.format("\n%d",Integer.parseInt(arrayList3.get(0))) +
                              String.format("%13.2f",Double.parseDouble(arrayList3.get(1))) +
                              String.format("%12.2f",Double.parseDouble(arrayList3.get(2))) +

                              String.format("\n%d",Integer.parseInt(arrayList4.get(0))) +
                              String.format("%13.2f",Double.parseDouble(arrayList4.get(1))) +
                              String.format("%12.2f",Double.parseDouble(arrayList4.get(2))) +
                              " \n\n\t" + (Double.parseDouble(arrayList1.get(2)) + Double.parseDouble(arrayList2.get(2)) +
                               Double.parseDouble(arrayList3.get(2)) + Double.parseDouble(arrayList4.get(2)) ));
        priceTextArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
        priceTextArea.setLineWrap(true);
        priceTextArea.setEditable(false);
        priceTextArea.setWrapStyleWord(true);
        priceTextArea.setOpaque(false);

        pricePanel = new JPanel();
        pricePanel.add(priceTextArea);
        pricePanel.setBounds(220,197,700,300);
        pricePanel.setOpaque(false);
        imageLabel.add(pricePanel);

//        menu
        menuButton = new JButton("Menu");
        menuButton.setBounds(195,450, 100, 40);
        menuButton.addActionListener(this);
        add(menuButton);

//        printReceiptButton
        printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.setBounds(345,450, 150, 40);
        printReceiptButton.addActionListener(this);
        add(printReceiptButton);

//        frame
        setTitle("Receipt");
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void fileMethod()throws IOException {
        //        NextDay.txt
        file = new File("NextDay.txt");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null){
            arrayList1.add(line);
            line = bufferedReader.readLine();
        }

//        SameDay.txt
        file = new File("SameDay.txt");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();
        while (line != null){
            arrayList2.add(line);
            line = bufferedReader.readLine();
        }

//        PrepaidBox.txt
        file = new File("PrepaidBox.txt");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();
        while (line != null){
            arrayList3.add(line);
            line = bufferedReader.readLine();
        }

//        PosExpress.txt
        file = new File("PosExpress.txt");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();
        while (line != null){
            arrayList4.add(line);
            line = bufferedReader.readLine();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == menuButton){
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    menu.frameMethod();
                }
            });
        }else
            JOptionPane.showMessageDialog(this,"Please come again and have a good day~");
        dispose();
    }

    public static void main(String[] args) throws IOException {
        new Receipt();
    }
}
