package model;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FiabiliteManager {
    private ArrayList<EvenementMaintenance> evenements = new ArrayList<>();
    private Map<String, Machine> machines = new HashMap<>();
    private Map<String, Float> fiabilites = new HashMap<>();

    public void ajouterMachine(Machine machine) {
        machines.put(machine.getRefEquipement(), machine);
    }

    public void chargerEvenements(String fichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fichier));
        String ligne;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy HH:mm");

        while ((ligne = reader.readLine()) != null) {
            if (ligne.trim().equals("") || ligne.startsWith("End Of File")) continue;

            String[] tokens = ligne.trim().split(";");
            if (tokens.length < 6) continue;

            String dateStr = tokens[0];
            String heureStr = tokens[1];
            String refMachine = tokens[2];
            String typeEvt = tokens[3];
            String operateur = tokens[4];
            String cause = tokens[5];

            LocalDateTime dateHeure = LocalDateTime.parse(dateStr + " " + heureStr, formatter);
            Machine machine = machines.get(refMachine);
            if (machine == null) {
                machine = new Machine(refMachine, "", "", 0, 0, 0);
                machines.put(refMachine, machine);
            }
            EvenementMaintenance evt = new EvenementMaintenance(dateHeure, machine, typeEvt, operateur, cause);
            evenements.add(evt);
        }

        reader.close();
    }

    public Map<String, Float> calculerFiabilites() {
        Map<Machine, List<EvenementMaintenance>> mapParMachine = new HashMap<>();
        for (EvenementMaintenance e : evenements) {
            mapParMachine.computeIfAbsent(e.getMachine(), k -> new ArrayList<>()).add(e);
        }
        for (Machine machine : mapParMachine.keySet()) {
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
            float dureeTotale = 14 * 60;
            fiabilites.put(machine.getRefEquipement(), totalFonctionnement / dureeTotale);
        }
        return fiabilites;
    }

    public void afficherClassement(Map<String, Float> fiabilites) {
        fiabilites.entrySet().stream()
            .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
            .forEach(entry -> {
            });
    }
}

