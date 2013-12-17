package fh;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MAIN {

	public static void main(String[] args) {
		
		GraphicUserInterface gui = new GraphicUserInterface();
		Scanner userInput = new Scanner(System.in);
		DataProcessing weekCheck = new DataProcessing();
		SimpleDateFormat format = new SimpleDateFormat("E#dd.MM.yyyy#HH:mm:ss");
		String day = null;
		String dayDateTime = format.format(Calendar.getInstance().getTime());
		String[] breakup = dayDateTime.split( Pattern.quote( "#" ) );
		day = breakup[0];
		day = weekCheck.convertWeekDays(breakup, day);
		boolean run = true;
		while(run == true){
			System.out.println("Was möchten Sie tun?"
					+ "\n.............."
					+ "\n1: Raum abfragen"
					+ "\n2: Raum updaten (alle Werte)"
					+ "\n3: Neue Tabelle anlegen"
					//+ "\n4: Hier könnte Ihre Werbung stehen"
					//+ "\n5: Hier könnte Ihre Werbung stehen"
					//+ "\n6: Hier könnte Ihre Werbung stehen"
					+ "\n7: Close");
	    	int eingabe = userInput.nextInt();
	    	int verwertung = 0;
	    	String building = null;
			switch(eingabe){
				case 1:
					//Variable eingabe des Gebäudes und Raumes.
					System.out.println("Bitte geben Sie an welches Gebäude: ");
					building = userInput.next();
					System.out.println("Bitte geben Sie nun den Raum des Gebäudes an: ");
					int selectRum = userInput.nextInt();
					verwertung = DataProcessing.auswahlVerarbeitung(building);
					System.out.println("Die verwertung ist " + verwertung);
					switch(verwertung){
						case 0:
							break;
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							if(selectRum == 22){
								BuildF.printRum022(day);
							}
							System.out.println("\n\n");
							break;
						case 6:
							break;
						case 7:
							break;
						case 8:
							break;
						case 9:
							break;
						case 10:
							break;
						case 11:
							break;
					}
						break;
				case 2:
					System.out.println("\n\nWillkommen bei dem UserDatabaseInputSystem: \n"
							+ "-------------------------------------- \n"
							+ "-Bitte denken Sie zuerst nach bevor Sie Daten eingeben.\n"
							+ "-------------------------------------- \n"
							+ "\nBitte geben Sie als erstes das Gebäude an: ");
					//String date = breakup[1];
					//String time = breakup[2];
					building = userInput.next();
					System.out.println("\nBitte geben Sie nun den Raum an: ");
					selectRum = userInput.nextInt();
					verwertung = DataProcessing.auswahlVerarbeitung(building);
					System.out.println("Die verwertung ist " + verwertung);
					switch(verwertung){
						case 0:
							System.out.println("Case 0");
							break;
						case 1:
							System.out.println("Case 1");
							break;
						case 2:
							System.out.println("Case 2");
							break;
						case 3:
							System.out.println("Case 3");
							break;
						case 4:
							System.out.println("Case 4");
							break;
						case 5:
							if(selectRum == 22){
								BuildF.updateRum022();
							}
							System.out.println("\n\n");
							break;
						case 6:
							System.out.println("Case 6");
							break;
						case 7:
							System.out.println("Case 7");
							break;
						case 8:
							System.out.println("Case 8");
							break;
						case 9:
							System.out.println("Case 9");
							break;
						case 10:
							System.out.println("Case 10");
							break;
						case 11:
							System.out.println("Case 11");
							break;
						default:
							System.out.println("Switch Ende");
					}
					
				
					System.out.println("\n\n");
					break;
				case 3:
					System.out.println("Bitte geben Sie den Namen der Tabelle an: ");
					String tableName = userInput.next();
					System.out.println("Geben Sie den Raum an: ");
					String rum = userInput.next();
					MySQLConnection.createTable(tableName, rum, breakup[0]);
					break;
				case 4:
					System.out.println(DataProcessing.check[1]);
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					System.out.println("bye bye");
					System.exit(0);
					break;
				default:
					System.out.println("Falsche Eingabe!");
					
			}
		}

	}

}
