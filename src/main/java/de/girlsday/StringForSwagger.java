package de.girlsday;

public class StringForSwagger {
	/*
	 * Param for more methodes 
	 */
	public static final String nameParam = "name";
	public static final String myNameParam = "meinName";
	public static final String otherUserNameParam = "FreundName";
	
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
	public static final String timelineDescription = "Aktivitäten Verlauf für die Benutzer mit dem name zeigen";
	public static final String timelineTitel = "Aktivitäten Verlauf";
	public static final String timelinePath = "/aktivitaeten";
	public static final String timelineParamDescription = "Name von dem benutzer wo man die Verlaufen sehen will";
	/*
	 * 
	 */
}
