package dea;

import org.junit.Assert;
import org.junit.Test;

public class TestDea {
    //Alle Tests definieren, die den dea vollständig definiert
/*
* Mögliche Tests
* 1) Der erste Zustand des deterministischen_Endlichen_Automaten ist der Startzustand
* 2) Der DEA liest vor dem ersten Zustand ein Zeichen ein, das nicht erlaubt ist
* 3) Der DEA liest im richtigen Zustand ein Zeichen ein und wechselt den Zustand in
* einen nicht EndlichenZustand
* 4) Der DEA liest im richtigen Zustand ein Zeichen ein und wechselt den Zustand in einen EndlichenZustand
* */

    private Idea toGetAnObjekt(){
        return new Deterministischer_Endlicher_Automat();
    }

    /**
     * prüft, ob sich der dea zu Beginn im Startzustand befindet
     */
    @Test
    public void goodtest1(){
        Idea idea = this.toGetAnObjekt();
        idea.getZustand();
        Assert.assertEquals(DeaZustand.Startzustand, idea.getZustand());
    }

    /**
     * prüft, ob der DEA vor dem Starten ein Zeichen einliest
     */
    @Test(expected = WrongStatus.class)
    public void failTest1(){
        Idea idea = this.toGetAnObjekt();
        idea.readSign("A");
    }

    /**
     * prüft, ob der DEA im Startzustand ein Zeichen einließt und im Zustand verbleibt
     */
    @Test
    public void goodTest2(){
        Idea idea = this.toGetAnObjekt();
        idea.getZustand();
        idea.readSign("A");
        Assert.assertEquals(DeaZustand.Zwischenzustand, idea.getZustand());
    }

    /**
     * prüft, ob der DEA im Startzustand ein Zeichen einließt und im Endzustand ankommt
     */
    @Test
    public void goodTest3(){
        Idea idea = this.toGetAnObjekt();
        idea.getZustand();
        idea.readSign("B");
        idea.getZustand();
        Assert.assertEquals(DeaZustand.Endzustand, idea.getZustand());
    }
}
