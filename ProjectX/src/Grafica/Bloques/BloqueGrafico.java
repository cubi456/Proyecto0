package Grafica.Bloques;


import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */

public abstract class BloqueGrafico{
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	
	/**
	 * Recibe los parametros px y py y setea la grafica en la celda correspondiente
	 * @param px ubicacion horizontal del bloque
	 * @param py ubicacion vertical del bloque
	 */
	
	protected BloqueGrafico(int px, int py){
		this.x=px*ancho;
		this.y=py*alto;
	}
	
	/**
	 * 	Retorna la imagen asociada al grafico
	 * @return JLabel grafico
	 */
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(x, y, ancho, alto);
		}
		
		return this.grafico;
	}
	
	/**
	 * Setear imagen a grafico
	 * @param JLabel b grafico a asignar
	 */
	public void setGrafico(JLabel b)
	{
		if(grafico!=null)
			this.grafico=b;
	}
	/**
	 * Se utiliza este metdo para aquellos bloques que la accion destruir
	 * les acciona algo.
	 */
	//Solo lo define BloqueDestruible
	public abstract void destruir();
	
}
