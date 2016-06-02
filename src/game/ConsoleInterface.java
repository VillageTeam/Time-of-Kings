package game;

import java.io.IOException;

public abstract class ConsoleInterface {

	private static java.util.Scanner scanner;

	public static void main(String[] args) {
		try {
			Update.checkUpdate();
		} catch (IOException e) {
			System.err.println("Error: " + e);
		}
		System.out.println("Herzlich willkommen!");
		System.out.println("Brauchst du Hilfe? -> Optionen");
		System.out.println("Version: Alpha Test, 0.2");
		System.out.println("");
		System.out.println("Patchnotes:");
		System.out.println("Neuer Geb\u00e4udetyp: Wohnhaus!");
		System.out.println("Baue jetzt deine Wohnh\u00e4user mit 'Wohnhaus bauen'.");
		System.out.println("");
		System.out.println("Hotfix 1");
		System.out.println("Neue Funktion: 'Ressourcen sammeln', sammelt deine Ressourcen");
		System.out.println("Bugfixes: Geb\u00e4ude nun auch in den \u00e4u\u00dferen rechten Teil setzbar!");
		System.out.println("Au\u00dferdem ist die 'Bewegen' Funktion nun nicht mehr verbugt und funktioniert einwandfrei!");
		System.out.println("Auch die Level Up Funktion funktioniert jetzt.");
		System.out.println("Falscheingaben von Benutzern werden jetzt abgefangen.");
		System.out.println("");
		System.out.println("Viel Spa\u00df!!");
		
		while( true ){
			System.out.println("");
			System.out.println( "Was willst du tun?" );
			String in = enter();
			if( in.equals( "Spieler erstellen" ) ){
				UserInterface.createPlayer();
			}else if( in.equals( "Admin erstellen" ) ){
				UserInterface.createAdmin();
			}else if(in.equals("Saegewerk bauen")){
				System.out.println("Wo soll das S\u00e4gewerk stehen?");
				System.out.println("X-Koordinate(zwischen 0 und 39):");
				int locationX = enterInt();
				System.out.println("Y-Koordinate (zwischen 0 und 9):");
				int locationY = enterInt();
				UserInterface.npBuildLumbermill(locationX, locationY);
			}else if(in.equals("Steinbruch bauen")){
				System.out.println("Wo soll der Steinbruch stehen?");
				System.out.println("X-Koordinate(zwischen 0 und 39):");
				int locationX = enterInt();
				System.out.println("Y-Koordinate (zwischen 0 und 9):");
				int locationY =enterInt();
				UserInterface.npBuildQuarry(locationX, locationY);
			}else if( in.equals("Mine bauen")){
				System.out.println("Wo soll die Mine stehen?");
				System.out.println("X-Koordinate(zwischen 0 und 39):");
				int locationX = enterInt();
				System.out.println("Y-Koordinate (zwischen 0 und 9):");
				int locationY =enterInt();
				UserInterface.npBuildMine(locationX, locationY);
			}else if( in.equals("Lager bauen")){
				System.out.println("Wo soll das Lager stehen?");
				System.out.println("X-Koordinate(zwischen 0 und 39):");
				int locationX = enterInt();
				System.out.println("Y-Koordinate (zwischen 0 und 9):");
				int locationY =enterInt();
				UserInterface.npBuildStorage(locationX, locationY);
			}else if( in.equals("Wohnhaus bauen")){
				System.out.println("Wo soll das Wohnhaus stehen?");
				System.out.println("X-Koordinate(zwischen 0 und 39):");
				int locationX = enterInt();
				System.out.println("Y-Koordinate (zwischen 0 und 9):");
				int locationY =enterInt();
				UserInterface.npBuildApartment(locationX, locationY);
			}else if( in.equals("Level Up")){
				System.out.println("Welches Geb\u00e4ude willst du aufwerten?");
				String building = enter();
				UserInterface.npLevelUp(building);
			}else if(in.equals("Bewegen")){
				System.out.println("Welches Geb\u00e4ude willst du bewegen?");
				String building = enter();
				System.out.println("Zu welcher X-Koordinate soll es bewegt werden (0 bis 39)?");
				int locationX = enterInt();
				System.out.println("Zu welcher Y-Koordinate soll es bewegt werden (0 bis 9)");
				int locationY = enterInt();
				UserInterface.npMove(building, locationX, locationY);
			}else if( in.equals("Speichern")){
				UserInterface.savePlayer();
			}else if(in.equals("Ressourcen sammeln")){
				UserInterface.npCollect();
			}else if( in.equals("Laden")){
				UserInterface.loadPlayer();
			}else if(in.equals("Optionen")){
				System.out.println("1. Spieler erstellen");
				System.out.println("2. Saegewerk bauen");
				System.out.println("3. Steinbruch bauen");
				System.out.println("4. Mine bauen");
				System.out.println("5. Lager bauen");
				System.out.println("6. Wohnhaus bauen");
				System.out.println("7. Level Up");
				System.out.println("8. Bewegen");
				System.out.println("9. Ressourcen sammeln");
				System.out.println("10. Speichern");
				System.out.println("11. Laden");
				System.out.println("12. Ende");
			}else if( in.equals("Ende") ){
				System.exit(0);
			}else{
				System.err.println("Unbekannt");
				System.out.println("Brauchst du Hilfe?");
				System.out.println("'Optionen' zeigt dir alle Features");
			}
		}
	}
	
	private static String enter(){
		scanner = new java.util.Scanner(System.in);
		String in = scanner.nextLine();
		return in;
	}
	
	private static int enterInt(){
		int value;
		value = -1;
		scanner = new java.util.Scanner(System.in);
		while ( value == -1){
			String value2;
			value2 = scanner.nextLine();
			try{
				value = Integer.parseInt( value2 );	
			}catch(java.lang.NumberFormatException e){
				System.err.println("Keine ganze Zahl eingegeben");
				System.out.println("");
			}
		}
		return value;
	}
}
