package de.girlsday;

public class StringForSwagger {
	/*
	 * Param for more methodes 
	 */
	public static final String nameParam = "name";

	
	/*
	 * USerController Swagger Notation
	 */
	//method Registrieren
	public static final String loginDescription = "neue eindeutig Benutzer einlegen damit man im der App sich registriert kann";
	public static final String loginTitel = "Benutzer Registrieren";
	public static final String loginParamDescription = "Name von dem Benutzer die man Registrieren will";
	public static final String loginPath = "/registrieren";
	/*
	 * TimelineControllen
	 */
	//method get my own timeline 
	public static final String timelineGetDescription = "Aktivitäten Verlauf für die Benutzer mit dem name als parameter anzeigen";
	public static final String timelineGetTitel = "Aktivitäten Verlauf";
	public static final String timelineGetPath = "/aktivitaeten";
	public static final String timelineParamGetDescription = "Name von dem benutzer wo man die Verlaufen sehen will";
	
	//method post TimelineItem
	
	public static final String timelinePostDescription = "Posten aktivitat";
	public static final String timelinePostTitel = "Posten Aktivität";
	public static final String timelinePostPath = "/posten";
	public static final String timelineParamPostDescription = "dein Name";
	// method timelineItem Parameters
	public static final String timelineFileParam = "photo";
	public static final String timelineMessageParam = "kommentar";
	
	/*
	 * 
	 */
}
