package fortechno.com.imagesretrieveinonethread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Document doc;
    String url;
    String imageURL;

    /**
     * ATTENTION Внимание: Специально не использовался адаптер, чтобы изображения и пункты списка дбавлялись сразу же как только загружалось изобрежение
     * с шириной или  высотой > 5 пикселей.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getImages(View view) {
        EditText dt = (EditText) findViewById(R.id.editText);
        final Button btn = (Button) findViewById(R.id.btnSearchForImages);

        Toast.makeText(this, "Gathering has been started", Toast.LENGTH_SHORT).show();
        url = String.valueOf(dt.getText());
//        url = "http://ya.ru";
        class DownloadImageAndShow extends AsyncTask<String, Bitmap, Bitmap> {
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
        new DownloadImageAndShow().execute(url);
    }
}
