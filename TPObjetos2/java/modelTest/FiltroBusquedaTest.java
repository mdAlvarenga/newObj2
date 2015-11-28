package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import model.FiltroBusqueda;
import model.FiltroCantidadHuespedes;
import model.FiltroCiudadHotel;
import model.FiltroCompuesto;
import model.FiltroNombreHotel;
import model.FiltroRango;
import model.Habitacion;
import model.Hotel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;

public class FiltroBusquedaTest {
	FiltroBusqueda sutBuscador;
	Hotel hotel1;
	Hotel hotel2;
	Habitacion hab1;
	Habitacion hab2;
	Habitacion hab3;
	Habitacion hab4;
	
	List<Hotel> expected;
	List<Hotel> resultado;
	List<Hotel> listaDeHoteles;
	
	List<Habitacion> listaDeHabitaciones;
	
	List<FiltroBusqueda> listaDeFiltros;
	
	@Before
	public void setUp(){
		Habitacion hab1 = Mockito.mock(Habitacion.class);
			when(hab1.getCapacidadMaxima()).thenReturn(5);
		Habitacion hab2 = Mockito.mock(Habitacion.class);
			when(hab1.getCapacidadMaxima()).thenReturn(1);
		Habitacion hab3 = Mockito.mock(Habitacion.class);
			when(hab1.getCapacidadMaxima()).thenReturn(5);
		Habitacion hab4 = Mockito.mock(Habitacion.class);
			when(hab1.getCapacidadMaxima()).thenReturn(5);
		
		Hotel hotel1 = Mockito.mock(Hotel.class);
		Hotel hotel2 = Mockito.mock(Hotel.class);
		listaDeHoteles.add(hotel1);
		listaDeHoteles.add(hotel2);
		
		//listaDeFiltros.add(filtroCant);
	//	listaDeFiltros.add(filtroNombreHotel);
		
		//List<Filtro> listaDeFiltros = new ArrayList<Filtro>();
		//filtro ciudad, nombre de hotel, rango disponible, cantidad de personas	
		FiltroBusqueda sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		
		
		//Ejerecitar el SUT
		//El buscador busca en una lista de hoteles que tiene el sistema
		//
		resultado = sutBuscador.buscar(listaDeHoteles);
		  // use mock in test.... 
		  //assertEquals(test.getUniqueId(), 43);*/
		
	}
	
	/**
	 * El test consiste en buscar la disponibilidad de hoteles con habitaciones 
	 * disponibles para 4 personas, se realice una busqueda y se obtiene como 
	 * resultado un Hotel.
	 */
	@Test
	public void testObtengoHotelDisponiblePara4Personas() {
		
		//this.sistema.agregarHotel(this.hotel1);
		//this.sistema.agregarHotel(this.hotel2);
		
		//ArrayList<Hotel> resultados = this.sistema.evaluar(this.parametros);
		//(new ArrayList<Hotel>()).add(hotel1)
		assertEquals(expected.size(), resultado.size());
		
	}
	
	
	
	
/*	@Test
	public void test1()  {
	  //  create mock
	  MyClass test = Mockito.mock(MyClass.class);
	  
	  // define return value for method getUniqueId()
	  when(test.getUniqueId()).thenReturn(43);
	  
	  // use mock in test.... 
	  assertEquals(test.getUniqueId(), 43);
	}


	// Demonstrates the return of multiple values
	@Test
	public void testMoreThanOneReturnValue()  {
	  Iterator i= mock(Iterator.class);
	  when(i.next()).thenReturn("Mockito").thenReturn("rocks");
	  String result=i.next()+" "+i.next();
	  //assert
	  assertEquals("Mockito rocks", result);
	}

	// this test demonstrates how to return values based on the input
	@Test
	public void testReturnValueDependentOnMethodParameter()  {
	  Comparable c= mock(Comparable.class);
	  when(c.compareTo("Mockito")).thenReturn(1);
	  when(c.compareTo("Eclipse")).thenReturn(2);
	  //assert
	  assertEquals(1,c.compareTo("Mockito"));
	}

	// this test demonstrates how to return values independent of the input value

	@Test
	public void testReturnValueInDependentOnMethodParameter()  {
	  Comparable c= mock(Comparable.class);
	  when(c.compareTo(anyInt())).thenReturn(-1);
	  //assert
	  assertEquals(-1 ,c.compareTo(9));
	}*/
	
}
