package project1b;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Nome do professor? ");
        String nome = s.next();
        System.out.print("Quantos anos de experiência ele tem? ");
        int experiencia = s.nextInt();
        Professor p = new Professor(nome, experiencia);
        System.out.println(p.toString());
        System.out.println(p.classifica());
        s.close();
    }
}
