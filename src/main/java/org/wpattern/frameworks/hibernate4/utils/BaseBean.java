package org.wpattern.frameworks.hibernate4.utils;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

// classe generica para centralizar responsabilidades repetitivas das Entidades mapeadas e será herdada por outras
public class BaseBean implements Serializable {


    // identificador da versão para verificar compatibilidade do objeto com a classe
    // transformar objeto ou estrutura de dados (que está guardado na memória) em formato lenear( como sequencia de bytes ou texto padrão) p armazenar no banco
    private static final long serialVersionUID = -8598920313448190380L;

    // imprimir informações de um objeto específico
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
