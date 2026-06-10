package api.soundlist.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistResponseDTO {

  private Long id;
  private String name;
  private String description;
}
