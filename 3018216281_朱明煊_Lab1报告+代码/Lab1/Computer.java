package Lab1;

public class Computer {
    private String Name;
    private double Price;
    private CPU cpu;
    private Memory memory;
    private Mainboard mainboard;
    private Hard_disk hard_disk;
    public Computer(String name,String cpu,String memory,String hard_disk,String mainboard) {
   	    this.Name=name;
   	    this.cpu=conCPU(cpu);
   	    this.memory=conMem(memory);
   	    this.mainboard=conMain(mainboard);
   	    this.hard_disk=conHar(hard_disk);
   	    this.Price=this.cpu.getPrice()+this.memory.getPrice()+this.hard_disk.getPrice()+this.mainboard.getPrice();
    }
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
	}
	public CPU getCPU() {
		return cpu;
	}
	public void setCPU(String name) {
		if(name.equals("AMD")) {
		    this.cpu = new AMD();
		}
	    else if(name.equals("Intel")) {
			this.cpu = new Intel();
		}
	    else {
	    	this.cpu = null;
		}
	}
	public Memory getMemory() {
		return memory;
	}
	public void setMemory(String name) {
		if(name.equals("Samsung")) {
		    this.memory = new Samsung();
		}
	    else if(name.equals("Kingston")) {
			this.memory = new Kingston();
		}
	    else {
	    	this.memory = null;
		}
	}
	public Mainboard getMainboard() {
		return mainboard;
	}
	public void setMainboard(String name) {
		if(name.equals("Asus")) {
		    this.mainboard = new Asus();
		}
	    else if(name.equals("Gigabyte")) {
			this.mainboard = new Gigabyte();
		}
	    else {
	    	this.mainboard = null;
		}
	}
	public Hard_disk getHard_disk() {
		return hard_disk;
	}
	public void setHard_disk(String name) {
		if(name.equals("Seagate")) {
		    this.hard_disk = new Seagate();
		}
	    else if(name.equals("WestDigitals")) {
			this.hard_disk = new WestDigitals();
		}
	    else {
	    	this.hard_disk = null;
		}
	}
	public CPU conCPU(String name){
	    if(name.equals("AMD")) {
		    return new AMD();
		}
	    else if(name.equals("Intel")) {
			return new Intel();
		}
	    else {
			return null;
		}
	}
	public Memory conMem(String name){
	    if(name.equals("Samsung")) {
		    return new Samsung();
		}
	    else if(name.equals("Kingston")) {
			return new Kingston();
		}
	    else {
			return null;
		}
	}
	public Hard_disk conHar(String name){
	    if(name.equals("Seagate")) {
		    return new Seagate();
		}
	    else if(name.equals("WestDigitals")) {
			return new WestDigitals();
		}
	    else {
			return null;
		}
	}
	public Mainboard conMain(String name){
	    if(name.equals("Asus")) {
		    return new Asus();
		}
	    else if(name.equals("Gigabyte")) {
			return new Gigabyte();
		}
	    else {
			return null;
		}
	}
}
