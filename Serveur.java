import java.io.*;
import java.net.*;

public class Serveur {
    static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket serveur = new ServerSocket(PORT)) {
            System.out.println("Serveur en attente sur le port " + PORT + "...");
            while (true) {
                try (Socket client = serveur.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                    System.out.println("Client connecté : " + client.getInetAddress());

                    String op1;
                    
                    while ((op1 = in.readLine()) != null) {
                        String operateur = in.readLine();
                        String op2 = in.readLine();
                        if (operateur == null || op2 == null) break;

                        System.out.println("Reçu : " + op1 + " " + operateur + " " + op2);
                        out.println(calculer(op1, operateur, op2));
                    }
                    System.out.println("Client déconnecté.");

                } catch (IOException e) {
                    System.out.println("Erreur client : " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }

    static String calculer(String s1, String operateur, String s2) {
        double a, b;
        try {
            a = Double.parseDouble(s1);
            b = Double.parseDouble(s2);
        } catch (NumberFormatException e) {
            return "Erreur : opérande invalide";
        }

        double resultat;
        switch (operateur) {
            case "+":
                resultat = a + b;
                break;
            case "-":
                resultat = a - b;
                break;
            case "*":
                resultat = a * b;
                break;
            case "/":
                if (b == 0) return "Erreur : division par zéro";
                resultat = a / b;
                break;
            default:
                return "Erreur : opérateur invalide";
        }

        return Double.toString(resultat);
    }
}