package nadaTesteable;

public class Efectivo implements FormaDePago {

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

