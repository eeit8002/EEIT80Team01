package global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSValidate {
	private Pattern pattern;
	private Matcher matcher;
	private static final String DATE_PATTERN = 
			".*<script.*";
	public XSSValidate() {
		pattern = Pattern.compile(DATE_PATTERN);
	}
	public boolean validate(final String hex) {
		matcher = pattern.matcher(hex);			
		return matcher.matches();

	}
}
