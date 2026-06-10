package api.soundlist.dto.music;

import jakarta.validation.constraints.PositiveOrZero;

public class MusicUpdateDTO {
  private String title;
  private String artist;
  private String genre;
  @PositiveOrZero(message = "A duração deve ser um número inteiro positivo.")
  private Integer duration;
}
