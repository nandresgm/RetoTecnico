/*
EN ESTA CLASE SE DESARROLLAN LAS ACCIONES
TRANSVARSALES A EL PROYECTO
*/

package Config;

import org.openqa.selenium.chrome.ChromeDriver;
import paginas.Login;
import java.awt.*;
import java.awt.event.KeyEvent;

public final class Actions {

    //Inicializa el driver con el tipo de driver y con la espera implicita parametrizada
    public static void InicializarDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        Driver.setDriver(new ChromeDriver());
        Driver.EsperaImplicita(Settings.getSegundos());
    }

    //Cuando es invocado se encarga de actualizar la ventana con la mas reciente
    public static  void ActualizarDriver(){
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
        }
    }

    /*Inicia sesión y se crea de forma transversal porque pueden haber varios casos de prueba que lo necesiten
    y no necesitarian crear un objeto de la pagina de inicio
    */
    public static void IniciarSesion(){
        Login paginaLogin = new Login();
        paginaLogin.getUsername().sendKeys(Settings.Credenciales.getUsername());
        paginaLogin.getPassword().sendKeys(Settings.Credenciales.getPassword());
        paginaLogin.getBtnLogin().click();
    }

    public static void IniciarSesionIncorrecto(){
        Login paginaLogin = new Login();
        paginaLogin.getUsername().sendKeys("");
        paginaLogin.getPassword().sendKeys("");
        paginaLogin.getBtnLogin().click();
    }

    //Se hizo con el fin de manipular el dialogo de impresión ya que no fue posible acceder mediante el driver
    public static void PresionarTecla(boolean evento) throws AWTException {
        Robot robot = new Robot();
        if(evento){
            robot.keyPress (KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }else{
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }

}
