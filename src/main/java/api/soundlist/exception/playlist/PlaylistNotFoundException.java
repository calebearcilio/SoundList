package api.soundlist.exception.playlist;

public class PlaylistNotFoundException extends RuntimeException {

  public PlaylistNotFoundException(Long id){
    super("Playlist de id '" + id + "' não encontrada.");
  }

  public PlaylistNotFoundException(String message) {
    super(message);
  }
}
