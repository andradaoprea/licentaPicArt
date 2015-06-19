package galerie;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrada.picart.R;

import java.util.ArrayList;
import java.util.List;


public class Gallery extends ListActivity {

    TextView output;
    ProgressBar pb;
    List<MyTask> tasks;
    List<Autori> autoriList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        output = (TextView) findViewById(R.id.textView3);

        pb = (ProgressBar)findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);

        tasks = new ArrayList<>();
        if(isOnline()) {
            requestData("http://andradapickart.esy.es/webservice/jsonautori.php");
        }else{
            Toast.makeText(this,"Network isn't available",Toast.LENGTH_LONG).show();
        }





    }

    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void updateDisplay(){

        AutorAdapter adapter = new AutorAdapter(this, R.layout.item_autor, autoriList);
        setListAdapter(adapter);
    }

    protected boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if(netInfo!=null && netInfo.isConnectedOrConnecting()){
            return true;

        }else{
            return false;
        }
    }


    private class MyTask extends AsyncTask<String, String, List<Autori>>
    {

        @Override
        protected void onPreExecute() {
           // updateDisplay();

            if(tasks.size()==0) {
                pb.setVisibility(View.VISIBLE);
            }
            tasks.add(this);
        }

        @Override
        protected String doInBackground(String... params) {

           String content = HttpManager.getData(params[0]);
            autoriList = APJsonParser.parseFeed(content);
            return content;
        }

        @Override
        protected void onPostExecute(String result) {
            autoriList = APJsonParser.parseFeed(result);

            updateDisplay();
            tasks.remove(this);
            if(tasks.size()==0) {
                pb.setVisibility(View.INVISIBLE);
            }


        }

        @Override
        protected void onProgressUpdate(String... values) {
           // updateDisplay(values[0]);
        }
    }
}
