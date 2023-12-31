package semana_07;

public class ArregloEdades {

	//  Atributos privados
	private int[] edad;
	private int indice;
	//  Constructor
	public ArregloEdades() {
		edad = new int[10];
		indice = 0;
	}
	//  Operaciones p�blicas b�sicas
	public int tamanio() {
		return indice;
	}
	public int obtener(int i) {
		return edad[i];
	}
	public void adicionar(int numero) {
		if (indice == edad.length)
			ampliarArreglo();
		edad[indice] = numero;
		indice ++;
	}
	//  Operaciones p�blicas complementarias
	public void eliminarAlFinal() {
		indice --;
	}
	public void eliminarTodo() {
		indice = 0;
	}
	//  Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = edad;
		edad = new int[indice + 10];
		for (int i=0; i<indice; i++)
			edad[i] = aux[i];
	}
	
	public int posPrimeraEdadAdolescente() {
		for(int i=0;i<indice;i++) {
			if(edad[i]>12 && edad[i]<20) {
				return i;
			}
		}
		return -1;
	}
	
	public int posUltimaEdadAdolescente() {
		for(int i=indice-1;i>=0;i--) {
			if(edad[i]>12 && edad[i]<20) {
				return i;
			}
		}
		return -1;
	}
	
	public void remplazarPrimeraEdadAdolescente() {
		int pos = posPrimeraEdadAdolescente();
		int pos2 = posUltimaEdadAdolescente();
		if(pos != -1 && pos2 != -1) {
			edad[pos] = edad[pos2];
		}
	}
	
	public void intercambiarEdadesAdolescentesExtremas() {
		int pos = posPrimeraEdadAdolescente();
		int pos2 = posUltimaEdadAdolescente();
		if(pos != -1 && pos2 != -1) {
			int aux = edad[pos];
			edad[pos] = edad[pos2];
			edad[pos2] = aux;
		}
	}
	
	public void eliminarPrimeraEdadAdolescente() {
		int pos = posPrimeraEdadAdolescente();
		if(pos != -1) {
			for(int i=pos;i<indice -1;i++) {
				edad[i] = edad[i+1];
			}
			indice --;
		}
	}

}
