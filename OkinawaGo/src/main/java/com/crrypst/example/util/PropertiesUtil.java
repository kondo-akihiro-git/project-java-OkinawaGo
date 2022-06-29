package main.java.com.crrypst.example.util;



import java.io.IOException;
import java.util.ResourceBundle;

public class PropertiesUtil {

	private static final String PROPERTIES_NAME = "application";

	//application.propertiesの読み込み
	public static String getProperty(String key) throws IOException {

		ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_NAME);
			return rb.getString(key);


	}
}