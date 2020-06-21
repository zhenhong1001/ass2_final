package test;

import javax.swing.*;
import java.awt.*;

public class Table extends JFrame {
    private JTable jTable, firstTable;
    private JPanel jPanel,jPanel2;

    public Table() {

        /*String data1[][]={{"","",""}};
        String column1[]={" ","Document (below 2kg)","Parcel(above 2kg)"};
        firstTable = new JTable(data1,column1);
        JScrollPane sp1=new JScrollPane(firstTable);
        jPanel = new JPanel();
        jPanel.add(sp1);
        jPanel.setBounds(10,0,80,50);*/
//        firstTable.add(column1);

        String data2[][]={{"Zone 1", "4.90","0.80","10.50","0.50"}};
        String column2[]={" ","First 500gm","Subsequent 250gm","2.001-2.5kg","Subsequent 500gm"};
        jTable = new JTable(data2,column2);
//        jTable.add(sp1);
//        jTable.setBounds(30,40,100,300);
        JScrollPane sp2=new JScrollPane(jTable);
//        sp2.setBounds(10,300,80,100);
//        jPanel2 = new JPanel();
////        jPanel.add(sp1);
//        jPanel2.add(sp2);
//        jPanel2.setBounds(10,300,80,100);

//        add(jPanel);



        add(sp2);
        setSize(500,400);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Table();
    }
}

