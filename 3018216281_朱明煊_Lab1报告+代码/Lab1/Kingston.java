package Lab1;

public class Kingston implements Memory{
	private String Name="Kingston";
    private int volume = 2048;
    private double price = 400.52;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Kingston work");
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public int getVolume() {
		// TODO Auto-generated method stub
		return volume;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
