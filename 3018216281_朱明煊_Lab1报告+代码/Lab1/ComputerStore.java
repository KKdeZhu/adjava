package Lab1;

public class ComputerStore {
    private static Computer A = new Computer("A","AMD","Samsung","Seagate","Gigabyte");
    private static Computer B = new Computer("B","Intel","Kingston","WestDigitals","Asus");
    private static Computer C = new Computer("C","Intel","Samsung","WestDigitals","Gigabyte");
    public static void list(Computer com) {
    	System.out.println(com.getName()+" : ");
    	System.out.println("Price is :"+ com.getPrice());
        System.out.println("CPU "+com.getCPU().getName()+" CoreNum "+com.getCPU().getcoreNum()+" Price "+com.getCPU().getPrice());
        com.getCPU().work();
        System.out.println("Memory "+com.getMemory().getName()+" Volume "+com.getMemory().getVolume()+" Price "+com.getMemory().getPrice());
        com.getMemory().work();
        System.out.println("Hard_disk "+com.getHard_disk().getName()+" Volume "+com.getHard_disk().getVolume()+" Price "+com.getHard_disk().getPrice());
        com.getHard_disk().work();
        System.out.println("Mainboard "+com.getMainboard().getName()+" Speed "+com.getMainboard().getSpeed()+" Price "+com.getMainboard().getPrice());
        com.getMainboard().work();
        System.out.println("\n");
    }
    public static void main(String[] args) {
    	list(A);
    	list(B);
    	list(C);
    }
}

