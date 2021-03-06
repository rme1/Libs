def fnWaitForNextTimeZone() {
    powershell script: '''

        Write-Output "----------------------------------------------------------------"
        Write-Output "----------------------------------------------------------------"
        $TimeZone = ${env:TIMEZONE}
        Write-Output "----> TimeZone: $TimeZone"
        Write-Output "----------------------------------------------------------------"
        $LoopSleep = ${env:SLEEPSECONDS}
        Write-Output "----> LoopSleep: $LoopSleep"
        Write-Output "----------------------------------------------------------------"
        $DryRun = ${env:DRY_RUN}
        Write-Output "----> DryRun: $DryRun"
        Write-Output "----------------------------------------------------------------"
        $WaitMinutes = ${env:WAITMINUTES}
        Write-Output "----> WaitMinutes: $WaitMinutes"
        Write-Output "----------------------------------------------------------------"
        Write-Output "----------------------------------------------------------------"

        $Now = Get-Date
        $JobStartDateText = '{0:d4}' -f $Now.Year + "|" +'{0:d2}' -f $Now.Month + "|" + '{0:d2}' -f $Now.Day + "|" + '{0:d2}' -f $Now.Hour + "|" + '{0:d2}' -f $Now.Minute
        $JobStartDateText

        if($DryRun){
            $AsiaStartTimeText = '{0:d4}' -f $Now.Year + "|" +'{0:d2}' -f $Now.Month + "|" + '{0:d2}' -f $Now.Day + "|" + '{0:d2}' -f $Now.Hour + "|" + '{0:d2}' -f ($Now.Minute + 2)
        }
        else{
            $AsiaStartTimeText = '{0:d4}' -f $Now.Year + "|" +'{0:d2}' -f $Now.Month + "|" + '{0:d2}' -f $Now.Day + "|" + '21|59'
        }
        $AsiaStartDate = $null
        $AsiaStartDate = [datetime]::ParseExact($AsiaStartTimeText , "yyyy|MM|dd|HH|mm" , $null)
        Write-Output "  --> AsiaStartDate:         $AsiaStartDate"

        if($DryRun){
            $EuropeStartDate = $AsiaStartDate.AddMinutes($WaitMinutes)
        }
        else{
            $EuropeStartDate = $AsiaStartDate.AddHours(2)
        }
        Write-Output "  --> EuropeStartDate:       $EuropeStartDate"

        if($DryRun){
            $SouthAmericaStartDate = $AsiaStartDate.AddMinutes($WaitMinutes)
        }
        else{
            $SouthAmericaStartDate = $AsiaStartDate.AddHours(5)
        }
        Write-Output "  --> SouthAmericaStartDate: $SouthAmericaStartDate"

        if($DryRun){
            $NorthAmericaStartDate = $AsiaStartDate.AddMinutes($WaitMinutes)
        }
        else{
            $NorthAmericaStartDate = $AsiaStartDate.AddHours(6)
        }
        Write-Output "  --> NorthAmericaStartDate: $NorthAmericaStartDate"

        # $TimeZone = 'Asia'
        # $LoopSleep = 10

        $LoopTimeToStart = $null
        $CommComplete = ('$LoopTimeToStart = $' + $TimeZone + 'StartDate' )
        Invoke-Expression $CommComplete

        $LoopTimeToStart

        $LoopTimeToStart = $null
        $CommComplete = ('$LoopTimeToStart = $' + $TimeZone + 'StartDate' )
        Invoke-Expression $CommComplete
        $LoopTimeToStart
        Write-Output "Start: $Now"
        $LoopTimeToStart = ($LoopTimeToStart - $Now)
        $LoopSeconds = $LoopTimeToStart.TotalSeconds

        while ($LoopSeconds -ge 0)
            {
            $Now = Get-Date
            Write-Output "$TimeZone starts in $LoopSeconds seconds from now:  $Now"
            sleep $LoopSleep
            $LoopSeconds = $LoopSeconds - $LoopSleep
        }
   
        $Now = Get-Date
        Write-Output "Ende: $Now"
        '''
}

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
