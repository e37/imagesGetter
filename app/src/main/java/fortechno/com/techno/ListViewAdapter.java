package fortechno.com.techno;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Дмитрий on 11.07.2016.
 */
public class ListViewAdapter extends Activity {
    final String ATTRIBUTE_NAME_URL = "url";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    public void main() {
        ListLinks ll = new ListLinks();

        ArrayList<String> arrayUrl = ll.getaList();


        int img = R.drawable.ic_launcher;


        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                ll.getaListSize());
        Map<String, Object> m;

        for (int i = 0; i < arrayUrl.size(); i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_URL, arrayUrl.get(i));
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        String[] from  = {ATTRIBUTE_NAME_URL,ATTRIBUTE_NAME_IMAGE};

        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = {R.id.textView,R.id.imageView}; // R.id.textViewForLoadedPic


        // создаем адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);


        // определяем список и присваиваем ему адаптер
        ListView lvSimple = (ListView) findViewById(R.id.listView);


        lvSimple.setAdapter(sAdapter);
        Log.d("myLogs", "Adapter has created");

    }


}







