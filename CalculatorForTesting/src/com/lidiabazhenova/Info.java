package com.lidiabazhenova;

import com.sun.media.sound.SoftAudioProcessor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Info {
    private double first;
    private String operation;
    private double second;
    private double result;
    Scanner sc = new Scanner(System.in);

    public Info(String operation, double first, double second, double result) {
        this.first = first;
        this.operation = operation;
        this.second = second;
        this.result = result;
    }

    public Info() {
    }

    public void createHtml(List<String> values) throws IOException {

        File file = new File(getPathName());
        if (file.exists()) {
            System.out.println("file exists");
            createHtml(values);
        } else {
            StringBuilder htmlContent = new StringBuilder();
            htmlContent.append("<table b order='1' cellpadding='5' style='border-collapse: collapse; border: 1px solid black;'>");
            htmlContent.append("<tr><th>Arg1</th><th>Operation</th><th>Arg2</th><th>equals</th><th>Result</th></tr>");
            htmlContent.append("<tr>");
            htmlContent.append("<td>").append(values.get(0));
            htmlContent.append("</td>");
            htmlContent.append("<td>").append(values.get(1));
            htmlContent.append("</td>");
            htmlContent.append("<td>").append(values.get(2));
            htmlContent.append("</td>");
            htmlContent.append("<td>=</td>");
            htmlContent.append("<td>").append(values.get(3));
            htmlContent.append("</td></tr>");
            htmlContent.append("</table>");
            PrintWriter htmlFile = new PrintWriter(file.getPath());
            htmlFile.println(htmlContent.toString());
            System.out.println("file saved with pathname " + file.getPath());
            htmlFile.close();
        }
    }

    public String getPathName() {
        System.out.println("Enter pathname to save in such format: 'D://SomeDir' ");
        String path = sc.nextLine();

        File dir = new File(path);
        boolean created = dir.mkdir();
        if ((created)&&(dir.exists())){
            System.out.println("Каталог успешно создан");}
        //!!!Пишет это сообщение даже если путь неверный

        System.out.println("Enter name to save in such format: '*.html' ");
        String name = sc.nextLine();
        String pathName = path + "//" + name;
        return pathName;
    }

    public Info(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public List<String> write() throws IOException {
        List<String> values = new ArrayList<String>();
        values.add(0, "" + this.first);
        values.add(1, "" + this.operation);
        values.add(2, "" + this.second);
        values.add(3, "" + this.result);
        createHtml(values);
        return values;

    }
}
