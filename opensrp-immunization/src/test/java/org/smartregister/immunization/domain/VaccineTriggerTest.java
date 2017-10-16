package org.smartregister.immunization.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.smartregister.immunization.BaseUnitTest;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * Created by onaio on 30/08/2017.
 */

public class VaccineTriggerTest extends BaseUnitTest {

    public static final String CHILD = "child";
    String stringdata1 = "{\n" +
            "              \"reference\": \"dob\",\n" +
            "              \"offset\": \"+0d\"\n" +
            "            }";
    String stringdata2 = "{\n" +
            "              \"reference\": \"prerequisite\",\n" +
            "              \"prerequisite\": \"OPV 1\",\n" +
            "              \"offset\": \"+28d\"\n" +
            "            }";

    @Test
    public void assertInitReturnsNonNullTriggers() throws JSONException {
        JSONObject data1 = new JSONObject(stringdata1);
        JSONObject data2 = new JSONObject(stringdata2);
        junit.framework.Assert.assertNotNull(VaccineTrigger.init(CHILD, data1));
        junit.framework.Assert.assertNotNull(VaccineTrigger.init(CHILD, data2));
    }

    @Test
    public void assertGetMethodsReturnsCorrectValues() throws JSONException {
        JSONObject data1 = new JSONObject(stringdata1);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        VaccineSchedule.standardiseCalendarDate(calendar);
        junit.framework.Assert.assertEquals(calendar.getTime(), VaccineTrigger.init(CHILD, data1).getFireDate(Collections.EMPTY_LIST, date));
    }

}
