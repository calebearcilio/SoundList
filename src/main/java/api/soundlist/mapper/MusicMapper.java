package api.soundlist.mapper;

import api.soundlist.dto.music.MusicCreateDTO;
import api.soundlist.dto.music.MusicResponseDTO;
import api.soundlist.dto.music.MusicUpdateDTO;
import api.soundlist.model.Music;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MusicMapper {

  MusicResponseDTO toDTO(Music music);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "playlist", ignore = true)
  Music toEntity(MusicCreateDTO musicDTO);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "playlist", ignore = true)
  void updateEntityFromDTO(MusicUpdateDTO dto, @MappingTarget Music music);

  default Page<MusicResponseDTO> toPageDTO(Page<Music> musics) {
    return musics.map(this::toDTO);
  }
}
