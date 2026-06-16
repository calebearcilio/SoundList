package api.soundlist.controller;

import api.soundlist.dto.music.MusicCreateDTO;
import api.soundlist.dto.music.MusicResponseDTO;
import api.soundlist.dto.music.MusicUpdateDTO;
import api.soundlist.service.MusicService;
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
@RequestMapping("/api/musics")
public class MusicController {

  private final MusicService musicService;

  @GetMapping
  public ResponseEntity<Page<MusicResponseDTO>> getAll(@PageableDefault(size = 5, sort = "title") Pageable pageable) {
    var musics = musicService.findAll(pageable);
    return ResponseEntity.ok(musics);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MusicResponseDTO> getById(@PathVariable Long id) {
    var music = musicService.findById(id);
    return ResponseEntity.ok(music);
  }

  @PostMapping
  public ResponseEntity<MusicResponseDTO> post(@RequestBody @Valid MusicCreateDTO dto) {
    var music = musicService.save(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(music);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MusicResponseDTO> put(@PathVariable Long id, @RequestBody @Valid MusicUpdateDTO dto) {
    var music = musicService.update(id, dto);
    return ResponseEntity.ok(music);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    musicService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
