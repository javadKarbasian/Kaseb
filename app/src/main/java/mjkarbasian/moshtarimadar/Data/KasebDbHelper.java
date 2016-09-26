package mjkarbasian.moshtarimadar.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by family on 9/25/2016.
 */
public class KasebDbHelper extends SQLiteOpenHelper {

    //Defining DB version
    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "kaseb.db";

    public KasebDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating customers Table
        final String CREATE_CUSTOMERS_TABLE = "CREATE TABLE " + KasebContract.Customers.TABLE_NAME + "(" +
                KasebContract.Customers._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.Customers.COLUMN_FIRST_NAME + " TEXT NOT NULL," +
                KasebContract.Customers.COLUMN_LAST_NAME + " TEXT NOT NULL," +
                KasebContract.Customers.COLUMN_PHONE_MOBILE + " TEXT NOT NULL UNIQUE,"+
                " FOREIGN KEY ("+ KasebContract.Customers.COLUMN_STATE_ID +") REFERENCES "+
                KasebContract.State.TABLE_NAME + " ("+KasebContract.State._ID+"), " +
                KasebContract.Customers.COLUMN_PHONE_WORK + " TEXT,"+
                KasebContract.Customers.COLUMN_PHONE_FAX + " TEXT," +
                KasebContract.Customers.COLUMN_PHONE_OTHER+ " TEXT,"+
                KasebContract.Customers.COLUMN_EMAIL+" TEXT,"+
                KasebContract.Customers.COLUMN_BIRTHDAY+" TEXT,"+
                KasebContract.Customers.COLUMN_ADDRESS_COUNTRY+ " TEXT,"+
                KasebContract.Customers.COLUMN_ADDRESS_CITY+ " TEXT,"+
                KasebContract.Customers.COLUMN_ADDRESS_STREET+ " TEXT,"+
                KasebContract.Customers.COLUMN_ADDRESS_POSTAL_CODE+ " TEXT,"+
                KasebContract.Customers.COLUMN_DESCRIPTION+" TEXT,"+
                KasebContract.Customers.COLUMN_IS_DELETED+ " BLOB NOT NULL," + ");";
        //creating state Table
        final String CREATE_STATE_TABLE = "CREATE TABLE " + KasebContract.State.TABLE_NAME + "(" +
                KasebContract.State._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.State.COLUMN_STATE_POINTER + " INTEGER NOT NULL" + ");";
        //creating sales table
        final String CREATE_SALES_TABLE = "CREATE TABLE " + KasebContract.Sales.TABLE_NAME + "(" +
                KasebContract.Sales._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.Sales.COLUMN_SALE_CODE + " TEXT NOT NULL," +
                " FOREIGN KEY ("+KasebContract.Sales.COLUMN_CUSTOMER_ID+") REFERENCES "+
                KasebContract.Customers.TABLE_NAME + " ("+KasebContract.Customers._ID+"), "+
                KasebContract.Sales.COLUMN_IS_DELETED + " BLOB NOT NULL," +
                ");";
        //creating detail sale taBLE
        final String CREATE_DETAIL_SALE_TABLE = "CREATE TABLE " + KasebContract.DetailSale.TABLE_NAME+ "(" +
                KasebContract.DetailSale._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " FOREIGN KEY (" + KasebContract.DetailSale.COLUMN_SALE_ID + ") REFERENCES "+
                KasebContract.Sales.TABLE_NAME + " ("+ KasebContract.Sales._ID + "), "+
                KasebContract.DetailSale.COLUMN_DATE + " TEXT NOT NULL," +
                KasebContract.DetailSale.COLUMN_ITEMS_NUMBER+ " INTEGER NOT NULL," +
                KasebContract.DetailSale.COLUMN_SUB_TOTAL + " REAL NOT NULL," +
                KasebContract.DetailSale.COLUMN_TOTAL_DISCOUNT + " REAL NOT NULL," +
                KasebContract.DetailSale.COLUMN_TOTAL_TAX + " REAL NOT NULL,"+
                KasebContract.DetailSale.COLUMN_TOTAL_DUE + " REAL NOT NULL,"+
                KasebContract.DetailSale.COLUMN_TOTAL_PAID+ " REAL NOT NULL,"+
                KasebContract.DetailSale.COLUMN_IS_BALANCED+ " BLOB NOT NULL"+
                ");";
        //create detail sale payment table

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
