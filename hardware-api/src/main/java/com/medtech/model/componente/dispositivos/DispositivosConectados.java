package com.medtech.model.componente.dispositivos;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

public class DispositivosConectados {
    private String comando = "Get-PnpDevice -PresentOnly | Where-Object { $_.InstanceId -match '^USB' }";

    public String getDispositivos() {
        PowerShellResponse response = PowerShell.executeSingleCommand(comando);

        // Verificar se houve erro na execução
        if (response.isError()) {
            System.out.println("Erro ao executar o comando PowerShell:");
            System.out.println(response.getCommandOutput());
            return null;
        }

        // Saída do comando PowerShell
        String output = response.getCommandOutput();

        // Retornar os dispositivos USB
        return output;
    }
}
