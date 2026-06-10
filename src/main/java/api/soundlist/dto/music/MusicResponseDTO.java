package api.soundlist.dto.music;

import api.soundlist.dto.playlist.PlaylistResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicResponseDTO {
  private Long id;
  private String title;
  private String artist;
  private String genre;
  private Integer duration;
  private PlaylistResponseDTO playlist;
}
