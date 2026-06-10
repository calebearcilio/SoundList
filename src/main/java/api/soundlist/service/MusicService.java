package api.soundlist.service;

import api.soundlist.dto.music.MusicCreateDTO;
import api.soundlist.dto.music.MusicResponseDTO;
import api.soundlist.dto.music.MusicUpdateDTO;
import api.soundlist.exception.music.MusicNotFoundException;
import api.soundlist.mapper.MusicMapper;
import api.soundlist.model.Music;
import api.soundlist.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {

  private final MusicRepository musicRepository;
  private final MusicMapper musicMapper;

  public Page<MusicResponseDTO> findAll(Pageable pageable) {
    return musicMapper.toPageDTO(musicRepository.findAll(pageable));
  }

  public MusicResponseDTO findById(Long id) {
    return musicMapper.toDTO(findOrThrow(id));
  }

  public MusicResponseDTO save(MusicCreateDTO dto) {
    var music = musicMapper.toEntity(dto);
    return musicMapper.toDTO(musicRepository.save(music));
  }

  public MusicResponseDTO update(Long id, MusicUpdateDTO dto) {
    var music = findOrThrow(id);
    music = musicMapper.updateEntityFromDTO(dto);
    return musicMapper.toDTO(musicRepository.save(music));
  }

  public void detele(Long id) {
    var music = findOrThrow(id);
    musicRepository.delete(music);
  }

  private Music findOrThrow(Long id) {
    return musicRepository.findById(id).orElseThrow(() -> new MusicNotFoundException(id));
  }
}
