
public class Main {

	public static void main(String[] args) throws Exception {
		UrlReader urlReader = new UrlReader("http://www.letsrevolutionizetesting.com/challenge.json");
		
		//Store the responses
		String currentForward = urlReader.getForward();
		String currentMessage = urlReader.getMessage();
		
		int runNumber = 1;
		
		//If we'll be sent to a new address
		while(currentForward != null) {
			//print our progress
			System.out.println("Run " + runNumber + " results: ");
			System.out.println("\tMessage: " + currentMessage);
			System.out.println("\tNext Challenge: " + currentForward);
			runNumber++;
			
			//Lets go again!
			urlReader = new UrlReader(urlReader.getForward().replace("challenge", "challenge.json"));
			currentForward = urlReader.getForward();
			currentMessage = urlReader.getMessage();
		}
		
		System.out.println("Final run results: ");
		System.out.println("\tFinal Message: " + currentMessage);
		System.out.println("\tFinal Challenge: " + currentForward);

	}

}
