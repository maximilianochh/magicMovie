package Vista;

import java.util.List;
import java.util.Map;

import model.Cliente;
import model.Cuenta;
import model.Pelicula; 
public interface IUsuario {
	public String MenuPrincipal(List<String> opsiones);
	public Map<String,Pelicula> mostrarPeliculas(List<Pelicula> peliculas,List<String> opsiones);
	public Map<String,Cuenta> modificarCuenta(Cuenta c);
	public boolean ReservarPelicula(int mExtra,int minutos,Pelicula p);
	public boolean VerListaDeReservas(List<Pelicula> peliculas);
	public void setSession(Cliente c);
	public Cliente getSession();
}
