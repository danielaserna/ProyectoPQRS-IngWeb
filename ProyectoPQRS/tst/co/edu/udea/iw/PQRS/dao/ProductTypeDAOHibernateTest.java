package co.edu.udea.iw.PQRS.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.PQRS.dao.hibernate.ProductTypeDAOHibernate;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class ProductTypeDAOHibernateTest {

	@Autowired
	private ProductTypeDAOHibernate productTypeHibernate;

	@Test
	public void testGet() {
		List<ProductType> productTypeList = null;

		try {
			productTypeList = this.productTypeHibernate.get();

			for (ProductType product : productTypeList) {
				System.out.println(product.getType());
			}

			assertTrue(true);
		} catch (IWDaoException e) {
			fail(e.getMessage());
		}
	}
}
