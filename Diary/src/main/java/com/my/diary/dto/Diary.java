package com.my.diary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "diary")
@SequenceGenerator(name = "diary_seq_generator",
                            sequenceName = "diary_seq",
                            initialValue = 1,
                            allocationSize =1
                    )
@DynamicInsert
@DynamicUpdate
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "diary_seq_genertor")
    @Column(name = "Diary_no")
    private  Long diaryNo;   //다이어리 글 번호

    @Column(name = "Diary_title")
    private String diaryTitle;

    @Column(name = "Diary_content")
    private String diaryContent;

    @Column(name="Diary_Viewcount")
    private int diaryViewcount;

    @ColumnDefault(value = "SYSDATE")
    @JsonFormat(pattern = "yy/MM/dd", timezone="Asia/Seoul")
    @Column(name="dairy_Dt")
    private Date boardDt;
}