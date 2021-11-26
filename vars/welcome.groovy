def fnWelcome(pName){
    echo "Ralf Merznicht ist ${pName}"
}

def fnRunPowerShell(pName){
    echo "Ralf Merznicht ist ${pName}"
    withEnv(["ParamInPowershell=${TIMEZONE}"])
    {    
        powershell script{'''
            Write-Output ${ParamInPowershell}
        '''
        }
    }
}