package handong.capstone2019s.salesb.app.mail;

import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.mail.util.MailSSLSocketFactory;

import handong.capstone2019s.salesb.domain.model.MailObject;
import handong.capstone2019s.salesb.domain.model.RequestToSeller;
import handong.capstone2019s.salesb.domain.model.SellerCustomer;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;

import javax.validation.Valid;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.util.Date;
import java.util.Properties;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@Inject
    SellerService sellerService;
	
	@RequestMapping(value = "{customerMail}/{customerCode}", method = RequestMethod.GET)
	/* @RequestMapping(value = {"/send"}, method = RequestMethod.GET) */
    public String createMail(Authentication authentication, @PathVariable("customerMail") String customerMail,@PathVariable("customerCode") String customerCode, Model model,
                             HttpServletRequest request,Principal principal) throws MalformedURLException {
		
		URL url = new URL(request.getRequestURL().toString());
		String seller = principal.getName();
		URL url_seller_page = new URL ("http://localhost:8080/SalesB-Seller/seller/"+seller);
		/*TODO seller_code insert*/

		/*
		 * String host = url.getHost(); String userInfo = url.getUserInfo(); String
		 * scheme = url.getProtocol(); int port = url.getPort(); Object path =
		 * request.getAttribute("javax.servlet.forward.request_uri"); Object query =
		 * request.getAttribute("javax.servlet.forward.query_string"); URI uri = new
		 * URI(scheme,userInfo,host,port,path,query,null);
		 */
		Date date = new Date();
		long current_time = date.getTime();
	 	
		MailObject object = new MailObject();
		object.setTo(customerMail);
		object.setText("You are now joined our car store."
				+ "\nOur seller page url is " +url_seller_page+"/"+current_time);
		object.setSubject("SalesB Seller allow you to join store."); // TODO  mail title (changable)
		model.addAttribute("mailObject", object);
        return "mail/send";
    }

    @RequestMapping(value = "{customerMail}/{customerCode}", method = RequestMethod.POST)
    public String createMail(Authentication authentication, @PathVariable("customerMail") String customerMail,@PathVariable("customerCode") String customerCode, Model model,
                             @ModelAttribute("mailObject") @Valid MailObject mailObject,
                             Errors errors) throws MessagingException, GeneralSecurityException {
        if (errors.hasErrors()) {
            return "mail/send";
        }
        
        final String USER = "salesbadvisior@gmail.com";
        final String PASSWORD = "dddd1234!!";
        String userMail = customerMail;
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.localhost", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        MailSSLSocketFactory socketFactory = new MailSSLSocketFactory();
        socketFactory.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.socketFactory", socketFactory);
        
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASSWORD);
            }
        };	
        
        Session session = Session.getInstance(properties, auth);
        
        MimeMessage msg = new MimeMessage(session);
        msg.setSentDate(new Date());
        msg.setFrom(new InternetAddress(USER));
        msg.setText(mailObject.getText()); // contents
        msg.setSubject(mailObject.getSubject()); // title
        msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(userMail));
        
        Transport.send(msg);
        
		SellerCustomer selcus = new SellerCustomer();
    	
		selcus.setSellerCode(authentication.getName());
		selcus.setCustomerCode(customerCode);
		selcus = sellerService.registerSellerCustomer(selcus);
        
        RequestToSeller requestToSeller = new RequestToSeller();
	 	requestToSeller.setCustomerCode(customerCode);
	 	sellerService.updateCustomer(requestToSeller);
	 	
        return "mail/success";
    }
    
    
	/* file include mail send code*/
   /*
    * @RequestMapping(value = "/sendTemplate", method = RequestMethod.POST) public
    * String createMailWithTemplate(Model model,
    * 
    * @ModelAttribute("mailObject") @Valid MailObject mailObject, Errors errors) {
    * if (errors.hasErrors()) { return "mail/send"; }
    * emailService.sendSimpleMessageUsingTemplate(mailObject.getTo(),
    * mailObject.getSubject(), template, mailObject.getText());
    * 
    * return "redirect:/home"; }
    * 
    * @RequestMapping(value = "/sendAttachment", method = RequestMethod.POST)
    * public String createMailWithAttachment(Model model,
    * 
    * @ModelAttribute("mailObject") @Valid MailObject mailObject, Errors errors) {
    * if (errors.hasErrors()) { return "mail/send"; }
    * emailService.sendMessageWithAttachment( mailObject.getTo(),
    * mailObject.getSubject(), mailObject.getText(), attachmentPath );
    * 
    * return "redirect:/home"; }
    */
}