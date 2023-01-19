package net.itinajero.app.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Utileria {

    /**
     * Metodo que regresa una lista de Strings con las fechas siguientes, segun el parametro count
     * @param count
     * @return
     */

    public static List<String> getNexdays(int count) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //today
        Date start = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, count); // Next N days form now
        Date endDate = cal.getTime();

        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(start);
        List<String> nextDays = new ArrayList<String>();
        while (!gcal.getTime().after(endDate)) {
            Date d = gcal.getTime();
            gcal.add(Calendar.DATE, 1);
            nextDays.add(sdf.format(d));
        }
        return nextDays;

    }


}
