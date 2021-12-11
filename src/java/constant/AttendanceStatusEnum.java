/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

public enum AttendanceStatusEnum {

    ABSENT("A", "Absent"),
    PRESENT("P", "Present");

    private String value;
    private String description;

    private AttendanceStatusEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static AttendanceStatusEnum findByValue(String value) {
        for (AttendanceStatusEnum status : AttendanceStatusEnum.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        return null;
    }

}
