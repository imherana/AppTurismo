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
        db.execSQL("create table categoriae(codigocat integer primary key autoincrement, nom_cat text)");
        db.execSQL("create table usuarios(codigo integer primary key autoincrement, nombre text, apellidos text, usuario text,contraseña text, correo text, tipo_id integer references tipou)");
        db.execSQL("create table empresas(codigoe integer primary key autoincrement, nombre text, p_web text,direccion text, imagen blog, codigo integer  references usuarios, codigocat integer  references categoriae)");

        db.execSQL("insert into categoriae values(1,'Salud')");
        db.execSQL("insert into categoriae values(2,'Restaurantes')");
        db.execSQL("insert into categoriae values(3,'Hoteles')");
        db.execSQL("insert into categoriae values(4,'Seguridad')");
        db.execSQL("insert into tipou values(1,'empresa')");
        db.execSQL("insert into tipou values(2,'usuario')");
        db.execSQL("insert into tipou values(3,'admin')");
        db.execSQL("insert into usuarios values(1,'david jesus','lazaro torres','admin','admin','admin@admin.com',3)");
        db.execSQL("insert into usuarios values(2,'yonella','Quispe','user','user','user@user.com',1)");
        db.execSQL("insert into usuarios values(3,'Ana Belen','Cortes Lopez','ana','ana','ana@ana.com',2)");
        db.execSQL("insert into empresas values(null,'El Gustito','WWW.ElGustito.com','Av. Mansiche 267,Trujillo, Perú','ana',2,2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table tipou(tipo_id int primary key,tipo_des text)");
        db.execSQL("create table categoriae(codigocat integer primary key autoincrement, nom_cat text)");
        db.execSQL("create table usuarios(codigo integer primary key autoincrement, nombre text, apellidos text, usuario text,contraseña text, correo text, tipo_id integer references tipou)");
        db.execSQL("create table empresas(codigoe integer primary key autoincrement, nombre text, p_web text,direccion text, imagen text, codigo integer  references usuarios, codigocat integer  references categoriae)");

        db.execSQL("insert into categoriae values(1,'Salud')");
        db.execSQL("insert into categoriae values(2,'Restaurantes')");
        db.execSQL("insert into categoriae values(3,'Hoteles')");
        db.execSQL("insert into categoriae values(4,'Seguridad')");
        db.execSQL("insert into tipou values(1,'empresa')");
        db.execSQL("insert into tipou values(2,'usuario')");
        db.execSQL("insert into tipou values(3,'admin')");
        db.execSQL("insert into usuarios values(1,'david jesus','lazaro torres','admin','admin','admin@admin.com',3)");
        db.execSQL("insert into usuarios values(2,'yonella','Quispe','user','user','user@user.com',1)");
        db.execSQL("insert into usuarios values(3,'Ana Belen','Cortes Lopez','ana','ana','ana@ana.com',2)");
        db.execSQL("insert into empresas values(null,'El Gustito','WWW.ElGustito.com','Av. Mansiche 267,Trujillo, Perú','ana',2,2)");
    }
}

