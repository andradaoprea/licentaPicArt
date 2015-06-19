package galerie;

import android.graphics.Bitmap;

/**
 * Created by Andrada on 18.06.2015.
 */
public class Picture {

    private int pictureId;
    private String namePic;
    private String descriptionPic;
    private String photo;
    private int votes;
    private Bitmap bitmap;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getNamePic() {
        return namePic;
    }

    public void setNamePic(String namePic) {
        this.namePic = namePic;
    }

    public String getDescriptionPic() {
        return descriptionPic;
    }

    public void setDescriptionPic(String descriptionPic) {
        this.descriptionPic = descriptionPic;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }



    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public Picture(int pictureId, String namePic, String descriptionPic, int votes, Bitmap bitmap) {
        this.pictureId = pictureId;
        this.namePic = namePic;
        this.descriptionPic = descriptionPic;
        this.votes = votes;
        this.bitmap = bitmap;
    }
}
