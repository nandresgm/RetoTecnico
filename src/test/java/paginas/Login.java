package paginas;

import Config.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {

    //Constructor que carga los elementos de la pagina
    public Login(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Localizacion de elementos para la prueba
    @FindBy(how = How.NAME, using = "user")
    private WebElement username;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "/html/body/center/div/form/table/tbody/tr[3]/td[2]/input")
    private WebElement btnLogin;

    @FindBy(how = How.ID, using = "errorMessage")
    private WebElement msgError;

    public WebElement getUsername() {
        return username;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public WebElement getMsgError() {
        return msgError;
    }

    //Metodo para verificar que si se presente el mensaje de error en el login
    public boolean LogueoExitoso(){
        if(getMsgError().isDisplayed()){
            return false;
        }else{
            return true;
        }
    }
}
