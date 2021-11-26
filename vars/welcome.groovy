def fnWelcome(pName){
    echo "Ralf Merznicht ist ${pName}"
}

def fnRunPowerShell(pName){
    echo "Ralf Merznicht ist ${pName}"
    powershell script{'''
        Write-Output ${pName}
    '''
    }
}

def WaitForNextTimeZone() {
    withEnv(["ParamInPowershell=${TIMEZONE}","ParamLoopSleep=${SLEEPSECONDS}","ParamDryRun=${DRY_RUN}","ParamWaitMinutes=${WAITMINUTES}"])
    {
        powershell script: '''
            
            $TimeZone = $env:ParamInPowershell
            Write-Output "----------------------------------------------------------------"
            Write-Output "----------------------------------------------------------------"
            Write-Output "----> ParamInPowershell: $TimeZone"
            Write-Output "----------------------------------------------------------------"
            $LoopSleep = $env:ParamLoopSleep
            Write-Output "----> ParamLoopSleep: $LoopSleep"
            Write-Output "----------------------------------------------------------------"
            $DryRun = $env:ParamDryRun
            Write-Output "----> ParamDryRun: $DryRun"
            Write-Output "----------------------------------------------------------------"
            $WaitMinutes = $env:ParamWaitMinutes
            Write-Output "----> ParamWaitMinutes: $WaitMinutes"
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
}
