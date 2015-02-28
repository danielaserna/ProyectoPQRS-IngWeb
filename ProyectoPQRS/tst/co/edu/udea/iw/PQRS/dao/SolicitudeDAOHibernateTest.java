package co.edu.udea.iw.PQRS.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.PQRS.dao.hibernate.SolicitudeDAOHibernate;
import co.edu.udea.iw.PQRS.dto.City;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.dto.Profile;
import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class SolicitudeDAOHibernateTest {

	@Autowired
	private SolicitudeDAOHibernate solicitudeDAOHibernate;
	private static Logger logger = Logger
			.getLogger(SolicitudeDAOHibernate.class);

	@Test
	public void testInsert() {
		Solicitude solicitude = new Solicitude();

		try {
			solicitude.setIdSolicitude(new Integer(4));
			solicitude
					.setDescription("Me salio muy malo ese producto, que cosita con ustedes");

			solicitude.setSolicitudeType(new SolicitudeType("Queja"));

			ProductType productType = new ProductType();
			productType.setType("Computador");
			Product product = new Product();
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
			client.setEmail("alexis@gmail.com");
			client.setIdNumber(1234);
			client.setPhoneNumber("456764");
			Profile profile = new Profile();
			profile.setProfile("cliente");
			client.setProfile(profile);
			solicitude.setIdNumber(client);

			solicitudeDAOHibernate.insert(solicitude);
			assertTrue(true);
		} catch (IWDaoException e) {
			logger.debug("Excepción obteniendo todos las solicitudes: "
					+ e.getLocalizedMessage());
		}
	}

	@Test
	public void testGet() {
		List<Solicitude> solicitudes = null;

		try {
			solicitudes = solicitudeDAOHibernate.get();

			for (Solicitude solicitude : solicitudes) {
				System.out.println(solicitude.getDescription());
			}

			assertEquals(2, solicitudes.size());
		} catch (IWDaoException e) {
			logger.debug("Excepción obteniendo todos las solicitudes: "
					+ e.getLocalizedMessage());
		}
	}
}
