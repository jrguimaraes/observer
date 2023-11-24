import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeguidorTest {

    @Test
    void deveNotificarUmSeguidor() {
        Canal canal = new Canal(78000, 60, "CanalA");
        Seguidor seguidor = new Seguidor("Jr");
        seguidor.seguir(canal);
        canal.lancarVideo();
        assertEquals("Jr, vídeo lançado no Canal{canal=CanalA, 78000 seguidores, 60 vídeos}", seguidor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSeguidores() {
        Canal canal = new Canal(78000, 60, "CanalA");
        Seguidor seguidor = new Seguidor("Jr");
        Seguidor seguidor2 = new Seguidor("Jr2");
        seguidor.seguir(canal);
        seguidor2.seguir(canal);
        canal.lancarVideo();
        assertEquals("Jr, vídeo lançado no Canal{canal=CanalA, 78000 seguidores, 60 vídeos}", seguidor.getUltimaNotificacao());
        assertEquals("Jr2, vídeo lançado no Canal{canal=CanalA, 78000 seguidores, 60 vídeos}", seguidor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarSeguidor() {
        Canal canal = new Canal(78000, 60, "CanalA");
        Seguidor seguidor = new Seguidor("Jr");
        canal.lancarVideo();
        assertEquals(null, seguidor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSeguidorCanalA() {
        Canal canalA = new Canal(78000, 60, "CanalA");
        Canal canalB = new Canal(78000, 60, "CanalB");
        Seguidor seguidor = new Seguidor("Jr");
        Seguidor seguidor2 = new Seguidor("Jr2");
        seguidor.seguir(canalA);
        seguidor2.seguir(canalB);
        canalA.lancarVideo();
        assertEquals("Jr, vídeo lançado no Canal{canal=CanalA, 78000 seguidores, 60 vídeos}", seguidor.getUltimaNotificacao());
        assertEquals(null, seguidor2.getUltimaNotificacao());
    }

}