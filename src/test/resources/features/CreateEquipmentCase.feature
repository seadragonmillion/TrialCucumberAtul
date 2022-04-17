Feature: Automated create equipment cases functional test

@ChromeTest
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "amlee" and password as "UGFzc3dvcmQyMDIxIQ==" on browser "chrome"
	When she deletes previous cases for "equipment" in "devAsia"
	When she deletes previous cases for "electrical" in "devAsia"
	And create cases for "equipment" in "devAsia"
	And create cases for "electrical" in "devAsia"	
	And check slides for "equipment" in "devAsia" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsia" for pii indicator 1
	And check slides for "electrical" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 1
	And check the keyword search for "electrical" in "devAsia" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsia"
	And look for equipment cases with type advanced learning in equipment databank in "devAsia" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "devAsia" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "devAsia"
	And add keyword to equipment case and search for case in "devAsia"
	And verify youtube link work in case in "devAsia"
	And view case with links and then a case without links in "devAsia"
	And verify cases with and without links with same keyword in equipment databank only in "devAsia"
	And add an existing keyword to case with links and search for case in "dev"
	And turn slide security on and click on links in related links slide in "devAsia" with username as "jenkinsvm"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE

@FirefoxTest
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she deletes previous cases for "equipment" in "devAsia"
	When she deletes previous cases for "electrical" in "devAsia"
	And create cases for "equipment" in "devAsia"
	And create cases for "electrical" in "devAsia"	
	And check slides for "equipment" in "devAsia" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsia" for pii indicator 1
	And check slides for "electrical" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 1
	And check the keyword search for "electrical" in "devAsia" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsia"
	And look for equipment cases with type advanced learning in equipment databank in "devAsia" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "devAsia" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "devAsia"
	And add keyword to equipment case and search for case in "devAsia"
	And verify youtube link work in case in "devAsia"
	And view case with links and then a case without links in "devAsia"
	And verify cases with and without links with same keyword in equipment databank only in "devAsia"
	And add an existing keyword to case with links and search for case in "dev"
	And turn slide security on and click on links in related links slide in "devAsia" with username as "jenkinsvm"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE

@IE10Test
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she deletes previous cases for "equipment" in "devAsia"
	When she deletes previous cases for "electrical" in "devAsia"
	And create cases for "equipment" in "devAsia"
	And create cases for "electrical" in "devAsia"	
	And check slides for "equipment" in "devAsia" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsia" for pii indicator 1
	And check slides for "electrical" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 1
	And check the keyword search for "electrical" in "devAsia" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsia"
	And look for equipment cases with type advanced learning in equipment databank in "devAsia" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "devAsia" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "devAsia"
	And add keyword to equipment case and search for case in "devAsia"
	And verify youtube link work in case in "devAsia"
	And view case with links and then a case without links in "devAsia"
	And verify cases with and without links with same keyword in equipment databank only in "devAsia"
	And add an existing keyword to case with links and search for case in "dev"
	And turn slide security on and click on links in related links slide in "devAsia" with username as "jenkinsvm"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE

@IE11Test
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she deletes previous cases for "equipment" in "devAsiaIE11"
	When she deletes previous cases for "electrical" in "devAsiaIE11"
	And create cases for "equipment" in "devAsiaIE11"
	And create cases for "electrical" in "devAsiaIE11"	
	And check slides for "equipment" in "devAsiaIE11" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsiaIE11" for pii indicator 1
	And check slides for "electrical" in "devAsiaIE11" for pii indicator 0
	And check the keyword search for "equipment" in "devAsiaIE11" for pii indicator 0
	And check the keyword search for "equipment" in "devAsiaIE11" for pii indicator 1
	And check the keyword search for "electrical" in "devAsiaIE11" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsiaIE11"
	And look for equipment cases with type advanced learning in equipment databank in "devAsiaIE11" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "devAsiaIE11" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "devAsiaIE11"
	And add keyword to equipment case and search for case in "devAsiaIE11"
	And verify youtube link work in case in "devAsiaIE11"
	And view case with links and then a case without links in "devAsiaIE11"
	And verify cases with and without links with same keyword in equipment databank only in "devAsiaIE11"
	And add an existing keyword to case with links and search for case in "dev"
	And turn slide security on and click on links in related links slide in "devAsiaIE11" with username as "jenkinsvm_ie11"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE
			
@AsiaChromeTest
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
    When she deletes previous cases for "equipment" in "devAsia"
	When she deletes previous cases for "electrical" in "devAsia"
	And create cases for "equipment" in "devAsia"
	And create cases for "electrical" in "devAsia"	
	And check slides for "equipment" in "devAsia" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsia" for pii indicator 1
	And check slides for "electrical" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 1
	And check the keyword search for "electrical" in "devAsia" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsia"
	And look for equipment cases with type advanced learning in equipment databank in "devAsia" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And look for equipment cases with all filters in "devAsia" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And change keyword and search for it in "devAsia"
	And add keyword to equipment case and search for case in "devAsia"
	And verify youtube link work in case in "devAsia"
	And view case with links and then a case without links in "devAsia"
	And verify cases with and without links with same keyword in equipment databank only in "devAsia"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "devAsia" with username as "ritica"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
    When she deletes previous cases for "equipment" in "devAsia"
	When she deletes previous cases for "electrical" in "devAsia"
	And create cases for "equipment" in "devAsia"
	And create cases for "electrical" in "devAsia"	
	And check slides for "equipment" in "devAsia" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsia" for pii indicator 1
	And check slides for "electrical" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 1
	And check the keyword search for "electrical" in "devAsia" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsia"
	And look for equipment cases with type advanced learning in equipment databank in "devAsia" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And look for equipment cases with all filters in "devAsia" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And change keyword and search for it in "devAsia"
	And add keyword to equipment case and search for case in "devAsia"
	And verify youtube link work in case in "devAsia"
	And view case with links and then a case without links in "devAsia"
	And verify cases with and without links with same keyword in equipment databank only in "devAsia"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "devAsia" with username as "ritica"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE
	
@AsiaIE10Test
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
    When she deletes previous cases for "equipment" in "devAsia"
	When she deletes previous cases for "electrical" in "devAsia"
	And create cases for "equipment" in "devAsia"
	And create cases for "electrical" in "devAsia"	
	And check slides for "equipment" in "devAsia" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsia" for pii indicator 1
	And check slides for "electrical" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 0
	And check the keyword search for "equipment" in "devAsia" for pii indicator 1
	And check the keyword search for "electrical" in "devAsia" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsia"
	And look for equipment cases with type advanced learning in equipment databank in "devAsia" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And look for equipment cases with all filters in "devAsia" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And change keyword and search for it in "devAsia"
	And add keyword to equipment case and search for case in "devAsia"
	And verify youtube link work in case in "devAsia"
	And view case with links and then a case without links in "devAsia"
	And verify cases with and without links with same keyword in equipment databank only in "devAsia"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "devAsia" with username as "ritica"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE
	
@AsiaIE11Test
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
    When she deletes previous cases for "equipment" in "devAsiaIE11"
	When she deletes previous cases for "electrical" in "devAsiaIE11"
	And create cases for "equipment" in "devAsiaIE11"
	And create cases for "electrical" in "devAsiaIE11"	
	And check slides for "equipment" in "devAsiaIE11" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "devAsiaIE11" for pii indicator 1
	And check slides for "electrical" in "devAsiaIE11" for pii indicator 0
	And check the keyword search for "equipment" in "devAsiaIE11" for pii indicator 0
	And check the keyword search for "equipment" in "devAsiaIE11" for pii indicator 1
	And check the keyword search for "electrical" in "devAsiaIE11" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "devAsiaIE11"
	And look for equipment cases with type advanced learning in equipment databank in "devAsiaIE11" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA=="
	And look for equipment cases with all filters in "devAsiaIE11" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA=="
	And change keyword and search for it in "devAsiaIE11"
	And add keyword to equipment case and search for case in "devAsiaIE11"
	And verify youtube link work in case in "devAsiaIE11"
	And view case with links and then a case without links in "devAsiaIE11"
	And verify cases with and without links with same keyword in equipment databank only in "devAsiaIE11"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "devAsiaIE11" with username as "ritica_ie11"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE
	
@USAChromeTest
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she deletes previous cases for "equipment" in "US"
	When she deletes previous cases for "electrical" in "US"
	And create cases for "equipment" in "US"
	And create cases for "electrical" in "US"	
	And check slides for "equipment" in "US" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "US" for pii indicator 1
	And check slides for "electrical" in "US" for pii indicator 0
	And check the keyword search for "equipment" in "US" for pii indicator 0
	And check the keyword search for "equipment" in "US" for pii indicator 1
	And check the keyword search for "electrical" in "US" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "US"
	And look for equipment cases with type advanced learning in equipment databank in "US" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "US" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "US"
	And add keyword to equipment case and search for case in "US"
	And verify youtube link work in case in "US"
	And view case with links and then a case without links in "US"
	And verify cases with and without links with same keyword in equipment databank only in "US"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "US" with username as "jenkinsvm"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE

@USAFirefoxTest
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she deletes previous cases for "equipment" in "US"
	When she deletes previous cases for "electrical" in "US"
	And create cases for "equipment" in "US"
	And create cases for "electrical" in "US"	
	And check slides for "equipment" in "US" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "US" for pii indicator 1
	And check slides for "electrical" in "US" for pii indicator 0
	And check the keyword search for "equipment" in "US" for pii indicator 0
	And check the keyword search for "equipment" in "US" for pii indicator 1
	And check the keyword search for "electrical" in "US" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "US"
	And look for equipment cases with type advanced learning in equipment databank in "US" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "US" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "US"
	And add keyword to equipment case and search for case in "US"
	And verify youtube link work in case in "US"
	And view case with links and then a case without links in "US"
	And verify cases with and without links with same keyword in equipment databank only in "US"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "US" with username as "jenkinsvm"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE

@USAIE10Test
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she deletes previous cases for "equipment" in "US"
	When she deletes previous cases for "electrical" in "US"
	And create cases for "equipment" in "US"
	And create cases for "electrical" in "US"	
	And check slides for "equipment" in "US" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "US" for pii indicator 1
	And check slides for "electrical" in "US" for pii indicator 0
	And check the keyword search for "equipment" in "US" for pii indicator 0
	And check the keyword search for "equipment" in "US" for pii indicator 1
	And check the keyword search for "electrical" in "US" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "US"
	And look for equipment cases with type advanced learning in equipment databank in "US" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "US" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "US"
	And add keyword to equipment case and search for case in "US"
	And verify youtube link work in case in "US"
	And view case with links and then a case without links in "US"
	And verify cases with and without links with same keyword in equipment databank only in "US"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "US" with username as "jenkinsvm"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE

@USAIE11Test
Scenario: Create equipment cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she deletes previoUSIE11 cases for "equipment" in "USIE11"
	When she deletes previoUSIE11 cases for "electrical" in "USIE11"
	And create cases for "equipment" in "USIE11"
	And create cases for "electrical" in "USIE11"	
	And check slides for "equipment" in "USIE11" for pii indicator 0
	And search with keyword with all special characters
	And search with keyword with special character in middle
	And check slides for "equipment" in "USIE11" for pii indicator 1
	And check slides for "electrical" in "USIE11" for pii indicator 0
	And check the keyword search for "equipment" in "USIE11" for pii indicator 0
	And check the keyword search for "equipment" in "USIE11" for pii indicator 1
	And check the keyword search for "electrical" in "USIE11" for pii indicator 0
	And check for presence of equipment and failure mode cases in other case modules in "USIE11"
	And look for equipment cases with type advanced learning in equipment databank in "USIE11" with USIE11ername as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz"
	And look for equipment cases with all filters in "USIE11" with USIE11ername as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz"
	And change keyword and search for it in "USIE11"
	And add keyword to equipment case and search for case in "USIE11"
	And verify youtube link work in case in "USIE11"
	And view case with links and then a case without links in "USIE11"
	And verify cases with and without links with same keyword in equipment databank only in "USIE11"
	And add an existing keyword to case with links and search for case in "prod"
	And turn slide security on and click on links in related links slide in "USIE11" with USIE11ername as "jenkinsvm_ie11"
	And edit links
	And delete links
	And delete cases for "equipment"
	And delete cases for "electrical"
	And logout from KALE
