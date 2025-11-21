package com.example.behavioral.strategy.spreadsheetapp.second;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static com.example.behavioral.strategy.spreadsheetapp.second.DataModel.EMPTYSTR;
import static com.example.behavioral.strategy.spreadsheetapp.second.DataModel.NEW_LINE;

public class CSVFormat implements IFormat {
    private static final String OUTPUT_FILE = "/Users/sarojkumarsahu/ml/data/data.csv";

    @Override
    public void exportData(DataModel dataModel) {
        File file = new File(OUTPUT_FILE);
        Path path = Paths.get(OUTPUT_FILE);
        try {
            if (file.exists()) {
                Files.delete(path);
            }

            Files.write(path, EMPTYSTR.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            for (List<Integer> row : dataModel.getSheet()) {
                for (int e : row) {
                    String val = e + ",";
                    Files.write(path, val.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
                Files.write(path, NEW_LINE.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException ex) {
            System.err.println("Exception caught : " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
