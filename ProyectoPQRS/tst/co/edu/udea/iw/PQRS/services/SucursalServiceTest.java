package co.edu.udea.iw.PQRS.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.SucursalService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class SucursalServiceTest {

	@Autowired
	private SucursalService sucursalService;

	@Test
	public void testGetAllSucursals() throws IWDaoException, IWServiceException {

		List<Sucursal> sucursalList = sucursalService.getAllSucursals();

		for (Sucursal sucursal : sucursalList) {
			System.out.print(sucursal.getNombre());
		}

		assertNotNull(sucursalList);
	}

}
