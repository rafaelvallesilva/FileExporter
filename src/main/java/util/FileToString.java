package util;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import domain.Arquivo;

public class FileToString {

    public static void main(String[] args) throws ParseException {
        
        // Locale.setDefault(Locale.pt);-
        Scanner scanner = new Scanner(System.in);

    	List<Arquivo> arquivos = new ArrayList<>();

        System.out.println("Digita o caminho: ");
        String sourceFileString = scanner.nextLine();

        File sourceFile = new File(sourceFileString);
        String sourceFolderString = sourceFile.getParent();

        boolean success = new File(sourceFolderString + "\\teste").mkdir();

        String targetFileString = sourceFolderString + "\\teste\\xd.csv";

        try () {

        } catch (IOException e) {
            System.out.println();
        }
        
        		
         scanner.close();
    }
}
        


    // public static void main(String[] args) throws IOException {
    //     try (FileReader fr = new FileReader("C:\\Users\\bruno.pansarim\\Documents\\Protheus\\Atual\\Compras\\ajussc7.prw")) {
    //         int i;

    //         while ((i = fr.read()) != -1) {

    //             System.out.println((char)i);

    //         }
    //     }
    // }
