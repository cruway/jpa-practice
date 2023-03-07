package hellojpa;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

@Deprecated
@Entity
@Builder
@Getter @Setter
/*@SequenceGenerator(
        name = "MEMBER2_SEQ_GENERATOR",
        sequenceName = "MEMBER2_SEQ",
        initialValue = 1, allocationSize = 1)*/
public class Member2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMGER2_SEQ_GENERATOR")*/
    private String id;
    @Column(name = "name", nullable = false)
    private String username;

}
