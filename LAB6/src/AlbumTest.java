//Nome: Matheus Barroso de Santana
//DRE: 120041661
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    private Album<Figurinha> albumFigurinhas;
    private Repositorio<Figurinha> repositorioFigurinhas;

    private Album<Selo> albumSelos;
    private Repositorio<Selo> repositorioSelos;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int ITENS_POR_PACOTE = 3;
    private static final Figurinha figurinhaEntrada = new Figurinha(0,"teste");
    private static final Selo seloEntrada= new Selo(0, "teste", "teste",0);


    @Before  // roda antes de cada teste
    public void setUp() {
        this.repositorioFigurinhas = new Repositorio("album_copa2014", TAMANHO_DO_ALBUM, figurinhaEntrada);
        this.albumFigurinhas = new Album(repositorioFigurinhas, ITENS_POR_PACOTE);

        this.repositorioSelos = new Repositorio("album_Selos2014", TAMANHO_DO_ALBUM, seloEntrada);
        this.albumSelos = new Album(repositorioFigurinhas, ITENS_POR_PACOTE);
    }

    private void popularAlbum(int[] posicoesDesejadas) {
        Pacotinho<Figurinha> pacoteF = new Pacotinho(this.repositorioFigurinhas, posicoesDesejadas);
        this.albumFigurinhas.receberNovoPacotinho(pacoteF);

        Pacotinho<Selo> pacoteS = new Pacotinho(this.repositorioSelos, posicoesDesejadas);
        this.albumSelos.receberNovoPacotinho(pacoteS);
    }

    @Test
    public void testarPossuiColecionavelParaColecionaveisExistentes() {
        popularAlbum(new int[] {1, 2, 3});

        for (int i = 1; i <= 3; i++) {
            assertTrue("Figurinhas já inseridas devem ser encontradas",
                    this.albumFigurinhas.possuiItemColado(i));
            assertTrue("Selos já inseridos devem ser encontrados",
                    this.albumSelos.possuiItemColado(i));
        }
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasAusentes() {
        popularAlbum(new int[] {1, 2, 3});

        assertFalse("Não devemos encontrar no álbum figurinhas nunca inseridas",
                this.albumFigurinhas.possuiItemColado(4));
        assertFalse("Não devemos encontrar figurinhas de posições não-positivas",
                this.albumFigurinhas.possuiItemColado(-390));
        assertFalse("Não devemos encontrar figurinhas maiores do que o tamanho",
                this.albumFigurinhas.possuiItemColado(TAMANHO_DO_ALBUM + 1));

        assertFalse("Não devemos encontrar no álbum selos nunca inseridos",
                this.albumSelos.possuiItemColado(4));
        assertFalse("Não devemos encontrar selos de posições não-positivas",
                this.albumSelos.possuiItemColado(-390));
        assertFalse("Não devemos encontrar selos maiores do que o tamanho",
                this.albumSelos.possuiItemColado(TAMANHO_DO_ALBUM + 1));
    }

    @Test
    public void testarPossuiRepetidaParaFigurinhaRepetida() {
        popularAlbum(new int[] {1, 2, 3});
        assertFalse(this.albumFigurinhas.possuiItemRepetido(2));  // sanity check
        assertFalse(this.albumSelos.possuiItemRepetido(2));  // sanity check

        popularAlbum(new int[] {2, 8, 9});
        assertTrue(this.albumFigurinhas.possuiItemRepetido(2));
        assertTrue(this.albumSelos.possuiItemRepetido(2));


    }

    @Test
    public void testarGetTamanhoAlbum() {

        assertEquals(TAMANHO_DO_ALBUM, this.albumFigurinhas.getTamanho());
        assertEquals(TAMANHO_DO_ALBUM, this.albumSelos.getTamanho());
    }

    @Test
    public void testarGetContFigurinhas() {
        popularAlbum(new int[] {1, 2, 3});
        assertEquals(3, this.albumFigurinhas.getQuantItensColados());
        assertEquals(3, this.albumSelos.getQuantItensColados());
        // vou agora abrir outro pacotinho com as mesmas figurinhas
        // e verificar que o álbum terá ainda 3 figurinhas

        popularAlbum(new int[] {1, 2, 3});
        assertEquals(3, this.albumFigurinhas.getQuantItensColados());
        assertEquals(3, this.albumSelos.getQuantItensColados());


    }

    @Test
    public void testarGetQuantasFaltam() {
        popularAlbum(new int[] {1, 2, 3});
        assertEquals(TAMANHO_DO_ALBUM - 3,
                this.albumFigurinhas.getQuantItensFaltantes());

        assertEquals(TAMANHO_DO_ALBUM - 3,
                this.albumSelos.getQuantItensFaltantes());
    }



    @Test
    public void testarRejeicaoPacotinhosDeTamanhoErrado() {
        popularAlbum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8});

        assertEquals("Pacotes de tamanho distinto do informado na construção " +
                        "do álbum devem ser rejeitados",
                0, albumFigurinhas.getQuantItensColados());


        assertEquals("Pacotes de tamanho distinto do informado na construção " +
                        "do álbum devem ser rejeitados",
                0, albumSelos.getQuantItensColados());
    }


    @Test
    public void testarGetItemColado() {
        popularAlbum(new int[] {1, 2, 3});
        Figurinha figurinha = albumFigurinhas.getItemColado(2);
        Selo selo = albumSelos.getItemColado(3);

        assertNotNull(figurinha);
        assertNotNull(selo);

        assertEquals(2, figurinha.getPosicao());
        assertEquals(3, selo.getPosicao());

        assertNull(albumFigurinhas.getItemColado(4));
        assertNull(albumSelos.getItemColado(4));
    }

}