package su.zzz.listtypes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Type3ListViewDatabaseActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type3_list_view_database);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listMonths = findViewById(R.id.month_list);
        final SQLiteOpenHelper listtypesDatabaseHelper = new ListTypesDatabaseHelper(this);
        try {
            db = listtypesDatabaseHelper.getReadableDatabase();
            cursor = db.query(ListTypesDatabaseHelper.TABLE_MONTH,
                    new String[]{"_id", "NAME"},
                    null, null, null,null,null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listMonths.setAdapter(listAdapter);
        } catch (Exception e) {
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    SQLiteDatabase db = listtypesDatabaseHelper.getReadableDatabase();
                    Cursor cursor = db.query(ListTypesDatabaseHelper.TABLE_MONTH,
                            new String[]{"NAME"},
                            "_id=?",
                            new String[]{Long.toString(id)},
                            null,null,null);
                    if (cursor.moveToFirst()){
                        Toast toast = Toast.makeText(getApplicationContext(), cursor.getString(0), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    cursor.close();
                    db.close();
                } catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        };
        listMonths.setOnItemClickListener(itemClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
