package org.cloudcost.core.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RequestProcess implements Serializable {

    private Long id;
    private String type;
    private LocalDateTime date;

}
