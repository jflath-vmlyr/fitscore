package jim.util;

import java.util.Properties;

public class StaticProperties {

	protected Properties getStaticProperties() {

		Properties props = new Properties();
		props.put("DEV.exactTarget.clientId", "nyf95z4akpcf3g985wvmawtr");
		props.put("PROD.exactTarget.clientId", "");
		props.put("DEV.exactTarget.clientSecret", "qbVAbgHGT3mf6awuAQ5EAYZY");
		props.put("PROD.exactTarget.clientSecret", "");

		props.put("exactTarget.auth.url",
				"https://auth.exacttargetapis.com/v1/requestToken");
		props.put(
				"exactTarget.email.url",
				"http://www.exacttargetapis.com/messaging/v1/messageDefinitionSends/key:FP_Welcome/send");

		props.put("DEV.optIn.url",
				"https://wwwqa.ford.com/services/lead/OptIn.json");
		props.put("PROD.optIn.url",
				"https://www.ford.com/services/lead/OptIn.json");
		props.put("optIn.listid", "500295");
		props.put("optIn.qacodes", "0799A|0848500295");

		props.put("campaign.name", "IntegrationTesting");

		props.put("piiDataMask.matches1", ".*customer\\.firstname\\=.*\\&.*");
		props.put("piiDataMask.replace1", "customer.firstname=");
		props.put("piiDataMask.matches2", ".*customer\\.lastname\\=.*\\&.*");
		props.put("piiDataMask.replace2", "customer.lastname=");
		props.put("piiDataMask.matches3",
				".*customer\\.address\\.zipcode\\=.*\\&.*");
		props.put("piiDataMask.replace3", "customer.address.zipcode=");
		
		props.put("captcha.secretKey", "6LcyehQTAAAAAOyBr8qM2HCEC31YCuYN73YsqYBP");


		return props;
	}
}
