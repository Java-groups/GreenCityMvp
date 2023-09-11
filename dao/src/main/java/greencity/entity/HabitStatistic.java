package greencity.entity;

import greencity.enums.HabitRate;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "habit_statistics")
@Entity
public class HabitStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "rate")
    private HabitRate habitRate;

    @Column(name = "create_date", nullable = false)
    private ZonedDateTime createDate;

    @Column(name = "amount_of_items")
    private Integer amountOfItems;

    @ManyToOne(fetch = FetchType.LAZY)
    private HabitAssign habitAssign;
}
