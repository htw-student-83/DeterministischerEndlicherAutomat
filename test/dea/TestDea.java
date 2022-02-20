package dea;

import org.junit.Assert;
import org.junit.Test;

public class TestDea {

    private Idea toGetAnObjekt(){
        return new Deterministischer_Endlicher_Automat();
    }


    /**
     * prüft, ob sich der Automat zu Beginn im Startzustand befindet
     */
    @Test
    public void goodtest1(){
        Idea idea = this.toGetAnObjekt();
        idea.getStart();
        idea.getZustand();
        Assert.assertEquals(DeaZustand.Startzustand, idea.getZustand());
    }


    /**
     * prüft, ob der Automat vor dem Starten ein Zeichen einliest
     */
    @Test(expected = WrongStatus.class)
    public void failedTest1(){
        Idea idea = this.toGetAnObjekt();
        idea.readSign("A");
    }


    /**
     * prüft die Reakton des Automaten im Falle, dass es ein falsches Zeichen einließt
     */
    @Test(expected = WrongSign.class)
    public void failedTest2(){
        Idea idea = this.toGetAnObjekt();
        idea.getStart();
        idea.readSign("C");
    }


    /**
     * prüft die Reakton des Automaten im Falle, dass es unter einigen richtigen Zeichen
     * ein falsches einließt
     */
    @Test(expected = WrongSign.class)
    public void failedTest3(){
        Idea idea = this.toGetAnObjekt();
        idea.getStart();
        idea.readSign("A");
        idea.readSign("0");
        idea.readSign("A");
        idea.readSign("A");
        idea.readSign("C");
    }


    /**
     * prüft, ob der Automat im Startzustand ein Zeichen einließt und nicht in den Endzustnd wechselt
     *
     * */
    @Test
    public void goodTest2(){
        Idea idea = this.toGetAnObjekt();
        idea.getStart();
        idea.readSign("A");
        idea.readSign("0");
        Assert.assertEquals(DeaZustand.Zwischenzustand, idea.getZustand());
    }


    /**
     * prüft, ob der Automat im Startzustand ein Zeichen einließt und in den Endzustand wechselt
     */
    @Test
    public void goodTest3(){
        Idea idea = this.toGetAnObjekt();
        idea.getStart();
        idea.readSign("B");
        idea.readSign("0");
        String zustand = idea.getZustand();
        Assert.assertEquals(zustand, DeaZustand.Endzustand);
    }


    /**
     * prüft, ob der Automat im Startzustand ein Zeichen einließt, im Endzustand ankommt und
     * weitere Zeichen einliest und im gleichen Zustand verbleibt
     */
    @Test
    public void goodTest4(){
        Idea idea = this.toGetAnObjekt();
        idea.getStart();
        idea.readSign("B");
        idea.readSign("B");
        idea.readSign("B");
        idea.readSign("B");
        idea.readSign("C");
        String zustand = idea.getZustand();
        Assert.assertEquals(zustand, DeaZustand.Endzustand);
    }


    /**
     * prüft, ob der Automat nach dem Start verschiedene Zeichen einließt
     * und am Ende im Endzustand ist
     */
    @Test
    public void goodTest5(){
        Idea idea = this.toGetAnObjekt();
        idea.getStart();
        idea.readSign("A");
        idea.readSign("0");
        idea.readSign("0");
        idea.readSign("B");
        idea.readSign("B");
        idea.readSign("C");
        String zustand = idea.getZustand();
        Assert.assertEquals(zustand, DeaZustand.Endzustand);
    }
}
