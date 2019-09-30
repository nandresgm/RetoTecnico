// ESCENARIO QUE CORRESPONDE AL PUNTO 4

package escenarios;

import Config.Actions;
import Config.Driver;
import Config.Settings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import paginas.Books;

public class ComprarLibros {

    //Es el primer método a ejecutarse inicializando el driver y ubicandonos en la url base
    @Before
    public void InicializarDriver(){
        Actions.InicializarDriver();
        Driver.getDriver().navigate().to(Settings.URLs.getUrlLogin());
    }

    //Agrega el libro al carro y verifica que el total sea correcto
    @Test
    public void AgregarLibro() throws InterruptedException {
        Books paginaBooks = new Books();
        Actions.IniciarSesion();
        paginaBooks.getTxtCoreJava().clear();
        paginaBooks.getTxtRubyRails().clear();
        paginaBooks.getTxtPython().clear();
        paginaBooks.getTxtCoreJava().sendKeys("2");
        paginaBooks.getTxtRubyRails().sendKeys("5");
        paginaBooks.getTxtPython().sendKeys("2");
        paginaBooks.getBtnAdd().click();
        Assert.assertTrue(paginaBooks.ValidarTotal());
    }

    //Finaliza la ejecucion del driver
    @After
    public void Finalizar(){
        Driver.getDriver().quit();
    }
}
