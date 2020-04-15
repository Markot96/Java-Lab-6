package ua.lviv.iot;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class PasswordFinderTest {

	@Test
	public void replaceIncorrectPassword() {
		String text = "password:DtfxsG5Hy9 password:dgygwj password:abcdef67 password:24DFggsxg7 password:87786 password:GafrJ7Kl36";
		InputStream in = new ByteArrayInputStream(text.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		text = scanner.nextLine();
		scanner.close();
		String expected = "UNSECURED password:dgygwj password:abcdef67 UNSECURED password:87786 UNSECURED";
		String actual = PasswordFinder.replaceIncorrectPassword(text, "UNSECURED");
		assertEquals(expected, actual);
	}
}