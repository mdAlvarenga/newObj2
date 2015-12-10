package nadaTesteable;

public class Efectivo implements IFormaDePago {

	private IMoneda moneda;

	public Efectivo(IMoneda unaMoneda) {
		this.setMoneda(unaMoneda);
	}

	public IMoneda getMoneda() {
		return moneda;
	}
	
	public void setMoneda(IMoneda unaMoneda){
		this.moneda = unaMoneda;
	}
}

