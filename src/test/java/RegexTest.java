import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class RegexTest {

    @Test
    public void TestRegex() {

        String[] textoExitoso = {
                "DCV 332",
                "6045003212",
                "3219784380",
                "Transversal 670AB Norte # 50W-56",
                "mateo.bermudeZ2910@elpoli.edu.com",
                "02/12/2022",
                "19:59:59",
                "98623551",
                "String i = 'Hola Mundo';",
                "https://regexr.com",
                "Mateño Bermúdeñz Cuártañs",
                "P@ssw0rd!",
                "35345353545.34"
        };

//        String[] textoFallido = {
//                "DCV 33",
//                "60450d3212",
//                "3219784380dd",
//                "Transveadrsal 670AB Norte # 50W-56",
//                "mateo.bermudeZ2910@elpoli.edu.co33m",
//                "2/12/2022",
//                "9:59:59",
//                "98623551eddw",
//                "Strindc3g i = 'Hola Mundo';",
//                "https://regexr.com.co9",
//                "Mateño Bermúdeñz C33uártañs",
//                "P@ssword!",
//                "35345353ad545.34"
//        };

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

        System.out.println("Test de Coincidencias\n");
        //Cada posicion de texto coincide con la misma posicion de Patrones, es decir, texto[0] con Patrones[0], (uno a uno)
        int i = 0;
        for (String patron : Patrones) {
            assertTrue(Main.Coincidencias(textoExitoso[i++], patron));
        }


//        System.out.println("\nTest de Coincidencias Fallidas\n");
//        i = 0;
//        for (String patron : Patrones) {
//            int index = i;
//            try {
//                Main.Coincidencias(textoFallido[i++], patron);
//                assertThrows(IllegalArgumentException.class, () -> {
//                    throw new IllegalArgumentException("Error. El texto: " + textoFallido[index] + " No coincide con el patron: " + patron);
//                });
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }
}
