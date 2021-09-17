*** Settings ***
Documentation     Testes do R4U.
Library           OperatingSystem
Library           DatabaseLibrary
Suite Setup       Connect To Database    dbapiModuleName=psycopg2    dbName=pi    dbUsername=fatec    dbPassword=fatec    dbHost=localhost    dbPort=5432

*** Test Cases ***

testCriacaoDeRecomendacao
    ${query}    Execute SQL String    insert into test.Recommendation(id, nome) values (nextval('seq_recommendation'), 'Test')
    ${query}    Query    SELECT * FROM test.Recommendation WHERE NOME = 'Test'
    Should Be Equal    ${query[0][1]}    Test

testConsultaFilmeNome
    ${query}    Query    SELECT * FROM test.FILME WHERE NOME = 'Joker'
    Should Be Equal    ${query[0][1]}    Joker

testConstultaFilmeGenero
    ${query}    Query    SELECT * FROM test.FILME WHERE Genero = 'Action'
    Should Not Be Equal    ${query[0][1]}    Joker
