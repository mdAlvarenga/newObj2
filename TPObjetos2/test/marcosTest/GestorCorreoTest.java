package marcosTest;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.BodyMailBuilder;
import model.GestorCorreo;
import nadaTesteable.IServidor;

public class GestorCorreoTest{
	protected GestorCorreo sutGestor;
	@Mock protected BodyMailBuilder builder;
	@Mock protected IServidor servidor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		sutGestor = new GestorCorreo(servidor);
	}
	
	@Test 
	public void cuandoPidoLasReservasParaMariuMeRetornaLaListaConReserva1(){
		sutGestor.update(null, builder);
		verify(builder).mailHotelero();
		verify(builder).mailPasajero();
		verify(builder).buildBody();
	}
	
	
	
}
