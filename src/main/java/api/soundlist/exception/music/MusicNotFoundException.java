package api.soundlist.exception.music;

public class MusicNotFoundException extends RuntimeException {

  public MusicNotFoundException(Long id){
    super("Playlist de id '" + id + "' não encontrada.");
  }

  public MusicNotFoundException(String message) {
    super(message);
  }
}
