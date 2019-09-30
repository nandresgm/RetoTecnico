//CLASE QUE MAPEA TODA LA PAGINA DE COMPRA DE LIBROS

package paginas;

import Config.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Books {

    //Constructor que carga los elementos de la pagina
    public Books(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Localizacion de elementos para la prueba
    @FindBy(how = How.XPATH, using = "//*[@id=\"available\"]/h2")
    private WebElement titulo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"listing\"]/tbody/tr[2]/td[4]/input")
    private WebElement txtCoreJava;

    @FindBy(how = How.XPATH, using = "//*[@id=\"listing\"]/tbody/tr[3]/td[4]/input")
    private WebElement txtRubyRails;

    @FindBy(how = How.XPATH, using = "//*[@id=\"listing\"]/tbody/tr[4]/td[4]/input")
    private WebElement txtPython;

    @FindBy(how = How.XPATH, using = "//*[@id=\"listing\"]/tbody/tr[2]/td[3]")
    private WebElement lblCostCore;

    @FindBy(how = How.XPATH, using = "//*[@id=\"listing\"]/tbody/tr[3]/td[3]")
    private WebElement lblCostRuby;

    @FindBy(how = How.XPATH, using = "//*[@id=\"listing\"]/tbody/tr[4]/td[3]")
    private WebElement lblCostPython;

    @FindBy(how = How.ID, using = "total")
    private WebElement txtTotal;

    @FindBy(how = How.XPATH, using = "//*[@id=\"available\"]/input[1]")
    private WebElement btnAdd;

    public WebElement getTxtCoreJava() {
        return txtCoreJava;
    }

    public void setTxtCoreJava(WebElement txtCoreJava) {
        this.txtCoreJava = txtCoreJava;
    }

    public WebElement getTxtRubyRails() {
        return txtRubyRails;
    }

    public void setTxtRubyRails(WebElement txtRubyRails) {
        this.txtRubyRails = txtRubyRails;
    }

    public WebElement getTxtPython() {
        return txtPython;
    }

    public void setTxtPython(WebElement txtPython) {
        this.txtPython = txtPython;
    }

    public WebElement getTitulo() {
        return titulo;
    }

    public WebElement getLblCostCore() {
        return lblCostCore;
    }

    public WebElement getLblCostRuby() {
        return lblCostRuby;
    }

    public WebElement getLblCostPython() {
        return lblCostPython;
    }

    public WebElement getTxtTotal() {
        return txtTotal;
    }

    public WebElement getBtnAdd() {
        return btnAdd;
    }

    //Metodo que permite validar si se cargo la pagina siendo asi un login exitoso
    public boolean CargaExitosa(){
        if(!getTitulo().getText().isEmpty()){
            return  true;
        }else{
            return false;
        }
    }

    //Se encarga de convertir los castos capturados a double y retirarle "RS." para que pueda ser operado
    public double PrepararCosto(WebElement elemento){
        String numero;
        numero = elemento.getText();
        numero = numero.substring(4,numero.length());
        return Double.parseDouble(numero);
    }

    //Verifica si el total obtenido de la pagina se calcula correctamente
    public boolean ValidarTotal(){
        double totalCostCore, totalCostRuby, totalCostPython, total;
        totalCostCore = PrepararCosto(getLblCostCore()) * Double.parseDouble(getTxtCoreJava().getAttribute("value"));
        totalCostRuby = PrepararCosto(getLblCostRuby()) * Double.parseDouble(getTxtRubyRails().getAttribute("value"));
        totalCostPython = PrepararCosto(getLblCostPython()) * Double.parseDouble(getTxtPython().getAttribute("value"));
        total = totalCostCore + totalCostRuby + totalCostPython;
        if(total==Double.parseDouble(getTxtTotal().getAttribute("value"))){
            return true;
        }else{
            return false;
        }

    }


}
