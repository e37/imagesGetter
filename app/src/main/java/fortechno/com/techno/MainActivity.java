package fortechno.com.techno;

import android.app.DownloadManager;
import android.content.ContentUris;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.appcompat.*;
import android.support.v7.appcompat.BuildConfig;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.examples.*;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
//
    public void getImages(View view) throws IOException {
//        EditText type = (EditText) findViewById(R.id.editText);
//        TextView text = (TextView) findViewById(R.id.textView);
//        String urls = String.valueOf(type.getText());
        Button btnGo  = (Button) findViewById(R.id.btnSearchForImages);
        btnGo.setActivated(false);
        String url = "http://ya.ru";

        AsycnTask asyncTask = new AsycnTask();
        asyncTask.execute(url);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //создать адаптер через метонд

    }
//
//        final String ATTRIBUTE_NAME_URL = "url";
//        final String ATTRIBUTE_NAME_IMAGE = "image";
//        {
//            ListView lvSimple;
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            ListLinks ll = new ListLinks();
//            ArrayList<String> arrayUrl = ll.getaList();
//            int img = R.drawable.ic_launcher;
////            assert arrayUrl.size()!=0:"size is NULL";
////            if (true){throw  new AssertionError();}
//
//            ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(ll.getaListSize());
//            Map<String, Object> m;
//
//            for (int i = 0; i < data.size(); i++) {
//                m = new HashMap<String, Object>();
//                m.put(ATTRIBUTE_NAME_URL, arrayUrl.get(i));
//                m.put(ATTRIBUTE_NAME_IMAGE, img);
//                data.add(m);
//            }
//            // массив имен атрибутов, из которых будут читаться данные
//            String[] from = {ATTRIBUTE_NAME_URL, ATTRIBUTE_NAME_IMAGE};
//            // массив ID View-компонентов, в которые будут вставлять данные
//            int[] to = {R.id.textViewForLoadedPic, R.id.imageView};
//
//
//            // создаем адаптер
//            SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);
//
//
//            // определяем список и присваиваем ему адаптер
//            lvSimple = (ListView) findViewById(R.id.listView);
//            lvSimple.setAdapter(sAdapter);
//        }
//
//    }
}