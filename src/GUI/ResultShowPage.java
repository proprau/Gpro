package GUI;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

class resultShowPage {


    resultShowPage(String fileDir) {
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane scroll = new JScrollPane(ta);
        f.getContentPane().add(scroll, java.awt.BorderLayout.CENTER);
        f.setBounds(200, 100, 900, 600);
        f.setVisible(true);

        String[] S = readFromFile(fileDir);
        for (String s : S) {
            ta.append(s + "\n");
        }
    }

    private String[] readFromFile(String fileName) {
        StringBuilder temp = new StringBuilder();
        File file = new File(fileName);

        try {
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                temp.append(in.nextLine()).append("&");
            }
        } catch (Exception e) {
            System.out.println("فایل مورد نظر پیدا نشد.");
        }
        return temp.toString().split("&");
    }
}
