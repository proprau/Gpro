package GUI;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Excel5 {

    private static final String FILE_PATH = "E://none text.xlsx";
    private static TextArea area = new TextArea();

    Excel5() {

        JFrame f = new JFrame();
        area.setBounds(10, 10, 290, 320);
        f.add(area);
getStudentsListFromExcel();
        f.setBounds(500, 200, 400, 400);
        f.setBackground(Color.decode("#fff"));
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private static void getStudentsListFromExcel() {
        FileInputStream fis;
        String S = "";
        try {
            fis = new FileInputStream(FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fis);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                for (Row row : sheet) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (CellType.STRING == cell.getCellType()) {
                            if (cell.getColumnIndex() == 1) {
                                area.setText(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());
                            }
                        } else if (CellType.NUMERIC == cell.getCellType()) {
                            if (cell.getColumnIndex() == 1) {
                                S = S + cell.getNumericCellValue() + "\n";
                                area.setText(S);
                                System.out.println(cell.getNumericCellValue()); }
                        } }
                }
            }

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}