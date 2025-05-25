package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.List;
import model.Machine;
import model.Atelier;

public class Map {
    public void afficherCarte(Atelier atelier) {
        JFrame frame = new JFrame("Carte des Machines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        List<Machine> machines = atelier.getAllMachines();
        for (Machine machine : machines) {
            JLabel machineLabel = new JLabel(machine.getRefMachine());
            machineLabel.setBounds((int) machine.getX(), (int) machine.getY(), 100, 20); // Position et taille
            panel.add(machineLabel);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}
