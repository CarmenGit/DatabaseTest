package es.cice.databasetest;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

import es.cice.databasetest.databases.ArtistOpenHelper;

public class ArtistListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArtistOpenHelper opHelper=new ArtistOpenHelper(this, null, 1);
        SQLiteDatabase db=opHelper.getReadableDatabase();
        Cursor cursor=db.query(ArtistOpenHelper.ARTIST_TABLE, new String[]{ArtistOpenHelper.ARTIST_PK,ArtistOpenHelper.NAME_COLUM},null,null,null,null,null);
        CursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.row_layout,cursor,new String[]{ArtistOpenHelper.ARTIST_PK,ArtistOpenHelper.NAME_COLUM},
                new int[]{R.id.pkTV, R.id.nameTV});
        setListAdapter(adapter);
    }

}
