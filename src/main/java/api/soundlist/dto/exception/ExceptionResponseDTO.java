package api.soundlist.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDTO {
  private int status;
  private String error;
  private String message;
  private LocalDateTime timestamp;
  private Map<String, String> fields;

}
