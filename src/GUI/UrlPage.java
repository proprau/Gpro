package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UrlPage {
    private TextArea area = new TextArea("Enter Urls Here...");
    private List<String> urls = new ArrayList<>();

    UrlPage() {
        /*-------------------------------------------------------------------*/
        JButton openUrl = new JButton("Open Url");
        openUrl.setBackground(Color.WHITE);
        openUrl.setBounds(20, 195, 100, 30);
        openUrl.setOpaque(true);

        JFrame f = new JFrame();
        f.add(openUrl);
        openUrl.setFocusPainted(false);
        openUrl.addActionListener(e -> {
            if (area.getText().equals("")) {
                JFrame frame = new JFrame("Error Message");
    JOptionPane.showMessageDialog(frame,
                        "لینک ها نمیتوانند خالی باشند.",
                        "Cannot Empty!",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                urls.clear();
                urls.addAll(Arrays.asList(area.getText().split("\\n")));
                new LoadingPage(urls);
            }
        });
        /*-------------------------------------------------------------------*/

        area.setBounds(10, 30, 300, 150);
        area.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                area.setFocusable(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                area.setFocusable(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                area.setFocusable(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        area.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                area.setFocusable(true);
                if (area.getText().equals("Enter Urls Here...")) {
                    area.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                area.setFocusable(false);
                if (area.getText().equals("")) {
                    area.setText("Enter Urls Here...");
                }
            }
        });
        area.setFocusable(false);
        f.add(area);
        /*-------------------------------------------------------------------*/
      f.setBounds(500, 200, 350, 350);
        f.setBackground(Color.decode("#fff"));
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
