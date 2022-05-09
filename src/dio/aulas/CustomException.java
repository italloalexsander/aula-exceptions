package dio.aulas;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;


public class CustomException {
    public static void main(String[] args){
        String fileLocation = "Jogos2022";
        printFileOnConsole(fileLocation);
        System.out.println("O programa continua de qualquer forma");
    }
    public static void printFileOnConsole(String fileName){
        try{
            BufferedReader br = readFile(fileName);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            do{
                bw.write(line);
                bw.newLine();
                line= br.readLine();
            } while (line != null);
            bw.flush();
            br.close();
        } catch (ImpossibleFileOpenException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch(IOException exc){
            JOptionPane.showMessageDialog(null, "ERRO INESPERADO");
            exc.printStackTrace();
        }


    }

    public static BufferedReader readFile(String fileName) throws ImpossibleFileOpenException {
        File file = new File(fileName);
        try {
            return new BufferedReader(new FileReader(file.getName()));
        } catch(FileNotFoundException e){
            throw new ImpossibleFileOpenException(file.getName(), file.getPath());
        }
    }
}

class ImpossibleFileOpenException extends Exception{
    private String fileName;
    private String directory;

    public ImpossibleFileOpenException(String fileName, String directory) {
        super("O arquivo " + fileName + " não foi encontrado no diretório " + directory);
        this.fileName = fileName;
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "ImpossibleFileOpenException{" +
                "fileName='" + fileName + '\'' +
                ", directory='" + directory + '\'' +
                '}';
    }
}
