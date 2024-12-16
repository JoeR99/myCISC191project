package IceCreamGame;

public class Flavor extends IceCream implements Coneable
{

	private boolean coned;
	
	private String coneSize;
	
	private int flavorLevel;
	
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
