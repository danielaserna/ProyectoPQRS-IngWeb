package co.edu.udea.iw.PQRS.services;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.PQRS.dao.hibernate.ClientDAOHibernate;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	private static Logger logger = Logger.getLogger(ClientDAOHibernate.class);

	public void testSaveClient() throws IWDaoException, IWServiceException {
		Integer idnumber = new Integer(123456);
		clientService.saveClient("Yefry", "Calderon", "3143423",
				"alexis@gmail.com", idnumber, "2341221", "cliente");
	}

	@Test
	public void testFindUserByLogin() throws IWDaoException, IWServiceException {
		Client client = clientService.findUserByLogin("123456");
		System.out.println("Bienvenido " + client.getFullName());
		assertNotNull(client);
	}

}
