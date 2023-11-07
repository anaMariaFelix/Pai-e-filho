package email;

import javax.swing.JOptionPane;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Mensageiro extends Thread{
	
	private volatile static Mensageiro instance;
	
	private String emailCliente;
	private String mensagem;
	
	private Mensageiro() {

	}
	
	public static Mensageiro getInstance() {
		if(instance == null) {
			synchronized (Mensageiro.class) {
				if(instance == null) {
					instance = new Mensageiro();
				}
				
			}
		}
		
		return instance;
	}

	public String getEmailCliente() {
		return emailCliente;
	}
	
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void run() {

		Email email = new SimpleEmail();

		try {
			email.setDebug(false);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("mensageiro811@gmail.com", "yazgcogoqjxgaxag");
			email.setSSL(true);
			email.addTo(emailCliente);
			email.setFrom("mensageiro811@gmail.com");
			email.setSubject("Novidades ");
			email.setMsg(mensagem);
			email.send();

		} catch (EmailException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel enviar o email");
			System.out.println(e.getMessage());

		}


	}

}
