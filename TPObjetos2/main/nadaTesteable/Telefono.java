package nadaTesteable;

public class Telefono {

	private Integer codigoDePais;
	private Integer codigoDeArea;
	private Integer codigoLocal;
	private Integer numeroDeAbonado;

	public Telefono(Integer unCodigoDePais, Integer unCodigoDeArea, 
					Integer unCodigoLocal, Integer unNumeroDeAbonado) {
		codigoDePais 	= unCodigoDePais;
		codigoDeArea 	= unCodigoDeArea;
		codigoLocal 	= unCodigoLocal;
		numeroDeAbonado = unNumeroDeAbonado;
	}

	public Integer getCodigoDePais() {
		return codigoDePais;
	}

	public Integer getCodigoDeArea() {
		return codigoDeArea;
	}

	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	public Integer getNumeroAbonado() {
		return numeroDeAbonado;
	}

}
