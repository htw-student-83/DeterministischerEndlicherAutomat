package dea;

public interface Idea {

    /**
     * Gibt den Zustand nach dem Start des Automaten zurück und leitet dieses Ereignis
     * an ein Listenerobjekt weiter
     * @return Startzustand
     */
    DeaZustand getStart();


    /**
     * Verändert den aktuellen Zustand des Automaten.
     * @param neuerZustand des Automoaten
     */
    void setStatus(DeaZustand neuerZustand);


    /**
     * Gibt des aktullen Zustand des Automaten zurück.
     * @return aktueller Zustand des Automaten
     */
    DeaZustand getZustand();


    /**
     * Nimmt ein Zeichen entgegen und prüft es auf Gültigkeit bevor es den Zustand wechselt.
     * @param zeichen, welches eingelesen wird
     * @throws Exception, im Fall, wenn der Zustand oder das Zeichen falsch sind
     */
    void readSign(String zeichen)throws Exception;

}
