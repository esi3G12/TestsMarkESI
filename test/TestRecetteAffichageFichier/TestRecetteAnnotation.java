/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRecetteAffichageFichier;

import java.util.concurrent.TimeUnit;
import junit.framework.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.SeleniumDriverResourceHandler;

/**
 *
 * @author g33895
 */
public class TestRecetteAnnotation extends TestRecetteCommon {

    private WebDriver driver ;

    public TestRecetteAnnotation(String testName) {
        super(testName);
    }
//
//    public void testAffichageAnnotation() {
//        Annotation a = new Annotation();
//        final String contents = "Hello World ! Everything is ok !";
//        a.setContenu(contents);
//        // L'intervalle commence en ligne 1 et en colonne 3 
//        //et se termine en ligne 4 et en colonne 6
//        a.addIntervalle(new Position(1, 3), new Position(4, 6));
//        selenium.open("/afficheAnnotation?annotationId=" + a.getId());
//        String annotationTexte = selenium.getText("id=annotationTexte");
//        assertEquals(contents, annotationTexte);
//        String intervallesTexte = selenium.getText("id=intervallesTexte");
//        String intervallesTexteAttendu = "[1,3]->[4,6]";
//        assertEquals(intervallesTexteAttendu, intervallesTexte);
//    }
//
//    public void testAjouterAnnotationDB() {
//        Annotation a = new Annotation();
//        final String contents = "Hello World ! Everything is ok !";
//        a.setContenu(contents);
//        a.addIntervalle(new Position(1, 3), new Position(4, 6));
//
//        ajoutAnnotationSite(a);
//        Annotation b = AnnotationDB.find(a.getId());
//
//        assertEquals(b, a);
//    }
//
//    public void testAjouterAnnotationSite() {
//        Annotation a = new Annotation();
//        a.addIntervalle(new Position(1, 3), new Position(4, 6));
//        a.addIntervalle(new Position(10, 13), new Position(14, 16));
//        final String contents = "Hello World ! Everything is ok !";
//        a.setContenu(contents);
//
//        //
//        String script = null;
//        script = getSelectionCoordonees();
//        ((JavascriptExecutor) driver).executeScript(script);
//
//    }

    public void testSelectionTexte() throws javax.script.ScriptException, InterruptedException {
        selenium.open("/");
        selenium.waitForPageToLoad("6000");

        String script = "var range = document.createRange();"
                + "var start = document.getElementById('prm');"
                + "var textNode = start.firstChild;"
                + "range.setStart(textNode, 2);"
                + "range.setEnd(textNode, 3);"
                + "window.getSelection().addRange(range);";

        selenium.runScript(script);
        
        
        selenium.getText("id=prm").contains("Entrez");





    }
}
