package Calendarizacion;

import Notificador.Notification;
import Notificador.Notificador;
import Repositorios.UsuarioRepository;
import entities.Usuario;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
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
                try {
                    if (user.diasUltimoPesaje() > 2){
                        List<Notificador> notificadores =  user.getFormasDeNotificar();
                        Notification notificacion = new Notification("Recordatorio: Pesaje diario",user.getNombre()+"! No olvides registrar tu peso!");
                        notificadores.forEach(not -> not.notify(user, notificacion));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
