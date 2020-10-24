Feature: Create Incident Feature In Service Now

Scenario Outline: To Test the Positve Flow of Create Incident with JsonFiles
And Set the contentType as Json
When Create a new incident with body using <FileName>
Then The Incident is created in ServioceNow

Examples:

|FileName|
|CreateIncident.json|
|CreateIncident2.json|


