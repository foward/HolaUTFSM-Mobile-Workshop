import net.rim.device.api.ui.UiApplication;







public class HelloWorld extends UiApplication{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//and start the application on the event thread
        HelloWorld theApp = new HelloWorld();
        theApp.enterEventDispatcher();

	}
	
	 public HelloWorld()
     {
             //display a new screen
             pushScreen(new HelloWorldScreen());
     }

}


