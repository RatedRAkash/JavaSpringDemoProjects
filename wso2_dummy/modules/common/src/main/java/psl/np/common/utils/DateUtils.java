package psl.np.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final DateTimeFormatter QUERY_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE; //yyyy-MM-dd
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME = DateTimeFormatter.ISO_LOCAL_DATE_TIME; //yyyy-MM-dd
    public static final String QUERY_DATE_TIME_FORMAT="yyyy-MM-dd HH:mm:ss.SSS";
    public static final DateTimeFormatter QUERY_DATE_TIME_FORMATTER=DateTimeFormatter.ofPattern(QUERY_DATE_TIME_FORMAT);

    public static ZonedDateTime toUtc(Date date) {
        if (date == null) {
            return null;
        }
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
    }

    public static ZonedDateTime toUtc(String dateStr) {
        return parseDate(dateStr, QUERY_FORMAT);
    }
    public static ZonedDateTime toUtcWithFormat(String dateStr,String format){
        return parseDate(dateStr,DateTimeFormatter.ofPattern(format));
    }
    public static ZonedDateTime toUtcDateTime(String dateStr){
        if (Strings.isNullOrWhiteSpace(dateStr)) {
            return null;
        }
        LocalDateTime ldt = LocalDateTime.parse(dateStr, ISO_LOCAL_DATE_TIME);
        return ZonedDateTime.of(ldt, ZoneOffset.UTC);
    }


    public static ZonedDateTime sqlDateToUtc(java.sql.Date date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate().atStartOfDay(ZoneOffset.UTC) ;
    }
    public static ZonedDateTime sqlDateToUtc(java.sql.Timestamp date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDateTime().atZone(ZoneId.systemDefault());
    }

    public static ZonedDateTime utcNow() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }

    public static Date toDate(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) {
            return null;
        }
        return Date.from(zonedDateTime.toInstant());
    }
    public static Date toDate(String dateTime,DateTimeFormatter dateTimeFormatter) {

        return toDate(parseDate(dateTime,dateTimeFormatter));
    }

    public static Date addYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    public static Date addDateDuration(Duration duration) {
        return Date.from(Instant.now().plusSeconds(duration.getSeconds()));
    }

    public static String formatDate(ZonedDateTime zonedDateTime) {
        return formatDate(zonedDateTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static String formatDate(ZonedDateTime zonedDateTime, String formatter) {
        return formatDate(zonedDateTime, DateTimeFormatter.ofPattern(formatter));
    }

    public static String formatDate(ZonedDateTime zonedDateTime, DateTimeFormatter formatter) {
        return zonedDateTime.format(formatter);
    }

    public static ZonedDateTime startOfMonth() {
        ZonedDateTime now = utcNow();
        return ZonedDateTime.of(now.getYear(), now.getMonthValue(), 1, 0, 0, 0, 0, now.getZone());
    }

    public static ZonedDateTime startOfDay(ZonedDateTime dateTime) {
        return ZonedDateTime.of(dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(), 0, 0, 0, 0, dateTime.getZone());
    }

    public static ZonedDateTime endOfDay(ZonedDateTime dateTime) {
        return ZonedDateTime.of(dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(), 23, 59, 59, 999, dateTime.getZone());
    }

    public static ZonedDateTime toUtcEndOfDay(Date date) {
        ZonedDateTime zdt = toUtc(date);
        return endOfDay(zdt);
    }

    public static ZonedDateTime parseDate(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return parseDate(dateStr, formatter);
    }

    public static ZonedDateTime parseDate(String dateStr, DateTimeFormatter formatter) {
        if (Strings.isNullOrWhiteSpace(dateStr)) {
            return null;
        }
        LocalDate ldt = LocalDate.parse(dateStr, formatter);
        return ZonedDateTime.of(ldt, LocalTime.MIN, ZoneOffset.UTC);
    }

    public static long toHourCeil(Duration duration) {
        long seconds = duration.getSeconds();
        return (seconds / 3600) + (seconds % 3600 == 0 ? 0 : 1);
    }

    public static String lastDayOfMonth(String date, String pattern){
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        convertedDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
        return convertedDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static Date getDateFromString(String date, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(date);
    }

    public static String getStringFromDate(Date date, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static long calculateWorkingDayMinutes(ZonedDateTime from, ZonedDateTime to){
        Period period = Period.parse("P1D");
        long minutes = 0;
        while(from.isBefore(to)){
            if(from.getDayOfWeek() != DayOfWeek.FRIDAY && from.getDayOfWeek() != DayOfWeek.SATURDAY){
                minutes += from.getDayOfYear() == to.getDayOfYear() ? from.until(to, ChronoUnit.MINUTES) :
                        from.until(endOfDay(from), ChronoUnit.MINUTES);
            }
            from = from.plus(period);
            from = startOfDay(from);
        }
        return minutes;
    }
    public static String dateStringFromZonedDateTime(ZonedDateTime zdt, String pattern){
        return zdt.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String dateFormatForQrPdfTemplate() {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        return dateFormatter.format(new Date());
    }
}
