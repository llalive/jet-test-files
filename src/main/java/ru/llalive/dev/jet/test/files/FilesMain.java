package ru.llalive.dev.jet.test.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.llalive.dev.jet.test.files.functions.Function;
import ru.llalive.dev.jet.test.files.manager.FunctionManager;

/**
 *
 * @author Павел
 */
public class FilesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Нужно передать в качестве параметров - входной и выходной файлы.");
            }
            String fileName = args[0];
            File inputFile = new File(fileName);
            fileName = args[1];
            File outputFile = new File(fileName);
            if (!inputFile.exists()) {
                throw new FileNotFoundException("Исходный файл не найден.");
            }
            if (!outputFile.exists()) {
                boolean added = outputFile.createNewFile();
                if (!added) {
                    throw new IOException("Не удалось создать выходной файл.");
                }
            }
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFile));
            int lineNum = 0;
            while (reader.ready()) {
                String line = reader.readLine();
                lineNum++;
                String[] params = line.split(" ");
                String tag = params[0];
                Integer[] values = new Integer[params.length - 1];
                for (int i = 1; i < params.length; i++) {
                    values[i - 1] = Integer.parseInt(params[i]);
                }
                Function function = FunctionManager.getFucntionByTag(tag);

                writer.append(lineNum + " " + function.getResult(values));
                writer.newLine();
            }
        } catch (IOException | IllegalArgumentException ex) {
            System.err.println(ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FilesMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
