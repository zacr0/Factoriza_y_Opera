package org.hlc.descomponerfactores;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DescomposicionNumero extends Activity {
	private int numero, resto;
	private LinearLayout columnaDivisores, columnaRestos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.factores);

		// Se obtienen los layouts donde se escribiran los textos
		columnaDivisores = (LinearLayout) findViewById(R.id.columna_divisores);
		columnaRestos = (LinearLayout) findViewById(R.id.columna_resto);

		Bundle extras = getIntent().getExtras();
		numero = extras.getInt("numero");
		
		// Calculo de divisores
		for (int i = 2; i <= numero; i++) {
			while (numero % i == 0) {
				resto = numero / i;
				numero /= i;
				
				// Creamos una vista para mostrar los valores
				final TextView filaDivisor = new TextView(this);
				final TextView filaResto = new TextView(this);
				
				// Se escriben los valores en las vistas
				filaDivisor.setText("" + i);
				filaResto.setText("" + resto);
				
				// Se insertan en el layout correspondiente
				columnaDivisores.addView(filaDivisor);
				columnaRestos.addView(filaResto);
			}
		}
	}

	public void lanzarVolver(View view) {
		finish();
	}
}
