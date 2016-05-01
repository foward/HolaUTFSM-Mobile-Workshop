import java.io.IOException;

import com.twitterapime.rest.Credential;
import com.twitterapime.rest.TweetER;
import com.twitterapime.rest.UserAccountManager;
import com.twitterapime.search.LimitExceededException;
import com.twitterapime.search.Tweet;
import com.twitterapime.xauth.Token;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.MainScreen;


public class TweetSuccessScreen extends MainScreen {
	
	public TweetSuccessScreen(String tweetPost) throws IOException, LimitExceededException {
		add(new RichTextField("Tweet Exitoso!"));
		add(new SeparatorField());
		add(new LabelField("Tweet :"+ tweetPost));
		
		Token token = new Token("192683686-25srg5mq1KekBYoJHBb5DpS660C12Ba2nqyYaCsX", "TivB2JCSkETDl2toB4P1izrWSUZk22dkfppohBChRCI");
		
		Credential c =
		  new Credential("francisco.riveros@gmail.com", "xtXCz7kq9azAc6pCoKrHg", "x1vr6x3FzmnPHMQmuoStAZTjJCK2Ho7vK7GfLSPDzI", token);
		UserAccountManager m =
		  UserAccountManager.getInstance(c);
		if (m.verifyCredential()) {
		  
		  Tweet t = new Tweet("(BB)"+tweetPost);
		  TweetER ter = TweetER.getInstance(m);
		  t = ter.post(t);
		}	
		
	}

}
