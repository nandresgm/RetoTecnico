//CLASE QUE MAPEA LOS ELEMENTOS A USAR EN LA PAGINA PRINCIPAL

package paginas;

import Config.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Index {

    //Constructor que carga los elementos de la pagina
    public Index(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Localizacion de elementos para la prueba
    @FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td[1]/a[6]")
    private WebElement linkIframeTest;


    public WebElement getLinkIframeTest() {
        return linkIframeTest;
    }

}
