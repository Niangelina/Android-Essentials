package br.com.fourlinux.trabalhando.com.arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends Activity {

	private TextView txtRoot;
	private TextView txtNomeArq;
	private TextView txtSalvar;
	private TextView txtLer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		try {
			setContentView(R.layout.main);

			txtRoot = (TextView) findViewById(R.id.txtRoot2);
			txtNomeArq = (TextView) findViewById(R.id.edtNomeArq);
			txtSalvar = (TextView) findViewById(R.id.edtSalvar);
			txtLer = (TextView) findViewById(R.id.edtLer);

			txtRoot.append(GetRoot());

		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
	}

	public void click_Salvar(View v) {
		SalvarArquivo();
	}

	public void click_Ler(View v) {
		LerArquivo();
	}

	public void click_Limpar(View v) {
		txtNomeArq.setText("teste.txt");
		txtSalvar.setText("");
		txtLer.setText("");
	}

	// Exibir o diret�rio de armazenamento externo do Android
	private String GetRoot() {
		File root = android.os.Environment.getExternalStorageDirectory();
		return root.toString();
	}

	private void SalvarArquivo() {
		String lstrNomeArq;
		File arq;
		byte[] dados;
		try {
			// pega o nome do arquivo a ser gravado
			lstrNomeArq = txtNomeArq.getText().toString();

			arq = new File(Environment.getExternalStorageDirectory(),
					lstrNomeArq);
			FileOutputStream fos;

			// transforma o texto digitado em array de bytes
			dados = txtSalvar.getText().toString().getBytes();

			fos = new FileOutputStream(arq);

			// escreve os dados e fecha o arquivo
			fos.write(dados);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
	}

	private void LerArquivo() {
		String lstrNomeArq;
		File arq;
		String lstrlinha;
		try {
			// pega o nome do arquivo a ser lido
			lstrNomeArq = txtNomeArq.getText().toString();

			// limpa a caixa de texto que ir� receber os dados do arquivo
			txtLer.setText("");

			arq = new File(Environment.getExternalStorageDirectory(),lstrNomeArq);
			BufferedReader br = new BufferedReader(new FileReader(arq));
			// efetua uma leitura linha a linha do arquivo a carrega
			// a caixa de texto com a informa��o lida
			while ((lstrlinha = br.readLine()) != null) {
				if (!txtLer.getText().toString().equals("")) {
					txtLer.append("\n");
				}
				txtLer.append(lstrlinha);
			}

		} catch (Exception e) {
			trace("Erro : " + e.getMessage());
		}
	}

	public void toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	private void trace(String msg) {
		toast(msg);
	}
}