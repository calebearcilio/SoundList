package api.soundlist.dto.music;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicCreateDTO {
  @NotBlank(message = "Campo 'title' está ausente.")
  private String title;
  @NotBlank(message = "Campo 'artist' está ausente.")
  private String artist;
  private String genre;
  @Positive(message = "A duração deve ser um número inteiro positivo.")
  @NotNull(message = "Campo 'duration' está ausente.")
  private Integer duration;
  @NotNull(message = "O ID da playlist é obrigatório.")
  private Long playlistId;
}
