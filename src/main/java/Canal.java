import java.util.Observable;

public class Canal extends Observable {

    private Integer seguidores;
    private Integer videos;
    private String nome;

    public Canal(Integer seguidores, Integer videos, String nome) {
        this.seguidores = seguidores;
        this.videos = videos;
        this.nome = nome;
    }

    public void lancarVideo() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Canal{" +
                "canal=" + nome + ", " +
                seguidores + " seguidores, " +
                videos + " vídeos" +

                '}';
    }
}