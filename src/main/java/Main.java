import Repositorios.EjercicioRepository;
import Repositorios.RutinaRepository;
import Repositorios.UsuarioRepository;
import entities.Ejercicio;
import entities.Rutina;
import entities.RutinaSimple;
import entities.Usuario;

import java.util.List;

public class Main {/* pa probar cosas*/
    private static UsuarioRepository userRepo = new UsuarioRepository();
    private static RutinaRepository rutinasRepo = new RutinaRepository();
    private static EjercicioRepository ejerciciosRepo = new EjercicioRepository();
    public static void main(String[] args) {
        /* TODO: BORRAR DE LA BD, SI LO VOLVES A CORRER LOS VOLVES A CREAR.
        Usuario usuario = new Usuario();
        usuario.dummyUser();
        userRepo.save(usuario);

        Usuario usuario1 = new Usuario();
        usuario1.dummyUser();
        usuario1.setUsuario("araceli");
        userRepo.save(usuario1);

        List<Usuario> usuarios = userRepo.findAll();
        usuarios.forEach(u -> {
            System.out.println(u.getUsuario());
        });

        Usuario found = userRepo.findByUsuario("usuario");
        System.out.println(found.getNombre());
        userRepo.remove(found);
        userRepo.remove(usuario1);

        Usuario found = userRepo.findByUsuario("dummy");
        System.out.println(found.getNombre());
        Rutina rutina = new RutinaSimple("Abs");
        found.cargarRutina(rutina);
        userRepo.save(found);

        Ejercicio sentadilla = new Ejercicio("sentadilla", "gluteo", 2, 5, 10, 8);
        List<Rutina> found = rutinasRepo.findByUsuario("dummy");
        found.forEach(r -> {
            System.out.println(r.getNombre());
            r.addEjercicio(sentadilla);
            rutinasRepo.save(r);
        });

        List<Ejercicio> ejercicios = ejerRepo.findByRutina("Abs");

        List<Ejercicio> ejercicios = ejerRepo.findAll();

        ejercicios.forEach(e -> {
            System.out.println(e.getNombre());
        });
         */
    }

}
