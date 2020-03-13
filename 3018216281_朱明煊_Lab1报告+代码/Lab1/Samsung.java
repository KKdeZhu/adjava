package Lab1;

public class Samsung implements Memory {
    private String Name="Samsung";
    private int volume = 4096;
    private double price = 500.56;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Samsung work");
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
