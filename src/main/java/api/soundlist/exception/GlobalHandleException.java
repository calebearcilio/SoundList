package api.soundlist.exception;

import api.soundlist.dto.exception.ExceptionResponseDTO;
import api.soundlist.exception.music.MusicNotFoundException;
import api.soundlist.exception.playlist.PlaylistNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
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

  // MUSIC
  @ExceptionHandler(MusicNotFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handleMusicNotFound (MusicNotFoundException exception) {
    return build(HttpStatus.NOT_FOUND, "Música não encontrada.", exception.getMessage(), null);
  }

  // VALIDATION
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return build(HttpStatus.BAD_REQUEST, "Erro de validação.", "Um ou mais campos estão inválidos.", errors);
  }

  // INTERNAL SERVER ERROR
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponseDTO> handleGeneralException(Exception exception) {
    return build(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor.", exception.getMessage(), null);
  }

  private ResponseEntity<ExceptionResponseDTO> build(HttpStatus status, String error, String message, Map<String, String> fields) {
    var body = new ExceptionResponseDTO(status.value(), error, message, LocalDateTime.now() , fields );
    return ResponseEntity.status(status).body(body);
  }
}
