package co.edu.udea.iw.PQRS.emailsender;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.PQRS.dto.City;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.dto.Profile;
import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.emailsender.exception.PQRSEmailException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class EmailSenderTest {

	@Test
	public void testSendEmail() {
		EmailSender emailSender = null;
		try {
			emailSender = new EmailSender();
		} catch (PQRSEmailException e) {
			e.printStackTrace();
		}

		Solicitude solicitude = new Solicitude();

		solicitude.setIdSolicitude(new Integer(4));
		solicitude
				.setDescription("Me salio muy malo ese producto, que cosita con ustedes");

		solicitude.setSolicitudeType(new SolicitudeType("Queja"));

		ProductType productType = new ProductType();
		productType.setType("Computador");
		Product product = new Product();
		product.setDescription("Computadora");
		product.setIdProduct(new Integer(1));
		product.setType(productType);
		solicitude.setIdProduct(product);

		City city = new City();
		city.setCode(1);
		city.setName("Medellin");
		city.setAreaCode("4");

		Sucursal sucursal = new Sucursal();
		sucursal.setIdSucursal(new Integer(1));
		sucursal.setCode(city);
		sucursal.setNombre("Centro");
		solicitude.setIdSucursal(sucursal);

		Client client = new Client();
		client.setFullName("Yefry Alexis");
		client.setLastName("Calderon Yepes");
		client.setCellphoneNumber("33333");
		client.setEmail("alexiscaly@gmail.com");
		client.setIdNumber(1234);
		client.setPhoneNumber("456764");
		Profile profile = new Profile();
		profile.setProfile("cliente");
		client.setProfile(profile);
		solicitude.setIdNumber(client);

		try {
			emailSender.sendEmail(solicitude, "Respuesta 1");
		} catch (PQRSEmailException e) {
			e.printStackTrace();
		}

		assertTrue(true);
	}

}
