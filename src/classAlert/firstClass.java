package classAlert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class firstClass {

	URL urlCPEG; // cpeg lab wednesday
	URL urlCISC;
	InputStream is1 = null;
	InputStream is2 = null;
	BufferedReader br1;
	BufferedReader br2;
	String line;

	SendEmail emailClass = new SendEmail();

	String undefinedSeats = "(out of";
	String zeroSeats = "0 open seats (out of";
	String udelClassCPEG = "Class: CPEG324021L wednesday";
	String udelClassCISC = "Class: CISC361010 2pm";

	boolean openSeat = false;

	public firstClass() {
	}

	public void checkUdelClasses() throws Exception {
		while (!openSeat) {
			try {

				urlCPEG = new URL(
						"https://udapps.nss.udel.edu/CoursesSearch/courseInfo?&courseid=007643&offernum=1&term=2183&session=1&section=021L");
				urlCISC = new URL(
						"https://udapps.nss.udel.edu/CoursesSearch/courseInfo?&courseid=006691&offernum=1&term=2183&session=1&section=010");

				is1 = urlCPEG.openStream(); // throws an IOException
				br1 = new BufferedReader(new InputStreamReader(is1));

				is2 = urlCISC.openStream(); // throws an IOException
				br2 = new BufferedReader(new InputStreamReader(is2));

				perClass(br1, udelClassCPEG);
				perClass(br2, udelClassCISC);
				

			} catch (MalformedURLException mue) {
				mue.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					if (is1 != null)
						is1.close();
					if (is2 != null)
						is2.close();
				} catch (IOException ioe) {
					// nothing to see here
				}
			}
			TimeUnit.SECONDS.sleep(5);
		}

	}

	public void perClass(BufferedReader i, String theClass) throws IOException {
		while ((line = i.readLine()) != null) {
			if (line.toLowerCase().indexOf(undefinedSeats.toLowerCase()) != -1) {
				System.out.println(theClass);
				String newString = line.trim();
				System.out.println(newString);

				if (newString.toLowerCase().indexOf(zeroSeats.toLowerCase()) != -1) {
					System.out.println("There are zero seats");

				} else {
					System.out.println("There is a seat open!!!!");
					emailClass.email(theClass);
					openSeat = true;
				}

			}

		}
		System.out.println();
	}

}
