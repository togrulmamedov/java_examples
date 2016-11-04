package chaptertwo.sixteen;
/**
 * An <code>IQueueExecutor</code> object
 * execute an <code>ImpatientQueue</code> object.
 * @author tohrul
 * @version 0.0.1
 */
public class IQueueExecutor {

	public static void main(String[] args) {
		ImpatientQueue<String> iQueue = new ImpatientQueue<String>(){{
			addItem("I am first.");
			addItem("I am second");
			addItem("I am third");
			addItem("I am fourth");
		}};
		
		System.out.println(iQueue + "\n\n");
		
		iQueue.removeItem("I am third");
		
		System.out.println(iQueue + "\n\n");
		
	}

}
