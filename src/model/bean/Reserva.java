package model.bean;

public class Reserva {
	private String idReserva;
	private String dataE;
	private String dataS;
	private float valor;
	private String formaPagamento;
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getDataE() {
		return dataE;
	}
	public void setDataE(String dataE) {
		this.dataE = dataE;
	}
	public String getDataS() {
		return dataS;
	}
	public void setDataS(String dataS) {
		this.dataS = dataS;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
