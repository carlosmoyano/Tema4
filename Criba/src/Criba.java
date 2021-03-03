/**
 * Clase para generar números primos desde 1 hasta número solicitado al usuario.
 * @author Carlos Moyano
 * @version 1.0 03/03/2021
 */
import java.util.Arrays;
import java.util.Scanner;

public class Criba {

	/**
	 * Preparamosel array que nos servirá para calcular los primos
	 * @param max Cantidad máxima de elementos introducida por el usuario
	 * @return Vector de elementos boolean
	 */
	private static boolean [] preparaBooleanarray(int max){
		int dim = max +1;
		boolean[] esPrimo= new boolean[dim];
		
		for (int i=0; i<dim; i++) {
			esPrimo[i]=true;
		}
		esPrimo[0]= esPrimo[1] = false;
		return esPrimo;
		
	}
	
	/**
	 * 
	 * @param v Array de booleanos para contar los números primos
	 * @return Cantidad de números primos.
	 */
	private static int cuentaPrimos (boolean[] v){
		int cuenta = 0;
		for (int i=0; i<v.length;i++) {
			if (v[i]) {
				cuenta++;
			}
		}
		return cuenta;
	}
	
	/**
	 * 
	 * @param v Array que recibe para hacer la criba de números primos
	 * @return Array de booleanos
	 */
	private static boolean [] criba (boolean [] v) {
		for (int i=2; i<Math.sqrt(v.length)+1;i++) {
				if(v[i]) {
					//Eliminar los múltiplos de i
					for(int j=2*i; j<v.length; j+=i) {
						v[j] = false;
					}
				}
			}
		return v;
	}
	
	/**
	 * 
	 * @param v Array de booleanos para comprobar números primos
	 * @param n_primos Cantidad de números primos
	 * @return Array con los números primos
	 */
	private static int [] array_primos (boolean [] v, int n_primos) {
		int [] primos = new int[n_primos];
		for (int i=0,j=0; i<v.length; i++) {
			if (v[i]) {
				primos[j++] = i;
			}
		}
		return primos;
	}
	
	/**
	 * Genera los números primos de 1 a max
	 * @param max Número máximo de números primos
	 * @return Array con los números primos
	 */
	public static int[] generarPrimos (int max) {
		
		int i,j;
		if (max >=2) {
			
			boolean[] esPrimo = preparaBooleanarray(max);
			int [] vector_primos;
			
			esPrimo = criba(esPrimo);
			int n_primos = cuentaPrimos(esPrimo);
			
			return vector_primos = array_primos (esPrimo, n_primos) ;
			
		}else {
			return new int[0];
		}	
		
	}
	
	/**
	 * Método para imprimir un vector standar
	 * @param v Array a imprimir en pantalla
	 */
	public static void mostrarVector(int []v) {
		for (int i=0; i< v.length; i++) {
			System.out.print(i+1 + "  " );
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un número:");
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		System.out.println("\nVector inicial hasta: " + dato);
		mostrarVector (vector);
		vector=generarPrimos(dato);
		System.out.println("\nVector de primos hasta: " + dato);
		System.out.println(Arrays.toString(vector));
		
		teclado.close();
	}//main
	


}//Class Criba
//Branch3