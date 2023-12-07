import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char operation;
        String[] expression;
        if (input.contains(" + ")) {
            expression = input.split(" \\+ ");
            operation = '+';
        } else if (input.contains(" - ")) {
            expression = input.split(" - ");
            operation = '-';
        } else if (input.contains(" * ")) {
            expression = input.split(" \\* ");
            operation = '*';
        } else if (input.contains(" / ")) {
            expression = input.split(" / ");
            operation = '/';
        } else {
            throw new Exception("Знак действия неккоректен");
        }
        if (operation == '*' || operation == '/') {
            if (expression[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");

        }
        if (operation == '+' || operation == '-') {
            if (!expression[1].contains("\"")) throw new Exception("Можем сложить только строки");
        }
        if (expression[0].length() > 10 || expression[1].length() > 10)
            throw new Exception("Строки должны быть не более 10 символов");

        for (int i = 0; i < expression.length; i++) {
            expression[i] = expression[i].replace("\"", "");
        }


        if (operation == '+') {
            quotes(expression[0] + expression[1]);
        } else if (operation == '*') {
            int operand = Integer.parseInt(expression[1]);
            if (operand < 1 || operand > 10) throw new Exception("Числа должны быть от 1 до 10");
            String result = "";
            for (int i = 0; i < operand; i++) {
                result += expression[0];
            }
            quotes(result);
        } else if (operation == '-') {
            int index = expression[0].indexOf(expression[1]);
            if (index == -1) {
                quotes(expression[0]);
            } else {
                String result = expression[0].substring(0, index);
                result += expression[0].substring(index + expression[1].length());
                quotes(result);
            }
        } else {
            int x = Integer.parseInt(expression[1]);
            if (x < 1 || x > 10) throw new Exception("Числа должны быть от 1 до 10");
            int resultdevision = expression[0].length() / x;

            String result = expression[0].substring(0, resultdevision);
            quotes(result);
        }


    }

    static void quotes(String info) {
        if (info.length() > 40) {
            String rez = info.substring(0, 40);
            System.out.println("\"" + rez + "..." + "\"");
        } else System.out.println("\""+info+"\"");

    }
}

