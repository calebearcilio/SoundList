package api.soundlist.controller;

import api.soundlist.dto.playlist.PlaylistCreateDTO;
import api.soundlist.dto.playlist.PlaylistResponseDTO;
import api.soundlist.dto.playlist.PlaylistUpdateDTO;
import api.soundlist.dto.playlist.PlaylistWithMusicsResponseDTO;
import api.soundlist.service.PlaylistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/playlists")
public class PlaylistController {

  private final PlaylistService playlistService;

  @GetMapping
  public ResponseEntity<Page<PlaylistResponseDTO>> getAll(@PageableDefault(size = 5, sort = "name") Pageable pageable) {
    var playlists = playlistService.findAll(pageable);
    return ResponseEntity.ok(playlists);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PlaylistWithMusicsResponseDTO> getById(@PathVariable Long id) {
    var playlist = playlistService.findById(id);
    return ResponseEntity.ok(playlist);
  }

  @PostMapping
  public ResponseEntity<PlaylistResponseDTO> post(@RequestBody @Valid PlaylistCreateDTO dto) {
    var playlist = playlistService.save(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(playlist);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PlaylistResponseDTO> put(@PathVariable Long id, @RequestBody @Valid PlaylistUpdateDTO dto) {
    var playlist = playlistService.update(id, dto);
    return ResponseEntity.ok(playlist);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    playlistService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
