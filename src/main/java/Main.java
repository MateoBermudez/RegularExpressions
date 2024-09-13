import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    private static final String Menu = """
                
                
                ***Menu Principal***

                Ingrese la opcion para la expresion regular que deseas probar:\s

                1. Placas de carro en Colombia
                2. Numeros de telefonos fijos en Medellin
                3. Numeros de telefonos celulares en Colombia
                4. Direcciones residenciales en Medellin
                5. Direcciones de correo electronico
                6. Fecha en formato dd/mm/aaaa
                7. Hora en Formato hh:mm:ss
                8. Cedulas en Colombia
                9. Una declaracion de variables en java
                10. URL
                11. Nombres y apellidos con tildes y ñ
                12. Contraseña Segura
                13. Codigo formato para representar un numero double
                0. Salir

                Digite una opcion:\s""";



    public static void main(String[] args) {
        System.out.println("Bienvenido al programa de expresiones regulares");
        System.out.println(Menu);
        int opcion = Menu();
        while (opcion != 0) {
            System.out.println("Ingrese el texto a evaluar para la opcion " + opcion + ": ");
            String input = sc.nextLine();

            String[] Patrones = {
                    "^[A-Z]{3}( |-)[0-9]{3}$",
                    "^(604)?\\d{7}$",
                    "^3\\d{9}$",
                    "^(Calle|Cl|Cll|Avenida|Av|Transversal|Tv|Diagonal|Dg|Carrera|Cra|Circular|Crc)" +
                            "( |-)?\\d{1,3}[a-zA-Z]{0,2}( |-)?(Sur|Norte)?( |-)?#" +
                            "( |-)?\\d{1,3}[a-zA-Z]{0,2}-\\d{1,3}$",
                    "^[a-zA-Z0-9-_.%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$",
                    "^([012]\\d|3[0-1])( |-|/)([0]\\d|1[0-2])( |-|/)([01]\\d{3}|2[01]\\d{2})$",
                    "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$",
                    "^\\d{6,10}$",
                    "^(int|String|char|float|short|long|double|boolean|byte)\\s+\\w+\\s*(=\\s*[^;]+)?\\s*;$",
                    "^(http(s)?://(www\\.)?)?\\w+\\.[a-zA-Z]{2,}$",
                    "^[A-ZÁÉÍÓÚÑa-záéíóúñ]+(?: +[A-ZÁÉÍÓÚÑa-záéíóúñ]+)*$",
                    "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=*!]).{8,}$",
                    "^[+-]?(\\d+|\\d{1,3}(,\\d{3})*)(\\.\\d+)?$"
            };
            try {
                Coincidencias(input, Patrones[opcion - 1]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Ingrese la opcion para la expresion regular que deseas probar (0-13):");

            opcion = Menu();
        }

        System.out.println("Gracias por usar el programa");
        System.exit(0);
    }

    public static boolean Coincidencias(String texto, String patron) {
        boolean v = false;
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Coincidencia " + matcher.group());
            v = true;
        }

        if (!v) {
            throw new IllegalArgumentException("Error. El texto: " + texto + " No coincide con el patron: " + patron);
        }

        return true;
    }


    public static int Menu() {
        //System.out.println(Menu);

        int opcion = sc.nextInt();
        sc.nextLine();
        while (opcion < 0 || opcion > 13) {
            System.out.println("Digite una opcion valida: ");
            opcion = sc.nextInt();
            sc.nextLine();
        }

        return opcion;
    }
}