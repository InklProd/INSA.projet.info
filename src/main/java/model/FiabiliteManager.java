package model;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FiabiliteManager {
    private ArrayList<EvenementMaintenance> evenements = new ArrayList<>();

    public void chargerEvenements(String fichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fichier));
        String ligne;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy HH:mm");

        while ((ligne = reader.readLine()) != null) {
            if (ligne.trim().equals("") || ligne.startsWith("End Of File")) continue;

            String[] tokens = ligne.trim().split("\\s+");
            if (tokens.length < 6) continue;

            String dateStr = tokens[0];
            String heureStr = tokens[1].replace(":", "");
            String machine = tokens[2];
            String typeEvt = tokens[3];
            String operateur = tokens[4];
            String cause = tokens[5];

            LocalDateTime dateHeure = LocalDateTime.parse(dateStr + " " + heureStr, formatter);
            EvenementMaintenance evt = new EvenementMaintenance(dateHeure, machine, typeEvt, operateur, cause);
            evenements.add(evt);
        }

        reader.close();
    }

    public Map<String, Float> calculerFiabilites() {
        Map<String, List<EvenementMaintenance>> mapParMachine = new HashMap<>();

        for (EvenementMaintenance e : evenements) {
            mapParMachine.computeIfAbsent(e.getMachine(), k -> new ArrayList<>()).add(e);
        }

        Map<String, Float> fiabilites = new HashMap<>();

        for (String machine : mapParMachine.keySet()) {
            List<EvenementMaintenance> liste = mapParMachine.get(machine);
            liste.sort(Comparator.comparing(EvenementMaintenance::getDateHeure));

            float totalFonctionnement = 0;
            LocalDateTime dernierDebut = null;

            for (EvenementMaintenance e : liste) {
                if (e.getTypeEvenement().equals("A")) {
                    dernierDebut = e.getDateHeure();
                } else if (e.getTypeEvenement().equals("D") && dernierDebut != null) {
                    Duration d = Duration.between(dernierDebut, e.getDateHeure());
                    totalFonctionnement += d.toMinutes();
                    dernierDebut = null;
                }
            }

            float dureeTotale = 14 * 60; // 14h par jour en minutes
            fiabilites.put(machine, totalFonctionnement / dureeTotale);
        }

        return fiabilites;
    }

    public void afficherClassement(Map<String, Float> fiabilites) {
        fiabilites.entrySet().stream()
            .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
            .forEach(entry -> System.out.println("Machine: " + entry.getKey() +
                    " | Fiabilité: " + String.format("%.2f", entry.getValue())));
    }
}
