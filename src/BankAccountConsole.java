import java.util.Scanner;

public class BankAccountConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("BankAccount");

        while (account == null) {
            System.out.print("Nom du titulaire : ");
            String owner = scanner.nextLine();

            System.out.print("Solde initial : ");
            double solde = scanner.nextDouble();
            scanner.nextLine(); // flush

            try {
                account = new BankAccount(owner, solde);
                System.out.println("Compte créé !");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Voir solde");
            System.out.println("2. Dépôt");
            System.out.println("3. Retrait");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choix) {
                    case 1:
                        System.out.println("Solde actuel : " + account.getBalance() + " €");
                        break;
                    case 2:
                        System.out.print("Montant à déposer : ");
                        double depot = scanner.nextDouble();
                        scanner.nextLine(); 
                        account.deposit(depot);
                        System.out.println("Dépôt effectué !");
                        break;
                    case 3:
                        System.out.print("Montant à retirer : ");
                        double retrait = scanner.nextDouble();
                        scanner.nextLine(); 
                        account.withdraw(retrait);
                        System.out.println("Retrait effectué");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Choix invalide");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}
