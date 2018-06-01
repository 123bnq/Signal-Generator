import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String IPPattern = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public static void main(String[] args) {
		String[] IPList = {"3322.33.22.899", "a.b.c.d", "100", "192.168.137.1"};
		pattern = Pattern.compile(IPPattern);
		for (String string : IPList) {
			System.out.println(string + validate(string));
		}
	}
	public static String validate(final String addr) {
		matcher = pattern.matcher(addr);
		if (matcher.matches())
			return " valid";
		return "invalid";
	}
}
