package member.register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {
	private Pattern pattern;
	private Matcher matcher;
	private static final String DATE_PATTERN = 
		"^\\d{2}/\\d{2}/\\d{4}$";
	public DateValidator() {
		pattern = Pattern.compile(DATE_PATTERN);
	}
	public boolean validate(final String hex) {
		matcher = pattern.matcher(hex);			
		return matcher.matches();

	}
}
