package IceCreamGame;

public abstract class IceCream
{
	
	private String flavor; // IceCream HAS-A Flavor
	
	private int cashModifier; // IceCream HAS-A cashModifier
	private int expModifier; // IceCream HAS-AN expModifier
	private int sciModifier; // IceCream HAS-A sciModifier
	private int resModifier; // IceCream HAS-A resModifier

	// Default Constructor
	public IceCream()
	{
		this.flavor = "Vanilla";
		this.cashModifier = 1;
		this.expModifier = 1;
		this.sciModifier = 1;
		this.resModifier = 1;
	}
	
	// Constructor with parameters for modifiers and flavor name
	public IceCream(String newFlavor, int newCashMod, int newExpMod, int newSciMod, int newResMod)
	{
		this();
		flavor = newFlavor;
		cashModifier = newCashMod;
		expModifier = newExpMod;
		sciModifier = newSciMod;
		resModifier = newResMod;
	}
	
	public String getFlavor()
	{
		return flavor;
	}

	public void setFlavor(String newFlavor)
	{
		flavor = newFlavor;
	}
	
	public double getCashModifier()
	{
		return cashModifier;
	}
	
	public void setCashModifier(int newModifier)
	{
		cashModifier = newModifier;
	}
	
	public double getExpModifier()
	{
		return expModifier;
	}
	
	public void setExpModifier(int newModifier)
	{
		expModifier = newModifier;
	}
	
	public double getSciModifier()
	{
		return sciModifier;
	}
	
	public void setSciModifier(int newModifier)
	{
		sciModifier = newModifier;
	}
	
	public double getResModifier()
	{
		return resModifier;
	}
	
	public void setResModifier(int newModifier)
	{
		resModifier = newModifier;
	}
	
	public String toString()
	{
		String report = "";
		
		System.out.println("Flavor: " + flavor + " | Cash " + cashModifier + "x | " + "Exp " + expModifier + "x | " + "Sci " + sciModifier + "x | " + "Res" + resModifier + "x");
		
		return report;
	}
}
