package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/*no need to expose this to the customer so not extending Exposed*/
@Getter
@Setter
@Builder
public class Role extends Audit{
    private String Role;
    private String description;


}
