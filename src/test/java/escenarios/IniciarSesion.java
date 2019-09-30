//ESCENARIO QUE CORRESPONDE AL PUNTO 3

package escenarios;

import Config.Actions;
import Config.Driver;
import Config.Settings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import paginas.Books;
import paginas.Login;


public class IniciarSesion {

    //Es el primer método a ejecutarse inicializando el driver y ubicandonos en la url base
    @Before
    public void InicializarDriver(){
        Actions.InicializarDriver();
        Driver.getDriver().navigate().to(Settings.URLs.getUrlLogin());
    }

    //Prueba el ingreso al sistema con datos correctos
    @Test
    public void LoginExitoso() {
        Books paginaBook = new Books();
        Actions.IniciarSesion();
        Assert.assertTrue(paginaBook.CargaExitosa());
    }

    //Prueba el ingreso al sistema con datos incorrectos
    @Test
    public void LoginIncorrecto() {
        Login paginaLogin = new Login();
        Actions.IniciarSesionIncorrecto();
        paginaLogin.LogueoExitoso();
        Assert.assertTrue(!paginaLogin.LogueoExitoso());
    }

    //Finaliza la ejecucion del driver
    @After
    public void Finalizar(){
        Driver.getDriver().quit();
    }
}
