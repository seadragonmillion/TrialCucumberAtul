Feature: Automated OPiRCA Bugs Test
	
@ChromeTest
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://kaleqa.error-free.com" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE

@FirefoxTest
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE

@IE10Test
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE

@IE11Test
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE
			
@AsiaChromeTest
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE
	
@AsiaIE10Test
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE
	
@AsiaIE11Test
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE
	
@USAChromeTest
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE

@USAFirefoxTest
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE

@USAIE10Test
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE

@USAIE11Test
Scenario: Test OPiRCA bugs
	Given user is on KALE Home Page "https://www.google.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an OPiRCA report to verify old bugs
	And logout from KALE