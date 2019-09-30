/*CLASE USADA PARA NAVEGAR EN LAS VISTAS DEL PROYECTO,
EN VISTA A QUE NO HAY MUCHA NAVEGACION SOLO SE TIENE UN MÉTODO
 */

package Config;

import paginas.Index;
import paginas.Inicio;

// Redirecciona a la pagina principal
public final class NavigateTo {
    public static void IframeTest(){
        Inicio paginaInicio = new Inicio();
        Index paginaIndex = new Index();
        paginaInicio.getLinkBack().click();
        paginaIndex.getLinkIframeTest().click();
    }
}
