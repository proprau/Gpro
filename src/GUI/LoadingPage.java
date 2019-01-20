package GUI;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import com.chilkatsoft.*;



class LoadingPage {

    private JButton doneButton;
    private JProgressBar progressBar;
    private JTextArea textArea;

    List<String> url;

    LoadingPage(List<String> url) {
        this.url = url;

        EventQueue.invokeLater(() -> {
            JFrame frame = new ProgressBarFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    class ProgressBarFrame extends JFrame {


        ProgressBarFrame() {
            setTitle("Please Wait Until Progress Complete...");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

            textArea = new JTextArea();
            textArea.setText("");


            final int MAX = 100;
            JPanel panel = new JPanel();
            doneButton = new JButton("Done");
            progressBar = new JProgressBar(0, MAX);
            progressBar.setStringPainted(true);
            panel.add(doneButton);

            add(new JScrollPane(textArea), BorderLayout.CENTER);
            add(panel, BorderLayout.SOUTH);

            doneButton.setEnabled(false);
            SimulatedActivity activity = new SimulatedActivity();
            activity.execute();

            doneButton.addActionListener(event -> new UrlResultPage());
        }
        static final int DEFAULT_WIDTH = 600;
        static final int DEFAULT_HEIGHT = 350;
        class SimulatedActivity extends SwingWorker<Void, Integer> {

            private int current = 0;
            private int jobs = 0;
            private double step = Math.ceil((100.0 / (url.size() * 8.0)));

            protected Void doInBackground() {
                while (current < url.size()) {
                    textArea.append("Getting Age Of: " + url.get(current) + "\n");
                    websiteAgeMethod(url.get(current));
                    progressBar.setValue(jobs += step);

                    textArea.append("Getting Ping Of: " + url.get(current) + "\n");
                    pingWebSite(url.get(current));
                    progressBar.setValue(jobs += step);

                    textArea.append("Getting Encoding Of: " + url.get(current) + "\n");
                    webSiteEncoding(url.get(current));
                    progressBar.setValue(jobs += step);
                    textArea.append("Getting Words Count Of: " + url.get(current) + "\n");
                    webSiteWordsCount(url.get(current));
                    progressBar.setValue(jobs);
                    jobs += step;
                    System.out.println(jobs + "    " + step);
                    textArea.append("Getting Pages Count Of: " + url.get(current) + "\n");
                    webSitePages(url.get(current));
                    progressBar.setValue(jobs);
                    jobs += step;
                    System.out.println(jobs + "    " + step);

                    textArea.append("Getting None Text Files Of: " + url.get(current) + "\n");
                    webSiteNoneTextFiles(url.get(current));
                    progressBar.setValue(jobs);
                    System.out.println(jobs + "    " + step);
                    jobs += step;

                    textArea.append("Getting Search Button Of: " + url.get(current) + "\n");
                    webSiteHasSearchButton(url.get(current));
                    progressBar.setValue(jobs);
                    System.out.println(jobs + "    " + step);
                    jobs += step;

                    textArea.append("Getting Type Of: " + url.get(current) + "\n");
                    webSiteType(url.get(current));
                    progressBar.setValue(jobs);
                    System.out.println(jobs + "    " + step);
                    jobs += step;

                    current++;
                }
                textArea.append("");
                textArea.setForeground(Color.red);
                textArea.append("All Done!!!");
                progressBar.setValue(100);

                return null;
            }

            protected void process(List<Integer> chunks) {
                progressBar.setValue(jobs += step);
            }

            protected void done() {
                doneButton.setEnabled(true);
            }
        }
    }

    private void webSiteType(String s) {

        int khabari = 0, dolati = 0, daneshgahi = 0, tejari=0;
        String webSiteType;
        s = addHttptoUrl(s);
        try {
            Document doc = Jsoup.connect(s).get();
            for (int i = 0; i < doc.select("div").size(); i++) {
                Element element = doc.select("div").get(i);
                if (element.text().contains("اخبار")
                        || element.text().contains("خبر")
                        || element.text().contains("دولت")
                        || element.text().contains("رهبران")
                        || element.text().contains("رئیس جمهور")
                        || element.text().contains("وزارت")
                        || element.text().contains("ورزشی")
                        || element.text().contains("ورزش")
                        || element.text().contains("ایران")
                        || element.text().contains("ارز")
                        || element.text().contains("دلار")
                        || element.text().contains("پول")
                        || element.text().contains("امروز")
                        || element.text().contains("آمریکا")
                        || element.text().contains("اسراییل")
                        || element.text().contains("کشور")
                        || element.text().contains("بزرگان")
                        || element.text().contains("مجلس")
                        || element.text().contains("رهبر")) {

                    khabari++;
                } else if (element.text().contains("خدمات")
                        || element.text().contains("مشاوره")
                        || element.text().contains("دولت")
                        || element.text().contains("متخصص")
                        || element.text().contains("شبکه")
                        || element.text().contains("ویژه نامه")
                        || element.text().contains("برنامه")
                        || element.text().contains("program")
                        || element.text().contains("ترجمه")
                        || element.text().contains("پشتیبانی")) {
                    dolati++;

                } else if (element.text().contains("دانشگاه")
                        || element.text().contains("سازمان")
                        || element.text().contains("واحد")
                        || element.text().contains("آموزش")
                        || element.text().contains("آموزشی")
                        || element.text().contains("دانشجو")
                        || element.text().contains("استاد")
                        || element.text().contains("معلم")
                        || element.text().contains("درس")
                        || element.text().contains("آزاد")
                        || element.text().contains("پیام نور")
                        || element.text().contains("اداری")
                        || element.text().contains("اداره")
                        || element.text().contains("ریاست")
                        || element.text().contains("اتوماسیون")
                        || element.text().contains("معاونت")) {
                    daneshgahi++;

                } else if (element.text().contains("تجارت")
                        || element.text().contains("تجاری")
                        || element.text().contains("سازمان")
                        || element.text().contains("پول")
                        || element.text().contains("ارز")
                        || element.text().contains("خرید")
                        || element.text().contains("فروش")
                        || element.text().contains("مغازه")
                        || element.text().contains("دنیا")
                        || element.text().contains("سود")
                        || element.text().contains("ضرر")
                        || element.text().contains("خارج")
                        || element.text().contains("خارجی")
                        || element.text().contains("ریاست")
                        || element.text().contains("اتوماسیون")
                        || element.text().contains("معاونت")) {
                    tejari++;



                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (khabari> dolati && khabari > daneshgahi && khabari > tejari) {
            webSiteType = "The Type Of " + s + " is: " + "خبری";
        } else if (daneshgahi > khabari && daneshgahi > dolati && daneshgahi > tejari) {
            webSiteType = "The Type Of " + s + " is: " + "دانشگاهی";
        } else if (tejari > khabari && tejari > daneshgahi&& tejari> dolati) {
            webSiteType = "The Type Of " + s + " is: " + "تجاری";
        } else if (dolati > khabari && dolati> daneshgahi&& dolati> tejari) {
            webSiteType = "The Type Of " + s + " is: " + "دولتی";

        } else {
            webSiteType = "The Type Of " + s + " Has Unknown or Undefined Type";
        }


        saveToFile(webSiteType, "E:/outFiles/webSiteType.txt");
    }





    private void webSiteHasSearchButton(String s) {
        s = addHttptoUrl(s);
        String res;
        int has = 0;
        try {
            Document doc = Jsoup.connect(s).get();
            Elements elements = doc.getAllElements();
            for (Element element : elements) {
                if (element.attr("placeholder").contains("Search")
                        || element.attr("placeholder").contains("search")
                        || element.attr("placeholder").contains("جستجو")
                        || element.attr("placeholder").contains("جستجو")
                        || element.attr("placeholder").contains("جست و جو")
                        || element.attr("title").contains("Search")
                        || element.attr("title").contains("search")
                        || element.attr("title").contains("جستجو")
                        || element.attr("title").contains("جست و جو")
                        || element.attr("value").contains("Search")
                        || element.attr("value").contains("search")
                        || element.attr("value").contains("جستجو")
                        || element.attr("value").contains("جست و جو")) {
                    has++;
                }
            }
        } catch (Exception ignored) {
        }
        if (has > 0) {
            res = "The Website " + s + " Has Search Button";
        } else {
            res = "The Website " + s + " Has Not Search Button";
        }
        saveToFile(res, "E:/outFiles/hasSearchButton.txt");
    }





    private void webSiteNoneTextFiles(String s) {

        s = addHttptoUrl(s);

        int nonTextCounter = 0;
        int textFileCounter = 0;
        try {
            Document doc = Jsoup.connect(s).get();
            Elements media = doc.getAllElements();
            for (Element src : media) {
                switch (src.tagName()) {
                    case "img":
                    case "source":
                    case "video":
                    case "audio":
                    case "pdf":


                        nonTextCounter++;
                        break;
                    case "p":
                    case "li":
                    case "h1":
                    case "h2":
                    case "h3":
                    case "h4":
                    case "h5":
                    case "h6":
                    case "article":
                    case "address":
                    case "a":
                        textFileCounter++;
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double percent = ((nonTextCounter * 1.0) / ((textFileCounter + nonTextCounter) * 1.0)) * 100;
        String res = "The Url " + s + " Contains " + percent + "% Of None Text Files and " + (100 - percent) + "% Of Text Files.";
        saveToFile(res, "E:/outFiles/noneTextFiles.txt");
    }





    private void webSitePages(String s) {


        ArrayList<String> aListColors = new ArrayList<>();
        s = addHttptoUrl(s);

        try {
            Document doc = Jsoup.connect(s).get();
            Elements links = doc.select("a[href]");
            s = getPagesUrl(s);
            for (Element link : links) {
                if (link.toString().contains(s)) {
                    if (!aListColors.contains(link.toString())) {
                        aListColors.add(link.toString());
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        String res = "The Url " + s + " Contains " + aListColors.size() + " of Pages.";

        saveToFile(res, "E:/outFiles/pages.txt");

    }

    private String getPagesUrl(String s) {
        StringBuilder res;
        if (s.contains("http://")) {
            res = createString(6, s.length(), s);
        } else if (s.contains("https://")) {
            res = createString(7, s.length(), s);
        } else {
            res = createString(0, s.length(), s);
        }
        return res.toString();
    }

    private StringBuilder createString(int begin, int end, String s) {
        StringBuilder res = wwwRemover(begin, end, s);
        if (res.toString().contains("/")) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i <= res.toString().lastIndexOf("/"); i++) {
                temp = new StringBuilder(temp.append(res.charAt(i)));
            }
            System.out.println(temp.toString());
            return temp;
        }
        return res;
    }

    private StringBuilder wwwRemover(int begin, int end, String s) {
        StringBuilder res = new StringBuilder();
        if (s.contains("www."))
            for (int i = (begin + 5); i < end; i++) {
                res = new StringBuilder(res.append(s.charAt(i)));
            }
        else {
            for (int i = (begin + 1); i < end; i++) {
                res = new StringBuilder(res.append(s.charAt(i)));
            }
        }
        return res;
    }






    private void webSiteWordsCount(String s) {
        s = addHttptoUrl(s);
        int wordCounter = 0;
        try {
            Document doc = Jsoup.connect(s).get();
            Elements links = doc.getAllElements();
            System.out.println(links.toString());
            for (Element link : links) {
                String[] S = link.text().split(" ");
                wordCounter += S.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String res = "The Page " + s + " Contains " + wordCounter + " Words.";
        saveToFile(res, "E:/outFiles/wordCount.txt");
    }





    private void webSiteEncoding(String s) {

        String result;
        URL url;
        s = addHttptoUrl(s);
        try {
            url = new URL(s);
            URLConnection con = url.openConnection();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8"  : encoding;


            result = "The " + s + " Encoding is:  " + encoding;
        } catch (IOException e) {
            result = "An Error Occurred During Get WebSite Encoding.";
        }
        saveToFile(result, "E:/outFiles/encoding.txt");


    }



    private String addHttptoUrl(String s) {

        if (!s.contains("http://") && !s.contains("https://")) {
            s = "https://" + s;
        }

        return s;
    }



    private void pingWebSite(String address) {

        String result = "";
        address = addHttptoUrl(address);
        try {
            final URL url = new URL(address);
            final HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setConnectTimeout(5000);
            final long startTime = System.currentTimeMillis();
            urlConn.connect();
            final long endTime = System.currentTimeMillis();
            if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                result = "Code " + urlConn.getResponseCode() + "   Ping Time Of:  " + address + "  is:  " + (endTime - startTime) + "  ms.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_BAD_GATEWAY) {
                result = "Code " + urlConn.getResponseCode() + "   Http Bad Gateway.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {
                result = "Code " + urlConn.getResponseCode() + "   Client Bad Request.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_CLIENT_TIMEOUT) {
                result = "Code " + urlConn.getResponseCode() + "   Client Request Timeout.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_CONFLICT) {
                result = "Code " + urlConn.getResponseCode() + "   Http Conflict.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_ENTITY_TOO_LARGE) {
                result = "Code " + urlConn.getResponseCode() + "   Http Entity is Too large.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_FORBIDDEN) {
                result = "Code " + urlConn.getResponseCode() + "   Url is Forbidden.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
                result = "Code " + urlConn.getResponseCode() + "   Http Gateway Timeout.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_GONE) {
                result = "Code " + urlConn.getResponseCode() + "   Url is Gone.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                result = "Code " + urlConn.getResponseCode() + "   There is an Internal Error.";
            } else if (urlConn.getResponseCode() == HttpURLConnection.HTTP_NOT_ACCEPTABLE) {
                result = "Code " + urlConn.getResponseCode() + "   Url is Not Acceptable.";
            }
        } catch (IOException e) {
            result = "Target Unreachable for url " + address;
        }
        saveToFile(result, "E:/outFiles/ping.txt");

    }



    private void websiteAgeMethod(String s) {
        WhoisTest obj = new WhoisTest();

        StringBuilder res = new StringBuilder();
        String[] S = obj.getWhois(getCurrectUrl(s)).split("\\r?\\n");
        Calendar calendar = Calendar.getInstance();
        int webYear = 0, currentYear;
        for (int i = (S[5].indexOf(":") + 2); i < S[5].length(); i++) { res.append(S[5].charAt(i));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date = sdf.parse(res.toString());
            calendar.setTime(date);
            webYear = calendar.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
 String result = s + " is Create in " + webYear + " And Now It Has " + (currentYear - webYear) + " Years Old.";
        saveToFile(result, "E:/outFiles/age.txt");
    }



    private String getCurrectUrl(String s) {
        StringBuilder res;


        if (s.contains("http://")) {
            res = myGetString(6, s.length(), s);
        } else if (s.contains("https://")) {
            res = myGetString(7, s.length(), s);
        } else {
            res = myGetString(0, s.length(), s);
        }
        return res.toString();
    }



    private StringBuilder myGetString(int begin, int end, String s) {
        StringBuilder res = wwwRemover(begin, end, s);
        wwwRemover(begin, end, s);
        if (res.toString().contains("/")) {
            StringBuilder temp = new StringBuilder();
            System.out.println(res.toString());
            for (int i = 0; i < res.toString().indexOf("/"); i++) {
                temp = new StringBuilder(temp.append(res.charAt(i)));
            }
            System.out.println(temp.toString());
            return temp;
        }
        return res;
    }

    private void saveToFile(String s, String fileName) {
  File file = new File(fileName);

        try {
            Scanner infile = new Scanner(file);
            StringBuilder temp = new StringBuilder();
            while (infile.hasNextLine()) {
                temp.append(infile.nextLine()).append("@");
            }

            temp.append(s).append("@");

            String[] inTheFile = temp.toString().split("@");
            try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {

                for (String s1 : inTheFile) {
                    bufferedOutputStream.write(s1.getBytes());
                    bufferedOutputStream.write("\r\n".getBytes());
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("فایل مورد نظر پیدا نشد.");
        }

    }
}