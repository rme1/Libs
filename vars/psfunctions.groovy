def fnExecuteSql(String pStatementToExecute){
    withEnv(["InFunctStatementToExecute=${pStatementToExecute}"])
    {
        powershell script:
              '''
              $InShellStatementToExecute = ${env:InFunctStatementToExecute}
              Write-Output "----------------------------------------------------------------"              
              Write-Output "----------------------------------------------------------------"
              Write-Output "SqlStatement --> $InShellStatementToExecute"
              Write-Output "----------------------------------------------------------------"              
              Write-Output "----------------------------------------------------------------"              
              $Datenquelle = "localhost,1433"
              $Datenbank = "merzi"
              $Benutzer = "sa"
              $Passwort = ${env:PASSWORD}
              Invoke-Sqlcmd -Query $InShellStatementToExecute -ServerInstance $Datenquelle -database $Datenbank -QueryTimeout 65535 -ErrorAction 'Stop' -username $Benutzer -password $Passwort
              write-host ($GetInfo | Format-Table | Out-String) 
              '''
    }       
}
