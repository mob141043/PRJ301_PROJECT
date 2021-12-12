package model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class SearchScheduleRequestDTO implements Serializable {

    private String searchClassName;
    private String searchCourseName;
    private String searchScheduleDate;
}
