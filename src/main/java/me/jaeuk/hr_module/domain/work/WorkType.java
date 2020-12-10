package me.jaeuk.hr_module.domain.work;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public enum WorkType {
    OLD_RESIDENT("구상주", LocalDate.of(2020, 11, 2))
    , RESIDENT("상주", LocalDate.of(2020, 11, 2))
    , RESIDENT_DEFORMATION("상주(변형)", LocalDate.of(2020, 11, 2))
    , DRIVER("운전직", LocalDate.of(2020, 11, 2))
    , TWO_GROUP_TWO_SHIFT("2조2교대", LocalDate.of(2020, 11, 2)) // 주5,휴2,야5,휴2
    , THREE_GROUP_TWO_SHIFT("3조2교대", LocalDate.of(2020, 11, 2))
    , FOUR_GROUP_TWO_SHIFT("4조2교대", LocalDate.of(2020, 11, 2))
    ;

    final private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private WorkType(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    private WorkType(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}