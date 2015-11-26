package Grafica.Personajes;

import java.awt.Point;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public abstract class PersonajeGrafico{
	protected JLabel grafico;
	protected Vector<Vector<Icon>> sprites;
	protected final int ancho= 32;
	protected final int alto= 32;
	protected int velocidad;
	protected Point pos;
	
	/**
	 * Recibe los parametros px y py y setea la grafica en la celda correspondiente
	 * @param px ubicacion horizontal del bloque
	 * @param py ubicacion vertical del bloque
	 */
	protected PersonajeGrafico(int v, int x, int y){
		this.velocidad=v;
		pos = new Point(ancho * x, alto * y);
		sprites = new Vector<Vector<Icon>>();
				
	}

	/**
	 * La logica le pasa la direccion donde va a mirar antes de verificar si puede moverse
	 * @param dir a donde se piensa mover
	 */
	public void cambiarDirec(int dir)
	{
			grafico.setIcon(sprites.elementAt(dir).elementAt(0));
	}
	/**
	 * mueve personaje segun la accion que se debe hacer
	 * 0:izquierda, 1:arriba, 2:derecha, 3:abajo, 4:muerte.
	 * @param direccion a la que se le pide mover
	 */
	
	public void mover(int direccion)
	{
		if(direccion==4)
			muerte();
		else
			{
				for(int j=0;j<2;j++){
					movimientoGrafico(direccion, 2);
				}
				grafico.setIcon(sprites.elementAt(direccion).elementAt(0));
			}
	}
	/**
	 * Metodo que emplea el movimiento grafico
	 * @param direccion
	 * @param mov
	 */
	private void movimientoGrafico(int direccion, int mov){
		for(Icon i:sprites.elementAt(direccion)){
			switch(direccion){
			case 0:
				pos.setLocation(pos.getX()-mov,pos.getY());
				break;
			case 1:
				pos.setLocation(pos.getX(), pos.getY()-mov);
				break;
			case 2:
				pos.setLocation(pos.getX()+mov,pos.getY());
				break;
			case 3:
				pos.setLocation(pos.getX(),pos.getY()+mov);
				break;	
			}
		  		grafico.setIcon(i);
		  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
		  		try {
					Thread.sleep(velocidad/(sprites.elementAt(direccion).size()*2));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	}
	}
	/**
	 * Metodo que emplea la animacion de la muerte
	 */
	private void muerte(){
		 for(Icon i:sprites.elementAt(4))
	  	 {
	  		 grafico.setIcon(i);
	  		 try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	 }
	  	 grafico.setIcon(null);
	}
	/**
	 * Retorna el imagen asociada al grafico
	 * @return Jlabel
	 */
	public JLabel getGrafico()
	{
		return this.grafico;
	}
	
	/**
	 * La logica lo llama cuandoun personaje muere para activar animacion
	 */
	public void morir()
	{
		if(this.grafico != null)	
			this.mover(4);
	}
	
	/**
	 * Setea velocidad pasada por parametro
	 * @param vel a la cual se quiere asignar
	 */

	
	public void setVelocidad(int vel)
	{
		velocidad=vel;
	}
	
	/**
	 * Este metodo se utiliza para aquellos personajes que deban cambiar
	 * por otro(estilo disfraz).
	 * En este caso solo lo utilizara Bomberman, porlo que solo este lo redefinira
	 * @param i
	 */
	public abstract void cambiarA(int i);
		//Solo redifinira Bomberman en modo Dios
		//se redefinira para las clases que lo necesitan

}