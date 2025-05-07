# commonFuntionACE
mqsivault --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --vault-key vaultTest

mqsistart --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --vault-key vaultTest ???

mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-type salesforce --credential-name nCinoSalesforce --vault-key vaultTest --auth-type basicClientId --username 'userTest' --password 'passw0rdTest' --client-id '1234567890-abc123def456.apps.googleusercontent.com' --client-secret 'GBAyfVL7YWtP6gudLIjbRZV\_N0dW4f3xETiIxqtokEAZ6FAsBtgyIq0MpU1uQ7J08xOTO2zwP0OuO3pMVAUTid'

mqsisetdbparms -w D:\Cursos\ACE12\WRK\A\TEST_SERVER -n odbc::USERDB2 -u myuserid2 -p mypassword2

mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-name testdb --credential-type odbc --username test --password test

mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-name testdbnode --credential-type odbc --vault-key vaultTest --username user1 --password user1