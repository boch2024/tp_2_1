import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    static final String HOTE = "localhost";
    static final int PORT = 1234;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOTE, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner clavier = new Scanner(System.in)) {

            System.out.println("Connecté au serveur. Saisissez une opération (ex: 55 * 25) ou 'quit'.");
            while (true) {
                System.out.print("> ");
                String saisie = clavier.nextLine().trim();
                if (saisie.equalsIgnoreCase("quit")) break;

           
                String[] parties = saisie.split("\\s+");
                if (parties.length != 3) {
                    System.out.println("Syntaxe incorrecte. Format attendu : <nombre> <+|-|*|/> <nombre>");
                    continue;
                }
                String op1 = parties[0];
                String operateur = parties[1];
                String op2 = parties[2]; 
                if (!(operateur.equals("+") || operateur.equals("-")
                   || operateur.equals("*") || operateur.equals("/"))) {
                    System.out.println("Opérateur invalide : utilisez + - * ou /");
                    continue;
                }

                out.println(op1);
                out.println(operateur);
                out.println(op2);

                String resultat = in.readLine();
                if (resultat == null) { System.out.println("Connexion fermée par le serveur."); break; }
                System.out.println("Résultat : " + resultat);
            }
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}