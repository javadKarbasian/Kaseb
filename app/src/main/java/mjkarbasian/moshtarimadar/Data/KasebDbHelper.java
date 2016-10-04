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

        //region 1 create customers Table
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
                KasebContract.Customers.COLUMN_IS_DELETED+ " BLOB NOT NULL" + ");";
        //endregion

        //region 2 create state Table
        final String CREATE_STATE_TABLE = "CREATE TABLE " + KasebContract.State.TABLE_NAME + "(" +
                KasebContract.State._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.State.COLUMN_STATE_POINTER + " INTEGER NOT NULL" + ");";
        //endregion

        //region 3 create sales table
        final String CREATE_SALES_TABLE = "CREATE TABLE " + KasebContract.Sales.TABLE_NAME + "(" +
                KasebContract.Sales._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.Sales.COLUMN_SALE_CODE + " TEXT NOT NULL," +
                " FOREIGN KEY ("+KasebContract.Sales.COLUMN_CUSTOMER_ID+") REFERENCES "+
                KasebContract.Customers.TABLE_NAME + " ("+KasebContract.Customers._ID+"), "+
                KasebContract.Sales.COLUMN_IS_DELETED + " BLOB NOT NULL" +
                ");";
        //endregion

        //region 4 create detail sale taBLE
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
        //endregion

        //region 5 create detail sale payment table
        final String CREATE_DETAIL_SALE_PAYMENT_TABLE = "CREATE TABLE " + KasebContract.DetailSalePayments.TABLE_NAME+ "(" +
                KasebContract.DetailSalePayments._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " FOREIGN KEY (" + KasebContract.DetailSalePayments.COLUMN_DETAIL_SALE_ID + ") REFERENCES "  +
                KasebContract.DetailSale.TABLE_NAME + " ("+ KasebContract.DetailSale._ID + "), " +
                " FOREIGN KEY (" + KasebContract.DetailSalePayments.COLUMN_PAYMENT_METHOD_ID + ") REFERENCES "  +
                KasebContract.PaymentMethods.TABLE_NAME + " ("+ KasebContract.PaymentMethods._ID + "), " +
                KasebContract.DetailSalePayments.COLUMN_DUE_DATE + " TEXT NOT NULL," +
                KasebContract.DetailSalePayments.COLUMN_AMOUNT + " REAL NOT NULL" + ");";
        //endregion

        //region 6 create detail sale product table
        final String CREATE_DETAIL_SALE_PRODUCT_TABLE = "CREATE TABLE " + KasebContract.DetailSaleProducts.TABLE_NAME+ "(" +
                KasebContract.DetailSaleProducts._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " FOREIGN KEY (" + KasebContract.DetailSaleProducts.COLUMN_DETAIL_SALE_ID + ") REFERENCES "  +
                KasebContract.DetailSale.TABLE_NAME + " ("+ KasebContract.DetailSale._ID + "), " +
                " FOREIGN KEY (" + KasebContract.DetailSaleProducts.COLUMN_PRODUCT_ID + ") REFERENCES "  +
                KasebContract.Products.TABLE_NAME + " ("+ KasebContract.Products._ID + "), " +
                KasebContract.DetailSaleProducts.COLUMN_QUANTITY + " INTEGER NOT NULL," +
                KasebContract.DetailSaleProducts.COLUMN_AMOUNT + " REAL NOT NULL" + ");";
        //endregion

        //region 7 create detail sale taxes table
        final String CREATE_DETAIL_SALE_TAXES_TABLE = "CREATE TABLE " + KasebContract.DetailSaleTaxes.TABLE_NAME+ "(" +
                KasebContract.DetailSaleTaxes._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " FOREIGN KEY (" + KasebContract.DetailSaleTaxes.COLUMN_DETAIL_SALE_ID + ") REFERENCES "  +
                KasebContract.DetailSale.TABLE_NAME + " ("+ KasebContract.DetailSale._ID + "), " +
                " FOREIGN KEY (" + KasebContract.DetailSaleTaxes.COLUMN_TAX_TYPE_ID + ") REFERENCES "  +
                KasebContract.TaxTypes.TABLE_NAME + " ("+ KasebContract.TaxTypes._ID + "), " +
                KasebContract.DetailSaleTaxes.COLUMN_AMOUNT + " REAL NOT NULL" + ");";
        //endregion

        //region 8 create paymentMethods table
        final String CREATE_PAYMENT_METHODS_TABLE = "CREATE TABLE " + KasebContract.PaymentMethods.TABLE_NAME + "(" +
                KasebContract.PaymentMethods._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.PaymentMethods.COLUMN_PAYMENT_METHOD_POINTER+ " INTEGER NOT NULL" + ");";
        //endregion

        //region 9 create taxtypes table
        final String CREATE_TAX_TYPES_TABLE = "CREATE TABLE " + KasebContract.TaxTypes.TABLE_NAME + "(" +
                KasebContract.TaxTypes._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.TaxTypes.COLUMN_TAX_TYPE_POINTER+ " INTEGER NOT NULL" + ");";
        //endregion

        //region 10 create product table
        final String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + KasebContract.Products.TABLE_NAME + "(" +
                KasebContract.Products._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.Products.COLUMN_PRODUCT_NAME + " TEXT NOT NULL UNIQUE," +
                KasebContract.Products.COLUMN_PRODUCT_CODE + " TEXT," +
                KasebContract.Products.COLUMN_DESCRIPTION + " TEXT,"+
                KasebContract.Products.COLUMN_UNIT + " TEXT);";
        //endregion

        //region 11 create product history table
        final String CREATE_PRODUCT_HISTORY = "CREATE TABLE " + KasebContract.ProductHistory.TABLE_NAME + "(" +
                KasebContract.ProductHistory._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " FOREIGN KEY (" + KasebContract.ProductHistory.COLUMN_PRODUCT_ID + ") REFERENCES "  +
                KasebContract.Products.TABLE_NAME + " ("+ KasebContract.Products._ID + "), " +
                KasebContract.ProductHistory.COLUMN_COST + " REAL NOT NULL," +
                KasebContract.ProductHistory.COLUMN_DATE + " TEXT NOT NULL," +
                KasebContract.ProductHistory.COLUMN_QUANTITY + " REAL NOT NULL,"+
                KasebContract.ProductHistory.COLUMN_SALE_PRICE + " REAL NOT NULL"+ ");";
        //endregion

        //region 12 create cost table
        final String CREATE_COSTS_TABLE = "CREATE TABLE " + KasebContract.Costs.TABLE_NAME + "(" +
                KasebContract.Costs._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " FOREIGN KEY (" + KasebContract.Costs.COLUMN_COST_TYPE_ID + ") REFERENCES "  +
                KasebContract.CostTypes.TABLE_NAME + " ("+ KasebContract.CostTypes._ID + "), " +
                KasebContract.Costs.COLUMN_COST_NAME + " TEXT NOT NULL," +
                KasebContract.Costs.COLUMN_COST_CODE + " TEXT," +
                KasebContract.Costs.COLUMN_AMOUNT + " REAL NOT NULL,"+
                KasebContract.Costs.COLUMN_DATE + " TEXT NOT NULL,"+
                KasebContract.Costs.COLUMN_DESCRIPTION + " TEXT"+
                ");";
        //endregion

        //region 13 create cost-types table
        final String CREATE_COST_TYPES_TABLE = "CREATE TABLE " + KasebContract.CostTypes.TABLE_NAME + "(" +
                KasebContract.CostTypes._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                KasebContract.CostTypes.COLUMN_COST_TYPE_POINTER+ " INTEGER NOT NULL" + ");";
        //endregion
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.Customers.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.State.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.Sales.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.DetailSale.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.DetailSalePayments.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.DetailSaleTaxes.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.DetailSaleProducts.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.PaymentMethods.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.TaxTypes.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.Products.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.ProductHistory.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.Costs.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + KasebContract.CostTypes.TABLE_NAME);
        onCreate(db);
    }
}
