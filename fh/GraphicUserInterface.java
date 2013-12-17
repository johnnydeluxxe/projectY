package fh;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GraphicUserInterface extends JFrame{
	
	//LoginScreen
	JFrame loginScreen = new JFrame();
	// Labels
	JLabel loginName = new JLabel();
	JLabel loginPassword = new JLabel();
	JLabel anzeige = new JLabel("WILLKOMMEN");
	// Buttons
	JButton loginBtnCheck = new JButton();
	JButton loginBtnCls = new JButton();
	// Textfelder
	JTextField loginTextBN = new JTextField();
	JTextField loginTextPW = new JTextField();
	
	//DatabaseScreen
	private JFrame DatabaseView = new JFrame();
	// Combobox
	private JComboBox buildingSelective = new JComboBox(new Object[] {"A","B","C","D","E","F","G","H","M","L","O","Mensa","Bibliothek"});
	
	public GraphicUserInterface(){
		
		String[] buildingSelectiveValue = DataProcessing.check;

        loginScreen.setTitle("Rum Service");
        loginScreen.setSize(500, 500);
        
        loginScreen.setVisible(true);
        
        loginScreen.setLayout(null);
		loginScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
		loginScreen.setTitle("Anmelde Fenster");
		loginScreen.setSize(400, 300);
		loginScreen.setLocationRelativeTo(null);
		loginScreen.setVisible(true);
		
		anzeige.setBounds(20, 10, 400, 30);
		//Border border = LineBorder.createGrayLineBorder();
		Font myfont = new Font("Myriad Pro",Font.BOLD ,24);
		anzeige.setFont(myfont);
		loginScreen.add(anzeige);
		
		loginName.setBounds(20, 50, 300, 20);
		//loginName.setBorder(border);
		loginName.setText("Geben Sie hier bitte Ihren Benutzernamen ein:");
		loginScreen.add(loginName);

		loginTextBN.setBounds(20, 80, 150, 20);
		loginScreen.add(loginTextBN);

		loginPassword.setBounds(20, 110, 300, 20);
		loginPassword.setText("Geben Sie hier bitte Ihr Passwort ein:");
		//loginPassword.setBorder(border);
		loginScreen.add(loginPassword);

		loginTextPW.setBounds(20, 140, 150, 20);
		loginScreen.add(loginTextPW);
		
		loginBtnCls.setBounds(20, 170, 80, 22);
		loginBtnCls.setText("Close");
		loginScreen.add(loginBtnCls);
		
		loginBtnCheck.setBounds(110, 170, 80, 22);
		loginBtnCheck.setText("Login");
		loginScreen.add(loginBtnCheck);
		
		DatabaseView.setLayout(null);
		DatabaseView.setDefaultCloseOperation(EXIT_ON_CLOSE);
		DatabaseView.setTitle("DatabaseView Rum Service");
		DatabaseView.setSize(800, 600);
		DatabaseView.setLocationRelativeTo(null);
		DatabaseView.setVisible(false);
		
		loginBtnCls.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		loginBtnCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MySQLConnection loginvalidation = new MySQLConnection();
				String isValid = loginvalidation.checkLoginData(loginTextBN.getText(), loginTextPW.getText());
				
				if (isValid == "Richtig"){
					loginScreen.setVisible(false);
					DatabaseView.setVisible(true);
				}else{					
					JOptionPane.showMessageDialog(loginScreen, "Logindaten sind nicht Korrekt!");
					
				}
			}
		});
		
		
			
		//DatabaseView.add(buildingSelective);
		DatabaseView.add( buildingSelective, BorderLayout.NORTH );
        
		
		/*
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
		*/
	}


	
	
}
