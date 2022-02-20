package dea;

public class Deterministischer_Endlicher_Automat implements Idea {

    private DeaZustand currentStatus = DeaZustand.Startzustand;

    @Override
    public DeaZustand getStart() {
        return this.currentStatus;
    }

    public void setStatus(DeaZustand zustand){
        this.currentStatus = zustand;
    }

    @Override
    public DeaZustand getZustand() {
        return this.currentStatus;
    }

    @Override
    public void readSign(String zeichen)throws Exception{
        if(getZustand() == null){
            throw new WrongStatus("Achtung, falscher Zustand für das Einlesen eines Zeichens.");
        }
        if (getZustand() == DeaZustand.Startzustand && !((zeichen.equals("A")|| (zeichen.equals("B"))))){
            throw new WrongSign("Das eingebene Zeichen ist ungültig.");
        }else{
            if(getZustand() == DeaZustand.Startzustand && (zeichen.equals("A") || zeichen.equals("0"))){
                setStatus(DeaZustand.Zwischenzustand);
            }else if(getZustand() == DeaZustand.Zwischenzustand && (zeichen.equals("A") || zeichen.equals("0"))){
                setStatus(DeaZustand.Zwischenzustand);
            }else if(getZustand() == DeaZustand.Startzustand || getZustand() == DeaZustand.Zwischenzustand && (zeichen.equals("B"))){
                setStatus(DeaZustand.Endzustand);
            }
        }
    }
}
