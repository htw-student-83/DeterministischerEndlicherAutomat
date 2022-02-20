package dea;

public interface Idea {

    DeaZustand getZustand();

    void readSign(String zeichen)throws Exception;

    DeaZustand getStart();
}
