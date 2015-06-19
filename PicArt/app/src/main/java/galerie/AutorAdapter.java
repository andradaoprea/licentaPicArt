package galerie;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.andrada.picart.R;

import java.util.List;


/**
 * Created by Andrada on 20.06.2015.
 */
public class AutorAdapter extends ArrayAdapter<Autori> {

        private Context context;
        private List<Autori> listaAutori;

        public AutorAdapter(Context context, int resource, List<Autori> objects){

            super(context,resource,objects);
            this.context=context;
            this.listaAutori=objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_autor, parent, false);

            Autori autor = listaAutori.get(position);
            TextView tv = (TextView) view.findViewById(R.id.textView3);
            tv.setText(autor.getNameAutor());

            return view;

        }
}
