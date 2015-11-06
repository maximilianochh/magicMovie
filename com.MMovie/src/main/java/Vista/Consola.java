package Vista;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.LeerDesdeConsola;
import model.Cliente;
import model.Cuenta;
import model.Pelicula;
import model.TipoCuenta;

public class Consola implements IUsuario {
	Cliente session=new Cliente();
	public String MenuPrincipal(List<String> opsiones) {
		// TODO Auto-generated method stub
		System.out.println("Hola soy magicMovie! que queres hacer?");
		for (int i=0;i<opsiones.size();i++) {
			System.out.println((i+1)+"-"+opsiones.get(i));
		}
		return LeerDesdeConsola.leer();
	}

	public Map<String, Pelicula> mostrarPeliculas(List<Pelicula> peliculas,List<String> opsiones) {
		// TODO Auto-generated method stub
		Map< String , Pelicula> salida=new HashMap<String , Pelicula>();		
		if (peliculas.isEmpty()) {
			System.out.println(":( lamentablemente no tenemos la peli que buscas");
			System.out.println("segui internando seguro podemos hacerte feliz :)");
			System.out.println("Para buscar denuevo presiona 1, presiona cualquer tecla para salir");
			String key=LeerDesdeConsola.leer();
			salida.put(key,null);
			return salida;
		}
		for (int i=0;i<peliculas.size();i++) {
			System.out.println((i+1)+"-"+peliculas.get(i));
		}
		System.out.println("ya se lindo/a... te moris por ver una de estas pelis");
		System.out.println("keep calm :) selecciona una pelicula ");
		int ops1=Integer.parseInt(LeerDesdeConsola.leer());
		System.out.println("Excelente eleccion campeon/a ;) ahora selecciona una opsion");
		int ops2=Integer.parseInt(LeerDesdeConsola.leer());
		String key=opsiones.get(ops2);
		Pelicula value=peliculas.get(ops1);
		salida.put(key, value);
		return salida;
	}

	public Map<String,String> modificarCuenta(List<String> opsiones) {
		// TODO Auto-generated method stub
		Map< String , String> salida=new HashMap<String ,String>();
		System.out.println("Ingreza 1 para utilizar la cuenta comun y cualquier otra tecla para utilizar la cuenta premium");
		int ops1=Integer.parseInt(LeerDesdeConsola.leer());
		System.out.println("Ingreza 1 para ganar minutos extras siendo el primero en ver los estrenos");
		System.out.println("Ingreza 2 para ganar minutos extras mirando pelicules exclusivas que pocos se animan a ver");
		int ops2=Integer.parseInt(LeerDesdeConsola.leer());
		String key1="Tipo Cuenta";
		String value1;
		if (ops1==1) {
			value1="Comun";
		} else {
			value1="premium";
		}
		String key2="Asignacion";
		String value2;
		if (ops2==1) {
			value2="Actualizados";
		} else {
			value2="Under";
		}
		salida.put(key1,value1);
		salida.put(key2, value2);
		return salida;
	}

	public boolean ReservarPelicula(int mExtra,int minutos,Pelicula p) {
		// TODO Auto-generated method stub
		if (p==null) {
			System.out.println(":( no tenes minutos para ver esta pelicula, presiona cualquier tecla para volver al menu principal");
			String ops=LeerDesdeConsola.leer();
			return true;
		}
		System.out.println("Minutos Extra: "+mExtra);
		System.out.println("Minutos: "+minutos);
		System.out.println("Duracion: "+p.getDuracion());
		System.out.println("Queres alquilar "+p.getTitulo()+"? ingreza 1 para confirmar o cualquier otra tecla para cancelar");
		String ops=LeerDesdeConsola.leer();
		if (ops.equalsIgnoreCase("s")){
			return true;
		};
		return false;
	}
	public boolean VerListaDeReservas(List<Pelicula> peliculas) {
		// TODO Auto-generated method stub	
		return false;
	}

	public void setSession(Cliente c) {
		// TODO Auto-generated method stub
		this.setSession(c);
	}

	public Cliente getSession() {
		// TODO Auto-generated method stub
		return this.session;
	}

	public Map<String, Cuenta> modificarCuenta(Cuenta c) {
		// TODO Auto-generated method stub
		return null;
	}
}
