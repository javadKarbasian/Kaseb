package mjkarbasian.moshtarimadar.Tool;

import android.content.ContentValues;
import android.database.Cursor;
import android.test.AndroidTestCase;
import java.util.Map;
import java.util.Set;

import mjkarbasian.moshtarimadar.Data.KasebContract;

/**
 * Created by Unique on 10/4/2016.
 */
public class TestUtilities extends AndroidTestCase {

    public static long sample_number = 100;
    public static String sample_text = "sample100";

    //region 1 State table createValues
    public static ContentValues createStateValues() {
        ContentValues StateValues = new ContentValues();
        StateValues.put(KasebContract.State.COLUMN_STATE_POINTER, sample_number++);
        return StateValues;
    }
    //endregion

    //region 2 Sales table createValues
    public static ContentValues createSalesValues(long CustomersRowId) {
        ContentValues SalesValues = new ContentValues();
        SalesValues.put(KasebContract.Sales.COLUMN_CUSTOMER_ID, CustomersRowId);
        SalesValues.put(KasebContract.Sales.COLUMN_SALE_CODE, sample_text+(sample_number++));
        SalesValues.put(KasebContract.Sales.COLUMN_IS_DELETED, false);

        return SalesValues;
    }
    //endregion

    //region 3 Products table createValues
    public static ContentValues createProductsValues() {
        ContentValues ProductsValues = new ContentValues();
        ProductsValues.put(KasebContract.Products.COLUMN_PRODUCT_NAME, sample_text+(sample_number++));
        ProductsValues.put(KasebContract.Products.COLUMN_PRODUCT_CODE, sample_text+(sample_number++));
        ProductsValues.put(KasebContract.Products.COLUMN_DESCRIPTION, sample_text+(sample_number++));
        ProductsValues.put(KasebContract.Products.COLUMN_UNIT, sample_text+(sample_number++));

        return ProductsValues;
    }
    //endregion

    //region 4 Costs table createValues
    public static ContentValues createCostsValues(long CostTypesRowId) {
        ContentValues CostsValues = new ContentValues();
        CostsValues.put(KasebContract.Costs.COLUMN_COST_TYPE_ID, CostTypesRowId);
        CostsValues.put(KasebContract.Costs.COLUMN_COST_NAME, sample_text+(sample_number++));
        CostsValues.put(KasebContract.Costs.COLUMN_COST_CODE, sample_text+(sample_number++));
        CostsValues.put(KasebContract.Costs.COLUMN_AMOUNT, sample_number++);
        CostsValues.put(KasebContract.Costs.COLUMN_DATE, sample_text+(sample_number++));
        CostsValues.put(KasebContract.Costs.COLUMN_DESCRIPTION, sample_text+(sample_number++));

        return CostsValues;
    }
    //endregion

    //region 5 PaymentMethods table createValues
    public static ContentValues createPaymentMethodsValues() {
        ContentValues PaymentMethodsValues = new ContentValues();
        PaymentMethodsValues.put(KasebContract.PaymentMethods.COLUMN_PAYMENT_METHOD_POINTER, sample_number++);
        return PaymentMethodsValues;
    }
    //endregion

    //region 6 TaxTypes table createValues
    public static ContentValues createTaxTypesValues() {
        ContentValues TaxTypesValues = new ContentValues();
        TaxTypesValues.put(KasebContract.TaxTypes.COLUMN_TAX_TYPE_POINTER, sample_number++);
        return TaxTypesValues;
    }
    //endregion

    //region 7 ProductHistory table createValues
    public static ContentValues createProductHistoryValues() {
        ContentValues StateValues = new ContentValues();
        StateValues.put(KasebContract.State.COLUMN_STATE_POINTER, sample_number++);
        return StateValues;
    }
    //endregion

    //region 8 DetailSaleTaxes table createValues
    public static ContentValues createDetailSaleTaxesValues() {
        ContentValues StateValues = new ContentValues();
        StateValues.put(KasebContract.State.COLUMN_STATE_POINTER, sample_number++);
        return StateValues;
    }
    //endregion

    //region 9 DetailSaleProducts table createValues
    public static ContentValues createDetailSaleProductsValues() {
        ContentValues StateValues = new ContentValues();
        StateValues.put(KasebContract.State.COLUMN_STATE_POINTER, sample_number++);
        return StateValues;
    }
    //endregion

    //region 10 CostTypes table createValues
    public static ContentValues createCostTypesValues() {
        ContentValues CostTypesValues = new ContentValues();
        CostTypesValues.put(KasebContract.CostTypes.COLUMN_COST_TYPE_POINTER, sample_text+(sample_number++));
        return CostTypesValues;
    }
    //endregion

    //region 11 DetailSale table createValues
    public static ContentValues createDetailSaleValues(long DetailSaleRowId) {
        ContentValues DetailSaleValues = new ContentValues();
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_SALE_ID, sample_number++);
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_DATE, sample_text+(sample_number++));
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_ITEMS_NUMBER, sample_number++);
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_SUB_TOTAL, sample_number++);
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_TOTAL_TAX, sample_number++);
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_TOTAL_DISCOUNT, sample_number++);
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_TOTAL_DUE, sample_number++);
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_TOTAL_PAID, sample_number++);
        DetailSaleValues.put(KasebContract.DetailSale.COLUMN_IS_BALANCED, false);
        return DetailSaleValues;
    }
    //endregion

    //region 12 DetailSalePayments table createValues
    public static ContentValues createDetailSalePaymentsValues() {
        ContentValues StateValues = new ContentValues();
        StateValues.put(KasebContract.State.COLUMN_STATE_POINTER, sample_number++);
        return StateValues;
    }
    //endregion

    //region 13 Customers table createValues
    public static ContentValues createCustomersValues(long StateRowId) {
        ContentValues CustomersValues = new ContentValues();

        CustomersValues.put(KasebContract.Customers.COLUMN_FIRST_NAME, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_LAST_NAME, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_BIRTHDAY, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_STATE_ID, StateRowId);
        CustomersValues.put(KasebContract.Customers.COLUMN_PHONE_MOBILE, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_DESCRIPTION, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_IS_DELETED, false);
        CustomersValues.put(KasebContract.Customers.COLUMN_EMAIL, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_PHONE_WORK, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_PHONE_OTHER, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_PHONE_FAX, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_ADDRESS_COUNTRY, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_ADDRESS_CITY, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_ADDRESS_STREET, sample_text+(sample_number++));
        CustomersValues.put(KasebContract.Customers.COLUMN_ADDRESS_POSTAL_CODE, sample_text+(sample_number++));

        return CustomersValues;
    }
    //endregion


    public static void validateCurrentRecord(String error, Cursor valueCursor, ContentValues expectedValues,String tablename) {
        Set<Map.Entry<String, Object>> valueSet = expectedValues.valueSet();
        for (Map.Entry<String, Object> entry : valueSet) {
            String columnName = entry.getKey();
            int idx = valueCursor.getColumnIndex(columnName);
            assertFalse("Column '" + columnName + "' not found. in -" + tablename + "table- " + error, idx == -1);

            String expectedValue = entry.getValue().toString();
            assertEquals("Value '" + entry.getValue().toString() +
                    "' did not match the expected value '" +
                    expectedValue + "'. " + error + "in -" + tablename + "table- " , expectedValue, valueCursor.getString(idx));
        }
    }
}