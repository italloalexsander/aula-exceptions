package dio.aulas;

import javax.swing.*;

public class CustomException2{
    public static void main(String[] args){
        int[] num = {4, 5, 8, 10};
        int[] den = {2, 4, 0, 2, 8};

        for (int i = 0; i < den.length; i++) {
            try {
                if(num[i] %2 != 0)
                    throw new NonExactDivisionException("Divisão não exata!", num[i], den[i]);

                int resultado = num[i] / den[i];
                System.out.println(resultado);
            } catch (NonExactDivisionException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        System.out.println("Chegou até aqui...");
    }
}

class NonExactDivisionException extends Exception{

    private int num;
    private int den;

    public NonExactDivisionException(String message, int num, int den) {
        super(message);
        this.num = num;
        this.den = den;
    }
}