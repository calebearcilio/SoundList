package api.soundlist.seed;

import api.soundlist.model.Music;
import api.soundlist.model.Playlist;
import api.soundlist.repository.MusicRepository;
import api.soundlist.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

  private final MusicRepository musicRepository;
  private final PlaylistRepository playlistRepository;

  @Override
  public void run(String... args) throws Exception {

    if(musicRepository.count() > 0 && playlistRepository.count() > 0) {
      return;
    }

    System.out.println("Iniciando seeder...");
    Playlist pop = new Playlist();
    pop.setName("Pop");
    pop.setDescription("As melhores do Pop mundial");

    pop.addMusic("Billie Jean", "Michael Jackson", "Pop", 294);
    pop.addMusic("Thriller", "Michael Jackson", "Pop", 357);
    pop.addMusic("Beat It", "Michael Jackson", "Pop Rock", 258);
    pop.addMusic("Smooth Criminal", "Michael Jackson", "Pop", 257);
    pop.addMusic("Black or White", "Michael Jackson", "Pop", 262);

    pop.addMusic("Just the Way You Are", "Bruno Mars", "Pop", 220);
    pop.addMusic("Grenade", "Bruno Mars", "Pop", 223);
    pop.addMusic("When I Was Your Man", "Bruno Mars", "Pop", 214);
    pop.addMusic("Locked Out of Heaven", "Bruno Mars", "Pop Rock", 233);
    pop.addMusic("Treasure", "Bruno Mars", "Pop", 178);

    Playlist eletronica = new Playlist();
    eletronica.setName("Eletrônica");
    eletronica.setDescription("As melhores músicas eletrônicas");

    eletronica.addMusic("One More Time", "Daft Punk", "Electronic", 320);
    eletronica.addMusic("Harder, Better, Faster, Stronger", "Daft Punk", "Electronic", 224);
    eletronica.addMusic("Get Lucky", "Daft Punk", "Disco", 369);
    eletronica.addMusic("Around the World", "Daft Punk", "Electronic", 430);
    eletronica.addMusic("Digital Love", "Daft Punk", "Electronic", 301);

    eletronica.addMusic("Feel Good Inc.", "Gorillaz", "Electronic Rock", 221);
    eletronica.addMusic("Clint Eastwood", "Gorillaz", "Trip Hop", 341);
    eletronica.addMusic("DARE", "Gorillaz", "Electronic", 244);
    eletronica.addMusic("Stylo", "Gorillaz", "Electronic", 270);
    eletronica.addMusic("On Melancholy Hill", "Gorillaz", "Synth Pop", 233);

    Playlist mpb = new Playlist();
    mpb.setName("MPB");
    mpb.setDescription("As melhores do MPB");

    mpb.addMusic("Não Quero Dinheiro", "Tim Maia", "MPB", 179);
    mpb.addMusic("Gostava Tanto de Você", "Tim Maia", "MPB", 210);
    mpb.addMusic("Sossego", "Tim Maia", "Soul Brasileira", 272);
    mpb.addMusic("Primavera", "Tim Maia", "MPB", 265);
    mpb.addMusic("Azul da Cor do Mar", "Tim Maia", "MPB", 242);

    mpb.addMusic("Chão de Giz", "Zé Ramalho", "MPB", 286);
    mpb.addMusic("Avôhai", "Zé Ramalho", "MPB", 279);
    mpb.addMusic("Frevo Mulher", "Zé Ramalho", "MPB", 233);

    mpb.addMusic("Oceano", "Djavan", "MPB", 221);
    mpb.addMusic("Flor de Lis", "Djavan", "MPB", 215);

    Playlist rock = new Playlist();
    rock.setName("Rock");
    rock.setDescription("As melhores do Rock");

    rock.addMusic("Believer", "Imagine Dragons", "Alternative Rock", 204);
    rock.addMusic("Radioactive", "Imagine Dragons", "Alternative Rock", 186);
    rock.addMusic("Demons", "Imagine Dragons", "Alternative Rock", 177);
    rock.addMusic("Thunder", "Imagine Dragons", "Alternative Rock", 187);
    rock.addMusic("Whatever It Takes", "Imagine Dragons", "Alternative Rock", 201);

    rock.addMusic("In the End", "Linkin Park", "Nu Metal", 216);
    rock.addMusic("Numb", "Linkin Park", "Alternative Rock", 185);
    rock.addMusic("What I've Done", "Linkin Park", "Alternative Rock", 205);
    rock.addMusic("Faint", "Linkin Park", "Nu Metal", 162);
    rock.addMusic("Breaking the Habit", "Linkin Park", "Alternative Rock", 196);

    Playlist hiphop = new Playlist();
    hiphop.setName("Hip-Hop");
    hiphop.setDescription("As melhores do Hip-Hop");

    hiphop.addMusic("Lose Yourself", "Eminem", "Hip Hop", 326);
    hiphop.addMusic("Without Me", "Eminem", "Hip Hop", 290);
    hiphop.addMusic("The Real Slim Shady", "Eminem", "Hip Hop", 284);
    hiphop.addMusic("Mockingbird", "Eminem", "Hip Hop", 251);
    hiphop.addMusic("Stan", "Eminem", "Hip Hop", 404);
    hiphop.addMusic("Not Afraid", "Eminem", "Hip Hop", 248);
    hiphop.addMusic("Rap God", "Eminem", "Hip Hop", 364);
    hiphop.addMusic("Cleanin' Out My Closet", "Eminem", "Hip Hop", 297);
    hiphop.addMusic("Sing for the Moment", "Eminem", "Hip Hop", 339);
    hiphop.addMusic("Till I Collapse", "Eminem", "Hip Hop", 298);

    playlistRepository.saveAll(List.of(pop, eletronica, mpb, rock, hiphop));
    System.out.println("Seeder realizado com sucesso.");
  }
}
