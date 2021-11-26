def function_PSTA_ISCALA_49() {
    stage('PSTA_ISCALA_49')
    {
        def PSTA_ISCALA_49 = [
             sp_t_GL0349YY_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_GL0349YY_merge]"]]}
            ,sp_t_MP614900_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_MP614900_merge]"]]}
            ,sp_t_SC014900_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_SC014900_merge]"]]}
            ,sp_t_SC034900_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_SC034900_merge]"]]}
            ,sp_t_SC104900_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_SC104900_merge]"]]}
            ,sp_t_ScaCompanySegment_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_ScaCompanySegment_merge]"]]}
            ,sp_t_SCP24900_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_SCP24900_merge]"]]}
            ,sp_t_SCP34900_merge:{build job: 'PSTA_ISCALA_49_with_Parameter',parameters: [[$class: 'StringParameterValue', name: 'p_STORED_PROCEDURE_NAME', value: "[PSTA_ISCALA_49].[sp_t_SCP34900_merge]"]]}
 
        ]
        parallel PSTA_ISCALA_49
    }
}