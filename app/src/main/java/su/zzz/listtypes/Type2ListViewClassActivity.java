package su.zzz.listtypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Type2ListViewClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type2_list_view_class);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<Month> listMonthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Month.months);
        ListView listMonth = findViewById(R.id.month_list);
        listMonth.setAdapter(listMonthAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(), getResources().getStringArray(R.array.months_array)[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        listMonth.setOnItemClickListener(itemClickListener);
    }
}
