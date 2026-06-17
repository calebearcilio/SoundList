package api.soundlist.dto.playlist;

import api.soundlist.dto.music.MusicWithoutPlaylistDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistWithMusicsResponseDTO {
  private Long id;
  private String name;
  private String description;

  List<MusicWithoutPlaylistDTO> musics;
}
