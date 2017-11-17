import com.lidiabazhenova.Info;
import junit.framework.TestCase;
import org.jmock.Mockery;
import org.jmock.Expectations;

import java.io.File;

public class InfoTest {
    Mockery context = new Mockery();

    public void testOneSubscriberReceivesAMessage() {
        // set up
//        final File file = context.mock(File.class);
//
//        Info info = new Info();
//        info.createHtml(values);
//
//        final String message = "message";
//
//        // expectations
//        context.checking(new Expectations() {{
//            oneOf (file).getPath(message);
//        }});
//
//        // execute
//        publisher.publish(message);
//
//        // verify
//        context.assertIsSatisfied();
    }
}
