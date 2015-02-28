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

import co.edu.udea.iw.PQRS.dao.hibernate.ClientDAOHibernate;
import co.edu.udea.iw.PQRS.dao.hibernate.ProductDAOHibernate;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class ProductDAOHibernateTest {

	@Autowired
	ProductDAOHibernate productDAOHibernate;
	private static Logger logger = Logger.getLogger(ClientDAOHibernate.class);

	@Test
	public void testGet() {
		List<Product> productList = null;

		try {
			productList = productDAOHibernate.get();
			for (Product product : productList) {
				System.out.println("Hola " + product.getType().getType());
			}

			assertTrue(true);
		} catch (IWDaoException e) {
			logger.debug("Excepción obteniendo todos los usuarios: "
					+ e.getLocalizedMessage());
		}
	}
}
