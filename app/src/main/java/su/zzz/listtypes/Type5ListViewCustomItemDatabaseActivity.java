package su.zzz.listtypes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Type5ListViewCustomItemDatabaseActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type5_list_view_custom_item_database);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listMonths = findViewById(R.id.month_list);
        final SQLiteOpenHelper listtypesDatabaseHelper = new ListTypesDatabaseHelper(this);
        try {
            db = listtypesDatabaseHelper.getReadableDatabase();
            cursor = db.query(ListTypesDatabaseHelper.TABLE_MONTH,
                    new String[]{"_id", "NAME", "SEASON"},
                    null, null, null,null,null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    R.layout.item_layout,
                    cursor,
                    new String[]{"NAME", "SEASON"},
                    new int[]{R.id.name, R.id.season},
                    0);
            listMonths.setAdapter(listAdapter);
        } catch (Exception e) {
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
