package fh;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class GraphicUserInterface extends JFrame{
	
	public GraphicUserInterface(){
		
        JFrame meinJFrame = new JFrame();
        meinJFrame.setTitle("Rum Service");
        meinJFrame.setSize(250, 250);
        JPanel chooseBuilding = new JPanel();//
 
        JLabel frage = new JLabel("Aus welchem Bundesland kommst du?");
        chooseBuilding.add(frage);
 		
        // Array für unsere JComboBox
        String comboBoxListe[] = {"Baden-Württemberg", "Bayern",
            "Berlin", "Brandenburg", "Bremen",
            "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
            "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
            "Saarland", "Sachsen", "Sachsen-Anhalt",
            "Schleswig-Holstein", "Thüringen"};
 
        //JComboBox mit Bundesländer-Einträgen wird erstellt
        JComboBox bundeslandAuswahl = new JComboBox(comboBoxListe);
 
        //JComboBox wird Panel hinzugefügt
        chooseBuilding.add(bundeslandAuswahl);
 
        meinJFrame.add(chooseBuilding);
        meinJFrame.setVisible(true);
		
	}


	
	
}
