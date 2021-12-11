/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.converter;

import constant.AttendanceStatusEnum;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AttendanceStatusConverter implements AttributeConverter<AttendanceStatusEnum, String>{

    @Override
    public String convertToDatabaseColumn(AttendanceStatusEnum status) {
        return status.getValue();
    }

    @Override
    public AttendanceStatusEnum convertToEntityAttribute(String data) {
        return AttendanceStatusEnum.findByValue(data);
    }
    
}
