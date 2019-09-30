//ESCENARIO QUE CORRESPONDE AL PUNTO 2
package escenarios;

import Config.Actions;
import Config.Driver;
import Config.NavigateTo;
import Config.Settings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import paginas.Elementos.ElementosIframeTest;
import paginas.IframeTest;

public class ErrorPage {

    //Es el primer método a ejecutarse inicializando el driver y ubicandonos en la url base
    @Before
    public void InicializarDriver(){
        Actions.InicializarDriver();
        Driver.getDriver().navigate().to(Settings.URLs.getUrlInicio());
    }

    //Valida que si se presente el mensaje de error en la opción 404 page
    @Test
    public void MensajeErrorExitoso() throws InterruptedException {
        IframeTest paginaIframeTest = new IframeTest();
        ElementosIframeTest elementosIframeTest = new ElementosIframeTest();
        NavigateTo.IframeTest();
        paginaIframeTest.SeleccionarOpcion(Settings.Datos.getErrorPagina());
        Thread.sleep(1000);
        paginaIframeTest.SeleccionarOpcionHijo(Settings.Datos.getError404());
        Assert.assertTrue(elementosIframeTest.CargaExitosa());
    }

    //Finaliza la ejecucion del driver
    @After
    public void Finalizar(){
        Driver.getDriver().quit();
    }
}
