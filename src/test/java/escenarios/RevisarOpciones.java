//ESCENARIO QUE CORRESPONDE AL PUNTO 5
package escenarios;

import Config.Actions;
import Config.Driver;
import Config.Settings;
import org.junit.*;
import paginas.Inicio;
import java.awt.*;

public class RevisarOpciones {

    //Es el primer método a ejecutarse inicializando el driver y ubicandonos en la url base
    @Before
    public void InicializarDriver(){
        Actions.InicializarDriver();
        Driver.getDriver().navigate().to(Settings.URLs.getUrlInicio());
    }

    /*Se confirman alertas pero no se ingresan datos en la alerta */
    @Test
    public void ImprimirSinDatos() throws AWTException, InterruptedException {
        Inicio paginaInicio = new Inicio();
        paginaInicio.getBtnPopUp().click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(3000);
        Actions.PresionarTecla(false);
        paginaInicio.getLinkBack().click();
    }

    /*Se confirman alertas ingresando datos en la alerta */
    @Test
    public void ImprimirConDatos() throws AWTException, InterruptedException {
        Inicio paginaInicio = new Inicio();
        paginaInicio.getBtnPopUp().click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().sendKeys(Settings.Datos.getMensaje());
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(3000);
        Actions.PresionarTecla(false);
        paginaInicio.getLinkBack().click();
    }

    /*Se confirman las 2 primeras alertas pero se cancela el ingreso de datos */
    @Test
    public void CancelarIngresoDatos() throws AWTException, InterruptedException {
        Inicio paginaInicio = new Inicio();
        paginaInicio.getBtnPopUp().click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().dismiss();
        Thread.sleep(3000);
        Actions.PresionarTecla(false);
        paginaInicio.getLinkBack().click();
    }

    /*Se*cancela 2da alerta y se cancela ingreso de datos */
    @Test
    public void CancelarConfirmacion() throws AWTException, InterruptedException {
        Inicio paginaInicio = new Inicio();
        paginaInicio.getBtnPopUp().click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().dismiss();

        Driver.getDriver().switchTo().alert().dismiss();
        Thread.sleep(3000);
        Actions.PresionarTecla(false);
        paginaInicio.getLinkBack().click();
    }


    /*Se*cancela 2da alerta y se ingresan de datos */
    @Test
    public void CancelarConfirmacionIngresoDatos() throws AWTException, InterruptedException {
        Inicio paginaInicio = new Inicio();
        paginaInicio.getBtnPopUp().click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().switchTo().alert().dismiss();
        Driver.getDriver().switchTo().alert().sendKeys(Settings.Datos.getMensaje());
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(3000);
        Actions.PresionarTecla(false);
        paginaInicio.getLinkBack().click();
    }

    //Finaliza la ejecucion del driver
    @After
    public void Finalizar(){
        Driver.getDriver().quit();
    }

}
