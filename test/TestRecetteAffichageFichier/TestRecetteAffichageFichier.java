package TestRecetteAffichageFichier;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author g33895
 */
public class TestRecetteAffichageFichier extends TestRecetteCommon {
    
    public TestRecetteAffichageFichier(String testName) {
        super(testName);
    }

    
    public void testContenuFichier() throws InterruptedException {
        String fileName = "C:\\Documents and Settings\\g35079\\Desktop\\Subversion Client\\Projet12Rep\\MarkESI_TestRecette\\src\\java\\TestFichier\\Test1Ligne.java";
        InputStream myStream;
        String myString="";
        try {
            myStream = new FileInputStream(fileName);
            myString = IOUtils.toString(myStream);
        } catch (Exception ex) {
            System.out.println(ex);
        } 
  
        final String contents = myString;
        System.out.println(contents);
        selenium.open("MarkESI-client-web/afficheFichier?fileName="+fileName);
        //Thread.sleep(20000);
        String contentsOnPage = selenium.getText("id=contenu");
        System.out.println("contents page \n"+contentsOnPage);
        assertEquals(contents, contentsOnPage);
    }
    
    public void testContenuFichierInexistant() {
        selenium.open("MarkESI-client-web/afficheFichier?fileName=aaaaa"); // l'id n'existe pas
        String contentsOnPage = selenium.getText("id=contenu");
        String contents = "Attention ! Ce fichier n'existe pas !";
        assertEquals(contents, contentsOnPage);
    }
}
