package search.image002;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SpiderTest {
	public static void main(String[] args) {
		try {
			getHtml();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getHtml() throws Exception{
		Document doc = Jsoup.connect("http://www.mzitu.com/86819").get();
		System.out.println(doc);
	}
}
