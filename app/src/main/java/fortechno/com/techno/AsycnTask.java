package fortechno.com.techno;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Дмитрий on 11.07.2016.
 */
public class AsycnTask extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        ListLinks listLinks = new ListLinks();
        String url = (String) params[0];
        System.out.println((String) params[0]);

        try {
            listLinks.main(url);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}




