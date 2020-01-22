package fi.academy;

import fi.academy.Topic;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader lukija = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("Oppimispäiväkirja.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List lista = new ArrayList();

        System.out.println("Syötä ID:");
        String id = lukija.readLine();
        pw.println(id);

        System.out.println("Syötä nimi:");
        String title = lukija.readLine();
        pw.println(title);

        System.out.println("Syötä kuvaus:");
        String description = lukija.readLine();
        pw.println(description);

        System.out.println("Syötä lähde:");
        String additionalSource = lukija.readLine();
        pw.println(additionalSource);

        System.out.println("Onko aiheen opiskelu kesken? true tai false.");
        boolean complete = Boolean.valueOf(lukija.readLine());
        pw.println(complete);

        System.out.println("Syötä aloituspäivämäärä muodossa dd/mm/yyyy:");
        String date = lukija.readLine();
        LocalDate creationDate = LocalDate.parse(date, formatter);
        pw.println(creationDate);

        System.out.println("Syötä valmistumispäivämäärä muodossa dd/mm/yyyy:");
        String date2 = lukija.readLine();
        LocalDate completionDate = LocalDate.parse(date2, formatter);
        pw.println(completionDate);

        System.out.println("  ");

        pw.close();
        fw.close();

        //while //käyttäjän syöttämät tiedot tallettuu
        //Topic t = new Topic(id, title, description, additionalSource, complete, creationDate, completionDate);
        //lista.add(t);
        }

    }

