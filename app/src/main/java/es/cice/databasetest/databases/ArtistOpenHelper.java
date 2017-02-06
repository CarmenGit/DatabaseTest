package es.cice.databasetest.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cice on 6/2/17.
 */

public class ArtistOpenHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="ArtistDB";//nombre de la b.d.
    public static final int DATABASE_VERSION=1;
    private static final String SCHEMA="CREATE TABLE ARTIST(_id INTEGER PRIMARY KEY AUTOINCREMENT, ARTIST_NAME TEXT)";
    public static final String ARTIST_TABLE="ARTIST";
    public static final String ARTIST_PK="_id";
    public static final String NAME_COLUM="ARTIST_NAME";
    private int version; //el número que me pasen en el constructor
    private Context ctx;

    public ArtistOpenHelper(Context context, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, factory, version);
        this.version = version;
        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCHEMA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //se borra la tabla que hubiera y se vuelve a actualizar
        db.execSQL("DROP TABLE ARTIST IF EXIST");
        //se vuelve a crear
        onCreate(db);
    }
}
