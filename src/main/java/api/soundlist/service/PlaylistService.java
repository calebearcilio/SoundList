package api.soundlist.service;

import api.soundlist.dto.playlist.PlaylistCreateDTO;
import api.soundlist.dto.playlist.PlaylistResponseDTO;
import api.soundlist.dto.playlist.PlaylistUpdateDTO;
import api.soundlist.exception.playlist.PlaylistNotFoundException;
import api.soundlist.mapper.PlaylistMapper;
import api.soundlist.model.Playlist;
import api.soundlist.repository.MusicRepository;
import api.soundlist.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistService {

  private final PlaylistRepository playlistRepository;
  private final MusicRepository musicRepository;
  private final PlaylistMapper playlistMapper;

  public Page<PlaylistResponseDTO> findAll(Pageable pageable) {
    return playlistMapper.toPageDTO(playlistRepository.findAll(pageable));
  }

  public PlaylistResponseDTO findById(Long id) {
    return playlistMapper.toDTO(findOrThrow(id));
  }

  public PlaylistResponseDTO save(PlaylistCreateDTO dto) {
    var playlist = playlistMapper.toEntity(dto);
    return playlistMapper.toDTO(playlistRepository.save(playlist));
  }

  public PlaylistResponseDTO update(Long id, PlaylistUpdateDTO dto){
    var playlist = findOrThrow(id);
    playlistMapper.updateEntityFromDTO(dto, playlist);
    return playlistMapper.toDTO(playlistRepository.save(playlist));
  }

  public void delete(Long id) {
    var playlist = findOrThrow(id);
    playlistRepository.delete(playlist);
  }

  private Playlist findOrThrow(Long id) {
    return playlistRepository.findById(id).orElseThrow(() -> new PlaylistNotFoundException(id));
  }
}
