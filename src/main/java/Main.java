import Repositorios.EjercicioRepository;
import Repositorios.RutinaRepository;
import Repositorios.UsuarioRepository;
import entities.*;
import managers.RutinasManager;
import managers.UsuarioManager;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UsuarioManager userManager = new UsuarioManager();
    private static RutinasManager rutinaManager = new RutinasManager();
    private static Usuario usuario;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        System.out.println("Bienvenido a FitTracker \n1- Registrarse \n2- Iniciar Sesión");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            registrarUsuario();
        } else {
            ingresarSesion();
        }
        System.out.println("Hola " + usuario.getNombre());
        boolean keepGoing = true;
        while(keepGoing) {
            System.out.println("1 - Ver Rutinas\n2 - Agregar Rutina \n3 - Obtener sugerencia\n4 - Mis Pesajes\n5 - Registrar peso\n6 - Dias desde el ultimo pesaje");
            opcion = sc.nextInt();
            handleMenu(opcion);
            System.out.println("Desea realizar otra operación? \n1- SI \n2- NO");
            keepGoing = sc.nextInt() == 1;
        }
        System.out.println("Nos vemos la próxima "+ usuario.getNombre() + "!");
        return;
    }

    private static void handleMenu(int op) throws ParseException {
        switch (op) {
            case 1: {
                List<Rutina> misRutinas = rutinaManager.getRutinas(usuario.getUsuario());
                misRutinas.forEach(r -> {
                    usuario.displayRutina(r);
                });
                break;
            }
            case 2: {
                System.out.println("Ingrese el nombre de la rutina:");
                String rutina = sc.next();
                userManager.crearRutina(usuario.getUsuario(), rutina);
                break;
            }
            case 3: {
                Rutina sugerencia = usuario.obtenerSugerencia();
                usuario.displayRutina(sugerencia);
                break;
            }
            case 4: {
                List<Pesaje> pesajes = usuario.getMisPesajes();
                pesajes.forEach(p -> {
                    System.out.println(p.getFecha() + ": "+p.getPeso()+"\n");
                });
                break;
            }
            case 5: {
                System.out.println("Ingrese el peso actual:");
                Float p = sc.nextFloat();
                Pesaje peso = new Pesaje(LocalDate.now(), p);
                Float pesoAnterior = usuario.pesoActual();
                userManager.agregarNuevoPeso(usuario.getNombre(), peso);
                System.out.println("Nuevo peso agregado:\n"+peso.getFecha() + ": "+peso.getPeso()+"\n");
                if(p<pesoAnterior){
                    System.out.println("Felicidades, disminuiste en " + (pesoAnterior-p) +"Kg tu peso");
                }else if(p>pesoAnterior){
                    System.out.println("Oops! Aumentaste en " + (p-pesoAnterior) + "Kg tu peso");
                }else{
                    System.out.println("Mantuviste tu peso!, felicidades!");
                }

            }
            case 6: {
                int diasUltPesaje = usuario.diasUltimoPesaje();
                System.out.println("Dias desde el ultimo pesaje: " + diasUltPesaje);
            }
        }
    }

    private static void registrarUsuario() {
        System.out.println("Ingrese los siguientes datos: \nUsuario:");
        String user = sc.next();
        System.out.println("Contraseña:");
        String psw = sc.next();
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("Apellido:");
        String apellido = sc.next();
        System.out.println("Telefono:");
        Long telefono = sc.nextLong();
        System.out.println("Mail:");
        String mail = sc.next();
        System.out.println("Altura:");
        int altura = sc.nextInt();
        try {
            usuario = userManager.registrarUsuario(user, psw, nombre, apellido, telefono, mail, altura);
        } catch (Exception e) {
            //mongo db logger error
        }
    }

    private static void ingresarSesion(){
        System.out.println("Ingrese los siguientes datos:\nUsuario:");
        String user = sc.next();
        System.out.println("Contraseña:");
        String psw = sc.next();
        usuario = userManager.validarUsuario(user, psw);
    }

}
