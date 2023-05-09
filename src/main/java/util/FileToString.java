package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Arquivo;

public class FileToString {

    public static void main(String[] args) throws ParseException {
        
        // Locale.setDefault(Locale.pt);-
        Scanner scanner = new Scanner(System.in);

    	List<Arquivo> arquivos = new ArrayList<>();

        System.out.println("Digita o caminho: ");
        String sourceFileString = scanner.nextLine();

        // File sourceFile = new File(sourceFileString);
        // String sourceFolderString = sourceFile.getParent();

        File file = new File("teste\\xd.txt");

        try {

            file.createNewFile();
            
        } catch (Exception e) {
            e.getStackTrace();
        }

        String targetFileString = "teste\\xd.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileString))) {

            String arquivoPrw = br.readLine();
            while (arquivoPrw != null) {
                
            String[] fields = arquivoPrw.split("//s*//--([A-Za-z1-9_/-]+)(/s*:/s*(.*?);)?/s*//");
            
            String fonte = fields[0];
            // String modulo = fields[1];
            // String rotina = fields[2];
            // String data = fields[3];
            // String obs = fields[4];
            
            arquivos.add(new Arquivo(fonte, null, null, null, null));
            
                // System.out.println(arquivos);
                // System.out.println(arquivoPrw);
                // System.out.println(fields);
                
                arquivoPrw = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileString))) {
                for (Arquivo item: arquivos) {
                    bw.write(item.getFonte() + "," + item.getModulo() + "," + item.getRotina() + "," + item.getData() + "," + item.getObs());
                    bw.newLine();
            }
                System.out.println(targetFileString + " Created");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        

        } catch (IOException e) {
            System.out.println("error: " +e.getMessage());
        }
         finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}



                        // Lê o arquivo, mas apenas linha por linha

    // public static void main(String[] args) throws IOException {
    //     try (FileReader fr = new FileReader("C:\\Users\\bruno.pansarim\\Documents\\Protheus\\Atual\\Compras\\ajussc7.prw")) {
    //         int i;

    //         while ((i = fr.read()) != -1) {

    //             System.out.println((char)i);

    //         }
    //     }
    // }
