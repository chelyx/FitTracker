package Calendarizacion;

import Notificador.Notification;
import Notificador.Notificador;
import Repositorios.UsuarioRepository;
import entities.NivelAvanzado;
import entities.NivelIntermedio;
import entities.Usuario;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.List;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class NivelController {

    static UsuarioRepository repoUsuarios = new UsuarioRepository();

    public static void main(String[] args) throws SchedulerException {
        JobDetail job = newJob(NivelController.ChequeoNivel.class).withIdentity("chequeo-nivel").build();

        Trigger trigger = newTrigger().withIdentity("trigger").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(20).repeatForever()).build();
        //Trigger trigger = newTrigger().withIdentity("trigger").startNow().withSchedule(simpleSchedule().withIntervalInHours(24).repeatForever()).build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public static class ChequeoNivel implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

            for(Usuario user : repoUsuarios.findAll()){
                boolean change = false ;
                int cantPesajes = user.getMisPesajes().size();
                int cantRutinas = user.getMisRutinas().size();

                if(cantPesajes >= 5 && cantRutinas > 5){
                    user.cambiarNivel(new NivelIntermedio());
                    change = true;
                }else if(cantPesajes > 15 && cantRutinas > 10){
                    user.cambiarNivel(new NivelAvanzado());
                    change = true;
                }
                if (change){
                    List<Notificador> notificadores =  user.getFormasDeNotificar();
                    Notification notificacion = new Notification("Felicidades: has sido ascendido a nivel: " + user.getNivel().getNombreNivel(),
                                                                    user.getNombre()+"! Sigue trabajando asi!");
                    notificadores.forEach(not -> not.notify(user, notificacion));

                }


            }
        }
    }

}
