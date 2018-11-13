package pe.com.petroperu.cosude.util;

public class Utilidades {

	public static String obtenerNroAcuerdoCosude(Integer nroCosude, Integer anio, Integer nroAcuerdo){
		
		StringBuilder nroAcuerdoCosude = new StringBuilder();
		
		nroAcuerdoCosude.append(cerosIzquierda(nroCosude,Constantes.CEROS_IZQUIERDA_COSUDE));
		nroAcuerdoCosude.append("-");
		nroAcuerdoCosude.append(anio);
		nroAcuerdoCosude.append("-");
		nroAcuerdoCosude.append(cerosIzquierda(nroAcuerdo,Constantes.CEROS_IZQUIERDA_ACUERDO));
		
		return nroAcuerdoCosude.toString();
		
	}
	
	public static String cerosIzquierda(Integer numero, Integer longitud){
		
		String numeroConFormato = numero.toString();
		
		int length = numero.toString().length();
		
		int cantZeros = longitud - length;
		
		for(int i = 0; i < cantZeros; i++){
			numeroConFormato = "0" + numeroConFormato;
		}
		
		return numeroConFormato;
		
	}
}
