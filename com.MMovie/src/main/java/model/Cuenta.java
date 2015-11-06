package model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import Excepsiones.ExceptionCuentaInactiva;
import Excepsiones.ExceptionMinutos;
import Factory.FactoryAsignacion;
import interfaces.IAsignacionMExtras;
@Entity(name="CUENTA")
public class Cuenta {
	@Id@GeneratedValue
	@Column(name="ID_CUENTA")
	private int Id;
	private Date FechaCreacion;
	@OneToMany(mappedBy="Cuenta")
	private Set<Reserva> Reservas=new HashSet<Reserva>();
	private int MinutosExtra;
	private boolean Estado;
	@ManyToOne
	@JoinColumn(name="ID_TIPO_CUENTA")
	private TipoCuenta TipoCuenta;
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente Cliente;
	private String EstrategiaMinutosExtra;
	private int minutosDisponibles;
	public Date getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
	public boolean puedeReservar(Pelicula p){
		if(this.getMinutosTotales()>=p.getDuracion()) {
			return true;
		}
		return false;
	}
	public void agregarReserva(Reserva r) throws ExceptionMinutos, ExceptionCuentaInactiva {
		// TODO Auto-generated method stub
		Pelicula peli=r.getPelicula();
		if (!this.isEstado()) {
			throw new ExceptionCuentaInactiva();
		};
		if (!this.puedeReservar(peli)) {
			throw new ExceptionMinutos();
		};
		this.Reservas.add(r);
		peli.addReserva(r);
		this.descontarMinutos(peli);
		this.agregarMinutosExtras(peli);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cliente == null) ? 0 : Cliente.hashCode());
		result = prime * result + ((TipoCuenta == null) ? 0 : TipoCuenta.hashCode());
		return result;
	}
	public Set<Reserva> getReservas() {
		return Reservas;
	}
	public void setReservas(Set<Reserva> reservas) {
		Reservas = reservas;
	}
	public TipoCuenta getTipoCuenta() {
		return TipoCuenta;
	}
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.TipoCuenta = tipoCuenta;
		this.minutosDisponibles=tipoCuenta.getMinutos();
	}
	public String getEstrategiaMinutosExtra() {
		return EstrategiaMinutosExtra;
	}
	public void setEstrategiaMinutosExtra(String estrategiaMinutosExtra) {
		EstrategiaMinutosExtra = estrategiaMinutosExtra;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (Cliente == null) {
			if (other.Cliente != null)
				return false;
		} else if (!Cliente.equals(other.Cliente))
			return false;
		if (TipoCuenta == null) {
			if (other.TipoCuenta != null)
				return false;
		} else if (!TipoCuenta.equals(other.TipoCuenta))
			return false;
		return true;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getMinutosExtra() {
		return MinutosExtra;
	}
	public void setMinutosExtra(int minutosExtra) {
		MinutosExtra = minutosExtra;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	public Cliente getCliente() {
		return Cliente;
	}
	public int getMinutosDisponibles() {
		return minutosDisponibles;
	}
	public void setMinutosDisponibles(int minutos) {
		this.minutosDisponibles = minutos;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	private void descontarMinutos(Pelicula p) {
		int diferencia=this.getMinutosDisponibles()-p.getDuracion();
		if (this.getMinutosDisponibles()<0) {
			this.setMinutosDisponibles(0);
			diferencia=diferencia+this.getMinutosExtra();
			this.setMinutosExtra(diferencia);
		} else {
			this.setMinutosDisponibles(diferencia);
		}
	}
	private void agregarMinutosExtras(Pelicula p) {
		IAsignacionMExtras asig=FactoryAsignacion.getInstance(this.EstrategiaMinutosExtra);
		this.MinutosExtra+=asig.getMinutosExtras(p);
	}
	public int getMinutosTotales() {
		// TODO Auto-generated method stub
		int mTotales=this.getMinutosDisponibles()+this.getMinutosExtra();
		return mTotales;
	}
}
