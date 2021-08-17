package Calendarizacion;

import Notificador.NotificadorMail;
import Notificador.Notification;
import Notificador.Notifier;
import Notificador.SMSNotification;
import Repositorios.UsuarioRepository;
import entities.Usuario;
import org.apache.http.cookie.SM;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.List;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class RecordatorioPesaje {

    static UsuarioRepository repoUsuarios = new UsuarioRepository();

    public static void main(String[] args) throws SchedulerException {
        JobDetail job = newJob(pesajeCalendarizado.class).withIdentity("pesaje-calendarizado").build();

        Trigger trigger = newTrigger().withIdentity("trigger").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(600).repeatForever()).build();
        //Trigger trigger = newTrigger().withIdentity("trigger").startNow().withSchedule(simpleSchedule().withIntervalInHours(24).repeatForever()).build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public static class pesajeCalendarizado implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

            for(Usuario user : repoUsuarios.findAll()){
                List<Notifier> notificadores =  user.getFormasDeNotificar();
                Notification notificacion = new Notification("Recordatorio: Pesaje diario",user.getNombre()+"! No olvides registrar tu peso!");
                notificadores.forEach(not -> not.notify(user, notificacion));
            }

            /*
            Usuario user1 = new Usuario().dummyUser2();
            NotificadorMail not = new NotificadorMail();
            not.notify(user1,new Notification("asunto","pesate carajo!"));
            System.out.println("PESATE CARAJO");

            SMSNotification smsnot = new SMSNotification();
            Notification notificacion = new Notification("Recordatorio: Pesaje diario",user1.getNombre()+"! No olvides registrar tu peso!");
            smsnot.notify(user1,notificacion);
            System.out.println("PESATE CARAJO SMS");
            */
        }
    }
}
