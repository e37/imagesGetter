package fortechno.com.retrieveimages;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.examples.*;
import org.jsoup.examples.ListLinks;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://yandex.ru";
//        org.jsoup.examples.ListLinks links = new ListLinks();
        final String [] urls= {url};
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                try {
                    ListLinks.main((String[]) params);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        asyncTask.execute(urls);
        Log.d("myTags","testing222");
//
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Elements links = doc.select("a[href]");
//        Elements media = doc.select("[src]");
//        Elements imports = doc.select("link[href]");
//
//
//        print("\nMedia: (%d)", media.size());
//        for (Element src : media) {
//            if (src.tagName().equals("img"))
//                print(" * %s: <%s> %sx%s (%s)",
//                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
//                        trim(src.attr("alt"), 20));
//            else
//                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
//        }
//
//        print("\nImports: (%d)", imports.size());
//        for (Element link : imports) {
//            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
//        }
//
//        print("\nLinks: (%d)", links.size());
//        for (Element link : links) {
//            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//        }
//    }
//
//    private static void print(String msg, Object... args) {
//        System.out.println(String.format(msg, args));
//    }
//
//    private static String trim(String s, int width) {
//        if (s.length() > width)
//            return s.substring(0, width-1) + ".";
//        else
//            return s;
//    }
    }
    }

