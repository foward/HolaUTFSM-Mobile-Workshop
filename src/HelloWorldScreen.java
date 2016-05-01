import java.io.IOException;

import com.twitterapime.search.LimitExceededException;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;


final class HelloWorldScreen extends MainScreen implements FieldChangeListener
{
	
	EditField tweetField;
	ButtonField tweetButton;
        public HelloWorldScreen()
        {
                //invoke the MainScreen constructor
                super();

                //add a title to the screen
                LabelField title = new LabelField("HelloWorld Utfsm", LabelField.ELLIPSIS
                                | LabelField.USE_ALL_WIDTH);
                setTitle(title);
                
                tweetField = new EditField("Tweet: ", "");
                add(tweetField);
                
                tweetButton = new ButtonField("Tweet", ButtonField.CONSUME_CLICK);
                tweetButton.setChangeListener(this);

                //add the text "Hello World!" to the screen
                add(new RichTextField("Hello World Utfsm!"));
                
                HorizontalFieldManager buttonManager = new HorizontalFieldManager(Field.FIELD_RIGHT);
        		buttonManager.add(tweetButton);
        		add(buttonManager);
        }

        
    	public void fieldChanged(Field field, int context) {
    		if (field == tweetButton){
    			try {
    				login();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (LimitExceededException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}    		
    	}
    	
    	private void login() throws IOException, LimitExceededException{
    		if(tweetField.getTextLength() >= 140 ){
    			Dialog.alert("Debe ingresar solo 140 caracteres");
    		}else{
    			String tweetPost = tweetField.getText();
    			TweetSuccessScreen tweetSuccessScreen = new TweetSuccessScreen(tweetPost);
    			UiApplication.getUiApplication().pushScreen(tweetSuccessScreen);
    		}		
    	}
        //override the onClose() method to display a dialog box to the user
        //with "Goodbye!" when the application is closed
        public boolean onClose()
        {
            Dialog.alert("Goodbye!");
            System.exit(0);
            return true;
        }
}