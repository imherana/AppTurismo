package pe.edu.cibertec.appturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu);
    }

    public void cargar(View view){
        Intent ventana = null;

        switch (view.getId()){
            case R.id.btn_consultarU:
                ventana = new Intent(AdminMenu.this,AMGestionarU.class);
                break;
            case R.id.btn_cons_empre:
                ventana = new Intent(AdminMenu.this,AMGestionarE.class);
                break;
        }
        if (ventana!=null){
            startActivity(ventana);
        }
    }
}
