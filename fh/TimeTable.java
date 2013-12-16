package fh;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeTable {
	
	private ResultSet rsZeit;
	
	TimeTable(){
		rsZeit = MySQLConnection.printZeit("rum022"); 	// Raum "rum022" wird verwendet da dies eine sichere Zeitquelle ist. Darf momentan nicht 
	}													// verändert werden.
	
	// Zeit auslesen und Wert an stelle "a" und stelle "b" in String-Array speichern
	public String StringArray(int a, int b) { 
		String[][] stringZeitRaster = new String[6][51];
		String stringWert = null;
		if (rsZeit != null){
			try{
				int i = 0;
				while(rsZeit.next()) {
					String zeit = rsZeit.getString("Zeit");
					
					stringZeitRaster[0][i] = zeit;
					i++;
				}
			} catch (SQLException e1){//
				e1.printStackTrace();
			}
			stringWert = stringZeitRaster[a][b];
		}
		return stringWert;
	}
	
	//Zeit auslesen und Wert an stelle "a" und stelle "b" in Boolean-Array speichern
	public boolean BooleanArray(int a, int b) {	
		boolean[][] boolZeitRaster = new boolean[6][51];
		boolean booleanWert = false;
		if (rsZeit != null){
			try{
				int i = 0;
				while(rsZeit.next()) {
					boolean zeit = rsZeit.getBoolean("Zeit");
					
					boolZeitRaster[0][i] = zeit;
					i++;
				}
			}catch (SQLException e1){
				e1.printStackTrace();
			}
			booleanWert = boolZeitRaster[a][b];
		}
		return booleanWert;
	}
	
	//Zeit auslesen und Wert an stelle "a" und stelle "b" in Double-Array speichern
	public double DoubleArray(int a, int b) {
		double[][] doubleZeitRaster = new double[6][51];
		double doubleWert = 0.0D;
		if (rsZeit != null){
			try{
				int i = 0;
				while(rsZeit.next()) {
					double zeit = rsZeit.getDouble("Zeit");
					
					doubleZeitRaster[0][i] = zeit;
					i++;
				}
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			doubleWert = doubleZeitRaster[a][b];
		
		}
		return doubleWert;
	}
	
	//Zeit ganz auslesen und jeden Wert in ein String Array einlesen. Dieses wird zurückgegeben.
	public String[] fullTimeArrayReturn(){
		String[] zeitRaster = new String[51];
		
		if (rsZeit != null){
			try{
				int i = 0;
				while(rsZeit.next()) {
					String zeit = rsZeit.getString("Zeit");
					zeitRaster[0] = zeit;
					i++;
				}
			} catch (SQLException e1){//
				e1.printStackTrace();
			}	
		}
		return zeitRaster;
	}
}

