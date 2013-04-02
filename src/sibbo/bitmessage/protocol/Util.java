package sibbo.bitmessage.protocol;

import java.util.logging.Logger;

/**
 * Provides some methods that are useful in multiple places.
 * 
 * @author Sebastian Schmidt
 * @version 1.0
 * 
 */
public final class Util {
	private static final Logger LOG = Logger.getLogger(Util.class.getName());

	/** Utility class */
	private Util() {
	}

	/**
	 * Returns a byte array containing the bytes of the given integer in big
	 * endian order.
	 * 
	 * @param i The integer to convert.
	 * @return A byte array containing the 4 bytes of the given integer in big
	 *         endian order.
	 */
	public static byte[] getBytes(int i) {
		return new byte[] { (byte) (i >> 24), (byte) (i >> 16 & 0xFF),
				(byte) (i >> 8 & 0xFF), (byte) (i & 0xFF) };
	}

	/**
	 * Creates an integer created from the given bytes.
	 * 
	 * @param b The byte data in big endian order.
	 * @return An integer created from the given bytes.
	 */
	public static int getInt(byte[] b) {
		int i = 0;

		i |= b[0] << 24;
		i |= b[1] << 16;
		i |= b[2] << 8;
		i |= b[3];

		return i;
	}

	/**
	 * Returns a byte array containing the bytes of the given long in big endian
	 * order.
	 * 
	 * @param l The long to convert.
	 * @return A byte array containing the 4 bytes of the given long in big
	 *         endian order.
	 */
	public static byte[] getBytes(long l) {
		return new byte[] { (byte) (l >> 56), (byte) (l >> 48),
				(byte) (l >> 40), (byte) (l >> 32), (byte) (l >> 24),
				(byte) (l >> 16 & 0xFF), (byte) (l >> 8 & 0xFF),
				(byte) (l & 0xFF) };
	}

	/**
	 * Creates a long created from the given bytes.
	 * 
	 * @param b The byte data in big endian order.
	 * @return A long created from the given bytes.
	 */
	public static long getLong(byte[] b) {
		long l = 0;

		l |= b[0] << 56;
		l |= b[1] << 48;
		l |= b[2] << 40;
		l |= b[3] << 32;
		l |= b[4] << 24;
		l |= b[5] << 16;
		l |= b[6] << 8;
		l |= b[7];

		return l;
	}
}