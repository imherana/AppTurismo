package pe.edu.cibertec.appturismo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity {
   private EditText etnom, etapell, etuser, etcontra, etcorreo;
   private RadioButton remp, ruser;
    private Cursor fila;
    private Cursor fila2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        etnom =(EditText) findViewById(R.id.nomtext);
        etapell =(EditText) findViewById(R.id.apelltext);
        etuser =(EditText) findViewById(R.id.usuariotext);
        etcontra =(EditText) findViewById(R.id.contratext);
        etcorreo =(EditText) findViewById(R.id.correotext);
        remp = (RadioButton) findViewById(R.id.radioemp);
        ruser = (RadioButton) findViewById(R.id.radiousu);
    }

    public void userregistrar(View v) {
        DBHelper admin=new DBHelper(this,"Hoteleria", null, 1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String nom = etnom.getText().toString();
        String apell = etapell.getText().toString();
        String user = etuser.getText().toString();
        String contra = etcontra.getText().toString();
        String correo = etcorreo.getText().toString();
        ContentValues reg = new ContentValues();
        Integer cod = null;
        fila=db.rawQuery("select usuario from usuarios where usuario='"+user+"",null);
        fila2=db.rawQuery("select correo from usuarios where correo='"+correo+"'",null);

        //if (fila.moveToFirst()|| fila2.moveToFirst())

        if (!nom.isEmpty() && !apell.isEmpty() && !user.isEmpty() && !contra.isEmpty() && !correo.isEmpty() ) {
            if (remp.isChecked()== true) {
                reg.put("codigo", cod);
                reg.put("nombre", nom);
                reg.put("apellidos", apell);
                reg.put("usuario", user);
                reg.put("contraseña", contra);
                reg.put("correo", correo);
                reg.put("tipo_id", 1);
                db.insert("usuarios", null, reg);
                db.close();
                Intent ven = new Intent(this, Login.class);
                startActivity(ven);
            }
            if (ruser.isChecked()== true) {
                reg.put("codigo", cod);
                reg.put("nombre", nom);
                reg.put("apellidos", apell);
                reg.put("usuario", user);
                reg.put("contraseña", contra);
                reg.put("correo", correo);
                reg.put("tipo_id", 2);
                db.insert("usuarios", null, reg);
                db.close();
                Intent ven = new Intent(this, Login.class);
                startActivity(ven);
            }
                    // Ninjas rule
            etapell.setText("");
            etuser.setText("");
            etcontra.setText("");
            etcorreo.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios",Toast.LENGTH_LONG).show();
        }
    }
}
