package galerie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrada on 19.06.2015.
 */
public class APJsonParser {

    public static List<Autori> parseFeed(String content){

        try {
            JSONArray ar = new JSONArray(content);
            List<Autori> autoriList = new ArrayList<>();

            for(int i=0; i<ar.length();i++){

                JSONObject obj = ar.getJSONObject(i);
                Autori autor = new Autori();

                autor.setAutorId(obj.getInt("id"));
                autor.setNameAutor(obj.getString("nume"));
                autor.setDescriereAutor(obj.getString("descriere"));

                autoriList.add(autor);
            }

            return autoriList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
