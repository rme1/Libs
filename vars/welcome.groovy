def fnWelcome(pName){
    echo "Ralf Merznicht ist ${pName}"
}

def fnRunPowerShell(pName){
    echo "Ralf Merznicht ist ${pName}"
    //withEnv(["ParamInPowershell=${env:TIMEZONE}"])
    //{    
        powershell script{'''
            Write-Output ${env:TIMEZONE}
        '''
        }
    //}
}