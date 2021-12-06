def LoadTables(){
    stage('STA_TO_PSTA_ISCALA_36'){
        steps{
            script{
                try {
                    if{
                        echo('fnExecuteSql(${env:SQLSTATEMENT})')
                    } else {
                        psfunctions.fnExecuteSql("${env:SQLSTATEMENT}")
                    }
                } catch (e){
                    echo('detected failure: function_PSTA_ISCALA_36()')
                }
            }
        }
    }
}
/*
def function_PSTA_ISCALA_36() {
    stage('PSTA_ISCALA_36')
    {
        def PSTA_ISCALA_36 = [
             sp_t_GL0336YY_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_GL0336YY_merge]"]]}
            ,sp_t_MP613600_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_MP613600_merge]"]]}
            ,sp_t_SC013600_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_SC013600_merge]"]]}
            ,sp_t_SC033600_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_SC033600_merge]"]]}
            ,sp_t_SC103600_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_SC103600_merge]"]]}
            ,sp_t_ScaCompanySegment_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_ScaCompanySegment_merge]"]]}
            ,sp_t_SCP23600_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_SCP23600_merge]"]]}
            ,sp_t_SCP33600_merge:{build job: 'PSTA_ISCALA_36_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_36].[sp_t_SCP33600_merge]"]]}
 
        ]
        parallel PSTA_ISCALA_36
    }
}
*/