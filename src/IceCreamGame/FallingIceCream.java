package IceCreamGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FallingIceCream extends JPanel implements ActionListener
{

	private ArrayList<ArrayList<Pixel>> grid = new ArrayList<>();
	
	private ArrayList<ArrayList<Pixel>> tempGrid = new ArrayList<>();
	
	private Pixel defaultPixel = new Pixel(0, 0, false, Color.BLACK);
	
	private Pixel currentPixel = new Pixel(0, 0, false, Color.BLACK);
	
	private final int thickness = 10;
	
	private int panelWidth = getWidth();
	private int panelHeight = getHeight(); 
	
	private int rows = panelWidth / thickness;
	private int cols = panelHeight / thickness;
	
	private Timer fallingTimer;
	
	private Random random = new Random();
	
	// Default Constructor
	public FallingIceCream()
	{
		make2DArray();
		
		fallingTimer = new Timer(1000 / 24, this);
		fallingTimer.start();

		MouseAdapter mouse = new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
				updateCellState(e);
			}		
			@Override
			public void mouseDragged(MouseEvent e)
			{
				updateCellState(e);
			}		
		};
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);			
	}
	
	// Painting section
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw Grid First (Colors)
        drawGrid(g);
        
    	// Draw Grid Lines on Top
        drawGridLines(g);
    }
    
    private void drawGrid(Graphics g)
    { 	
    	panelWidth = getWidth();
    	panelHeight = getHeight();
    	
    	// Iterate through each cell in the grid
    	for ( int row = 0 ; row < rows ; row++) {
    		for ( int col = 0 ; col < cols ; col++)
    		{  			
                // Get pixel color or default to black if grid is not fully initialized
                Color pixelColor = grid.get(row).get(col).getColor();
                g.setColor(pixelColor);

                // Draw the cell
                g.fillRect(col * thickness, row * thickness, thickness, thickness);	
    		}
    	}    	
    }  
	
	// Draws Grid Lines for Panel
	public void drawGridLines(Graphics g)
	{
    	g.setColor(Color.LIGHT_GRAY);
    	for ( int x = 0 ; x < panelWidth ; x += thickness) {
			g.drawLine(x,  0, x, panelHeight);
    	}  	
    	for ( int y = 0 ; y < panelHeight ; y += thickness)
    	{
			g.drawLine(0,  y, panelWidth, y);
    	}
	}
	
    // Makes a blank grid for ice cream to start appearing on
	public void make2DArray()
	{
		grid.clear();
		
        rows = getHeight() / thickness;
        cols = getWidth() / thickness;
		
		for (int row = 0 ; row < rows ; row++)
		{
			ArrayList<Pixel> pixelRow = new ArrayList<>();
			for ( int col = 0 ; col < cols ; col++)
			{
				pixelRow.add(new Pixel(row, col, false , Color.BLACK)); // Default black
			}
			grid.add(pixelRow);
			tempGrid.add(pixelRow);
		}		
	}
	
	public Color randomColor()
	{	
		int red = random.nextInt(250);
		int green = random.nextInt(250);
		int blue = random.nextInt(250);
		
		Color newColor = new Color(red, green, blue);
	
		return newColor;
	}
	
	// Updates GUI
	public void updateGrid()
	{
        // Iterate from bottom to top to handle falling properly
        for (int row = rows - 2 ; row >= 0 ; row--) 
        {
            for (int col = 0 ; col < cols ; col++) 
            {
            	Pixel current = tempGrid.get(row).get(col);
            	Pixel below = tempGrid.get(row+1).get(col);
            	
            	if (current.getState() && !below.getState())
            	{
                	below.setState(true);
                	below.setColor(current.getColor());
                	
                	current.setState(false);
                	current.setColor(Color.BLACK);
            	}
            }
            grid = tempGrid;
        }  
        
//		grid = nextGrid;
//		nextGrid = temp;
        
		repaint();
	}
	
	public void updateCellState(MouseEvent e)
	{
		int col = e.getX() / thickness;
		int row = e.getY() / thickness;
		
		if (row >= 0 && row < rows && col >= 0 && col < cols)
		{
			Pixel pixel = grid.get(row).get(col);
			pixel.setState(true);
			pixel.setColor(randomColor());
			System.out.println("Row: " + row + " Col: " + col);
		}
			
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		updateGrid();
	}
	
	// Pixel Class
	class Pixel {
		
		private int x; // Row position
		
		private int y; // Column position
		
		private boolean state;
		
		private Color color; // RGB Value of Pixel
		
		// Constructor
	    public Pixel(int x, int y, boolean state, Color color) 
	    {
	        this.x = x;
	        this.y = y;
	        this.state = state;
	        this.color = color;
	    }
	    
	    public int[] getPosition(int x, int y)
	    {
	    	int[] position = {x,y};
	    	
	    	return position;
	    }
	    
	    public int getRow()
	    {
	    	return x;
	    }
	    
	    public int getCol()
	    {
	    	return y;
	    }
	    
	    public boolean getState()
	    {
	    	return state;
	    }
	    
	    public void setState(boolean newState)
	    {
	    	state = newState;
	    }
	    
	    public Color getColor()
	    {
	    	return color;
	    }
	    
	    public void setColor(Color newColor)
	    {
	    	color = newColor;
	    }
	}
}
