//MAPEA LOS ELEMENTOS A USAR DE LA PAGINA IFRAMETEST QUE ES CARGADA DESDE LA PAGINA PRINCIPAL

package paginas;

import Config.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class IframeTest {

    //Constructor que carga los elementos de la pagina
    public IframeTest(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Localizacion de elementos para la prueba
    @FindBy(how = How.XPATH, using = "//*[@id=\"another\"]/iframe")
    private WebElement IframeDerecho;

    public WebElement getIframeDerecho() {
        return IframeDerecho;
    }

    //Metodo general que da clic en la opción que le sea enviada como parametro
    public void SeleccionarOpcion(String opcion){
        List<WebElement> lstOpciones = new ArrayList<>();
        Driver.getDriver().switchTo().frame(getIframeDerecho());
        lstOpciones = Driver.getDriver().findElements(By.tagName("a"));
        for(WebElement elemento : lstOpciones){
            if(elemento.getText().equals(opcion)){
                elemento.click();
                break;
            }
        }
    }

    /*Metodo general que da clic en la opción que le sea enviada como parametro,
    pero esta opción debe ser de las secundarias que se cargan*/
    public void SeleccionarOpcionHijo(String opcion){
        List<WebElement> lstOpciones = new ArrayList<>();
        lstOpciones = Driver.getDriver().findElements(By.tagName("a"));
        for(WebElement elemento : lstOpciones){
            if(elemento.getText().equals(opcion)){
                elemento.click();
                break;
            }
        }
    }
}
