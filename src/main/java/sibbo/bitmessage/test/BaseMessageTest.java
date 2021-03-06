package sibbo.bitmessage.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import sibbo.bitmessage.Options;
import sibbo.bitmessage.network.protocol.BaseMessage;
import sibbo.bitmessage.network.protocol.MessageFactory;
import sibbo.bitmessage.network.protocol.P2PMessage;
import sibbo.bitmessage.network.protocol.ParsingException;
import sibbo.bitmessage.network.protocol.V1MessageFactory;
import sibbo.bitmessage.network.protocol.VerackMessage;

public class BaseMessageTest {
	private static final Logger LOG = Logger.getLogger(BaseMessageTest.class.getName());

	public static void main(String[] args) throws IOException, ParsingException {
		MessageFactory factory = new V1MessageFactory();
		P2PMessage m = new VerackMessage(factory);

		BaseMessage b = new BaseMessage(m, factory);
		BaseMessage c = new BaseMessage(new ByteArrayInputStream(b.getBytes()), Options.getInstance().getInt(
				"protocol.maxMessageLength"), factory);

		if (!c.getCommand().equals(b.getCommand())) {
			System.out.println("Wrong command: " + c.getCommand() + " != " + b.getCommand());
		}

		if (!Arrays.equals(b.getPayload().getBytes(), c.getPayload().getBytes())) {
			System.out.println("The payloads are different: " + Arrays.toString(c.getPayload().getBytes()) + " != "
					+ Arrays.toString(b.getPayload().getBytes()));
		}

		if (!Arrays.equals(m.getBytes(), c.getPayload().getBytes())) {
			System.out.println("The resulting payload is not equal to the byte representation of the given message.");
		}

		System.out.println("Finished");
	}
}