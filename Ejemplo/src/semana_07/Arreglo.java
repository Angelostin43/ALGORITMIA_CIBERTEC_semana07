package semana_07;

public class Arreglo {

	//  Atributos privados
	private int[] n;
	private int indice;
	//  Constructor
	public Arreglo() {
		n = new int[10];
		indice = 0;
	}
	//  Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}
	public int obtener(int i) {
		return n[i];
	}
	//  Operaciones públicas complementarias
	public void buscarAdicionar(int numero) {
		int pos = buscar(numero);
		if (pos == -1)
			adicionar(numero);
	}
	public void primeroAlFinal() {
		for (int i=0; i<indice-1; i++)
			intercambiar(i, i+1);
	}
	public void ultimoAlInicio() {
		for (int i=indice-1; i>0; i--)
			intercambiar(i, i-1);
	}
	public void buscarEliminar(int numero) {
		int pos = buscar(numero);
		if (pos != -1)
			eliminar(pos);
	}
	//  Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = n;
		n = new int[indice + 10];
		for (int i=0; i<indice; i++)
			n[i] = aux[i];
	}
	private void adicionar(int numero) {
		if (indice == n.length)
			ampliarArreglo();
		n[indice] = numero;
		indice ++;
	}
	private int buscar(int numero) {
		for (int i=0; i<indice; i++)
			if (n[i] == numero)
				return i;
		return -1;
	}
	private void intercambiar(int pos1, int pos2) {
		int aux = n[pos1];
		n[pos1] = n[pos2];
		n[pos2] = aux;
	}
	private void eliminar(int pos) {
		for (int i=pos; i<indice-1; i++)
			n[i] = n[i+1];
		indice --;
	}
	
}