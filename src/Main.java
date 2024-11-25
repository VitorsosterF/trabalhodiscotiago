import java.sql.SQLOutput;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Catalogo catalogo = new Catalogo();
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            exibirMenu();
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha)
            {
                case 1 -> catalogo.cadastrarDisco(sc);
                case 2 -> catalogo.cadastrarArtista(sc);
                case 3 -> catalogo.exibirDiscos();
                case 4 -> catalogo.removerDisco(sc);
                case 5 -> catalogo.editarDisco(sc);
                case 6 -> catalogo.editarFaixas(sc);
                case 7 -> catalogo.removerArtista(sc);
                case 8 -> catalogo.editarArtista(sc);
                case 9 -> catalogo.exibirArtistas();
                case 10 -> System.out.println("Fechando o sistema...");
            }
        } while (escolha != 10);

    }

    private static void exibirMenu()
    {
        System.out.println("\n----------------------------\n");
        System.out.println("Sistema de catálogo de discos");
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Cadastrar disco");
        System.out.println("2 - Cadastrar artista");
        System.out.println("3 - Listar discos");
        System.out.println("4 - Remover disco");
        System.out.println("5 - Editar disco");
        System.out.println("6 - Editar faixas");
        System.out.println("7 - Remover artista");
        System.out.println("8 - Editar artista");
        System.out.println("9 - Listar artistas");
        System.out.println("10 - Sair");
        System.out.println("\n----------------------------\n");
    }

}