package Notificador;

import entities.User;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSNotification implements Notifier{

    private final String ACCOUNT_SID = "AC621381f1e6eda571e0d2c14ede21697e"; //el SID del dashboard de twilo
    private final String AUTH_TOKEN = "729a4f71c681be20d527cf6a6b193b6b";
    private final String ourPhone = "15852073818";
    //el numero que envia el SMS, aca va el proporcionado por twillo

    public void notify(User aPerson, Notification msg){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try{
            Message message = Message.creator(
                new PhoneNumber("+"+ aPerson.getPhone()), //numero al que van a llegar los mensajes, aca iria el de la persona que quiero notificar
                new PhoneNumber("+"+ourPhone),
                msg.toString()
            ).create();
        } catch(ApiException e){
            //throw new NumeroDesconocidoException(unPersona.getTelefono()); TODO
        }
    }

}
