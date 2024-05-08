package ravi.learning.bloggingapp.dto;

import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails {
    private Date timeStamp;
    private String message;
    private String details;

}
