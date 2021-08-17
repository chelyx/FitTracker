package Notificador;

import entities.Usuario;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSNotification implements Notifier{

    private final String ACCOUNT_SID = "ACe56e55ea1e60341b883feff7815929e8"; //el SID del dashboard de twilo
    private final String AUTH_TOKEN = "5491c8612eba5a12a0376c1546c3ff12";
    private final String ourPhone = "19704091036";
    //el numero que envia el SMS, aca va el proporcionado por twillo

    public void notify(Usuario aPerson, Notification msg){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try{
            Message message = Message.creator(
                new PhoneNumber("+"+ aPerson.getTelefono()), //numero al que van a llegar los mensajes, aca iria el de la persona que quiero notificar
                new PhoneNumber("+"+ourPhone),
                msg.toString()
            ).create();
        } catch(ApiException e){
            //throw new NumeroDesconocidoException(unPersona.getTelefono()); TODO
        }
    }

}
