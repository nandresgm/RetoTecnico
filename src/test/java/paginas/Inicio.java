//CLASE QUE MAPEA LOS ELEMENTOS QUE SE CARGAN EN LA URL BASE

package paginas;

import Config.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Inicio {

    //Constructor que carga los elementos de la pagina
    public Inicio(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Localizacion de elementos para la prueba
    @FindBy(how = How.XPATH, using = "/html/body/button")
    private WebElement btnPopUp;

    @FindBy(how = How.XPATH, using = "/html/body/a")
    private WebElement linkBack;

    public WebElement getBtnPopUp() {
        return btnPopUp;
    }

    public void setBtnPopUp(WebElement btnPopUp) {
        this.btnPopUp = btnPopUp;
    }

    public WebElement getLinkBack() {
        return linkBack;
    }

    public void setLinkBack(WebElement linkBack) {
        this.linkBack = linkBack;
    }

}
