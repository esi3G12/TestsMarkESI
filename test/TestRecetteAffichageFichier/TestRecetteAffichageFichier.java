package TestRecetteAffichageFichier;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebElement;

/**
 *
 * @author g33895
 */
public class TestRecetteAffichageFichier extends TestRecetteCommon {
    
    public TestRecetteAffichageFichier(String testName) {
        super(testName);
    }
    
    public void testContenuFichier() throws InterruptedException {
        String fileName = "files/TestRecetteCommon.java";
        InputStream myStream;
        String contents="";
        try {
            myStream = new FileInputStream(fileName);
            contents = IOUtils.toString(myStream);
        } catch (Exception ex) {
            System.out.println(ex);
        } 
  
        selenium.open("MarkESI-client-web/?action=viewFile&fileName="
                + (new File(fileName)).getAbsolutePath());
//        Thread.sleep(20000);
        String contentsOnPage = selenium.getEval("selenium.browserbot.getCurrentWindow()."
                + "$('#content').text();");
//        String contentsOnPage = selenium.getText("id=content");

        contentsOnPage = contentsOnPage.replaceAll("(\n|\r)", "");
        contents = contents.replaceAll("(\n|\r)", "");
        assertEquals(contents, contentsOnPage);
    }
    
    public void testContenuFichierInexistant() {
        selenium.open("MarkESI-client-web/?action=viewFile&fileName=aaaa"); // l'id n'existe pas
        assertTrue(selenium.isTextPresent("Ce fichier n'existe pas !"));
    }
}
