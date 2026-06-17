package api.soundlist.dto.music;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicWithoutPlaylistDTO {
  private Long id;
  private String title;
  private String artist;
  private String genre;
  private Integer duration;
}
