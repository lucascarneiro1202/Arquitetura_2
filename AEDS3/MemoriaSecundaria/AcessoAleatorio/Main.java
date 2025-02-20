package AcessoAleatorio;

import java.io.RandomAccessFile;

public class Main {
	public static void main (String args []) {
		Livro l1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.9F);
		Livro l2 = new Livro (2, "Eu Sou A Lenda", "Richard Matheson", 21.99F);

		RandomAccessFile arq;
		byte[] ba;
			
		try {
		//---------------- Escrita --------------------
		//Abrir arquivo e classe auxiliar
			arq = new RandomAccessFile("dados/livros.db", "rw");
			//Escrever livro 1
			long p1 = arq.getFilePointer();
			ba = l1.toByteArray();
			arq.writeInt(ba.length);
			arq.write(ba);
		//Escrever livro 2
			long p2 = arq.getFilePointer();
			ba = l2.toByteArray();
			arq.writeInt(ba.length);
			arq.write(ba);
		//------------------ Leitura ----------------
		//Definir livros a serem lidos
			Livro l3 = new Livro();
			Livro l4 = new Livro();
			int tam;
		//Ler livro 3
			arq.seek(p1);
			tam = arq.readInt();
			ba = new byte[tam];
			arq.read(ba);
			l3.fromByteArray(ba);
		//Ler livro 4
			arq.seek(p2);
			tam = arq.readInt();
			ba = new byte[tam];
			arq.read(ba);
			l4.fromByteArray(ba);
		//Mostrar resultado
			System.out.println(l3);
			System.out.println(l4);
		//Fechar arquivo
			arq.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
