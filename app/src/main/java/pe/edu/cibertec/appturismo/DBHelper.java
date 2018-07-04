package pe.edu.cibertec.appturismo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tipou(tipo_id int primary key,tipo_des text)");
        db.execSQL("create table usuarios(codigo integer primary key autoincrement, nombre text, apellidos text, usuario text,contraseña text, correo text, tipo_id int references tipou)");
        db.execSQL("create table empresas(codigo integer primary key autoincrement, nombre text, p_web text, usuario text,contraseña text, correo text, tipo_id int references tipou)");
        db.execSQL("insert into tipou values(1,'empresa')");
        db.execSQL("insert into tipou values(2,'usuario')");
        db.execSQL("insert into tipou values(3,'admin')");
        db.execSQL("insert into usuarios values(null,'david jesus','lazaro torres','admin','admin','admin@admin.com',3)");
        db.execSQL("insert into usuarios values(null,'yonella','Quispe','user','user','user@user.com',1)");
        db.execSQL("insert into usuarios values(null,'Ana Belen','Cortes Lopez','ana','ana','ana@ana.com',2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table tipou(tipo_id int primary key,tipo_des text)");
        db.execSQL("create table usuarios(codigo integer primary key autoincrement, nombre text, apellidos text, usuario text,contraseña text, correo text, tipo_id int references tipou)");
        db.execSQL("insert into tipou values(1,'empresa')");
        db.execSQL("insert into tipou values(2,'usuario')");
        db.execSQL("insert into tipou values(3,'admin')");
        db.execSQL("insert into usuarios values(null,'david jesus','lazaro torres','admin','admin','admin@admin.com',3)");
        db.execSQL("insert into usuarios values(null,'yonella','Quispe','user','user','user@user.com',1)");
        db.execSQL("insert into usuarios values(null,'Ana Belen','Cortes Lopez','ana','ana','ana@ana.com',2)");
    }
}

