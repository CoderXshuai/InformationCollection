package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author CoderXshuai
 */
public class DateTransform {
    public static Object localDate2Date(Object object) {
        if (object.getClass() == LocalDate.class) {
            LocalDate localDate = (LocalDate) object;
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
            Instant instant1 = zonedDateTime.toInstant();
            return Date.from(instant1);
        }
        if (object.getClass() == Date.class) {
            Date date = (Date) object;
            Instant instant = date.toInstant();
            ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
            return zdt.toLocalDate();
        }
        return null;
    }

}
