package com.example;

import com.sendgrid.SendGrid;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces("application/json")
@Consumes("application/json")
public class MyResource {

    @POST
    @Path("/hulu")
    public Response sendMail() {
        Email fromEmail = new Email("t888est@kd999kdk.com");
        Content textContent = new Content(TEXT_HTML, "test");
        Mail mail = new Mail();
        mail.setSubject("test");
        mail.addContent(textContent);
        mail.setFrom(fromEmail);

        List<String> recipients = List.of("t888est@kd999kdk.com");
        for (String recipientEmail : recipients) {
            Personalization personalization = new Personalization();
            personalization.addTo(new Email(recipientEmail));
            mail.addPersonalization(personalization);
        }

        SendGrid sendGrid = new SendGrid("PUT_HERE_SOME_SEND_GRID_API_KEY_FOR_TESTING");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build()); // Body will be empty in native mode
            return sendGrid.api(request);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
