import java.util.Scanner;

public class CalculatriceConsole {
    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculatrice");
        System.out.print("Entrez le 1er nombre : ");
        int a = scanner.nextInt();

        System.out.print("Entrez le 2e nombre : ");
        int b = scanner.nextInt();

        System.out.println("Choisissez l'opération (+, -, /) : ");
        String op = scanner.next();

        try {
            int result;
            switch (op) {
                case "+":
                    result = calc.additionner(a, b);
                    break;
                case "-":
                    result = calc.soustraire(a, b);
                    break;
                case "/":
                    result = calc.diviser(a, b);
                    break;
                default:
                    System.out.println("Opération non reconnue");
                    return;
            }
            System.out.println("Résultat : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

// java -cp bin CalculatriceConsole