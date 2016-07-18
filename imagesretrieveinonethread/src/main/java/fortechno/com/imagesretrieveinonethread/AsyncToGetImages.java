package fortechno.com.imagesretrieveinonethread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
// TODO: 18.07.2016 ВСЯ ПРОГАРММА В АСИНК ТАСКЕ, РАСТАЩИТЬ ЕЕ НА АДАПТЕР И КЛАСА СИНКА
/**
 * Created by Дмитрий on 18.07.2016.
 */
public class AsyncToGetImages extends AsyncTask<String, Bitmap, Bitmap> {
    Document doc;
    String url;
    String imageURL;

    protected Bitmap doInBackground(String... urls) {
        try {

            Document doc1;
            url = "http://mail.ru";
            doc1 = Jsoup.connect(url).get();
            doc = doc1;
            System.out.println("Connected _________________________");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements media = doc.select("[src]");
        for (Element src : media) {
            if (src.tagName().equals("img")) {
                imageURL = src.attr("abs:src");
                Bitmap bitmap = null;
                try {
                    URL url2= new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(new URL(imageURL).openStream());
                    } catch (MalformedURLException e) {


                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert bitmap != null;
                if (bitmap.getHeight() > 5 || bitmap.getWidth() > 5)
                    publishProgress(bitmap);


                System.out.println("Image has been______________________ downloaded");
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Bitmap... values) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater li = getLayoutInflater();
        View item = li.inflate(R.layout.list_item, ll, false);
        ImageView iv = (ImageView) item.findViewById(R.id.networkImageView);
        TextView tv = (TextView) item.findViewById(R.id.textViewForPREloadedPic);
        iv.setImageBitmap(values[0]);//bitmapArrayList.get(i));
        tv.setText(imageURL); //arrayList.get(i));
        item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        ll.addView(item);
        super.onProgressUpdate(values);
    }

    protected void onPostExecute(Bitmap doc) {
        btn.setEnabled(true);
    }
}
