package api.soundlist.exception;

import api.soundlist.dto.exception.ExceptionResponseDTO;
import api.soundlist.exception.playlist.PlaylistNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandleException {

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handleNoResourceFound(NoResourceFoundException exception) {
    return build(HttpStatus.NOT_FOUND, "Recurso não encontrado.", exception.getMessage(), null);
  }


  // PLAYLIST
  @ExceptionHandler(PlaylistNotFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handlePlaylistNotFound (PlaylistNotFoundException exception) {
    return build(HttpStatus.NOT_FOUND, "Playlist não encontrada.", exception.getMessage(), null);
  }

  private ResponseEntity<ExceptionResponseDTO> build(HttpStatus status, String error, String message, Map<String, String> fields) {
    var body = new ExceptionResponseDTO(status.value(), error, message, LocalDateTime.now() , fields );
    return ResponseEntity.status(status).body(body);
  }
}
