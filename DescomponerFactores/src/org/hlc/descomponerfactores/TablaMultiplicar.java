package org.hlc.descomponerfactores;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TablaMultiplicar extends Activity {
	private int numero;
	final int FILAS = 11; // Cantidad de filas que se crearan para mostrar la
							// tabla de multiplicar (del 0 al 10)
	final TextView[] filas = new TextView[FILAS];
	private LinearLayout layoutFilas;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablas);

		// Se obtiene el layout donde se insertaran los textos
		layoutFilas = (LinearLayout) findViewById(R.id.LinearLayout);

		Bundle extras = getIntent().getExtras();
		numero = extras.getInt("numero");

		for (int i = 0; i < filas.length; i++) {
			// Creamos un nuevo texto
			final TextView filaTexto = new TextView(this);

			// Escribimos la multiplicacion en la vista
			filaTexto.setText(numero + " x " + i + " = " + numero * i);

			// Centramos la vista
			filaTexto.setGravity(Gravity.CENTER);

			// Añadimos la vista al layout
			layoutFilas.addView(filaTexto);

			// Lo almacenamos en el array
			filas[i] = filaTexto;
		}
	}

	public void lanzarVolver(View view) {
		finish();
	}
}
