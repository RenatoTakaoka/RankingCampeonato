import java.util.Scanner;
import java.util.Random;
public class Sp4 
{
	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		int equipes;
		int pontos[], design[];
		String nomes[];
		boolean Finais = false;
		Random r = new Random();

		System.out.println("Digite o número de equipes: ");
		equipes = teclado.nextInt();
		pontos = new int[equipes];
		design = new int[equipes];
		nomes = new String[equipes];
		for (int i = 0; i < nomes.length; i++) {
			System.out.println("Digite o nome do " + (i + 1) + "º robô: ");
			nomes[i] = teclado.next();
			design[i] = r.nextInt(10);
		}
		Combates(nomes, pontos, design, Finais);
		Rank(nomes, pontos, design, Finais);
		TopRank(nomes, pontos, design, Finais);
		teclado.close();
	}

	public static void Combates(String nomes[], int pontos[], int design[], boolean Finais) 
	{
		int equipe1 = 0, equipe2 = 0;
		int aux[];
		String aux2[];
		aux = new int[pontos.length - 1];
		aux2 = new String[nomes.length - 1];
		int pontosVIT = 10, pontosE = 5, pontosD = 0;
		if (Finais == true) 
		{
			pontosVIT = 2;
			pontosE = 1;
		}

		for (int j = 0; j < nomes.length; j++) 
		{
			for (int y = (j + 1); y < nomes.length; y++) 
			{

				Random r = new Random();
				equipe1 = r.nextInt(10);
				equipe2 = r.nextInt(10);

				if (equipe1 > equipe2) 
				{
					pontos[j] += pontosVIT;
					aux[y - 1] -= pontosD;
				} 
				else if (equipe1 < equipe2) {
					pontos[j] -= pontosD;
					aux[y - 1] += pontosVIT;
				} 
				else if (equipe1 == equipe2) 
				{
					pontos[j] += pontosE;
					aux[y - 1] += pontosE;
				}
				
				System.out.println("---------------------");
				System.out.println("Combate: ");
				System.out.println("ROBO " + nomes[j] + " X ROBO " + nomes[y]);
				System.out.println("");
				System.out.println("Robo: " + nomes[j] + " Pontuação:" + equipe1);
				System.out.println("Robo: " + nomes[y] + " Pontuação:" + equipe2);
				System.out.println("");
				if (aux2.length > j) 
				{
					aux2[y - 1] = nomes[y];
				}
			}
		}
		;
		int n;
		n = nomes.length;
		for (int x = 0; x < (n - 1); x++) 
		{
			for (int z = 0; z < n; z++) 
			{
				if (aux2[x] == nomes[z]) 
				{
					pontos[z] = pontos[z] + aux[x];
				}
			}
		}
	}

	public static void Rank(String nomes[], int pontos[], int design[], boolean Finais) 
	{
		int i = 0, j = 0, n = 0, x = 0;
		String X;
		n = nomes.length;
		for (i = 0; i < n - 1; i++) 
		{
			for (j = 0; j < (n - 1) - i; j++) 
			{
				if (pontos[j] < pontos[j + 1]) 
				{
					x = pontos[j + 1];
					pontos[j + 1] = pontos[j];
					pontos[j] = x;
					X = nomes[j + 1];
					nomes[j + 1] = nomes[j];
					nomes[j] = X;
					x = design[j + 1];
					design[j + 1] = design[j];
					design[j] = x;
				}
				if (pontos[j] == pontos[j + 1] && design[j] < design[j + 1]) 
				{
					x = pontos[j + 1];
					pontos[j + 1] = pontos[j];
					pontos[j] = x;
					X = nomes[j + 1];
					nomes[j + 1] = nomes[j];
					nomes[j] = X;
					x = design[j + 1];
					design[j + 1] = design[j];
					design[j] = x;
				}
			}
		}
		if (Finais == true) 
		{
			System.out.println("---------------------");
			System.out.print("Ganhador: ");
			System.out.print(nomes[0] + " ");
			System.out.print(" Pontuação:" + pontos[0] + " ");
			System.out.println(" Nota de design:" + design[0]);
		}
	}

	public static void TopRank(String nomes[], int pontos[], int design[], boolean Finais) 
	{
		int PontosMelhorTime[] = new int[3], DesingMelhorTime[] = new int[3];
		String NomeMelhorTime[] = new String[3];
		System.out.println("---------------------");
		for (int i = 0; i < 3; i++) 
		{
			
			System.out.print((i + 1) + "º: " + nomes[i] + " ");
			System.out.print(" Pontuação:" + pontos[i] + " ");
			System.out.println(" Nota de design:" + design[i]);
			NomeMelhorTime[i] = nomes[i];
			PontosMelhorTime[i] = 0;
			DesingMelhorTime[i] = design[i];
		}
		System.out.println("");
		Finais = true;
		Combates(NomeMelhorTime, PontosMelhorTime, DesingMelhorTime, Finais);
		Rank(NomeMelhorTime, PontosMelhorTime, DesingMelhorTime, Finais);
	}
}