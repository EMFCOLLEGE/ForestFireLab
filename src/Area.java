import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Area {
	private int x;
    private int y;
    private int width;
    private int height;
    
    protected int state;

    private Color c;
    
    private int fireTick;
 

    public Area(int x, int y, int w, int h, Color c, int state, int fireTick){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.c = c;
        this.state = state;
        this.fireTick = fireTick;
        
        
    }

    public void paint(Graphics g){
        g.setColor(c);
        g.fillRect(x,y,width,height);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getState() {
    	return state;
    }

    public void setState(int state) {
    	this.state = state;
    }

  

    public int getFireTick() {
    	return fireTick;
    }
    
    public void setFireTick(int fireTick) {
    	this.fireTick = fireTick;
    }
    
    public void fireStarter() {
    	
    	/*
    	 * Adds to fireTick until
    	 * it reaches 35, which it will
    	 * then turn red Area into Gray,
    	 * signifying dead
    	 */
    	
    	fireTick++;
    	if(fireTick==35) {
    		setState(5);
    	}

    }
    
}

