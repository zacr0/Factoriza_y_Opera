package org.hlc.descomponerfactores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	// private int numeros[] = { -1, -1 };
	EditText campoPrimerNumero;
	EditText campoSegundoNumero;
	private int queNumero;
	private String mensaje;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		campoPrimerNumero = (EditText) findViewById(R.id.primer_numero);
		campoSegundoNumero = (EditText) findViewById(R.id.segundo_numero);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item_salir:
			salir(null);
			break;
		}
		return true;
	}

	public void lanzarDescomponer(View view) {
		if (view.getId() == R.id.boton_descomp_n1) {
			if (campoPrimerNumero.length() == 0) {
				Toast.makeText(this, R.string.errorFaltaN1, Toast.LENGTH_LONG)
						.show();
			} else {
				queNumero = getPrimerNumero();

				if (queNumero == 0) {
					Toast.makeText(this, R.string.errorCero, Toast.LENGTH_LONG)
							.show();
				} else {
					Intent intent = new Intent(this, DescomposicionNumero.class);
					intent.putExtra("numero", queNumero);
					startActivity(intent);
				}
			}
		} else if (view.getId() == R.id.boton_descomp_n2) {
			if (campoSegundoNumero.length() == 0) {
				Toast.makeText(this, R.string.errorFaltaN2, Toast.LENGTH_LONG)
						.show();
			} else {
				queNumero = getSegundoNumero();

				if (queNumero == 0) {
					Toast.makeText(this, R.string.errorCero, Toast.LENGTH_LONG)
							.show();
				} else {
					Intent intent = new Intent(this, DescomposicionNumero.class);
					intent.putExtra("numero", queNumero);
					startActivity(intent);
				}
			}
		}

	}

	public void lanzarTablas(View view) {
		if (view.getId() == R.id.boton_mult_n1) {
			if (campoPrimerNumero.length() == 0) {
				Toast.makeText(this, R.string.errorFaltaN1, Toast.LENGTH_LONG)
						.show();
			} else {
				queNumero = getPrimerNumero();

				if (queNumero == 0) {
					Toast.makeText(this, R.string.errorCero, Toast.LENGTH_LONG)
							.show();
				} else {
					Intent intent = new Intent(this, TablaMultiplicar.class);
					intent.putExtra("numero", queNumero);
					startActivity(intent);
				}
			}
		} else if (view.getId() == R.id.boton_mult_n2) {
			if (campoSegundoNumero.length() == 0) {
				Toast.makeText(this, R.string.errorFaltaN2, Toast.LENGTH_LONG)
						.show();
			} else {
				queNumero = getSegundoNumero();

				if (queNumero == 0) {
					Toast.makeText(this, R.string.errorCero, Toast.LENGTH_LONG)
							.show();
				} else {
					Intent intent = new Intent(this, TablaMultiplicar.class);
					intent.putExtra("numero", queNumero);
					startActivity(intent);
				}
			}
		}
	}

	public void mostrarMcmMcd(View view) {
		int n1, n2;
		n1 = n2 = 0;

		if (campoPrimerNumero.length() != 0) {
			n1 = getPrimerNumero();
		}

		if (campoSegundoNumero.length() != 0) {
			n2 = getSegundoNumero();
		}

		if (n1 == 0 && n2 == 0) {
			mensaje = this.getString(R.string.errorFaltanNumeros);
		} else if (n1 == 0) {
			mensaje = this.getString(R.string.errorFaltaN1);
		} else if (n2 == 0) {
			mensaje = this.getString(R.string.errorFaltaN2);
		} else {
			if (view.getId() == R.id.boton_mcm) {
				mensaje = "M.C.M de " + n1 + " y " + n2 + ": "
						+ calcularMinimoComunMultiplo(n1, n2);
			} else {
				mensaje = "M.C.D de " + n1 + " y " + n2 + ": "
						+ calcularMaximoComunDivisor(n1, n2);
			}
		}

		Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
	}

	public int calcularMaximoComunDivisor(int n1, int n2) {
		int temp = n1 % n2;

		while (temp != 0) {
			n1 = n2;
			n2 = temp;
			temp = n1 % n2;
		}

		return n2;
	}

	public int calcularMinimoComunMultiplo(int n1, int n2) {
		int mcd = calcularMaximoComunDivisor(n1, n2);
		return n1 * n2 / mcd;
	}

	public void salir(View view) {
		finish();
	}

	public int getPrimerNumero() {
		return Integer.valueOf(campoPrimerNumero.getText().toString());
	}

	public int getSegundoNumero() {
		return Integer.valueOf(campoSegundoNumero.getText().toString());
	}

}
