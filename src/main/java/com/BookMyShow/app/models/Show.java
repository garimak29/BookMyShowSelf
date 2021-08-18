package com.BookMyShow.app.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Show extends Exposed {
    private Date startTime; // include Timezone
    private Date endTime;
    private Movie movie;
    private Hall hall;
    private boolean isCancelled;

    public boolean isShowPending(){
        return !isCancelled && endTime.after(new Date());
    }
}
