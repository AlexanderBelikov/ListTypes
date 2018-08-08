package su.zzz.listtypes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("MainActivity", "itemSelect: position = " + Integer.toString(position) + ", id = "+ Long.toString(id));
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(getApplicationContext(), ListViewStringArrayActivity.class);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), Type2ListViewClassActivity.class);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), Type3ListViewDatabaseActivity.class);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), Type4RecyclerViewClassActivity.class);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), Type5ListViewCustomItemDatabaseActivity.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        };
        ListView listView = findViewById(R.id.types_array);
        listView.setOnItemClickListener(itemClickListener);
    }

}
