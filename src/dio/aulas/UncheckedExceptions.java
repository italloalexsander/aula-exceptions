package dio.aulas;

import javax.swing.*;

public class UncheckedExceptions {
    public static void main(String[] args) {
        boolean continueLooping = true;

        do{
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try {
                int resultado = divide(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Entrada Inválida, informe um número inteiro " + e.getMessage());
                //e.printStackTrace();
            }catch (ArithmeticException e) {
                JOptionPane.showMessageDialog( null, "Impossível divisão por 0 " + e.getMessage());
                //e.printStackTrace();
            }finally {
                System.out.println("Chegou aqui no finally...");
            }
        } while(continueLooping);



        System.out.println("O código continuou...");
    }

    public static int divide(int a, int b){
        return a / b;
    }
}