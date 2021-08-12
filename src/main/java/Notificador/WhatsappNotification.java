package Notificador;

import Users.Persona;
//import Utils.Exceptions.NumeroDesconocidoException;
import Users.Persona;
import com.twilio.Twilio;

import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsappNotification implements Notifier{
    final String ACCOUNT_SID = "AC621381f1e6eda571e0d2c14ede21697e";
    final String AUTH_TOKEN = "729a4f71c681be20d527cf6a6b193b6b";
    private final String ourPhone = "14155238886";

    public void notify(Persona aPerson, Notification message){
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            try{
                Message.creator(
                    new PhoneNumber("whatsapp:+"+aPerson.getPhone()),
                    new PhoneNumber("whatsapp:+"+ourPhone),
                    message.toString()
                ).create();

            } catch (ApiException e){
                //throw new NumeroDesconocidoException(unPersona.getTelefono()); todo
            }
        }
}
