//Test
    
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRecetteAffichageFichier;

import com.thoughtworks.selenium.DefaultSelenium;
import junit.framework.TestCase;

/**
 *
 * @author g33895
 */
public abstract class TestRecetteCommon extends TestCase {
    protected DefaultSelenium selenium;

    public TestRecetteCommon(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
//        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080/projet");
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:24211/MarkESI-client-web");
        selenium.start();
    }

    @Override
    protected void tearDown() throws Exception {
        selenium.stop();
    }
    
}
