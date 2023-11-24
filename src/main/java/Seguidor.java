import java.util.Observable;
import java.util.Observer;

public class Seguidor implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Seguidor(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void seguir(Canal canal) {
        canal.addObserver(this);
    }

    public void update(Observable canal, Object arg1) {
        this.ultimaNotificacao = this.nome + ", vídeo lançado no " + canal.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}