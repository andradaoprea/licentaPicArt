package galerie;

import android.graphics.Bitmap;

/**
 * Created by Andrada on 19.06.2015.
 */
public class Autori {

    private int autorId;
    private String nameAutor;
    private String descriereAutor;
    private Bitmap bitmap;

    public String getNameAutor() {
        return nameAutor;
    }

    public void setNameAutor(String nameAutor) {
        this.nameAutor = nameAutor;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getDescriereAutor() {
        return descriereAutor;
    }

    public void setDescriereAutor(String descriereAutor) {
        this.descriereAutor = descriereAutor;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }



}
