package dio.aulas;

import javax.swing.*;
import java.io.*;


public class CheckedExceptions {
    public static void main(String[] args){
        String fileLocation = "Jogos2022";
        try {
            printFileOnConsole(fileLocation);
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Nome do arquivo está errado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO INESPERADO - CONTACT SUPPORT");
            e.printStackTrace();
        }
        System.out.println("O programa continua de qualquer forma");
    }
    public static void printFileOnConsole(String fileName) throws IOException {
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            bw.write(line);
            bw.newLine();
            line= br.readLine();
        } while (line != null);
        bw.flush();
        br.close();
    }
}
