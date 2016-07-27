/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 *
 * @author byron
 */
@RequestScoped
public class GenericDao {

    private Session session;

    protected GenericDao() {
    }

    @Inject
    public GenericDao(Session session) {
        this.session = session;

    }

    public void salvar(Object object) {

        session.saveOrUpdate(object);

    }

    public void salvarUpdate(Object object) {

        session.update(object);

    }

    public void salvarMerge(Object object) {

        session.merge(object);

    }

    public void salvarInsert(Object object) {

        session.save(object);

    }

    public List buscar(Object object) {

        List lista = session.createCriteria(object.getClass()).list();

        return lista;
    }

    public List<Object> buscarUnicoString(String campo, String valor, Object object, int limite) {

        List<Object> lista;
        if (valor != null) {
            Criterion criterion = Restrictions.like(campo, "%" + valor + "%");
            lista = session.createCriteria(object.getClass()).setMaxResults(limite).add(criterion).list();
        } else {

            lista = session.createCriteria(object.getClass()).setMaxResults(limite).list();
        }

        return lista;
    }

    public Object buscarUnico(String campo, int id, Object object) {

        Criterion criterion = Restrictions.eq(campo, id);
        Criterion habilitado = Restrictions.eq("habilitado", true);
        LogicalExpression expression = Restrictions.and(habilitado, criterion);
        Object retorno = session.createCriteria(object.getClass()).add(expression).uniqueResult();

        return retorno;
    }

    public List buscarUnicoData(String campo, Object object, int limite) {
        Calendar calDois = Calendar.getInstance();
        calDois.add(Calendar.DATE, 1);
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.HOUR, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calDois.set(Calendar.HOUR, 0);
        calDois.set(Calendar.MINUTE, 0);
        calDois.set(Calendar.SECOND, 0);
        calDois.set(Calendar.HOUR_OF_DAY, 0);
        Criterion criterion = Restrictions.between(campo, calendario, calDois);
        Criterion habilitado = Restrictions.eq("habilitado", true);
        LogicalExpression expression = Restrictions.and(habilitado, criterion);
        List<Object> retorno;
        Criteria c = session.createCriteria(object.getClass()).add(expression);
        if (limite > 0) {
            retorno = c.setMaxResults(limite).list();
        } else {
            retorno = c.list();
        }
        return retorno;
    }

    public void remove(Object object) {
        session.delete(object);

    }

    public void update(Object object) {

        session.update(object);

    }

    public Session getSessao() {
        return session;
    }

    @SuppressWarnings("unchecked")
    public List<Object> findTheRange(int start, int length, Object object) {

        List<Object> lista = session.createCriteria(object.getClass()).setFirstResult(start).setMaxResults(length).list();

        return lista;
    }

    //DataTable
    @SuppressWarnings("unchecked")
    public List<Object> findIntervalByAttribute(String[] colunasNumericas, String[] colunas, String valor, int start, int length, ArrayList<String> OrderBy, Object obj, ArrayList<String> variavel, ArrayList<String> valorVar, String[] leftJoin, ArrayList<String> operacao) {

        Disjunction disjunction = Restrictions.disjunction();
        Criterion criterion;
        Criterion habilitado = Restrictions.eq("habilitado", true);
        ProjectionList proList = Projections.projectionList();
        Criteria c = session.createCriteria(obj.getClass()).setFirstResult(start).setMaxResults(length);

        //Procurando aliases.
        List<String> aliases = auxAliases(colunasNumericas);
        List<String> aliasesDois = auxAliases(colunas);
        List<String> aliasesTres = auxAliases(variavel);
        aliases.addAll(aliasesDois);
        aliases.addAll(aliasesTres);
        List<String> ultima = new ArrayList<String>();
        for (String temp : aliases) {
            if (!ultima.contains(temp)) {
                ultima.add(temp);
            }

        }

        //Criando aliases com left se necessario
        if (ultima != null & ultima.size() > 0) {
            for (String t : ultima) {
                int teste = 0;
                if (leftJoin != null) {
                    for (String a : leftJoin) {
                        if (t.indexOf(a) > -1) {
                            c.createAlias(t, t.replaceAll("\\.", "_"), JoinType.LEFT_OUTER_JOIN);
                            teste = 1;
                        }

                    }
                }
                if (teste == 0) {
                    c.createAlias(t, t.replaceAll("\\.", "_"));
                }

            }
        }
//Where
        if (valor != null && !valor.trim().isEmpty()) {
            for (String temp : colunas) {
                if (temp.indexOf("data") > -1) {
                    try {
                        // O valor é data .. Fazendo o tratamento necessário
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(sdf.parse(valor));
                        criterion = Restrictions.eq(temp, cal);
                        disjunction.add(criterion); //add your restirction here
                        c.add(disjunction);
                    } catch (ParseException e) {
                        //Nada
                    }
                } else {
                    criterion = Restrictions.ilike(temp, valor, MatchMode.ANYWHERE);
                    disjunction.add(criterion); //add your restirction here
                    c.add(disjunction);
                }

            }

        }
//Where numerico
        if (valor != null && !valor.trim().isEmpty()) {
            for (String temp : colunasNumericas) {
                try {
                    int total = Integer.parseInt(valor);
                    criterion = Restrictions.eq(temp, total);
                    disjunction.add(criterion); //add your restirction herere
                    c.add(disjunction);
                } catch (Exception ex) {

                }

            }
        }
//Colocando em ordem
        int i = 0;
        if (OrderBy.size() > 0) {
            for (String ordem : colunas) {
                if (!OrderBy.get(i).toLowerCase().trim().isEmpty()) {
                    c.addOrder(OrderBy.get(i).toLowerCase().equals("asc")
                            ? Order.asc(ordem)
                            : Order.desc(ordem));
                }
                i++;
            }
        }

        //Where dinamico
        if (variavel != null && operacao != null && valorVar != null) {
            int contador = 0;
            List<Criterion> or = new ArrayList<Criterion>();
            for (String t : variavel) {
                if (t.indexOf("data") > -1) {
                    Criterion var;
                    try {

                        // O valor é data .. Fazendo o tratamento necessário
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar cal = Calendar.getInstance();
                        Calendar calDois = Calendar.getInstance();
                        calDois.add(Calendar.DATE, 1);
                        cal.setTime(sdf.parse(valorVar.get(contador)));
                        var = Restrictions.between(t, cal, calDois);
                        if (operacao.get(contador).equals("add")) {
                            c.add(var);

                        } else if (operacao.get(contador).equals("or")) {
                            or.add(var);
                        }
                    } catch (Exception e) {
                        //Nada
                        System.out.println(e);
                        //Is Null
                        if (valorVar.get(contador).equals("is_null")) {
                            if (operacao.get(contador).equals("add")) {
                                var = Restrictions.isNull(t);
                                c.add(var);
                            } else if (operacao.get(contador).equals("or")) {
                                var = Restrictions.isNull(t);
                                or.add(var);
                            }
                        }
                    }
                } else {
                    if (valorVar.get(contador) != null) {
                        if (!valorVar.get(contador).isEmpty()) {
                            Criterion var;
                            try {
                                t = retornaVariavel(t);
                                int teste = Integer.parseInt(valorVar.get(contador).trim());
                                var = Restrictions.eq(t, teste);
                            } catch (Exception ex) {
                                var = Restrictions.eq(t, valorVar.get(contador));
                            }
                            if (operacao.get(contador).equals("add")) {
                                c.add(var);
                            } else if (operacao.get(contador).equals("or")) {
                                or.add(var);
                            }

                        }
                    }
                }

                contador++;
            }

            Criterion[] as = new Criterion[or.size()];
            int cont = 0;
            for (Criterion valorTemp : or) {
                as[cont] = valorTemp;
                cont++;
            }

            c.add(Restrictions.or(as));
        }

        List<Object> lista = c.setFirstResult(start)
                .setMaxResults(length)
                .list();

        return lista;
    }

    public static String retornaVariavel(String t) {
        String local = "";
        String tamanho[] = t.split("\\.");
        if (tamanho.length > 1) {
            int p = 0;

            for (String tDois : tamanho) {
                p++;
                if (tamanho.length > 2) {
                    if (p == tamanho.length) {
                        local = local + "." + tDois;
                    } else {
                        if (p > 1) {
                            local = local + "_";
                        }

                        local = local + tDois;
                    }
                } else {
                    if (p > 1) {
                        local = local + "." + tDois;
                    } else {
                        local = tDois;
                    }

                }

            }
        } else {
            local = t;
        }
        return local;
    }

    @SuppressWarnings("unchecked")
    public Long totalTabela(String[] colunasNumericas, String[] colunas, String valor, String OrderByColumn, Object object, ArrayList<String> variavel, ArrayList<String> valorVar, String[] leftJoin, ArrayList<String> operacao) {
        Disjunction disjunction = Restrictions.disjunction();
        Criterion criterion;
        Criterion habilitado = Restrictions.eq("habilitado", true);
        ProjectionList proList = Projections.projectionList();
        Criteria c = session.createCriteria(object.getClass());

        //Procurando aliases.
        List<String> aliases = auxAliases(colunasNumericas);
        List<String> aliasesDois = auxAliases(colunas);
        List<String> aliasesTres = auxAliases(variavel);
        aliases.addAll(aliasesDois);
        aliases.addAll(aliasesTres);
        List<String> ultima = new ArrayList<String>();
        for (String temp : aliases) {
            if (!ultima.contains(temp)) {
                ultima.add(temp);
            }

        }

        //Criando aliases com left se necessario
        if (ultima != null & ultima.size() > 0) {
            for (String t : ultima) {
                int teste = 0;
                if (leftJoin != null) {
                    for (String a : leftJoin) {
                        if (t.indexOf(a) > -1) {
                            c.createAlias(t, t.replaceAll("\\.", "_"), JoinType.LEFT_OUTER_JOIN);
                            teste = 1;
                        }

                    }
                }
                if (teste == 0) {
                    c.createAlias(t, t.replaceAll("\\.", "_"));
                }

            }
        }
//Where
        if (valor != null && !valor.trim().isEmpty()) {
            for (String temp : colunas) {
                if (temp.indexOf("data") > -1) {
                    try {
                        // O valor é data .. Fazendo o tratamento necessário
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(sdf.parse(valor));
                        criterion = Restrictions.eq(temp, cal);
                        disjunction.add(criterion); //add your restirction here
                        c.add(disjunction);
                    } catch (ParseException e) {
                        //Nada
                    }
                } else {
                    criterion = Restrictions.ilike(temp, valor, MatchMode.ANYWHERE);
                    disjunction.add(criterion); //add your restirction here
                    c.add(disjunction);
                }

            }

        }
//Where numerico
        if (valor != null && !valor.trim().isEmpty()) {
            for (String temp : colunasNumericas) {
                try {
                    int total = Integer.parseInt(valor);
                    criterion = Restrictions.eq(temp, total);
                    disjunction.add(criterion); //add your restirction herere
                    c.add(disjunction);
                } catch (Exception ex) {

                }

            }
        }

        //Where dinamico
        if (variavel != null && operacao != null && valorVar != null) {
            int contador = 0;
            List<Criterion> or = new ArrayList<Criterion>();
            for (String t : variavel) {
                if (t.indexOf("data") > -1) {
                    Criterion var;
                    try {

                        // O valor é data .. Fazendo o tratamento necessário
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar cal = Calendar.getInstance();
                        Calendar calDois = Calendar.getInstance();
                        calDois.add(Calendar.DATE, 1);
                        cal.setTime(sdf.parse(valorVar.get(contador)));
                        var = Restrictions.between(t, cal, calDois);
                        if (operacao.get(contador).equals("add")) {
                            c.add(var);

                        } else if (operacao.get(contador).equals("or")) {
                            or.add(var);
                        }
                    } catch (Exception e) {
                        //Nada
                        System.out.println(e);
                        //Is Null
                        if (valorVar.get(contador).equals("is_null")) {
                            if (operacao.get(contador).equals("add")) {
                                var = Restrictions.isNull(t);
                                c.add(var);
                            } else if (operacao.get(contador).equals("or")) {
                                var = Restrictions.isNull(t);
                                or.add(var);
                            }
                        }
                    }
                } else {
                    if (valorVar.get(contador) != null) {
                        if (!valorVar.get(contador).isEmpty()) {
                            Criterion var;
                            try {
                                t = retornaVariavel(t);
                                int teste = Integer.parseInt(valorVar.get(contador).trim());
                                var = Restrictions.eq(t, teste);
                            } catch (Exception ex) {
                                var = Restrictions.eq(t, valorVar.get(contador));
                            }
                            if (operacao.get(contador).equals("add")) {
                                c.add(var);
                            } else if (operacao.get(contador).equals("or")) {
                                or.add(var);
                            }

                        }
                    }
                }

                contador++;
            }

            Criterion[] as = new Criterion[or.size()];
            int cont = 0;
            for (Criterion valorTemp : or) {
                as[cont] = valorTemp;
                cont++;
            }

            c.add(Restrictions.or(as));
        }

        Long retorno = (Long) c.setProjection(Projections.countDistinct(OrderByColumn)).uniqueResult();

        return retorno;
    }

    public Long totalRecords(String column, Object object) {

        Criterion habilitado = Restrictions.eq("habilitado", true);
        Long retorno = (Long) session.createCriteria(object.getClass()).add(habilitado).setProjection(Projections.countDistinct(column)).uniqueResult();

        return retorno;
    }

    public List auxAliases(String[] buscarTabelas) {
        List<String> retorno = new ArrayList<String>();
        List<String> retornoDois = new ArrayList<String>();
        //Procurando aliases. Nos casos de tabelas relacional.!
        for (String aliases : buscarTabelas) {
            String[] tabela = aliases.split("\\.");
            if (tabela.length > 1) {
                int i = 0;
                String anterior = "";
                for (String tab : tabela) {
                    if ((i + 1) < tabela.length) {
                        if (i > 0) {
                            anterior = anterior + "." + tab;
                            retorno.add(anterior);
                        } else {
                            retorno.add(tab);
                            anterior = tab;
                        }

                    }
                    i++;
                }

            }

        }
        for (String ta : retorno) {
            String[] temp = ta.split("\\.");
            int i = 0;
            String alia = "";
            for (String g : temp) {
                if (temp.length > 1) {
                    i++;
                    if (i == 1) {
                        alia = g;
                    } else {
                        if (i == temp.length) {
                            alia = alia + "." + g;
                        } else {
                            alia = alia + "_" + g;
                        }
                    }

                } else {
                    alia = g;
                }
            }
            retornoDois.add(alia);
        }
        return retornoDois;
    }

    public List auxAliases(ArrayList<String> buscarTabelas) {
        List<String> retorno = new ArrayList<String>();
        List<String> retornoDois = new ArrayList<String>();
        //Procurando aliases. Nos casos de tabelas relacional.!
        for (String aliases : buscarTabelas) {
            String[] tabela = aliases.split("\\.");
            if (tabela.length > 1) {
                int i = 0;
                String anterior = "";
                for (String tab : tabela) {
                    if ((i + 1) < tabela.length) {
                        if (i > 0) {
                            anterior = anterior + "." + tab;
                            retorno.add(anterior);
                        } else {
                            retorno.add(tab);
                            anterior = tab;
                        }

                    }
                    i++;
                }

            }

        }
        for (String ta : retorno) {
            String[] temp = ta.split("\\.");
            int i = 0;
            String alia = "";
            for (String g : temp) {
                if (temp.length > 1) {
                    i++;
                    if (i == 1) {
                        alia = g;
                    } else {
                        if (i == temp.length) {
                            alia = alia + "." + g;
                        } else {
                            alia = alia + "_" + g;
                        }
                    }

                } else {
                    alia = g;
                }
            }
            retornoDois.add(alia);
        }
        return retornoDois;
    }
}
