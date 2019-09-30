/*CLASE QUE SE USA PARA CAPTURAR LOS ELEMENTOS DE LA VENTANA QUE SE CARGA AL DAR EN LA OPCION
WIONDOW OPEN TEST Y VALIDAR SI SE CARGA CORRECTAMENTE*/

package paginas;

import Config.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FramesTests {

    //Constructor que carga los elementos de la pagina
    public FramesTests(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Localizacion de elementos para la prueba
    @FindBy(how = How.XPATH, using = "/html/frameset")
    private WebElement Frames;

    public WebElement getFrames() {
        return Frames;
    }

    //Verifica la carga exitosa
    public boolean CargaExitosa(){
        if(getFrames().isDisplayed()){
            return true;
        }else{
            return false;
        }

    }
}
