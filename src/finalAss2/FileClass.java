package finalAss2;

import java.io.*;
import java.util.ArrayList;

public class FileClass {

    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private ArrayList <String> arrayList1 = new ArrayList<>();
    private ArrayList <String> arrayList2 = new ArrayList<>();
    private ArrayList <String> arrayList3 = new ArrayList<>();
    private ArrayList <String> arrayList4 = new ArrayList<>();

    public void fileMethod() throws IOException {
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
}
