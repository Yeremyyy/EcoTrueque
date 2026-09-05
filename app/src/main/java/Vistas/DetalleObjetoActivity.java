package Vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecotrueque.R;

public class DetalleObjetoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_objeto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView lblMostrarNombre = findViewById(R.id.lbl_nombre);
        TextView lblMostrarCategoria = findViewById(R.id.lbl_categoriaprod);
        Button btnAceptar = findViewById(R.id.btn_Aceptar);
        Button btnVolver = findViewById(R.id.btn_volver);

        Intent intentRecibido = getIntent();

        String nombreRecibido = intentRecibido.getStringExtra("EXTRA_NOMBRE");
        String categoriaRecibida = intentRecibido.getStringExtra("EXTRA_CATEGORIA");

        if (nombreRecibido != null){
            lblMostrarNombre.setText(nombreRecibido);
        }
        if(categoriaRecibida != null){
            lblMostrarCategoria.setText(categoriaRecibida);
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRetorno = new Intent(DetalleObjetoActivity.this, MenuPrincipalActivity.class);
                intentRetorno.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                startActivity(intentRetorno);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}