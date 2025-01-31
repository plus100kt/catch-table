package com.echo.catchtable.dto.request;

public record OpenWeek (
        String week,
        String start_time,
        String end_time,
        String last_order,
        String break_start_time,
        String break_end_time
){

}
