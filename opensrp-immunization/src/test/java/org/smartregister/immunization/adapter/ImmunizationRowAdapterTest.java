package org.smartregister.immunization.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.domain.Alert;
import org.smartregister.immunization.BaseUnitTest;
import org.smartregister.immunization.domain.Vaccine;
import org.smartregister.immunization.domain.VaccineWrapper;
import org.smartregister.immunization.view.ImmunizationRowCard;
import org.smartregister.immunization.view.ImmunizationRowGroup;
import org.smartregister.immunization.view.VaccineCard;
import org.smartregister.immunization.view.VaccineGroup;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by onaio on 30/08/2017.
 */

public class ImmunizationRowAdapterTest extends BaseUnitTest {

    @Mock
    private Context context;

    @Mock
    private ImmunizationRowAdapter immunizationRowAdapter;

    @Mock
    private AttributeSet attributeSet;

    @Mock
    private ImmunizationRowGroup vaccineGroup;

    @Mock
    private CommonPersonObjectClient commonPersonObjectClient;

    @Mock
    protected View convertView;

    @Mock
    protected ViewGroup parentView;

    @Mock
    private ImmunizationRowCard immunizationRowCard;

    @Mock
    private VaccineWrapper vaccineWrapper;

    @Before
    public void setUp() {
        immunizationRowAdapter = Mockito.mock(ImmunizationRowAdapter.class);
        initMocks(this);
    }

    @Test
    public void assertConstructorsCreateNonNullObjectsOnInstantiation() throws JSONException {

        assertNotNull(new ImmunizationRowAdapter(context, vaccineGroup,true));
    }


    @Test
    public void assertGetCountReturnsTheCorrectNumberOfItems() throws Exception {
        JSONObject vaccineData = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("testvalue1");
        jsonArray.put("testvalue2");
        jsonArray.put("testvalue3");
        vaccineData.put("vaccines", jsonArray);

        List<Vaccine> vaccineList = new ArrayList<>();
        List<Alert> alerts = new ArrayList<>();
        vaccineGroup.setData(vaccineData, commonPersonObjectClient, vaccineList, alerts);
        Mockito.when(vaccineGroup.getVaccineData()).thenReturn(vaccineData);
        immunizationRowAdapter = new ImmunizationRowAdapter(context, vaccineGroup,true);
        assertNotNull(immunizationRowAdapter);
        assertEquals(3, immunizationRowAdapter.getCount());
    }


}
