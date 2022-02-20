package dea;

public interface Idea {

    /**
     * Gibt den Zustand nach dem Start des Automaten zurück.
     * @return Startzustand
     */
    DeaZustand getStart();


    /**
     * Verändert des aktuellen Zustand in einen neuen.
     * @param zustand
     */
    void setStatus(DeaZustand zustand);


    /**
     * Gibt des aktullen Zustand des Automaten zurück.
     * @return Zustand des Automaten
     */
    DeaZustand getZustand();


    /**
     * Nimmt ein Zeichen entgegen und prüft es auf Gültigkeit.
     * @param zeichen
     * @throws Exception, im Fall, wenn der Zustand oder das Zeichen falsch sind
     */
    void readSign(String zeichen)throws Exception;

}
