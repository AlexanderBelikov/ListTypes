package su.zzz.listtypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class Type4RecyclerViewClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type4_recycler_view_class);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get recycler view
        RecyclerView mRecyclerView = findViewById(R.id.month_recycler);
        mRecyclerView.setHasFixedSize(true);

        // change layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        MonthAdapter monthAdapter = new MonthAdapter(new String[]{"1", "2", "3"});
        mRecyclerView.setAdapter(monthAdapter);
    }
}
