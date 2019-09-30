/* CLASE EN LA QUE SE ALMACENAN LOS PARAMETROS DE CONFIGURACION DEL PROYECTO,
URLs, CREDENCIALES Y SET DE DATOS
 */
package Config;

public final class Settings {

    //Segundos parametrizados para la espera implicita del driver
    private static int segundos = 5;

    public static int getSegundos() {
        return segundos;
    }

    //URLs del proyecto
    public static class URLs{
        private static String urlInicio = "http://sahitest.com/demo/jsPopup.htm";
        private static String urlLogin = "http://sahitest.com/demo/training/login.htm";


        public static String getUrlLogin() {
            return urlLogin;
        }

        public static String getUrlInicio() {
            return urlInicio;
        }
    }

    //Datos del login
    public static class Credenciales{

        private static String username = "test";
        private static String password = "secret";


        public static String getUsername() {
            return username;
        }

        public static void setUsername(String username) {
            Credenciales.username = username;
        }

        public static String getPassword() {
            return password;
        }

        public static void setPassword(String password) {
            Credenciales.password = password;
        }
    }

    //Set de datos
    public static class Datos{
        private static String mensaje  = "Datos de prueba";
        private static String ErrorNotFound = "Not Found";
        private static String Error404 = "404 Page";
        private static String ErrorPagina = "Error Pages";


        public static String getMensaje() {
            return mensaje;
        }

        public static String getErrorNotFound() {
            return ErrorNotFound;
        }

        public static String getError404() {
            return Error404;
        }

        public static String getErrorPagina() {
            return ErrorPagina;
        }
    }


}
