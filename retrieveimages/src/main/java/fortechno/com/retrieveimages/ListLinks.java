package fortechno.com.retrieveimages;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Example program to list links from a URL.
 */
public class ListLinks {
    public static void main(String inputUrl) throws IOException {
//        Validate.isTrue(args.length == 1, "usage: supply url to fetch");
//        String url = args[0];
        String url = inputUrl;
        Log.d("myTags","testing");
        print("Fetching %s...", url);
        ArrayList<String> arrayList = new ArrayList<>();

        Document doc = Jsoup.connect(url).get();
        Elements media = doc.select("[src]");

        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img")){
                arrayList = new ArrayList<>();
                arrayList.add(src.attr("abs:src"));



            print(" * %s: <%s> %sx%s (%s)",
                    src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                    trim(src.attr("alt"), 20));}

        }
        print("__________________________________-","__________________");
        String from1 = String.valueOf(arrayList);
        String[] from = from1.split("http");
        print(" * %s: <%s> %sx%s (%s)", Arrays.toString(from));
        Log.d("myTags","testing");
        Log.d("myTags", Arrays.toString(from));

//        print("\nImports: (%d)", imports.size());
//        for (Element link : imports) {
//            print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel"));
//        }

//        for (Element link : links) {
//            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width - 1) + ".";
        else
            return s;
    }

}