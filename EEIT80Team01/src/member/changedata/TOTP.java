package member.changedata;


import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class TOTP {

	private TOTP() {
	}

	private static byte[] hmac_sha(String crypto, byte[] keyBytes, byte[] text) {
		try {
			Mac hmac;
			hmac = Mac.getInstance(crypto);
			SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW");
			hmac.init(macKey);
			return hmac.doFinal(text);
		} catch (GeneralSecurityException gse) {
			throw new UndeclaredThrowableException(gse);
		}
	}

	private static byte[] hexStr2Bytes(String hex) {
		// Adding one byte to get the right conversion
		// Values starting with "0" can be converted
		byte[] bArray = new BigInteger("10" + hex, 16).toByteArray();

		// Copy all the REAL bytes, not the "first"
		byte[] ret = new byte[bArray.length - 1];
		for (int i = 0; i < ret.length; i++)
			ret[i] = bArray[i + 1];
		return ret;
	}

	private static final long[] DIGITS_POWER = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000,
			1000000000, 10000000000L };

	public static String generateTOTP512(String key, String time, String returnDigits) {
		return generateTOTP(key, time, returnDigits, "HmacSHA512");
	}

	public static String generateTOTP(String key, String time, String returnDigits, String crypto) {
		int codeDigits = Integer.decode(returnDigits).intValue();
		String result = null;

		// Using the counter
		// First 8 bytes are for the movingFactor
		// Compliant with base RFC 4226 (HOTP)
		while (time.length() < 16)
			time = "0" + time;

		// Get the HEX in a Byte[]
		byte[] msg = hexStr2Bytes(time);
		byte[] k = hexStr2Bytes(key);
		byte[] hash = hmac_sha(crypto, k, msg);

		// put selected bytes into result int
		int offset = hash[hash.length - 1] & 0xf;

		long binary = ((hash[offset] & 0x7f) << 24) | ((hash[offset + 1] & 0xff) << 16)
				| ((hash[offset + 2] & 0xff) << 8) | (hash[offset + 3] & 0xff);

		long otp = binary % DIGITS_POWER[codeDigits];

		result = Long.toString(otp);
		while (result.length() < codeDigits) {
			result = "0" + result;
		}
		return result;
	}

	public static String toHex(String arg) {
		byte[] buf = arg.getBytes();
		StringBuffer sb = new StringBuffer();
		for (byte b : buf) {
			sb.append(String.format("%x", b));
		}

		return sb.toString();
	}

	public static String getTOTP(String seed, long date){
		long time = date;
		long T0 = 0;
		long X = 30000;
		long T = (long) Math.floor((time - T0) / X);		
		String steps = "0";
		String seed64 = TOTP.toHex(seed);
		steps = Long.toHexString(T).toUpperCase();
		while (steps.length() < 16) {
			steps = "0" + steps;
		}		
		return generateTOTP(seed64, steps, "10", "HmacSHA512");
	}
//  test code //
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		long time = System.currentTimeMillis();
//		long T0 = 0;
//		long X = 30000;
//		long T = (long) Math.floor((time - T0) / X);
//		String steps = "0";
//		String seed = "gn00466269@gmail.com";
//		String seed64 = TOTP.toHex(seed);
//		steps = Long.toHexString(T).toUpperCase();
//		while (steps.length() < 16) {
//			steps = "0" + steps;
//		}
//		System.out.println(generateTOTP(seed64, steps, "10", "HmacSHA512"));
//	}
}
