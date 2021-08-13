package com.BookMyShow.app.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
public abstract class Audit {
    private Long Id;
    private Date createdOn;
    private Date updatedOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audit audit = (Audit) o;
        return Objects.equals(Id, audit.Id)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
