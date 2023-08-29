package com.rto.repo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rto.entity.VehicleDetailsEntity;



@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class RtoRepoVdetailsTest {
	
	@Autowired
	private RtoRepoVDetails vehicleDtlsRepo;
	

	@Test
    public void testSaveVehicleDtls() {
		VehicleDetailsEntity vd=new VehicleDetailsEntity();
                            vd.setVcompanyname("activa");
                            vd.setYear(1990);
                            vd.setType("2 wheeler");
 
        assertNull(vd.getVid());// NOPMD by PC on 1/11/19 12:30 PM
 
        vd =  vehicleDtlsRepo.save(vd);
 
        assertNotNull(vd.getVid());
        assertTrue(vd.getVid() > 0);
    }

}
