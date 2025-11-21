package com.example.behavioral.strategy.spreadsheetapp.first;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataModel {
    private List<List<Integer>> mSheet = new ArrayList<>();
    // This is the input file -- for the sake of understanding this design pattern
    // we have hard coded the input file and writing the content by using addRow()
    private static final String FILE = "/Users/sarojkumarsahu/ml/data/data_input.txt";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String EMPTYSTR = "";

    private void addRow(List<Integer> data) {
        mSheet.add(data);
    }

    public void display() {
        for (List<Integer> row : mSheet) {
            for (int e : row) {
                System.out.printf("%d ", e);
            }
            System.out.println();
        }
    }

    // Reads a file line by line
    public void load() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE), StandardCharsets.UTF_8);

            for (String line : lines) {
                List<Integer> rowData = new ArrayList<>();
                for (String w : line.split(" ")) {
                    rowData.add(Integer.valueOf(w));
                }
                addRow(rowData);
            }
        } catch (IOException e) {
            System.err.println("Exception caught : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void save(List<List<Integer>> inputDatas) {
        try {
            Path path = Paths.get(FILE);
            File file = new File(FILE);
            if (file.exists()) {
                Files.delete(path);
            }
            for (List<Integer> row : inputDatas) {
                for (int e : row) {
                    String val = e + " ";
                    Files.write(path, val.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
                Files.write(path, NEW_LINE.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch(IOException ex) {
            System.err.println("Exeception caught : " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public void export() {
        String filePath = "/Users/sarojkumarsahu/data.csv";
        File file = new File(filePath);
        Path path = Paths.get(filePath);
        try {
            if (file.exists()) {
                Files.delete(path);
            }

            Files.write(path, EMPTYSTR.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            for (List<Integer> row : mSheet) {
                for (int e : row) {
                    String val = e + ",";
                    Files.write(path, val.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
                Files.write(path, NEW_LINE.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch(IOException ex) {
            System.err.println("Exception caught : " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public void export(int type) {
        if (type == 0) {
            String filePath = "/Users/sarojkumarsahu/ml/data/data.csv";
            File file = new File(filePath);
            Path path = Paths.get(filePath);
            try {
                if (file.exists()) {
                    Files.delete(path);
                }

                Files.write(path, EMPTYSTR.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
                for (List<Integer> row : mSheet) {
                    for (int e : row) {
                        String val = e + ",";
                        Files.write(path, val.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    }
                    Files.write(path, NEW_LINE.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
            } catch(IOException ex) {
                System.err.println("Exception caught : " + ex.getMessage());
                throw new RuntimeException(ex);
            }
        } else if (type == 1) {
            String filePath = "/Users/sarojkumarsahu/ml/data/data.html";
            File file = new File(filePath);
            Path path = Paths.get(filePath);
            try {
                if (file.exists()) {
                    Files.delete(path);
                }

                Files.write(path, EMPTYSTR.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
                StringBuilder sb = new StringBuilder()
                        .append("<!DOCTYPE html>\n")
                        .append("<html>\n")
                        .append("<body>\n")
                        .append("<h1>Exported</h1>\n");

                String PARA_START = "<p>";
                String PARA_END = "</p>\n";
                for (List<Integer> row : mSheet) {
                    sb.append(PARA_START);
                    for (int e : row) {
                        String val = e + " ";
                        sb.append(val);
                    }
                    sb.append(PARA_END);
                }
                sb.append("</html>\n");
                sb.append("</body>\n");
                Files.write(path, sb.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                System.err.println("Exception caught : " + ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
        DataModel dataModel = new DataModel();
        // { Creating input data
        List<List<Integer>> datas = Arrays.asList(
                Arrays.asList(10, 2, 3),
                Arrays.asList(40, 5, 6),
                Arrays.asList(70, 8, 9)
        );
        // Insert the data into file with save() method
        dataModel.save(datas);
        // } input file got created.

        // Load the data into memory
        dataModel.load();
        // Display the data loaded into memory
        dataModel.display();

        // Export with csv
        dataModel.export(0);

        // Export data with html
        dataModel.export(1);

    }
}
