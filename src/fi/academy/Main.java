package fi.academy;

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
        ArrayList<Topic> lista= new ArrayList<Topic>();

        while (true) {

            System.out.println("Kirjoita aihe, lopeta lopettaa");
            String title = lukija.readLine();
            pw.println("Aihe: " + title);

            if (title.equals("lopeta")) {
                break;
            }
                int id = ID(lukija, pw);

                String description = description(lukija, pw, "Syötä kuvaus:");

                String additionalSource = additionalSource(lukija, pw);

                boolean complete = complete(lukija, pw);

                LocalDate creationDate = localDate(lukija, pw, formatter);

                completionDate(lukija, pw, formatter);

                System.out.println("  ");

                pw.close();
                fw.close();

                Topic t = new Topic(id, title, description, additionalSource, complete, creationDate, null);
                lista.add(t);

            }

        //tulosta
        
        }

    private static void completionDate(BufferedReader lukija, PrintWriter pw, DateTimeFormatter formatter) throws IOException {
        System.out.println("Syötä valmistumispäivämäärä muodossa dd/mm/yyyy:");
        String date2 = lukija.readLine();
        LocalDate completionDate = LocalDate.parse(date2, formatter);
        pw.println(completionDate);
    }

    private static LocalDate localDate(BufferedReader lukija, PrintWriter pw, DateTimeFormatter formatter) throws IOException {
        System.out.println("Syötä aloituspäivämäärä muodossa dd/mm/yyyy:");
        String date = lukija.readLine();
        LocalDate creationDate = LocalDate.parse(date, formatter);
        pw.println(creationDate);
        return creationDate;
    }

    private static boolean complete(BufferedReader lukija, PrintWriter pw) throws IOException {
        System.out.println("Onko aiheen opiskelu kesken? true tai false.");
        boolean complete = Boolean.valueOf(lukija.readLine());
        if (complete == false) {
            pw.println("Onko asia kesken: tehty");
        } else {
            pw.println("Onko asia kesken: ei");
        }
        return complete;
    }

    private static String additionalSource(BufferedReader lukija, PrintWriter pw) throws IOException {
        System.out.println("Syötä lähde:");
        String additionalSource = lukija.readLine();
        pw.println(additionalSource);
        return additionalSource;
    }

    private static String description(BufferedReader lukija, PrintWriter pw, String s) throws IOException {
        System.out.println(s);
        String description = lukija.readLine();
        pw.println(description);
        return description;
    }


    private static int ID(BufferedReader lukija, PrintWriter pw) throws IOException {
        System.out.println("Syötä ID:");
        int id = Integer.valueOf(lukija.readLine());
        pw.println("ID: " + id);
        return id;
    }
}
