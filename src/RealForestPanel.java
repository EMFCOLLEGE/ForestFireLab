import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;

public class RealForestPanel extends JPanel implements MouseMotionListener, ActionListener, MouseListener {

	
	Area[][] grid;
	int rows;
	int cols;
	public int phase;
	public int counter;
	
	
	public RealForestPanel() {
		super();
		
		//Dimensions of panel divided by 4
		this.rows = 256;
		this.cols = 192;
		grid = new Area[rows][cols];
		this.phase = 0;
		
		Timer t = new Timer(75, this);
		t.start();
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		//Creates object Area for
		// the grid array
		
		for(int i = 0;i<rows;i++) {
			for(int j = 0; j<cols; j++) {
				
				
				grid[i][j] = new Area((4*i),(4*j),4,4,Color.black,0,0);
				
				
			}
		}
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				grid[i][j].paint(g);
			}
		}
		
		
		/*
		 * Paints area based on the
		 * state of the area
		 */
		
		for(int i =0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
			
			if(grid[i][j].getState()==1) {
				grid[i][j].setC(Color.gray);
		}
			else if(grid[i][j].getState() == 2) {
				grid[i][j].setC(Color.green);
		}
			else if(grid[i][j].getState()==3) {
				grid[i][j].setC(Color.red);
		}
			/*
			 * Little orange flare
			 */
			else if(grid[i][j].getState()==4) {
				grid[i][j].setState(3);
				grid[i][j].setC(Color.orange);
		}
			else if(grid[i][j].getState()==5) {
				grid[i][j].setC(Color.darkGray);

				}
			}
			
			
		
			}
		
		}
		

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int mouseX = e.getX();
		int mouseY = e.getY();
	
		
		if(true) {
			
			//Allows user to click on a square and turn red
			
			for(int i = 0;i<rows;i++) {
				for(int j = 0;j<cols;j++) {
					int x = grid[i][j].getX();
					int y =grid[i][j].getY();
					int height = grid[i][j].getHeight();
					int width = grid[i][j].getWidth();

					if(mouseX>= x && mouseY>= y && mouseX < (x + width) && mouseY < (y + height) && grid[i][j].getState() == 2) {
						grid[i][j].setState(3);
						System.out.println("User turned square Red");
						phase++;
						System.out.println(phase);
					}
				}
			}
			


			
		}	
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		//Randomizes states to be dirt or tree
		if(phase==0) {
			for(int i = 0;i<rows;i++) {
				for(int j = 0;j<cols;j++) {
				
				int randomizer = (int)(2*Math.random());

				if(randomizer==1) {
					grid[i][j].setState(1);
		
				} else{
					grid[i][j].setState(2);
				}
			
				}
			}
			phase++;
			System.out.println(phase);
		}
		
		

	//Calls Spread Fire Function
	spread();
	
	
	//Creates dead trees
	for(int i=0;i<rows;i++) {
		for(int j=0;j<cols;j++) {
			if(grid[i][j].getState()==3) {
				grid[i][j].fireStarter();
			}
		}
	}
	
	
	//Repaints
	this.repaint();
	
	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void spread() {
		 
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(grid[i][j].getState() ==3) {
					
					//Checks state of right
					if(i<rows-1 && grid[i+1][j].getState() == 2	) {
							grid[i+1][j].setState(4);
							grid[i+1][j].fireStarter();
					} 
					//Checks state of left
					else if(i>0 && grid[i-1][j].getState() == 2) {
							grid[i-1][j].setState(4);
							grid[i-1][j].fireStarter();
					} 
					//Checks state of above
					else if(j>0 && grid[i][j-1].getState() == 2) {
							grid[i][j-1].setState(4);
							grid[i][j-1].fireStarter();
					}
					//Checks state of below
					else if(j<cols-1 && grid[i][j+1].getState() == 2) {
							grid[i][j+1].setState(4);
							grid[i][j+1].fireStarter();
					}
					
					
					//Checks state of top left corner
					else if(i>0 && j>0 && grid[i-1][j-1].getState() == 2	) {
						grid[i-1][j-1].setState(4);
						grid[i-1][j-1].fireStarter();
					} 
					//Checks state of bottom right corner
					else if(i<rows-1 && j<cols-1 && grid[i+1][j+1].getState() == 2) {
						grid[i+1][j+1].setState(4);
						grid[i+1][j+1].fireStarter();
						
					} 
					//Checks state of top right corner
					else if(j>0 && i<rows-1 && grid[i+1][j-1].getState() == 2) {
						grid[i+1][j-1].setState(4);
						grid[i+1][j-1].fireStarter();
					}
					//Checks state of bottom left corner
					else if(j<cols-1 && i>0 && grid[i-1][j+1].getState() == 2) {
						grid[i-1][j+1].setState(4);
						grid[i-1][j+1].fireStarter();
					}
						
				}
				

			}
		}
			
		
	
	
		
		
		
	}
	
	

}
