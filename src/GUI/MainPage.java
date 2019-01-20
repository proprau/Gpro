package GUI;

import javax.swing.*;
import java.awt.*;

public class MainPage {

    public MainPage() {

        /*-------------------------------------------------------------------*/
        JButton selectFileButton = new JButton("See Result");
        selectFileButton.setBackground(Color.WHITE);
        selectFileButton.setBounds(80, 40, 100, 30);
        selectFileButton.setOpaque(true);
        JFrame jFrame = new JFrame();
        jFrame.add(selectFileButton);
        selectFileButton.setFocusPainted(false);
        selectFileButton.addActionListener(e -> new ResultPage());
        /*-------------------------------------------------------------------*/
        JButton openUrl = new JButton("crawlsite");
        openUrl.setBackground(Color.WHITE);
        openUrl.setBounds(200, 40, 100, 30);
        openUrl.setOpaque(true);
        jFrame.add(openUrl);
        openUrl.setFocusPainted(false);
        openUrl.addActionListener(e -> new UrlPage());
        /*-------------------------------------------------------------------*/
        jFrame.setBounds(500, 220, 400, 150);
        jFrame.setBackground(Color.decode("#fff"));
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
