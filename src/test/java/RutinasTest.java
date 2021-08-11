import models.Ejercicio;
import models.RutinaCompuesta;
import models.RutinaSimple;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RutinasTest {
    Ejercicio sentadilla = new Ejercicio("sentadilla", "gluteo", 2, 5, 10);
    Ejercicio hipthrust = new Ejercicio("hip-thrust", "cuadricep", 4, 10, 15);
    Ejercicio vups = new Ejercicio("v-ups", "oblicuos", 6, 12, 5);
    RutinaSimple rutina1 = new RutinaSimple("piernas");

    @Before
    public void init(){}

    @Test
    public void lasRutinasSimplesFuncionanCorrectamente() {
        rutina1.addEjercicio(sentadilla, 8);
        rutina1.addEjercicio(hipthrust, 10);
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
        rutina1.addEjercicio(sentadilla, 8);
        rutina1.addEjercicio(hipthrust, 8);
        rutina2.addEjercicio(vups, 12);
        fullbody.add(rutina1);
        fullbody.add(rutina2);

        assertEquals(lista,  fullbody.getSubEjercicios());
        assertEquals("gluteo, cuadricep, oblicuos", fullbody.getMusculos());
        assertEquals(4, fullbody.getDificultad());
        assertEquals(264, fullbody.getKcal());
        assertEquals(260, fullbody.getTiempo());
    }
}
