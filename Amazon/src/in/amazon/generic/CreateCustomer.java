package in.amazon.generic;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Listner(in.amazon.generic.ListnerImplementation.class)

public class CreateCustomer extends BaseClass {
	@Test
	public void createCustomer() {
		System.out.println("create customer");
		System.out.println("login cust");
	}

}
