import entities.Ejercicio;
import entities.RutinaCompuesta;
import entities.RutinaSimple;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RutinasTest {
    Ejercicio sentadilla = new Ejercicio("sentadilla", "gluteo", 2, 5, 10, 8);
    Ejercicio hipthrust = new Ejercicio("hip-thrust", "cuadricep", 4, 10, 15, 10);
    Ejercicio vups = new Ejercicio("v-ups", "oblicuos", 6, 12, 5, 12);
    RutinaSimple rutina1 = new RutinaSimple("piernas");

    @Before
    public void init(){}

    @Test
    public void lasRutinasSimplesFuncionanCorrectamente() {
        rutina1.addEjercicio(sentadilla);
        rutina1.addEjercicio(hipthrust);
        List<Ejercicio> lista = Arrays.asList(hipthrust, sentadilla);

        assertEquals(3 , rutina1.getDificultad());
        assertEquals("cuadricep, gluteo", rutina1.getMusculos());
        assertEquals(140, rutina1.getKcal());
        assertEquals(230, rutina1.getTiempo());
        assertEquals(lista, rutina1.getSubEjercicios());
    }

    @Test
    public void lasRutinasCompuestasFuncionan(){
        RutinaSimple rutina2 = new RutinaSimple("abs");
        RutinaCompuesta fullbody = new RutinaCompuesta("Fullbody");
        List<Ejercicio> lista = Arrays.asList(sentadilla, hipthrust , vups);
        rutina1.addEjercicio(sentadilla);
        rutina1.addEjercicio(hipthrust);
        rutina2.addEjercicio(vups);
        fullbody.add(rutina1);
        fullbody.add(rutina2);

        assertEquals(lista,  fullbody.getSubEjercicios());
        assertEquals("gluteo, cuadricep, oblicuos", fullbody.getMusculos());
        assertEquals(4, fullbody.getDificultad());
        assertEquals(264, fullbody.getKcal());
        assertEquals(260, fullbody.getTiempo());
        assertEquals("Fullbody", fullbody.getNombre());
    }
}
