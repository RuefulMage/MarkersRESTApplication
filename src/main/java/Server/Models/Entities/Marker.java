package Server.Models.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor(force=true)
@Table(name = "markers")
@XmlRootElement
@AllArgsConstructor
public class Marker implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "marker_id")
    private int id;

    @Column(name="comment")
    @Size(max=200, message="Comment must be less than 200 characters long")
    private String comment;


    @NotBlank
    @Column(name="country")
    private String country;

    @NotBlank
    @Column(name="longitude")
    private float longitude;

    @NotBlank
    @Column(name = "latitude")
    private float latitude;

    @NotBlank
    @Column(name="reasonOfTurism")
    private String reasonOfTurism;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
