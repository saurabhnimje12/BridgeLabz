package BridegeLabz_Exception_Handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionChaining {
	public static void check() throws Exception {
		try {
			File file = new File("text.txt");
			FileReader fr = new FileReader(file);
		} catch (FileNotFoundException fnf) {
			throw new IOException("File Not Found Exception : " + fnf.getCause());
		}
	}

	public static void main(String[] args) {
		try {
			check();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
