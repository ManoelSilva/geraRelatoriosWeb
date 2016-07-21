/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.factory;

import br.com.gerarelatoriosweb.modelo.PersonBean;
import java.util.Vector;

/**
 *
 * @author touti
 */
public class JavaBeansDStestFactory {

    public static java.util.Collection generateCollection() {
        Vector collection = new Vector();

        collection.add(new PersonBean("Ted", 20));
        collection.add(new PersonBean("Manoel", 27));
        collection.add(new PersonBean("Julia", 26));
        collection.add(new PersonBean("Lucas", 32));
        collection.add(new PersonBean("Rafael", 21));
        
        return collection;
    }
}
