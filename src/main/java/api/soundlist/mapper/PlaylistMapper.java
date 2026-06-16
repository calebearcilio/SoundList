package api.soundlist.mapper;

import api.soundlist.dto.playlist.PlaylistCreateDTO;
import api.soundlist.dto.playlist.PlaylistResponseDTO;
import api.soundlist.dto.playlist.PlaylistUpdateDTO;
import api.soundlist.model.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlaylistMapper {

  PlaylistResponseDTO toDTO(Playlist playList);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "musics", ignore = true)
  Playlist toEntity(PlaylistCreateDTO playlistDTO);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "musics", ignore = true)
  void updateEntityFromDTO(PlaylistUpdateDTO dto, @MappingTarget Playlist playlist);

  default Page<PlaylistResponseDTO> toPageDTO(Page<Playlist> playlists) {
    return playlists.map(this::toDTO);
  }
}
