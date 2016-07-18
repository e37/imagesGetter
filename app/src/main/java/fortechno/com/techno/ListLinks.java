package fortechno.com.techno;

/**
 * Created by Дмитрий on 11.07.2016.
 */

import android.widget.SimpleAdapter;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Example program to list links from a URL.
 */
public class ListLinks {
    ArrayList<String> aList = new ArrayList<>();

    public ArrayList<String> getaList() {
        return aList;
    }

    public int getaListSize() {
        return aList.size();
    }

    public void main(String url) throws IOException {

        Document doc ;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements media = doc.select("[src]");

        for (Element src : media) {
            if (src.tagName().equals("img")) {
                aList = new ArrayList<>();
                aList.add(src.attr("abs:src"));
                System.out.println("image has been downloaded");
                System.out.println(aList);
                System.out.println(Arrays.toString(aList.toArray()));


            }
        }
        ListViewAdapter listViewAdapter = new ListViewAdapter();
        listViewAdapter.main();

    }


}