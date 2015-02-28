package co.edu.udea.iw.PQRS.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.PQRS.dao.hibernate.ClientDAOHibernate;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.dto.Profile;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class ClientDAOHibernateTest {

	@Autowired
	private ClientDAOHibernate clientDaoHibernate;
	private static Logger logger = Logger.getLogger(ClientDAOHibernate.class);

	@Test
	public void testInsert() {
		Client client = new Client();

		try {
			client.setFullName("Client Name 1");
			client.setLastName("Client Last Name 1");
			client.setCellphoneNumber("123456");
			client.setEmail("client1@gmail.com");
			client.setIdNumber(9876);
			client.setPhoneNumber("2215318");
			Profile profile = new Profile();
			profile.setProfile("admin");
			client.setProfile(profile);

			this.clientDaoHibernate.insert(client);
			assertTrue(true);
		} catch (IWDaoException e) {
			logger.debug("Excepción obteniendo todos los usuarios: "
					+ e.getLocalizedMessage());
			fail(e.getMessage());
		}
	}

	@Test()
	public void testGet() {
		List<Client> clients = null;

		try {
			clients = clientDaoHibernate.get();

			for (Client client : clients) {
				System.out.println(client.getFullName());
			}

			assertTrue(true);
		} catch (IWDaoException e) {
			logger.debug("Excepción obteniendo todos los usuarios: "
					+ e.getLocalizedMessage());
		}
	}
}
