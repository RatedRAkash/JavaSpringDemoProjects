package com.psl.wso2.np.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeFormatter {
    private static final Log LOGGER = LogFactory.getLog(TimeFormatter.class);
    private static final String TIME = "TIME";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;


    public static String formatDate(String inputTime) {
        String dateOutput;
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(inputTime, FORMATTER);
            Date local = Date.from(localDateTime.toInstant(ZoneOffset.of(getZoneInfo(inputTime))));
            DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            dateOutput = formatDate.format(local);
        } catch (Exception e) {
            LOGGER.fatal(e);
            dateOutput = new Date().toLocaleString();
        }
        return dateOutput;
    }

    private static String getZoneInfo(String time) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(time);
        return zonedDateTime.getZone().toString();
    }
}
