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

import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.VehicleRegistrationNoEntity;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class RtoRepoVregistrationTest {

	@Autowired
	private RtoRepoVRegistration vregiRepo;
	
			

			@Test
		    public void testSaveAddressDtls() {
				VehicleRegistrationNoEntity vd=new VehicleRegistrationNoEntity();
		                           vd.setRegCenter("hyd");
		                           vd.setRegNo("ts 23");
		                          
		        assertNull(vd.getVregid());// NOPMD by PC on 1/11/19 12:30 PM
		 
		        vd =  vregiRepo.save(vd);
		 
		        assertNotNull(vd.getVregid());
		        assertTrue(vd.getVregid() > 0);
		    }
}
