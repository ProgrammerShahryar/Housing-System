package com.example.assignment.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assignment.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.assignment.model.Util.APPLICATION_DATE;
import static com.example.assignment.model.Util.APPLICATION_ID;
import static com.example.assignment.model.Util.APPLICATION_MONTH;
import static com.example.assignment.model.Util.APPLICATION_STATUS;
import static com.example.assignment.model.Util.APPLICATION_YEAR;
import static com.example.assignment.model.Util.DURATION;
import static com.example.assignment.model.Util.FROM_DATE;
import static com.example.assignment.model.Util.KEY_ADDRESS;
import static com.example.assignment.model.Util.KEY_EMAIL;
import static com.example.assignment.model.Util.KEY_FULL_NAME;
import static com.example.assignment.model.Util.KEY_FULL_NAME2;
import static com.example.assignment.model.Util.KEY_ID;
import static com.example.assignment.model.Util.KEY_ID2;
import static com.example.assignment.model.Util.KEY_RESIDENCE_ID;
import static com.example.assignment.model.Util.KEY_MONTHLYRENTAL;
import static com.example.assignment.model.Util.KEY_MONTHLY_INCOME;
import static com.example.assignment.model.Util.KEY_NUMOFUNITS;
import static com.example.assignment.model.Util.KEY_PASSWORD;
import static com.example.assignment.model.Util.KEY_PASSWORD2;
import static com.example.assignment.model.Util.KEY_RESIDENCE_STATUS;
import static com.example.assignment.model.Util.KEY_SIZEPERUNIT;
import static com.example.assignment.model.Util.KEY_USER_NAME;
import static com.example.assignment.model.Util.KEY_USER_NAME2;
import static com.example.assignment.model.Util.RES_ID;
import static com.example.assignment.model.Util.TABLE_Application;
import static com.example.assignment.model.Util.TABLE_User1;
import static com.example.assignment.model.Util.TABLE_User2;
import static com.example.assignment.model.Util.TABLE_NAME;




public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_User1 + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + Util.KEY_USER_NAME + " TEXT," + KEY_PASSWORD + " TEXT," + Util.KEY_FULL_NAME + " TEXT," + Util.KEY_EMAIL + " TEXT,"
            + Util.KEY_MONTHLY_INCOME + " TEXT" + ")";

    private static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_User2 + "(" + KEY_ID2 + " INTEGER PRIMARY KEY,"
            + Util.KEY_USER_NAME2 + " TEXT," + KEY_PASSWORD2 + " TEXT," + Util.KEY_FULL_NAME2 + " TEXT"
            + ")";

    private static final String CREATE_TABLE3 = "CREATE TABLE " + TABLE_NAME + "(" + KEY_RESIDENCE_ID + " INTEGER PRIMARY KEY,"
            + Util.KEY_ADDRESS + " TEXT," + KEY_NUMOFUNITS + " TEXT," + KEY_SIZEPERUNIT +" TEXT," + Util.KEY_MONTHLYRENTAL +
            " TEXT," + KEY_RESIDENCE_STATUS + " TEXT DEFAULT \"Available\""  + ")";

    private static final String CREATE_TABLE4 = "CREATE TABLE " + TABLE_Application + "(" + APPLICATION_ID + " INTEGER PRIMARY KEY,"
            + Util.APPLICATION_DATE + " TEXT," + APPLICATION_MONTH + " TEXT," + Util.APPLICATION_YEAR + " TEXT," + APPLICATION_STATUS + " TEXT DEFAULT \"Pending\","
            + KEY_RESIDENCE_ID + " INTEGER, " + RES_ID + " INTEGER, " + FROM_DATE + " TEXT," + DURATION + " TEXT,"
            + " FOREIGN KEY ("+ RES_ID +") REFERENCES "+ TABLE_NAME +"("+ KEY_RESIDENCE_ID +"));";

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);
        db.execSQL(CREATE_TABLE3);
        db.execSQL(CREATE_TABLE4);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion1) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_User1 + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_User2 + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_Application + "'");


        onCreate(db);
    }

    public void AddUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME, user.userName);
        values.put(KEY_PASSWORD, user.password);
        values.put(KEY_FULL_NAME, user.fullName);
        values.put(KEY_EMAIL, user.email);
        values.put(KEY_MONTHLY_INCOME, user.monthlyIncome);

        // Inserting Row
        db.insert(TABLE_User1, null, values);
        db.close();
    }

    public void AddUser2(User2 user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME2, user.userName);
        values.put(KEY_PASSWORD2, user.password);
        values.put(KEY_FULL_NAME2, user.fullName);

        // Inserting Row
        db.insert(TABLE_User2, null, values);
        db.close();
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_User1,// Selecting Table
                new String[]{KEY_ID, KEY_USER_NAME, KEY_PASSWORD},//Selecting columns want to query
                KEY_USER_NAME + "=?",
                new String[]{user.userName},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //if cursor has value then in user database there is user associated with this given username
            User user1 = new User(cursor.getString(0), cursor.getString(1),
                    cursor.getString(2));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }
        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public User2 Authenticate(User2 user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_User2,// Selecting Table
                new String[]{KEY_ID2, KEY_USER_NAME2, KEY_PASSWORD2},//Selecting columns want to query
                KEY_USER_NAME2 + "=?",
                new String[]{user.userName},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //if cursor has value then in user database there is user associated with this given username
            User2 user1 = new User2(cursor.getString(0), cursor.getString(1),
                    cursor.getString(2));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }
        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public void AddResidence(Residence residence){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ADDRESS, residence.getAddress());
        contentValues.put(KEY_NUMOFUNITS, residence.getNumOfUnit());
        contentValues.put(KEY_SIZEPERUNIT, residence.getSizePerUnit());
        contentValues.put(KEY_MONTHLYRENTAL, residence.getMonthlyRental());


        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
    }

    public Residence GetResidence(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]
                        {Util.KEY_RESIDENCE_ID, Util.KEY_ADDRESS, Util.KEY_NUMOFUNITS,
                                KEY_SIZEPERUNIT, Util.KEY_MONTHLYRENTAL},
                KEY_RESIDENCE_ID+ "=?", new String[]{String.valueOf(id)},
                null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        Residence residence = new Residence();
        residence.setResidenceid((Integer.parseInt(cursor.getString(0))));
        residence.setAddress(cursor.getString(1));
        residence.setNumOfUnit(cursor.getString(2));
        residence.setSizePerUnit(cursor.getString(3));
        residence.setMonthlyRental(cursor.getString(4));

        return residence;
    }

    public Application GetApplication(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_Application, new String[]
                        {APPLICATION_ID, FROM_DATE, DURATION,
                                APPLICATION_STATUS},
                APPLICATION_ID+ "=?", new String[]{String.valueOf(id)},
                null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        Application application = new Application();
        application.setId((Integer.parseInt(cursor.getString(0))));
        application.setFromdate(((cursor.getString(1))));
        application.setDuration(((cursor.getString(2))));
        application.setStatus(((cursor.getString(3))));

        return application;
    }

    public List<Residence> GetAllResidences(){
        List<Residence> residenceList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectAll, null);

        if (cursor.moveToFirst()){
            do{
                Residence residence = new Residence();
                residence.setResidenceid((Integer.parseInt(cursor.getString(0))));
                residence.setAddress(cursor.getString(1));
                residence.setNumOfUnit(cursor.getString(2));
                residence.setSizePerUnit(cursor.getString(3));
                residence.setMonthlyRental(cursor.getString(4));
                residence.setStatus(cursor.getString(5));

                residenceList.add(residence);
            }while (cursor.moveToNext());
        }
        db.close();
        return residenceList;
    }

    public void DeleteResidence(Residence residence){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, KEY_RESIDENCE_ID + "=?",
                new String[]{String.valueOf(residence.getResidenceid())});
        db.close();
    }

    public int UpdateResidence(Residence residence){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_ADDRESS, residence.getAddress());
        contentValues.put(Util.KEY_NUMOFUNITS, residence.getNumOfUnit());
        contentValues.put(KEY_SIZEPERUNIT, residence.getSizePerUnit());
        contentValues.put(Util.KEY_MONTHLYRENTAL, residence.getMonthlyRental());

        return db.update(Util.TABLE_NAME,contentValues,
                Util.KEY_RESIDENCE_ID+"=?",
                new String[]{String.valueOf(residence.getResidenceid())});
    }

    public void CreateApplication(Application application) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(APPLICATION_DATE, application.date);
        values.put(APPLICATION_MONTH, application.month);
        values.put(APPLICATION_YEAR, application.year);
        values.put(RES_ID, application.resid);

        // Inserting Row
        db.insert(TABLE_Application, null, values);
        db.close();
    }

    public int AllocateHousing(Application application) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FROM_DATE, application.getFromdate());
        contentValues.put(DURATION, application.getDuration());
        contentValues.put(APPLICATION_STATUS, application.getStatus());

        return db.update(TABLE_Application,contentValues,
                APPLICATION_ID+"=?",
                new String[]{String.valueOf(application.getId())});
    }

    public void WithdrawApplication(Application application){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_Application, APPLICATION_ID + "=?", new String[]{String.valueOf(application.getId())});
        db.close();
    }


    public List<Application> GetAllApplications(){
        List<Application> applicationList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = " SELECT * FROM " + TABLE_Application;
        Cursor cursor = db.rawQuery(selectAll, null);
        if(cursor.moveToFirst() == true){

            do{
                Application application = new Application();
                application.setId((Integer.parseInt(cursor.getString(0))));
                application.setDate((cursor.getString(1)));
                application.setMonth((cursor.getString(2)));
                application.setYear((cursor.getString(3)));
                application.setStatus((cursor.getString(4)));
                application.setResid((cursor.getInt(6)));

                applicationList.add(application);

            }while (cursor.moveToNext());
        }
        db.close();
        return applicationList;

    }
}
