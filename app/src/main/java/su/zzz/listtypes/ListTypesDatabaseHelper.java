package su.zzz.listtypes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ListTypesDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "listtypes";
    private static final int DB_VERSION = 1;
    public static final String TABLE_MONTH = "MONTH";

    ListTypesDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+this.TABLE_MONTH+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"NAME TEXT,"
                +"SEASON TEXT);");
        insertMonth(db,"January", "Winter");
        insertMonth(db,"February", "Winter");
        insertMonth(db,"March", "Spring");
        insertMonth(db,"April", "Spring");
        insertMonth(db,"May", "Spring");
        insertMonth(db,"June", "Summer");
        insertMonth(db,"July", "Summer");
        insertMonth(db,"August", "Summer");
        insertMonth(db,"September", "Autumn");
        insertMonth(db,"October", "Autumn");
        insertMonth(db,"November", "Autumn");
        insertMonth(db,"December", "Winter");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private void insertMonth(SQLiteDatabase db, String name, String season){
        ContentValues monthValue = new ContentValues();
        monthValue.put("NAME", name);
        monthValue.put("SEASON", season);
        db.insert("MONTH", null, monthValue);
    }
}
