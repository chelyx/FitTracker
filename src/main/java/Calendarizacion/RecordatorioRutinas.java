package Calendarizacion;

import Notificador.NotificadorMail;
import Notificador.Notification;
import Notificador.Notifier;
import Repositorios.UsuarioRepository;
import entities.NivelPrincipiante;
import entities.Rutina;
import entities.Usuario;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class RecordatorioRutinas {

    static UsuarioRepository repoUsuarios = new UsuarioRepository();


    public static void main(String[] args) throws SchedulerException {
        JobDetail job = newJob(RecordatorioRutinas.rutinasCalendarizadas.class).withIdentity("rutinas-calendarizadas").build();

        Trigger trigger = newTrigger().withIdentity("trigger").startNow().withSchedule(simpleSchedule().withIntervalInMinutes(10).repeatForever()).build();
        //Trigger trigger = newTrigger().withIdentity("trigger").startNow().withSchedule(simpleSchedule().withIntervalInHours(24).repeatForever()).build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public static class rutinasCalendarizadas implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            for (Usuario user : repoUsuarios.findAll()) {
                List<Notifier> notificadores = user.getFormasDeNotificar();
                String msg = user.getNombre() + ", te recordamos tus rutinas cargadas: \n";
                for (Rutina rutina : user.getMisRutinas()) {
                    msg = msg + "-" + rutina.getNombre() + "\n";
                }
                Notification notificacion = new Notification("Recordatorio: Rutinas cargadas", msg);
                notificadores.forEach(not -> not.notify(user, notificacion));

                /*
                        Usuario user1 = new Usuario().dummyUser2();
            System.out.println("Mandemos mail a "+ user1.getNombre() +" hace tus rutinas");
            String msg = user1.getNombre()+", te recordamos tus rutinas cargadas: \n";
            System.out.println(msg);
            System.out.println(user1.getMail());
            Notification notificacion = new Notification("Recordatorio: Rutinas cargadas",msg);
            NotificadorMail notEmail = new NotificadorMail();
            notEmail.notify(user1, notificacion);
            System.out.println("Listo");

                */
            }

        }
    }
}

