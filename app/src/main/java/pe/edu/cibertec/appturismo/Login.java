package pe.edu.cibertec.appturismo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //create variables
    EditText et1, et2 ;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = (EditText) findViewById(R.id.usertext);
        et2 = (EditText) findViewById(R.id.passtext);
    }

    public void ingresar(View v){
        DBHelper admin=new DBHelper(this,"Hoteleria", null, 1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String usuario = et1.getText().toString();
        String contraseña = et1.getText().toString();

        fila=db.rawQuery("select usuario,contraseña from usuarios where usuario='"+usuario+"' and contraseña ='"+contraseña+"'",null);
        if(fila.moveToFirst()){
            String usu= fila.getString(0);
            String cont= fila.getString(1);
            Intent ven=new Intent(this,userMenu.class);
            startActivity(ven);
            et1.setText("");
            et2.setText("");
            db.close();
            }
            else{
                Toast.makeText(getApplicationContext(), "usuario incorrecto",Toast.LENGTH_LONG).show();
            }

        }

        public  void openregistrar(View v){
            Intent ven=new Intent(this,RegistrarUsuario.class);
            startActivity(ven);
        }
    }


