package api.soundlist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "musics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String artist;

  private String genre;

  @Column(nullable = false)
  private Integer duration;

  @ManyToOne
  @JoinColumn(name = "playlist_id")
  private Playlist playlist;
}
