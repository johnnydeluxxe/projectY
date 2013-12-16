package fh;

public class DataProcessing {
	
	DataProcessing(){
		//Konstruktor
	}
	
	protected static final String[] check = {"A","B","C","D","E","F","G","H","M","L","O","Mensa","Bibliothek"};
	protected static final String[] time = new String[51];
	
	public static String getCheck(int i) {
		return check[i];
	}
	public static String getTime(int i) {
		return time[i];
	}
	
	//Hier wird die Auswahl des Gebäudes ausgewertet und mit dem array "check" verglichen. Das ergebnis wird als int zurückgegeben. 
	public static int auswahlVerarbeitung(String building){
		int checkFinal = 5; // Für Standard Gebäude F
		for(int i = 0; i < check.length; i++){
			if(check[i] == building){
			checkFinal = i;	
			
			}else{}
			
		}
		return 	checkFinal;//
	}
	
	//Ausgelesener Wert von englischen und deutschen Systemen in Wochentag Deutsch Konvertieren: Mo oder Mon --> Montag
	public String convertWeekDays(String breakup[], String day){
		String montag = "Mo";
		String dienstag = "Di";
		String mittwoch = "Mi";
		String donnerstag = "Do";
		String freitag = "Fr";
		String samstag = "Sa";
		String sonntag = "So";
		
		String monday = "Mon";
		String tuesday = "Tue";
		String wednesday = "Wed";
		String thursday = "Thu";
		String friday = "Fri";
		String saturday = "Sat";
		String sunday = "Sun";
		
		if (breakup[0].hashCode() == montag.hashCode() || breakup[0].hashCode() == monday.hashCode()){
			day = "Montag";
		}
		if (breakup[0].hashCode() == dienstag.hashCode() || breakup[0].hashCode() == tuesday.hashCode()){
			day = "Dienstag";
		}
		if (breakup[0].hashCode() == mittwoch.hashCode() || breakup[0].hashCode() == wednesday.hashCode()){
			day = "Mittwoch";
		}
		if (breakup[0].hashCode() == donnerstag.hashCode() || breakup[0].hashCode() == thursday.hashCode()){
			day = "Donnerstag";
		}
		if (breakup[0].hashCode() == freitag.hashCode() || breakup[0].hashCode() == friday.hashCode()){
			day = "Freitag";
		}
		if (breakup[0].hashCode() == samstag.hashCode() || breakup[0].hashCode() == saturday.hashCode()){
			day = "Samstag";
		}
		if (breakup[0].hashCode() == sonntag.hashCode() || breakup[0].hashCode() == sunday.hashCode()){
			day = "Sonntag";
		}
		return day;
	}
	
	
}
