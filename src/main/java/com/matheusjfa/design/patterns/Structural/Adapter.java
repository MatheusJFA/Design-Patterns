package com.matheusjfa.design.patterns.Structural;

/**
 * The Adapter Pattern converts the interface of a class into another interface the clients expect.
 * Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
 *
 * In this example, we have a TextToCSVAdapter that converts a text file into a CSV file.
 * And a CSVToTextAdapter that converts a CSV file into a text file.
 * The Format interface is the interface that both adapters implement.
 *
 * Output:
 * This,is,a,text,file
 * */

public class Adapter {
    public static void main(String[] args) {
        var textFile = "This was a text file";

        Format textToCSVAdapter = new TextToCSVAdapter(textFile);
        System.out.println(textToCSVAdapter.formatter());

        var csvFile = "This,was,a,csv,file";

        Format csvToTextAdapter = new CSVToTextAdapter(csvFile);
        System.out.println(csvToTextAdapter.formatter());
    }
}

interface Format {
    String formatter();
}

class TextToCSVAdapter implements Format {
    private final String textFile;

    public TextToCSVAdapter(String textFile) {
        this.textFile = textFile;
    }

    @Override
    public String formatter() {
        return textFile.replace(" ", ",");
    }
}

class CSVToTextAdapter implements Format {
    private final String csvFile;

    public CSVToTextAdapter(String csvFile) {
        this.csvFile = csvFile;
    }

    @Override
    public String formatter() {
        return csvFile.replace(",", " ");
    }
}