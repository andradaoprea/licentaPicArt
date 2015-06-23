package galerie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.andrada.picart.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.andrada.picart.R.layout.activity_gallery;
import static com.example.andrada.picart.R.layout.item_autor;

/**
 * Created by Andrada on 20.06.2015.
 */
public class PictureAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Activity context;
    private final ArrayList<Picture> itemsArrayList;
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    String imageUrl = Gallery.PHOTO_BASE_URL;

    public PictureAdapter(Activity context, ArrayList<Picture> itemsArrayList) {
        this.context = context;
        this.itemsArrayList = itemsArrayList;


    }

    @Override
    public int getCount() {
        return itemsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_autor, null);
        }
        if (imageLoader == null) {
            imageLoader = AppController.getInstance().getImageLoader();
        }


        TextView tv = (TextView) convertView.findViewById(R.id.textView3);
        NetworkImageView image = (NetworkImageView) convertView.findViewById(R.id.imageView1);
        tv.setText(itemsArrayList.get(position).getNamePic());
        image.setImageUrl(imageUrl + itemsArrayList.get(position).getPhotoPic(), imageLoader);


        return convertView;

    }
}
