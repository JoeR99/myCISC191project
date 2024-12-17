package IceCreamGame;

/**
 * Lead Author(s):
 * @author Joseph Rathbun
 *  
 * References: 
 *  
 * Version/date: 12/16/2024
 * 
 * Responsibilities of class: 
 * 
 * Flavor class (subclass of IceCream) which inherits from the abstract class IceCream. Contains logic for cones and cone sizes
 * 
 */

public class Flavor extends IceCream implements Coneable
{

	private boolean coned;
	
	private String cone = "No Cone";
	
	private String coneSize;
	
//	private int flavorLevel;
	
	public Flavor()
	{
		super();
	}
	
	public Flavor(String newFlavor, int newCashMod, int newExpMod, int newSciMod, int newResMod) 
	{
		super(newFlavor, newCashMod, newExpMod, newSciMod, newResMod);
	}
	
	@Override
	public boolean isConed()
	{
		// TODO Auto-generated method stub
		return coned;
	}
	
	@Override
	public void setConed(boolean state)
	{
		// TODO Auto-generated method stub
		coned = state;
	}

	@Override
	public String getCone()
	{
		// TODO Auto-generated method stub
		return cone;
	}
	
	@Override
	public void setCone(String cone)
	{
		// TODO Auto-generated method stub
		this.cone = cone;
	}
	
	@Override
	public String getConeSize()
	{
		// TODO Auto-generated method stub
		return coneSize;
	}

	@Override
	public void setConeSize(String newConeSize)
	{
		// TODO Auto-generated method stub
		coneSize = newConeSize;
	}


}
