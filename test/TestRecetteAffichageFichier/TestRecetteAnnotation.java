/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRecetteAffichageFichier;

import java.io.File;
import javax.ejb.EJB;
import markesi.business.AnnotationEJB;
import markesi.business.IntervalEJB;
import markesi.entity.Annotation;
import markesi.entity.Interval;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author g33895
 */
public class TestRecetteAnnotation extends TestRecetteCommon {

    private WebDriver driver;
    @EJB
    private static AnnotationEJB annotationEJB;
    @EJB
    private static IntervalEJB intervalEJB;

    public TestRecetteAnnotation(String testName) {
        super(testName);
    }

    
    public void testAjouterAnnotationDB() {
        Annotation a = annotationEJB.create("Hello World ! Everything is ok !");
        Interval i = intervalEJB.create(0, 5);
        
        ajoutAnnotationSite(a);
        Annotation b = AnnotationDB.find(a.getId());

        assertEquals(b, a);
    }

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
        selenium.open("MarkESI-client-web/?action=manageFile&fileName="
                + (new File("files/TestRecetteCommon.java")).getAbsolutePath());
        selenium.waitForPageToLoad("6000");

        String script = "$('#content').selection(0, 6); "
                + "$('#content').mouseup();";

        selenium.runScript(script);

        assertEquals(selenium.getText("class=selection"), "//Test");

    }

    public void testSelectionVide() throws javax.script.ScriptException, InterruptedException {
        selenium.open("MarkESI-client-web/?action=manageFile&fileName="
                + (new File("files/TestRecetteCommon.java")).getAbsolutePath());
        selenium.waitForPageToLoad("6000");

        String script = "$('#content').selection(0, 0); "
                + "$('#content').mouseup();";

        selenium.runScript(script);

        assertFalse(selenium.isElementPresent("class=selection"));
    }

    public void testSelectionEspaces() throws javax.script.ScriptException, InterruptedException {
        selenium.open("MarkESI-client-web/?action=manageFile&fileName="
                + (new File("files/TestRecetteCommon.java")).getAbsolutePath());
        selenium.waitForPageToLoad("6000");

        //du caractère 8 au caractère 10 il n'y a que des espaces
        String script = "$('#content').selection(8, 10); "
                + "$('#content').mouseup();";

        selenium.runScript(script);

        assertFalse(selenium.isElementPresent("class=selection"));
    }
}
