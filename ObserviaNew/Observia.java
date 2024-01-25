import java.util.ArrayList;
import java.util.Random;

public class Observia {

    public static void main(String[] args ) {
        CharberryTree tree = new CharberryTree();
		Notifier notifier = new Notifier(tree);
		Harvester harvester = new Harvester(tree);
        while (tree.getNumberOfSuccessfullHarvests() < 5) tree.maybeGrow();
    }
}

 class CharberryTree {
	
    private Random random = new Random();
    private boolean ripe = false;
	private int gotHarvestedSuccessfully;
	private ArrayList<CharberryTreeListener> listeners = new ArrayList<>();
    
    public void maybeGrow() {
    
        // Only a tiny chance of ripening each time, but we try a lot!
        if (random.nextDouble() < 0.00000001 && !ripe){
            ripe = true;
			for(CharberryTreeListener ctl: listeners){
				ctl.onFruitRipenedEvent();
			}
		}
   }
   
   public boolean getHarvested(){
	   if(ripe){
		   ripe = false;
		   gotHarvestedSuccessfully++;
		   return true;
	   }
	   return false;
   }
   
   public void addCharberryTreeListener(CharberryTreeListener ctl){
	   listeners.add(ctl);
   }
   
   public int getNumberOfSuccessfullHarvests(){
	   return gotHarvestedSuccessfully;
   }
}

interface CharberryTreeListener{
	void onFruitRipenedEvent();
}

class Notifier implements CharberryTreeListener{
	private CharberryTree tree;
	
	public Notifier(CharberryTree tree){
		this.tree = tree;
		tree.addCharberryTreeListener(this);
	}
	
	public void onFruitRipenedEvent(){
		System.out.println("A charberry fruit has ripened!");
	}
}

class Harvester implements CharberryTreeListener{
	private CharberryTree tree;
	
	public Harvester(CharberryTree tree){
		this.tree = tree;
		tree.addCharberryTreeListener(this);
	}
	
	public void onFruitRipenedEvent(){
		this.harvest();
	}
	
	public void harvest(){
		System.out.println("Me and my girl");
		if(tree.getHarvested()){
			System.out.println("Got another fruit now!");
		}
		else{
			System.out.println("Didn't find a fruit");
		}
	}
}

/*
(1) automatically notify people as soon as a tree ripens and 
(2) automatically harvest the fruit.
*/

/*
Make a Notifier class with a handle method that displays something like “A charberry fruit has ripened!” to the console window.

Make a Harvester class that knows about the tree. When it is called, it sets the tree’s “ripe” field back to false

make the CharberryTree class implement the Listener (also known as Observer) pattern. (If you don’t know it, Google “observer pattern java”)
Hint: for ease of programming, it may help to have the handle method in the Notifier class also take an argument of type CharberryTree
Update your main method to create a tree, notifier, and harvester, and get them to work together
to grow, notify, and harvest forever.
*/