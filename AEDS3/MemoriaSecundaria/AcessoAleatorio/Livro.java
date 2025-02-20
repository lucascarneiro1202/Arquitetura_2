package AcessoAleatorio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.DecimalFormat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")

public class Livro {
	protected int idLivro;
	protected String titulo;
	protected String autor;
	protected float preco;


	protected static DecimalFormat df = new DecimalFormat("#,##0.00");

	public Livro() {
		idLivro = -1;
		titulo = "";
		autor = "";
		preco = 0F;
	}

	public Livro(int i, String t, String a, float p) {
		idLivro = i;
		titulo = t;
		autor = a;
		preco = p;
	}

	public String toString() {
		return "ID: " + idLivro +
			"\nTítulo: " + titulo +
			"\nAutor: " + autor + 
			"\nPreço: R$ " + df.format(preco) + "\n";
	}

	public byte[] toByteArray() throws IOException {
	//Definir dados locais
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
	//Preencher atributos do livro
		dos.writeInt(idLivro);
		dos.writeUTF(titulo);
		dos.writeUTF(autor);
		dos.writeFloat(preco);
	//Retornar
		return baos.toByteArray();
	}

	public void fromByteArray(byte[] ba) throws IOException {
	//Definir dados locais
		ByteArrayInputStream bais = new ByteArrayInputStream(ba);
		DataInputStream dis = new DataInputStream(bais);
	//Preencher atributos do livro
		idLivro = dis.readInt();
		titulo = dis.readUTF();
		autor = dis.readUTF();
		preco = dis.readFloat();
	}
}
