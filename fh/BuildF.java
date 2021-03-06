package fh;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;

public class BuildF {
	
	BuildF(){
		//KONSTRUKTOR	
	}
	
	public static void updateRum022(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Geben Sie die Zeit ein, zu welcher die Werte gebucht werden sollen:");
		String time = userInput.next();
		System.out.println("Geben Sie den Wert für Montag um " + time + "ein: ");
		String montag = userInput.next();
		System.out.println("Geben Sie den Wert für Dienstag um " + time + "ein: ");
		String dienstag = userInput.next();
		System.out.println("Geben Sie den Wert für Mittwoch um " + time + "ein: ");
		String mittwoch = userInput.next();
		System.out.println("Geben Sie den Wert für Donnerstag um " + time + "ein: ");
		String donnerstag = userInput.next();
		System.out.println("Geben Sie den Wert für Freitag um " + time + "ein: ");
		String freitag = userInput.next();
		System.out.println("Geben Sie den Wert für Samstag um " + time + "ein: ");
		String samstag = userInput.next();
		System.out.println("Geben Sie den Wert ein ob der Vorlesungsraum in um " + time + "offen ist: ");
		String offen = userInput.next();
		MySQLConnection.changeSevenValues("rum022", time, montag, dienstag, mittwoch, donnerstag, freitag, samstag, offen);
	}
	
	
	
	public static void printRum022(String day){
		
		ResultSet rsDay = MySQLConnection.printDay("rumF022", day);
		ResultSet rsZeit = MySQLConnection.printZeit("rumF022");
		TimeTable zeitMaster = new TimeTable("rumF022", day);
		
		String[][] stringZeitRaster = new String[6][51];
		boolean[][] belegung = new boolean[6][51];
		
		if (rsDay != null){
			try {
				int i = 0;
				while (rsDay.next()) {
					
				    int montag = rsDay.getInt(day);
				    int name = montag;
				    //System.out.println(name);
				    if(name == 0){belegung[0][i] = false;}
				    if(name == 1){belegung[0][i] = true;}
				    if(name == -10){belegung[0][i] = false;}
				    if(name == -11){belegung[0][i] = true;}
				    i++;	
				}
			} catch (SQLException e1) {
				e1.printStackTrace();//
			}	
		}
		
		if (rsZeit != null){
			try{
				int i = 0;
				while(rsZeit.next()) {
					String zeit = rsZeit.getString("Zeit");
					
					stringZeitRaster[0][i] = zeit;
					i++;
				}
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			
		}
		
		for(int i = 0; i <= 50 ; i++){
			System.out.println(stringZeitRaster[0][i] + " Uhr: " + belegung[0][i]);	
		}
		
		//Zeit-Verarbeitung
		/*
		SimpleDateFormat format = new SimpleDateFormat("E#dd.MM.yyyy#HH.mm");
		String dayDateTime = format.format(Calendar.getInstance().getTime());
		String[] breakup = dayDateTime.split( Pattern.quote( "#" ) );
		//System.out.println( Arrays.toString(breakup) ); // [Tag, Datum, Zeit]
		//System.out.println(breakup[1]);
		
		Double.parseDouble(breakup[2]);
		System.out.println(breakup[2]);
		
		double achtDreissig = 830.0D;
		
		int lecture = 0;
		
		if (zeitMaster.DoubleArray(0, 0) < achtDreissig && achtDreissig < zeitMaster.DoubleArray(0, 3)) {
			if (zeitMaster.BooleanArray(1, 0) && zeitMaster.BooleanArray(1, 1) && zeitMaster.BooleanArray(1, 2)&& zeitMaster.BooleanArray(1, 3)){
				lecture = 0;
			}else{
				lecture = 1;
			}
		}else if(zeitMaster.DoubleArray(0, 4) < achtDreissig && achtDreissig < zeitMaster.DoubleArray(0, 7)){
			
		}
		
		
		
		System.out.println(zeitMaster.DoubleArray(1, 3));
		if (lecture == 0){
			double timeDif = zeitMaster.DoubleArray(1, 3) - achtDreissig; 
			System.out.println("Der Raum ist noch für " + timeDif + " geöffnet.");
		}else if (lecture == 1){
			System.out.println("Raum hat Vorlesung.");
		}
		*/
		
		
	}
	
}
