package api.soundlist.mapper;

import api.soundlist.dto.music.MusicCreateDTO;
import api.soundlist.dto.music.MusicResponseDTO;
import api.soundlist.dto.music.MusicUpdateDTO;
import api.soundlist.model.Music;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MusicMapper {

  MusicResponseDTO toDTO(Music music);

  @Mapping(target = "playlist", ignore = true)
  @Mapping(target = "id", ignore = true)
  Music toEntity(MusicCreateDTO musicDTO);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "playlist", ignore = true)
  Music updateEntityFromDTO(MusicUpdateDTO dto);

  default Page<MusicResponseDTO> toPageDTO(Page<Music> musics) {
    return musics.map(this::toDTO);
  }
}
