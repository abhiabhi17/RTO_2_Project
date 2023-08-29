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

import com.rto.entity.VehicleOwnerRegistrationEntity;


@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest

public class RtoOwnerDtlsRepositoryTest {
	
	@Autowired
	private RtoOwnerDtlsRepository OwnerDtlsRepo;
	
	
	@Test
    public void testSaveVehicleOwnerDtls() {
		VehicleOwnerRegistrationEntity vd=new VehicleOwnerRegistrationEntity();
                            vd.setFname("abhi");
                            vd.setEmail("abhi@gmail.com");
                            vd.setLname("abhishek");
                            vd.setSsn("333 333 3333");
 
        assertNull(vd.getOid()); // NOPMD by pc on 1/11/19 12:30 PM
 
        vd =  OwnerDtlsRepo.save(vd);
 
        assertNotNull(vd.getOid());
        assertTrue(vd.getOid() > 0);
    }

}
