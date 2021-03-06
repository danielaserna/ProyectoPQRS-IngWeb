package co.edu.udea.iw.PQRS.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testGetAllProductType() throws IWDaoException,
			IWServiceException {
		List<ProductType> listProductType = productService.getAllProductType();

		for (ProductType productType : listProductType) {
			System.out.println(productType.getType());
		}
	}

	@Test
	public void testGtAllProducts() throws IWDaoException, IWServiceException {

		List<Product> productList = productService.getAllProducts();

		for (Product product : productList) {
			System.out.println(product.getType().getType() + " "
					+ product.getDescription());
		}

	}

}
