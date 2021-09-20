*** Settings ***
Documentation     Testes do R4U.
Library           OperatingSystem
Library           DatabaseLibrary
Library           Selenium2Library
Suite Setup       Connect To Database    dbapiModuleName=psycopg2    dbName=pi    dbUsername=fatec    dbPassword=fatec    dbHost=localhost    dbPort=5432
Suite Teardown    Close Browser

*** Test Cases ***
testFrontend
    Sleep    40s
    ${frontIP}    Run    hostname -I | awk '{print $1}'
    ${firefox options} =     Evaluate    sys.modules['selenium.webdriver'].firefox.webdriver.Options()    sys, selenium.webdriver
    Call Method    ${firefox options}   add_argument    -headless
    Create Webdriver    Firefox    firefox_options=${firefox options}
    Go To    http://${frontIP}:8081
    ${service args}    Create List    proxy=${frontIP}:8081
    Wait Until Element Is Visible    xpath=.//html/body/div/div[2]/div/button
    Click Element    xpath=.//html/body/div/div[2]/div/button
    Wait Until Element Is Visible    xpath=.//html/body/div/div[2]/div/p[2]
    Sleep    2s
    ${resultFront}    Get Text    xpath=.//html/body/div/div[2]/div/p[2]
    ${query}    Query    SELECT NOME FROM Recommendation WHERE NOME = '${resultFront}'
    Should Be Equal    ${query[0][0]}    ${resultFront}
