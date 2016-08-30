/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author touti
 */
public class RelatorioUtil {

    public InputStream getInputStreamParametroLogo(String caminhoDoLogo) {
        InputStream inputStreamDoLogo = null;
        try {
            File file = new File(caminhoDoLogo);
            if (file.exists()) {
                inputStreamDoLogo = new FileInputStream(file);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStreamDoLogo;
    }
}
