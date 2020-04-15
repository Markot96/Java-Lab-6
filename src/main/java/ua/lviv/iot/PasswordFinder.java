package ua.lviv.iot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordFinder {

	public static String replaceIncorrectPassword(String text, String changeStr) {
		Pattern pattern = Pattern.compile("\\bpassword:/(?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{10,10}\\b",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		text = matcher.replaceAll(changeStr);
		return text;
	}
}