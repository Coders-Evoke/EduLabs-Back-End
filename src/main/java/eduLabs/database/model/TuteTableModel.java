package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tute")
public class TuteTableModel {

    @Id
    @Column(length = 5)
    private String tuteID;

    @Column(length = 4)
    private String classID;

    @Column(length = 20)
    private String title;

    @Column(length = 4)
    private int totalCount;

    @Column(length = 4)
    private int remainingCount;

}
