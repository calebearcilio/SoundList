package api.soundlist.service;

import api.soundlist.dto.music.MusicCreateDTO;
import api.soundlist.dto.music.MusicResponseDTO;
import api.soundlist.dto.music.MusicUpdateDTO;
import api.soundlist.exception.music.MusicNotFoundException;
import api.soundlist.exception.playlist.PlaylistNotFoundException;
import api.soundlist.mapper.MusicMapper;
import api.soundlist.model.Music;
import api.soundlist.repository.MusicRepository;
import api.soundlist.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {

  private final MusicRepository musicRepository;
  private final PlaylistRepository playlistRepository;
  private final MusicMapper musicMapper;

  public Page<MusicResponseDTO> findAll(Pageable pageable) {
    return musicMapper.toPageDTO(musicRepository.findAll(pageable));
  }

  public MusicResponseDTO findById(Long id) {
    return musicMapper.toDTO(findOrThrow(id));
  }

  public MusicResponseDTO save(MusicCreateDTO dto) {
    var playlist = playlistRepository.findById(dto.getPlaylistId())
            .orElseThrow(() -> new PlaylistNotFoundException(dto.getPlaylistId()));

    var music = musicMapper.toEntity(dto);
    music.setPlaylist(playlist);

    return musicMapper.toDTO(musicRepository.save(music));
  }

  public MusicResponseDTO update(Long id, MusicUpdateDTO dto) {
    var music = findOrThrow(id);

    var playlist = playlistRepository.findById(dto.getPlaylistId())
            .orElseThrow(() -> new PlaylistNotFoundException(dto.getPlaylistId()));

    musicMapper.updateEntityFromDTO(dto, music);
    music.setPlaylist(playlist);

    return musicMapper.toDTO(musicRepository.save(music));
  }

  public void delete(Long id) {
    var music = findOrThrow(id);
    musicRepository.delete(music);
  }

  private Music findOrThrow(Long id) {
    return musicRepository.findById(id).orElseThrow(() -> new MusicNotFoundException(id));
  }
}
