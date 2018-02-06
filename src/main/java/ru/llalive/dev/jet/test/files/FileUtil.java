package ru.llalive.dev.jet.test.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import ru.llalive.dev.jet.test.files.interfaces.Function;
import ru.llalive.dev.jet.test.files.manager.FunctionManager;

/**
 *
 * @author Павел
 */
public class FileUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new Exception("Не задан исходный файл.");
            }
            String fileName = args[0];
            File inputFile = new File(fileName);
            if (!inputFile.exists()) {
                throw new FileNotFoundException("Исходный файл не найден.");
            }
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            while (reader.ready()) {
                String line = reader.readLine();
                String[] params = line.split(" ");
                String tag = params[0];
                Function fucntionByTag = FunctionManager.getFucntionByTag(tag);
                int k = 0;
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
