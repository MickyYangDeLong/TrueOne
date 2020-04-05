package search.image002;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws Exception {
		String url ="http://www.mzitu.com/86778";
		ArrayList<String> urls = new ArrayList<String>();
		try {
			for (int i = 0; i < 40; i++) {
				int lastnumber = url.indexOf("m") + 16;
				int ordernumber = Integer.parseInt(url.substring(lastnumber));
				ordernumber++;
				String preurl = url.substring(0, lastnumber);
				url = preurl + String.valueOf(ordernumber);
				String src = SpiderUtil.getSrc(url);
				urls.add(src);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		SpiderUtil.saveImage(urls);
		SpiderTest.getHtml();
	}
}
