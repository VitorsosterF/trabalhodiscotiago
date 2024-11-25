import java.util.ArrayList;
import java.util.List;

public class Disco
{
    private String titulo;
    private int anoLancamento;
    private List<String> faixas;
    private Artista artista;

    public Disco(String titulo, int anoLancamento, List<String> faixas, Artista artista)
    {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = faixas != null ? faixas : new ArrayList<String>();
        this.artista = artista;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public int getAnoLancamento()
    {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento)
    {
        this.anoLancamento = anoLancamento;
    }

    public List<String> getFaixas()
    {
        return faixas;
    }

    public void setFaixas(List<String> faixas)
    {
        this.faixas = faixas;
    }

    public Artista getArtista()
    {
        return artista;
    }

    public void setArtista(Artista artista)
    {
        this.artista = artista;
    }

    public void exibirDisco() {
        System.out.println("Título: " + titulo);
        System.out.println("Ano de Lançamento: " + anoLancamento);

        if (artista != null) {
            System.out.println("Artista: " + artista.getNome());
            System.out.println("Gênero: " + artista.getGenero());
        } else {
            System.out.println("Artista: Não associado.");
        }

        System.out.println("Faixas:");
        for (int i = 0; i < faixas.size(); i++) {
            System.out.println((i + 1) + ". " + faixas.get(i));
        }
    }
}
