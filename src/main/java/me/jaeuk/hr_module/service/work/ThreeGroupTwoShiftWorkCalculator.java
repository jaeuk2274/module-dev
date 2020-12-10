package me.jaeuk.hr_module.service.work;

import me.jaeuk.hr_module.domain.work.WorkShift;
import me.jaeuk.hr_module.domain.work.WorkTime;
import me.jaeuk.hr_module.domain.work.WorkType;

import java.time.LocalDate;

public class ThreeGroupTwoShiftWorkCalculator implements WorkCalculator {
    private WorkShift workShift;
    private LocalDate dutydate;

    public ThreeGroupTwoShiftWorkCalculator(WorkShift workShift, LocalDate dutydate) {
        this.workShift = workShift;
        this.dutydate = dutydate;
    }

    @Override
    public WorkTime getWorkShift(){
        WorkType type = workShift.getType();
        long stdDay = dutydate.toEpochDay() - type.getStartDate().toEpochDay();
        long shiftChkCnt = 0;

        switch(workShift){
            case THREE_GROUP_TWO_SHIFT_A:
                shiftChkCnt = stdDay%10;
                break;
            case THREE_GROUP_TWO_SHIFT_B:
                shiftChkCnt = (stdDay+2)%10;
                break;
            case THREE_GROUP_TWO_SHIFT_C:
                shiftChkCnt = (stdDay+4)%10;
                break;
            default:
                throw new IllegalArgumentException("근무조가 없습니다." + workShift.getName());
        }

        if(shiftChkCnt < 4) {
            return WorkTime.THREE_GROUP_TWO_SHIFT_W1;
        }else if(shiftChkCnt == 4 || shiftChkCnt == 5) {
            return WorkTime.THREE_GROUP_TWO_SHIFT_H;
        }else if(shiftChkCnt < 10) {
            return WorkTime.THREE_GROUP_TWO_SHIFT_W2;
        }else {
            throw new IllegalArgumentException("잘못된 시간입니다." + workShift.getName());
        }
    }

}