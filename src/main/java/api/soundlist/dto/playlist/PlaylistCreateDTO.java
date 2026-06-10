package api.soundlist.dto.playlist;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistCreateDTO {

  @NotBlank(message = "Campo 'name' ausente.")
  private String name;
  private String description;
}
