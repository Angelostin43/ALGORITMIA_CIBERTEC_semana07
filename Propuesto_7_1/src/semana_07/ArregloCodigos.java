package semana_07;

public class ArregloCodigos {
	private int[] codigo;
	private int indice;
	
	public ArregloCodigos() {
		codigo = new int[10];
		indice = 0;
	}
	
	public int tama�o(){
		return indice;
	}
	
	public int obtener(int numero) {
		return codigo[numero];
	}
	
	private void ampliarArreglo() {
		int[] aux = codigo;
		codigo = new int[indice + 10];
		for(int i=0;i<indice;i++) {
			codigo[i] = aux[i];
		}
	}
	
	public void adicionar(int numero) {
		if(indice == 10) {
			ampliarArreglo();
		}
		codigo[indice] = numero;
		indice ++;
	}
	
	public void intercambiarSegPen() {
		int segundo = 1;
		int penultimo = indice - 2;
		int aux = codigo[segundo];
		codigo[segundo] = codigo[penultimo];
		codigo[penultimo] = aux;
	}
	
	public void eliminarPrimero(){
		for(int i=0;i<indice;i++) {
			codigo[i] = codigo[i +1];
		}
		indice--;
	}
	
    public int posCodigo() {
    	for(int i=indice-1;i>=0;i--) {
    		if(codigo[i] > 1000 && codigo[i] < 1111) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public void intercambiarCodigo() {
    	int pos = posCodigo();
    	if(pos != -1) {
    		int aux = codigo[pos];
    		codigo[pos] = codigo[2];
    		codigo[2] = aux;
    	}
    }
    
    public void eliminarCodigo(){
    	int pos = posCodigo();
    	if(pos != -1) {
    		for(int i=pos;i<indice;i++) {
    			codigo[i] = codigo[i+1];
    		}
    		indice --;
    	}
    }
}
