/*CLASE USADA PARA MAPEAR LOS ELEMENTOS COMO MENUS O OPCIONES QUE SE DESLIGAN DE UNA PAGINA,
ES DECIR SIGUE SIENDO LA MISMA PAGINA, EN ESTE CASO ES LA DE IframeTest*/

package paginas.Elementos;

import Config.Driver;
import Config.Settings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ElementosIframeTest {

    //Constructor que carga los elementos de la pagina
    public ElementosIframeTest(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Localizacion de elementos para la prueba
    @FindBy(how = How.XPATH, using = "/html/body/h1")
    private WebElement titulo;

    public WebElement getTitulo() {
        return titulo;
    }

    //Metodo que se encarga de validar si la opcion 404 pages si presenta el mensaje de error en el elemento de la pagina IframeTest
    public boolean CargaExitosa(){
        String a = Driver.getDriver().getPageSource();
        String b = getTitulo().getText();
        if(getTitulo().getText().equals(Settings.Datos.getErrorNotFound())){
            return  true;
        }else{
            return false;
        }
    }
}
