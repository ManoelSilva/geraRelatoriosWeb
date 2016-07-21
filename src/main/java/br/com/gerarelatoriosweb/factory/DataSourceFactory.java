/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.factory;

import br.com.gerarelatoriosweb.modelo.Conta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author touti
 */
public class DataSourceFactory {

    public static Conta conta1 = new Conta();
    public static Conta conta2 = new Conta();
    
    public static List createBeanCollection() {
        conta1.setTitular("Manoel");
        conta1.setBanco("Banco do Brasil");
        conta1.setNumero("12345");

        conta2.setTitular("Julia Mamade");
        conta2.setBanco("Bradesco");
        conta2.setNumero("123456");

        List beanCollection = new ArrayList();

        beanCollection.add(conta1);
        beanCollection.add(conta2);

        return beanCollection;
    }
}
