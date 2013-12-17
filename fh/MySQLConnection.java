package fh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.String;

public class MySQLConnection {
	
	private static Connection conn = null;
	 
    // Hostname
    private static String dbHost = "www.marchofer.net";
 
    // Port -- Standard: 3306
    private static String dbPort = "3306";
 
    // Datenbankname
    private static String database = "d018e19d";
 
    // Datenbankuser
    private static String dbUser = "d018e19d";
 
    // Datenbankpasswort
    private static String dbPassword = "JoAXyzXMV82XK6Wg";
 
    MySQLConnection() {
        try {
            // Datenbanktreiber für ODBC Schnittstellen laden.
            // Für verschiedene ODBC-Datenbanken muss dieser Treiber
            // nur einmal geladen werden.
        	Class.forName("com.mysql.jdbc.Driver");
        	System.out.println("Treiber erfolgreich geladen... ");
            // Verbindung zur ODBC-Datenbank 'sakila' herstellen.
            // Es wird die JDBC-ODBC-Brücke verwendet.
            conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
                    + dbPort + "/" + database + "?" + "user=" + dbUser + "&"
                    + "password=" + dbPassword);
            System.out.println("Verbindung erfolgreich hergestellt.");
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler beim Laden des Treibers!" + e);
            System.exit(0); //Abbruch des Programms
        } catch (SQLException e) {
            System.out.println("Verbinung konnte nicht hergestellt werden! " + e);
        }
    }
     
    private static Connection getInstance(){
        if(conn == null)
            new MySQLConnection();
        return conn;
    }
    
    public String checkLoginData(String bnName, String bnPassword){
    	
    	conn = getInstance();
        
        if(conn != null)
        {
            // Anfrage-Statement erzeugen.
            Statement query;
            try {
                query = conn.createStatement();
		    	//Boolean validation = false;
		    	String user = null;
		    	String userpassword = null;
		    	String sql = "SELECT * FROM userlogin WHERE loginname = '" + bnName +"'";
                ResultSet result1 = query.executeQuery(sql);
                while (result1.next()) {
                	user = result1.getString("loginname");
                	userpassword = result1.getString("loginpwd"); // Alternativ: result1.getString(1);
                }
                
		    	if (bnName.equals(user)){
					if (bnPassword.equals(userpassword)){
						return "Richtig";
					}
					else{	
						return "Falsch";
					}
					
				} 
				else{
					return "Falsch";
				}
            } catch (SQLException e) {
                //e.printStackTrace();
                System.out.println("Filme konnten nicht ausgegeben werden. Fehler: " + e);
                System.exit(0); //Abbruch des Programms
            }
        }
		return "Fehler";
    	
    }
    
    public static ResultSet printZeit(String rum){
    	conn = getInstance();
    	
    	if(conn != null){
    		Statement query;
    		try{
    			query = conn.createStatement();
    			
    			String sql = "SELECT Zeit " + "FROM rumF022";
    			ResultSet result = query.executeQuery(sql);
    			
    			return result;
    		} catch (SQLException e){
    			System.out.println("Daten konnten nicht abgerufen werden. Fehler: " + e);
    			System.exit(0);
    		}
    	}
    	return null;
    }
    
    public static ResultSet printDay(String rum, String tag){
        conn = getInstance();
         
        if(conn != null)
        {
            // Anfrage-Statement erzeugen.
            Statement query;
            try {
                query = conn.createStatement();
 
                // Ergebnistabelle erzeugen und abholen.
                String sql = "SELECT " + tag + " FROM " + rum;
                ResultSet result = query.executeQuery(sql);
                
                return result;
                // Ergebnissätze durchfahren.
                
            } catch (SQLException e) {
                //e.printStackTrace();//
                System.out.println("Daten konnten nicht abgerufen werden. Fehler: " + e);
                System.exit(0); //Abbruch des Programms
            }
        }
		return null;
    }
    
    public static ResultSet printDienstag(String rum){
        conn = getInstance();
        
        if(conn != null)
        {
            // Anfrage-Statement erzeugen.
            Statement query;
            try {
                query = conn.createStatement();
 
                // Ergebnistabelle erzeugen und abholen.
                String sql = "SELECT Dienstag " + "FROM rumF022";
                ResultSet result = query.executeQuery(sql);
                
                return result;
                // Ergebnissätze durchfahren.
                
            } catch (SQLException e) {
                //e.printStackTrace();
                System.out.println("Daten konnten nicht abgerufen werden. Fehler: " + e);
                System.exit(0); //Abbruch des Programms
            }
        }
		return null;
    	
    }
    
    public static void changeSevenValues(String rum, String time, String montag, String dienstag, 
    		String mittwoch, String donnerstag, String freitag, String samstag, String offen){
    	
        conn = getInstance();
         
        if(conn != null)
        {
            // Anfrage-Statement erzeugen.
            Statement query;
            try {
                query = conn.createStatement();
                 
                String querySql = "SELECT * FROM " + rum + " WHERE Zeit = " + time;
                ResultSet result = query.executeQuery(querySql);
                 
                if(result.next())
                {
                    // Vorher
                    System.out.println("VORHER: (" + result.getString(1) + ")" + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) 
                    		+ " " + result.getString(5) + " " + result.getString(6) + " " + result.getString(7) + " " + result.getString(8));
                }
 
                // Ergebnistabelle erzeugen und abholen.
                String updateSql = "UPDATE " + rum + " SET Montag = '" + montag + "', Dienstag = '" + dienstag + "', Mittwoch = '" + mittwoch + "',"
                		+ "Donnerstag = '" + donnerstag + "', Freitag = '" + freitag + "', Samstag = '" + samstag + "', Offen = '" + offen + "' WHERE Zeit = " + "'" + time + "'";
                query.executeUpdate(updateSql);
                 
                // Es wird der letzte Datensatz abgefragt
                result = query.executeQuery(querySql);
                 
                if(result.next())
                {
                    System.out.println("NACHHER: (" + result.getString(1) + ")" + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) 
                    		+ " " + result.getString(5) + " " + result.getString(6) + " " + result.getString(7) + " " + result.getString(8));
                }
                 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createTable(String tableName, String rum, String day){
    	TimeTable getTime = new TimeTable(rum, day);
    	String[] time = getTime.fullTimeArrayReturn();
    	conn = getInstance();
        if(conn != null)
        {
            // Anfrage-Statement erzeugen.
            Statement query;
            try {
                query = conn.createStatement();
                // Ergebnistabelle erzeugen und abholen.
                String createSql = "CREATE TABLE " + tableName + " "
                		+ "(Zeit VARCHAR(255), "
                		+ "Montag TINYINT(1), "
                		+ "Dienstag TINYINT(1), "
                		+ "Mittwoch TINYINT(1), "
                		+ "Donnerstag TINYINT(1), "
                		+ "Freitag TINYINT(1), "
                		+ "Samstag TINYINT(1), "
                		+ "Offen TINYINT(1));";
                query.execute(createSql);             
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
    }
}
