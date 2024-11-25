import java.util.ArrayList;
import java.util.List;

public class Artista
{
    private String nome;
    private String genero;
    private List<Disco> discos;

    public Artista(String nome, String genero)
    {
        this.nome = nome;
        this.genero = genero;
        this.discos = new ArrayList<Disco>();
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public List<Disco> getDiscos()
    {
        return discos;
    }

    public void adicionarDisco(Disco disco)
    {
        discos.add(disco);
    }


    public void exibirArtista()
    {
        System.out.println("Nome: " + nome);
        System.out.println("Genero: " + genero);
        System.out.println("Discos: ");
        for (Disco disco : discos)
        {
            System.out.println("- " + disco.getTitulo());
        }
    }

}
