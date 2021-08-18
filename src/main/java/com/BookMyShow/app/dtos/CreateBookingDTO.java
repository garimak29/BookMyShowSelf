package com.BookMyShow.app.dtos;

import com.BookMyShow.app.models.Show;
import com.BookMyShow.app.models.ShowSeat;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CreateBookingDTO {
    // checking the validity of the show uuid is not a part of customer usecase
    // this should be done at the request layer it self , after validation we will directly receive the show from the show uuid
    @NonNull
    Show show;
    @NonNull
    List<ShowSeat> showSeats;
}
