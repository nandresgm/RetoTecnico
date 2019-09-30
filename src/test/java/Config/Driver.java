// CLASE DEFINIDA PARA CONFIGURAR EL DRIVER Y LAS ESPERAS USADAS
package Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class Driver {

    private static WebDriver Driver;

    public static WebDriver getDriver() {
        return Driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static void EsperaImplicita(int segundos){
        Driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

}
