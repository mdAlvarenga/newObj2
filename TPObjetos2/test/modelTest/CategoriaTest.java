package modelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Categoria;

public class CategoriaTest {
	
	@Test
	public void testCategoria(){
		Categoria categoria = new Categoria(4);
		assertEquals(categoria.getCantidadEstrellas(), 4);
	}

}
