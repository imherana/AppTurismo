package pe.edu.cibertec.appturismo;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.net.ConnectException;
import java.util.ArrayList;

import pe.edu.cibertec.appturismo.Entidades.Categoria;

public class EmpreMenu extends AppCompatActivity {
    Spinner combocat;
    ArrayList<String>ListaCategorias;
    ArrayList<Categoria> CategoriasList;
    String categoria_empresa;
    EditText direccion_em;
    ImageView imagen;
    Button btnfoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_empresa);

        combocat = (Spinner) findViewById(R.id.combocatext);
        direccion_em= (EditText) findViewById(R.id.directext);
        imagen = (ImageView) findViewById(R.id.imagenempre);

        btnfoto= (Button) findViewById(R.id.add_img);

        coonsultarListaCategorias();
        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this,android.R.layout.simple_spinner_item,ListaCategorias);
        combocat.setAdapter(adaptador);

        combocat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoria_empresa= combocat.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnfoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mostrarDialogodeOpciones();
            }
        });
    }

    public void mostrarDialogodeOpciones(){
        final CharSequence[] opciones ={"Tomar Foto","Elegir de galeria","Cancelar"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("Elije una Opcion");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(opciones[which].equals("Tomar Foto")){

                }else{
                    if(opciones[which].equals("Elegir de galeria")){
                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI );
                        intent.setType("immage/");
                        startActivityForResult(intent.createChooser(intent, "Seleccione"),10);
                    }else{
                        dialog.dismiss();
                    }
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                Uri miPath=data.getData();
                imagen.setImageURI(miPath);
                break;
        }
    }

    public void coonsultarListaCategorias() {

        DBHelper admin = new DBHelper(this, "Turismo", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Categoria categoria= null;
        CategoriasList =new ArrayList<Categoria>();

        Cursor cursor =db.rawQuery("select * from categoriae", null);

        while (cursor.moveToNext()){
            categoria = new Categoria();
            categoria.setNom_cat(cursor.getString(1));

            CategoriasList.add(categoria);
        }
        obtenerLista();


    }

    public void obtenerLista() {
        ListaCategorias=new ArrayList<String>();
        ListaCategorias.add("Seleccione");

        for (int i=0;i<CategoriasList.size();i++){
            ListaCategorias.add(CategoriasList.get(i).getNom_cat());
        }
    }

    public void cargarfoto (){


    }

}
