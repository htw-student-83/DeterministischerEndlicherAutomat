package dea;

import org.junit.Assert;
import org.junit.Test;

public class TestDea {
    //Alle Tests definieren, die den dea vollständig definiert
/*
* Mögliche Tests
* 1) Der erste Zustand des deterministischen_Endlichen_Automaten ist der Startzustand
*
*
*
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
     * prüft, ob der dea vor dem Starten ein Zeichen einliest
     */
    @Test(expected = WrongStatus.class)
    public void goodtest2(){
        Idea idea = this.toGetAnObjekt();
        idea.readSign();
    }
}
