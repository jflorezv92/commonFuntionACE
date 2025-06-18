# commonFuntionACE
This code contains a different examples of code:
	Developed in ACE 12.0.10.0

	- Default Policy
		UserDefined.policyxml
			Example of a User Defined Policy
	- CommonUtilLib
		Library contains diferent functions:
			- encrypt
				encrypt a string
			- decrypt
				decrypt a string
			- getPolicyProperty
				get the value of a User Defined property
			- getCredentialSalesforce
				get credencial salesforce (mqsicredentials)
			- getCredential
				get any credential depends on the input (mqsicredentials)
			- setCacheValue
				set calue in global cache 
					chrKey:	Key map
					chrVal:	Value map
					mapCache:	map name
			- getCacheValue
				get calue in global cache
					chrKey:	Key map
					chrVal:	Value map
					mapCache:	map name
	CommonUtilJava
		CryptoUtil
			- Code in java to encrypt/decrypt
		PolicyAccess
			- Code in java to access a User Defined property
		CredentialsUtil
			- Code in java to get the (mqsicredentials)
		CacheUtil
			- Code In java to manage the cache map
	TestApp
		- TestApp (folder)
			Contains a conllection of following operaritions:
		- encryptText (flow)
			Api Rest HTTP Request Node to call encrypt
		- decryptText (flow)
			Api Rest HTTP Request Node to call decrypt
		- getUDProperty (flow)
			Api Rest HTTP Request Node to call getPolicyProperty
		- getCredentials (flow)
			Api Rest HTTP Request Node to call getCredential
		- getCredentialSalesforce (flow)
			Api Rest HTTP Request Node to call getCredential only salesforce
		- getCache (flow)
			Api Rest HTTP Request Node to call getCacheValue
		- setCache (flow)
			Api Rest HTTP Request Node to call getCacheValue
		- getProfile (flow)
			Api Rest HTTP Request Node to call get profile info of https://dummyjson.com/docs/auth, through jwt
		- getPagination (flow)
			Api Rest HTTP Request Node to call get pagination info with contenSize and chuckSize.
	server.conf.yaml
		Yaml file with the configurarions of ACE
	
	Commands to configure ACE 
		- Create a Vault
			mqsivault --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --vault-key vaultTest
		- Start a ntegration Nodes With a vault
			mqsistart TEST_SERVER --vault-key vaultTest -> For a Integration Nodes
		- Create a mqsicredentials for salesforce
			mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-type salesforce --credential-name nCinoSalesforce --vault-key vaultTest --auth-type basicClientId --username 'userTest' --password 'passw0rdTest' --client-id '1234567890-abc123def456.apps.googleusercontent.com' --client-secret 'GBAyfVL7YWtP6gudLIjbRZV\_N0dW4f3xETiIxqtokEAZ6FAsBtgyIq0MpU1uQ7J08xOTO2zwP0OuO3pMVAUTid'
		- Set a ODBJ Credential
			mqsisetdbparms -w D:\Cursos\ACE12\WRK\A\TEST_SERVER -n odbc::USERDB2 -u myuserid2 -p mypassword2
		- Create a mqsicredentials for salesforce odbc
			mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-name testdb --credential-type odbc --username test --password test