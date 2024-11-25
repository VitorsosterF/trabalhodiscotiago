import java.util.*;

public class Catalogo
{
    private List<Disco> discos;
    private List<Artista> artistas;

    public Catalogo()
    {
        this.discos = new ArrayList();
        this.artistas = new ArrayList();
    }

    public void cadastrarDisco(Scanner scanner)
    {
        System.out.println("Digite o nome do Disco: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o ano de lançamento: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Quantas faixas o disco tem?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        List<String> faixas  = new ArrayList();
        for (int i = 0; i < quantidade; i++)
        {
            System.out.println("Nome da faixa " + (i + 1) + ": ");
            faixas.add(scanner.nextLine());
        }

        Disco disco = new Disco(nome, anoLancamento, faixas, null);
        discos.add(disco);
        System.out.printf("Cadastrado com sucesso!");
    }

    public void cadastrarArtista(Scanner scanner)
    {
        System.out.println("Digite o nome do artista: ");
        String nome = scanner.nextLine();

        Artista artistaExiste = artistas.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        if (artistaExiste != null) {
            System.out.println("Artista já existe.");
            return;
        }

        System.out.println("Digite o gênero do artista: ");
        String genero = scanner.nextLine();

        exibirDiscos();
        System.out.print("Digite o título do álbum que deseja associar ao artista: ");
        String tituloDisco = scanner.nextLine();

        Disco disco = discos.stream()
                .filter(a -> a.getTitulo().equalsIgnoreCase(tituloDisco))
                .findFirst()
                .orElse(null);

        if (disco == null) {
            System.out.println("Disco não encontrado. Cadastre o disco primeiro.");
            return;
        }

        if (artistaExiste != null) {
            artistaExiste.adicionarDisco(disco);
            disco.setArtista(artistaExiste);
            System.out.println("Disco associado ao artista existente com sucesso!");
            return;
        }

        Artista artista = new Artista(nome, genero);
        artistas.add(artista);
        artista.adicionarDisco(disco);
        disco.setArtista(artista);

        System.out.println("Artista cadastrado e associado ao disco.");
    }

    public void exibirArtistas()
    {
        if (artistas.isEmpty())
        {
            System.out.println("Não há nenhum artista cadastrado.");
            return;
        }

        System.out.println("\n----------------------------\n");
        for (Artista artista : artistas)
        {
            artista.exibirArtista();
            System.out.printf("\n----------------------------\n");
        }
    }

    public void editarArtista(Scanner scanner)
    {
        if(artistas.isEmpty())
        {
            System.out.println("Não há nenhum artista cadastrado.");
            return;
        }
        else
        {
            exibirArtistas();
        }

        System.out.println("Digite o artista que quer editar: ");
        String nomeArtista = scanner.nextLine();

        Artista artista = artistas.stream()
                .filter(a -> a.getNome().equals(nomeArtista))
                .findFirst()
                .orElse(null);

        if (artista == null)
        {
            System.out.println("Artista não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do artista (Deixe em branco para manter): ");
        String novoNome  = scanner.nextLine();

        if(!novoNome.isBlank())
        {
            artista.setNome(novoNome);
        }

        System.out.println("Digite o novo gênero (Deixe em branco para manter o mesmo): ");
        String genero = scanner.nextLine();
        if (!genero.isBlank())
        {
            artista.setGenero(genero);
        }

        System.out.printf("Artista atualizado com sucesso!");
    }

    public void removerArtista(Scanner scanner)
    {
        if(artistas.isEmpty())
        {
            System.out.println("Não há nenhum artista cadastrado.");
            return;
        }
        else
        {
            exibirArtistas();
        }

        System.out.println("Digite o artista que quer remover: ");
        String nomeArtista = scanner.nextLine();

        artistas.removeIf(a -> a.getNome().equalsIgnoreCase(nomeArtista));
        System.out.println("Artista removido com sucesso");
    }


    public void exibirDiscos()
    {
        if (discos.isEmpty())
        {
            System.out.println("Não há nenhum disco cadastrado.");
            return;
        }

        System.out.println("\n----------------------------\n");
        for (Disco disco : discos)
        {
            disco.exibirDisco();
            System.out.printf("\n----------------------------\n");
        }
    }

    public void editarDisco(Scanner scanner)
    {
        if(discos.isEmpty())
        {
            System.out.println("Não há nenhum disco cadastrado.");
            return;
        }
        else
        {
            exibirDiscos();
        }

        System.out.println("\nDigite o Disco que quer editar: ");
        String titulo = scanner.nextLine();

        Disco disco = discos.stream()
                .filter(a -> a.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

        if (disco == null)
        {
            System.out.println("Disco não encontrado.");
            return;
        }

        System.out.println("Digite o novo título (Aperte apenas Enter para manter): ");
        String tituloNovo = scanner.nextLine();
        if (!tituloNovo.isBlank())
        {
            disco.setTitulo(tituloNovo);
        }

        System.out.println("Digite o novo ano de lançamento (0 para manter o mesmo): ");
        int novoAnoLancamento = scanner.nextInt();
        if (novoAnoLancamento != 0)
        {
            disco.setAnoLancamento(novoAnoLancamento);
        }

        System.out.printf("Disco atualizado com sucesso!");
    }

    public void removerDisco(Scanner scanner)
    {
        if(discos.isEmpty())
        {
            System.out.println("Não há nenhum disco cadastrado.");
            return;
        }
        else
        {
            exibirDiscos();
        }

        System.out.println("Digite o nome do disco que quer remover: ");
        String nome = scanner.nextLine();

        discos.removeIf(a -> a.getTitulo().equalsIgnoreCase(nome));
        System.out.println("Disco removido com sucesso!");
    }

    public void editarFaixas(Scanner scanner)
    {
        exibirDiscos();

        System.out.println("Digite o nome do disco que quer editar: ");
        String titulo = scanner.nextLine();

        Disco disco = discos.stream()
                .filter(a -> a.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

        if (disco == null)
        {
            System.out.println("Disco não encontrado.");
            return;
        }

        System.out.println("Faixas existentes: ");
        List<String> faixas = disco.getFaixas();
        for (int i = 0; i < faixas.size(); i++)
        {
            System.out.println((i + 1) + "\n- " + faixas.get(i));
        }

        int escolha;

        do
        {
            System.out.println("\nEditar Faixas");
            System.out.println("1- Adicionar nova faixa");
            System.out.println("2- Editar faixa existente");
            System.out.println("3- Remover faixa");
            System.out.println("4- Terminar edição");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha)
            {
                case 1 ->
                {
                    System.out.println("Digite o nome da nova faixa: ");
                    String novaFaixa = scanner.nextLine();
                    faixas.add(novaFaixa);
                    System.out.println("Adicionada com sucesso!");
                }
                case 2 ->
                {
                    System.out.println("Digite o número da faixa que quer editar: ");
                    int numeroFaixa = scanner.nextInt();
                    scanner.nextLine();
                    if (numeroFaixa > 0 && numeroFaixa <= discos.size())
                    {
                        System.out.println("Digite o novo nome da faixa: ");
                        String novoNome = scanner.nextLine();
                        faixas.set(numeroFaixa - 1, novoNome);
                        System.out.println("Editada com sucesso!");
                    }
                    else
                    {
                        System.out.println("Número de faixa inválido.");
                    }
                }
                case 3 ->
                {
                    System.out.println("Digite o número da faixa que quer remover: ");
                    int numeroFaixa = scanner.nextInt();
                    scanner.nextLine();

                    if (numeroFaixa > 0 && numeroFaixa <= discos.size())
                    {
                        faixas.remove(numeroFaixa - 1);
                        System.out.println("Removido com sucesso!");
                    }
                    else
                    {
                        System.out.println("Número de faixa inválido.");
                    }
                }
                case 4 -> System.out.println("Edição concluída!");
                default -> System.out.println("Opção inválida.");
            }
        } while (escolha != 4);

    }

}
