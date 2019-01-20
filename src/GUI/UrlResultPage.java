package GUI;

import javax.swing.*;
import java.awt.*;

class UrlResultPage {

    private JFrame jFrame = new JFrame();
    private JButton webSiteAge, webSieEncoding, usedWordsCount, webSitePages, webSiteNoneTextFiles, hasSearchButton, webSitePing, webSiteType;

    UrlResultPage() {

        initButtons();

        webSiteAge.addActionListener(e -> {
            new resultShowPage("E:/outFiles/age.txt");
        });
        webSieEncoding.addActionListener(e -> {
            new resultShowPage("E:/outFiles/encoding.txt");
        });
        usedWordsCount.addActionListener(e -> {
            new resultShowPage("E:/outFiles/wordCount.txt");
        });
        webSitePages.addActionListener(e -> {
            new resultShowPage("E:/outFiles/pages.txt");
        });
        webSiteNoneTextFiles.addActionListener(e -> {
            new resultShowPage("E:/outFiles/noneTextFiles.txt");
        });
        hasSearchButton.addActionListener(e -> {
            new resultShowPage("E:/outFiles/hasSearchButton.txt");
        });
        webSitePing.addActionListener(e -> {
            new resultShowPage("E:/outFiles/ping.txt");
        });
        webSiteType.addActionListener(e -> {
            new resultShowPage("E:/outFiles/webSiteType.txt");
        });

        jFrame.setBounds(500, 200, 400, 200);
        jFrame.setBackground(Color.decode("#fff"));
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void initButtons() {
        webSiteAge = new JButton("webSiteAge");
        jFrame.add(webSiteAge);
        webSiteAge.setBackground(Color.WHITE);
        webSiteAge.setBounds(10, 15, 180, 30);
        webSiteAge.setOpaque(true);
        webSiteAge.setFocusPainted(false);

        webSieEncoding = new JButton("webSieEncoding");
        jFrame.add(webSieEncoding);
        webSieEncoding.setBackground(Color.WHITE);
        webSieEncoding.setBounds(210, 15, 180, 30);
        webSieEncoding.setOpaque(true);
        webSieEncoding.setFocusPainted(false);

        usedWordsCount = new JButton("usedWordsCount");
        jFrame.add(usedWordsCount);
        usedWordsCount.setBackground(Color.WHITE);
        usedWordsCount.setBounds(10, 55, 180, 30);
        usedWordsCount.setOpaque(true);
        usedWordsCount.setFocusPainted(false);

        webSitePages = new JButton("webSitePages");
        jFrame.add(webSitePages);
        webSitePages.setBackground(Color.WHITE);
        webSitePages.setBounds(210, 55, 180, 30);
        webSitePages.setOpaque(true);
        webSitePages.setFocusPainted(false);

        webSiteNoneTextFiles = new JButton("anotherfiletype");
        jFrame.add(webSiteNoneTextFiles);
        webSiteNoneTextFiles.setBackground(Color.WHITE);
        webSiteNoneTextFiles.setBounds(10, 95, 180, 30);
        webSiteNoneTextFiles.setOpaque(true);
        webSiteNoneTextFiles.setFocusPainted(false);

        hasSearchButton = new JButton("hasSearchButton");
        jFrame.add(hasSearchButton);
        hasSearchButton.setBackground(Color.WHITE);
        hasSearchButton.setBounds(210, 95, 180, 30);
        hasSearchButton.setOpaque(true);
        hasSearchButton.setFocusPainted(false);

        webSitePing = new JButton("webSitettfb");
        jFrame.add(webSitePing);
        webSitePing.setBackground(Color.WHITE);
        webSitePing.setBounds(10, 135, 180, 30);
        webSitePing.setOpaque(true);
        webSitePing.setFocusPainted(false);

        webSiteType = new JButton("webSiteType");
        jFrame.add(webSiteType);
        webSiteType.setBackground(Color.WHITE);
        webSiteType.setBounds(210, 135, 180, 30);
        webSiteType.setOpaque(true);
        webSiteType.setFocusPainted(false);


    }

}
