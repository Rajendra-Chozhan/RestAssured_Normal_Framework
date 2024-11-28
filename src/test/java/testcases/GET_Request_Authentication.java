package testcases;




import java.io.IOException;

import org.testng.annotations.Test;


import pages.Authorization;

@Test
public class GET_Request_Authentication extends Authorization{
	
	public void test_01() throws IOException {

		Validate_Authorisation() ;

	}

}
