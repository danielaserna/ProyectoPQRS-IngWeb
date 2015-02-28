package co.edu.udea.iw.PQRS.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:/co/edu/udea/iw/PQRS/spring/config/SpringConfig.xml")
public class SolicitudeServiceTest {

	@Autowired
	private ISolicitudeService solicitudeService;

	@Test
	public void testInsertSolicitude() throws IWDaoException,
			IWServiceException {

		solicitudeService.insertSolicitude("Malo Producto", "1", "1", "123456",
				"333");

	}

	@Test
	public void getSolicitudesTest() throws IWDaoException, IWServiceException {

		List<Solicitude> solicitudeList = solicitudeService.getAll();

		for (Solicitude solicitude : solicitudeList) {
			System.out.println(solicitude.getIdSolicitude());
		}

	}

	@Test
	public void deleteSolicitude() throws IWDaoException, IWServiceException {
		
		Solicitude solicitude = new Solicitude();
		solicitude.setIdSolicitude(new Integer(1));
		
		solicitudeService.deleteSolicitude("4");
	}
	
	@Test
	public void getSolicitudeType() throws IWDaoException, IWServiceException{
		List<SolicitudeType> solicitudeList = solicitudeService.getAllSolicitudeType();
		
		for(SolicitudeType solicitudeType : solicitudeList){
			System.out.println(solicitudeType.getDescription());
		}
	}
}
