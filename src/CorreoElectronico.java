import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CorreoElectronico {
	private String destinatario;
	private String asunto;
	private String cuerpo;

	public CorreoElectronico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CorreoElectronico(String destinatario, String asunto, String cuerpo) {
		super();
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public void enviarConGMail() {
		// Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el
		// remitente también.
		String remitente = "talleradvisors@gmail.com"; // Para la dirección nomcuenta@gmail.com

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", "TallerAdvisor2021Alonso"); // La clave de la cuenta
		props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
		props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(remitente));
			message.addRecipients(Message.RecipientType.TO, destinatario); // Se podrían añadir varios de la misma
																			// manera
			message.setSubject(asunto);
			message.setText(cuerpo);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, "TallerAdvisor2021Alonso");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Correo enviádo correctamente a: "+destinatario);
		} catch (MessagingException me) {
			me.printStackTrace(); // Si se produce un error
		}
	}
}
