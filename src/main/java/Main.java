import models.Ejercicio;
import models.RutinaCompuesta;
import models.RutinaSimple;

public class Main { /* pa probar cosas*/

    public static void main(String[] args) {
        RutinaSimple rutina1 = new RutinaSimple("abdominales");
        RutinaSimple rutina2 = new RutinaSimple("piernas");
        RutinaCompuesta rutinaza = new RutinaCompuesta("Fullbody");
        rutina1.addEjercicio(new Ejercicio("sentadilla", "gluteo", "cuadricep",
                2, 5, 10), 8);
        rutina1.addEjercicio(new Ejercicio("hip-thrust", "gluteo", "cuadricep",
                4, 10, 15), 8);
        rutina2.addEjercicio(new Ejercicio("v-ups", "abdo", "oblicuos",
                6, 12, 5), 12);
        rutinaza.add(rutina1);
        rutinaza.add(rutina2);
        System.out.println(rutinaza.getSubEjercicios());
        System.out.println(rutinaza.getDificultad());
        System.out.println(rutina1.getDificultad());

    }
}
