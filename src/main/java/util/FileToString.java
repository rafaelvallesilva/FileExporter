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
import util.StringUtils;

import domain.Arquivo;

public class FileToString {

    public static void main(String[] args) throws ParseException {

        // Scanner scanner = new Scanner(System.in);

        List<Arquivo> arquivos = new ArrayList<>();

        // System.out.println("Digita o caminho: ");
        // String sourceFileString = scanner.nextLine();

        // File file = new File("teste\\xd.txt");

        // try {

        // file.createNewFile();

        // } catch (Exception e) {
        // e.getStackTrace();
        // }

        // try (BufferedReader br = new BufferedReader(new FileReader(sourceFileString))) {

            String conteudo = new ReadFile().read("teste.txt");
            String[] array = StringUtils.splitCommentBlock(conteudo);
            // System.out.println(array[1]);

            String[] descricao = StringUtils.splitDescricao(array[1]);


            String fonte = descricao[1] + descricao[2];


            String modulo = descricao[14] + descricao[15];
            String rotina = descricao[2];
            String data = descricao[6];
            String obs = descricao[8] + descricao[9] + descricao[10] + descricao[11];

            System.out.println(obs);

            // for (String string : descricao) {
            //     System.out.println(string);
            // }

            arquivos.add(new Arquivo(fonte, modulo, rotina, data, obs));


            // try (BufferedWriter bw = new BufferedWriter(new
            // FileWriter(sourceFileString))) {
            // for (Arquivo item: arquivos) {
            // bw.write(item.getFonte() + "," + item.getModulo() + "," + item.getRotina() +
            // "," + item.getData() + "," + item.getObs());
            // bw.newLine();
            // }
            // System.out.println(sourceFileString + " Created");

            // } catch (Exception e) {
            // System.out.println("Error: " + e.getMessage());
            // }

            // } catch (IOException e) {
            // System.out.println("error: " +e.getMessage());
            // }
            // finally {
            // if (scanner != null) {
            // scanner.close();
            // }
            // }
        }
    }
