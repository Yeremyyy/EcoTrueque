package Vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecotrueque.R;

public class PublicarObjetoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_publicar_objeto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtNombre = findViewById(R.id.txt_nombre);
        RadioGroup rdgCategorias = findViewById(R.id.rdg_categorias);
        Button btnPublicar = findViewById(R.id.btn_publicar);

        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = txtNombre.getText().toString();
                int idCategoria = rdgCategorias.getCheckedRadioButtonId();

                if (nombreProducto.isEmpty()){
                    txtNombre.setError("El nombre no puede estar vacio");
                } else if (idCategoria == -1){
                    Toast.makeText(PublicarObjetoActivity.this, "Por favor selecciona una cateogoria", Toast.LENGTH_SHORT).show();
                } else {
                    String categoriaSeleccionada = "Sin categoria";

                    if (idCategoria == R.id.rd_ropa){
                        categoriaSeleccionada = "Ropa";
                    } else if (idCategoria == R.id.rd_libros){
                        categoriaSeleccionada = "Libros";
                    } else if (idCategoria == R.id.rd_tecnologia){
                        categoriaSeleccionada = "Tecnologia";
                    }

                    Intent intent = new Intent(PublicarObjetoActivity.this, DetalleObjetoActivity.class);
                    intent.putExtra("EXTRA_NOMBRE", nombreProducto);
                    intent.putExtra("EXTRA_CATEGORIA", categoriaSeleccionada);

                    startActivity(intent);
                }
            }
        });

    }
}