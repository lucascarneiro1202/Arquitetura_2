package AcessoSequencial;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class Main {
	public static void main (String args []) {
		Livro l1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.9F);
		Livro l2 = new Livro (2, "Eu Sou A Lenda", "Richard Matheson", 21.99F);

		FileOutputStream arq;
		FileInputStream arq2;

		DataOutputStream dos;
		DataInputStream dis;

		byte[] ba;
			
		try {
		//---------------- Escrita --------------------
		//Abrir arquivo e classe auxiliar
			arq = new FileOutputStream("dados/livros.db");
			dos = new DataOutputStream(arq);
		//Escrever livro 1
			ba = l1.toByteArray(); //Transformar objeto em array de bytes
			dos.writeInt(ba.length); //Escrever tamanho do arranjo de bytes
			dos.write(ba); //Escrever arranjo de bytes em si
		//Escrever livro 2
			ba = l2.toByteArray();
			dos.writeInt(ba.length);
			dos.write(ba);
		//Fechar arquivo
			arq.close();
			// arq.flush(); -> Libera o canal, mas não desloca o recurso
		//------------------ Leitura ----------------
		//Definir livros a serem lidos
			Livro l3 = new Livro();
			Livro l4 = new Livro();
			int tam;
		//Abrir arquivo e classe auxiliar
			arq2 = new FileInputStream("dados/livros.db");
			dis = new DataInputStream(arq2);
		//Ler livro 1
			tam = dis.readInt(); //Ler tamanho do array de bytes
			ba = new byte[tam]; //Definir array de bytes com o tamanho lido
			dis.read(ba); //Ler array de bytes do arquivo
			l3.fromByteArray(ba); //Converter array de bytes para o objeto Livro
		//Ler livro 2
			tam = dis.readInt();
			ba = new byte[tam];
			dis.read(ba);
			l4.fromByteArray(ba);
		//Mostrar resultado
			System.out.println(l3);
			System.out.println(l4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
