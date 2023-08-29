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


@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class RtoRepoOAddressTest {
	
	@Autowired
	private RtoRepoOAddress ownerAddRepo;
	

	@Test
    public void testSaveAddressDtls() {
		OwnerAddressEntity vd=new OwnerAddressEntity();
                            vd.setHno(1);
                            vd.setStreetno("abc");
                            vd.setCity("hyd");
                            vd.setZip(500039);
                            
        assertNull(vd.getOaid());// NOPMD by PC on 1/11/19 12:30 PM
 
        vd =  ownerAddRepo.save(vd);
 
        assertNotNull(vd.getOaid());
        assertTrue(vd.getOaid() > 0);
    }


}
