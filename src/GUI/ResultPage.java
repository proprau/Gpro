package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPage {

    private JFrame jFrame = new JFrame();
    private JButton One, Two, Three, Four, Five, Six, Seven, Eight;

    public ResultPage() {

        initButtons();

        One.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel1();
            }
        });
        Two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel2();
            }
        });
        Three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel3();

            }
        });
        Four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel4();

            }
        });
        Five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel5();

            }
        });
        Six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel6();

            }
        });
        Seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel7();

            }
        });
        Eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Excel8();

            }
        });

        jFrame.setBounds(500, 200, 400, 200);
        jFrame.setBackground(Color.decode("#fff"));
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void initButtons() {
        One = new JButton("Web Site Age");
        jFrame.add(One);
        One.setBackground(Color.WHITE);
        One.setBounds(10, 15, 180, 30);
        One.setOpaque(true);
        One.setFocusPainted(false);

        Two = new JButton("Website Encoding");
        jFrame.add(Two);
        Two.setBackground(Color.WHITE);
        Two.setBounds(210, 15, 180, 30);
        Two.setOpaque(true);
        Two.setFocusPainted(false);

        Three = new JButton("used Words Count");
        jFrame.add(Three);
        Three.setBackground(Color.WHITE);
        Three.setBounds(10, 55, 180, 30);
        Three.setOpaque(true);
        Three.setFocusPainted(false);

        Four = new JButton("Website Pages Count");
        jFrame.add(Four);
        Four.setBackground(Color.WHITE);
        Four.setBounds(210, 55, 180, 30);
        Four.setOpaque(true);
        Four.setFocusPainted(false);

        Five = new JButton("Another File Type");
        jFrame.add(Five);
        Five.setBackground(Color.WHITE);
        Five.setBounds(10, 95, 180, 30);
        Five.setOpaque(true);
        Five.setFocusPainted(false);

        Six = new JButton("Has Search Button");
        jFrame.add(Six);
        Six.setBackground(Color.WHITE);
        Six.setBounds(210, 95, 180, 30);
        Six.setOpaque(true);
        Six.setFocusPainted(false);

        Seven = new JButton("Website TTFB");
        jFrame.add(Seven);
        Seven.setBackground(Color.WHITE);
        Seven.setBounds(10, 135, 180, 30);
        Seven.setOpaque(true);
        Seven.setFocusPainted(false);

        Eight = new JButton("Website Type");
        jFrame.add(Eight);
        Eight.setBackground(Color.WHITE);
        Eight.setBounds(210, 135, 180, 30);
        Eight.setOpaque(true);
        Eight.setFocusPainted(false);


    }

}
