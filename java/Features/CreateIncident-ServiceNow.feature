Feature: Create Incident Feature In Service Now

#Background:
#
#Given Set the End Point
#And Set the Authendication
#And Set the contentType as Json

Scenario: To Test the Positve Flow of Create Incident without Body
And Set the contentType as Json
When Create a new incident without body using Post method
Then The Incident is created in ServioceNow


Scenario Outline: To Test the Positve Flow of Create Incident with JsonFiles
And Set the contentType as Json
When Create a new incident with body using <FileName>
Then The Incident is created in ServioceNow

Examples:

|FileName|
|CreateIncident.json|
|CreateIncident2.json|


