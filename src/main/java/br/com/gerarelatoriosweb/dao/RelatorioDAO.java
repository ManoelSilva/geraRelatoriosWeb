/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.dao;

import br.com.gerarelatoriosweb.factory.ConnectionFactory;
import br.com.gerarelatoriosweb.modelo.Erro;
import br.com.gerarelatoriosweb.modelo.Estoque;
import br.com.gerarelatoriosweb.modelo.EstoqueRelatorio;
import br.com.gerarelatoriosweb.modelo.EstoqueUsuario;
import br.com.gerarelatoriosweb.modelo.EstoqueUsuarioRelatorio;
import br.com.gerarelatoriosweb.modelo.Funcionario;
import br.com.gerarelatoriosweb.modelo.ItensOrdemServico;
import br.com.gerarelatoriosweb.modelo.ItensOrdemServicoRelatorio;
import br.com.gerarelatoriosweb.modelo.Multa;
import br.com.gerarelatoriosweb.modelo.MultaRelatorio;
import br.com.gerarelatoriosweb.modelo.OS;
import br.com.gerarelatoriosweb.modelo.Produto;
import br.com.gerarelatoriosweb.modelo.Rota;
import br.com.gerarelatoriosweb.modelo.ServicoProdutoRelacional;
import br.com.gerarelatoriosweb.modelo.ServicoProdutoRelacionalRelatorio;
import br.com.gerarelatoriosweb.modelo.Servicos;
import br.com.gerarelatoriosweb.modelo.Tecnico;
import br.com.gerarelatoriosweb.modelo.Vistoria;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author touti
 */
public class RelatorioDAO {

    private Connection conexao;

    public RelatorioDAO() throws ClassNotFoundException {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public List<ItensOrdemServicoRelatorio> getDataSourceRota(Integer tecnicoId) throws SQLException {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("SELECT distinct rota.data, funcionario.nome, "
                    + "tecnico.idSky, rota.id "
                    + "FROM tbos os "
                    + "inner join tbrotalog rota on os.rota_id = rota.id "
                    + "inner join tbtecnico tecnico on os.tecnico_id = tecnico.id "
                    + "inner join tbfuncionario funcionario on tecnico.funcionario_id = funcionario.id "
                    + "where tecnico.idSky = ?;");
            stmt.setInt(1, tecnicoId);

            List<ItensOrdemServicoRelatorio> listaItensOsRelatorio = new ArrayList<ItensOrdemServicoRelatorio>();
            ItensOrdemServicoRelatorio itensOsRelatorio = null;
            ItensOrdemServico itensOS = null;
            Rota rota = null;
            Tecnico tecnico = null;
            Funcionario funcionario = null;

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Calendar rotaData = Calendar.getInstance();
                rotaData.setTime(rs.getDate("data"));

                Integer rotaId = rs.getInt("id");

                String tecnicoNome = rs.getString("nome");
                String tecnicoCodigo = rs.getString("idSky");

                rota = new Rota();
                rota.setData(rotaData);
                rota.setId(rotaId);

                funcionario = new Funcionario();
                funcionario.setNome(tecnicoNome);

                tecnico = new Tecnico();
                tecnico.setIdSky(tecnicoCodigo);
                tecnico.setFuncionario(funcionario);

                itensOS = new ItensOrdemServico();
                itensOS.setRota(rota);
                itensOS.setTecnico(tecnico);

                itensOsRelatorio = new ItensOrdemServicoRelatorio(itensOS);

                listaItensOsRelatorio.add(itensOsRelatorio);
            }
            rs.close();
            stmt.close();
            return listaItensOsRelatorio;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItensOrdemServicoRelatorio> getListaOsDaRota(Integer tecnicoId) throws SQLException {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("select distinct os.id as OS, servicos.nome as Serviço from tbos os "
                    + "inner join tbitensordemservico itens on os.id = itens.os_id "
                    + "inner join tbsevicos servicos on itens.servico_id = servicos.id "
                    + "inner join tbtecnico tecnico on os.tecnico_id = tecnico.id "
                    + "where tecnico.idSky = ?;");
            stmt.setInt(1, tecnicoId);

            List<ItensOrdemServicoRelatorio> osLista = new ArrayList<ItensOrdemServicoRelatorio>();
            ItensOrdemServicoRelatorio itensOsRelatorio = null;
            ItensOrdemServico itensOS = null;
            OS os = null;
            Servicos servicos = null;

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Integer osID = rs.getInt("OS");
                String nome = rs.getString("Serviço");

                os = new OS();
                os.setId(osID);

                servicos = new Servicos();
                servicos.setNome(nome);

                itensOS = new ItensOrdemServico();
                itensOS.setOrdens(os);
                itensOS.setServico(servicos);

                itensOsRelatorio = new ItensOrdemServicoRelatorio(itensOS);
                osLista.add(itensOsRelatorio);
            }

            rs.close();
            stmt.close();
            return osLista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ServicoProdutoRelacionalRelatorio> getListaMaterialAretirar(Integer tecnicoId) throws SQLException {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("select os.id as OS, relacaoServProd.quantidade as Quantidade, "
                    + "produtos.nome as Material from tbos os "
                    + "inner join tbtecnico tecnico on os.tecnico_id = tecnico.id "
                    + "inner join tbitensordemservico ositens on os.id = ositens.os_id "
                    + "inner join tbsevicos servicos on ositens.servico_id = servicos.id "
                    + "inner join tbsevicos_tbprodutos relacaoServProd on servicos.id = relacaoServProd.servico_id "
                    + "inner join tbprodutos produtos on relacaoServProd.produto_id = produtos.id "
                    + "where tecnico.idSky = ?;");
            stmt.setInt(1, tecnicoId);

            List<ServicoProdutoRelacionalRelatorio> lista = new ArrayList<ServicoProdutoRelacionalRelatorio>();
            ServicoProdutoRelacionalRelatorio relacionalRelatorio = null;
            ServicoProdutoRelacional relacional = null;
            OS os = null;
            Produto produto = null;

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Integer osID = rs.getInt("OS");
                os = new OS();
                os.setId(osID);

                BigDecimal quantidade = rs.getBigDecimal("Quantidade");
                relacional = new ServicoProdutoRelacional();
                relacional.setQuantidade(quantidade);

                String nome = rs.getString("Material");
                produto = new Produto();
                produto.setNome(nome);
                relacional.setProduto(produto);

                relacionalRelatorio = new ServicoProdutoRelacionalRelatorio(relacional);
                relacionalRelatorio.setOs(os);
                lista.add(relacionalRelatorio);
            }

            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ServicoProdutoRelacionalRelatorio> getListaResumoMaterialAretirar(Integer tecnicoId) throws SQLException {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("select produtos.nome as Material, "
                    + "(sum(relacaoServProd.quantidade) - IFNULL(sum(estoque.estoque), 0)) "
                    + "as Quantidade from tbos os "
                    + "join tbitensordemservico ositens on os.id = ositens.os_id "
                    + "join tbtecnico tecnico on os.tecnico_id = tecnico.id "
                    + "join tbsevicos servicos on ositens.servico_id = servicos.id "
                    + "join tbsevicos_tbprodutos relacaoServProd on servicos.id = relacaoServProd.servico_id "
                    + "left join tbprodutos produtos on relacaoServProd.produto_id = produtos.id "
                    + "left join tbestoqueusuario estoque on (tecnico.id = estoque.tecnico_id) and (produtos.id=estoque.produto_id) "
                    + "where tecnico.idSky = ? "
                    + "group by produtos.nome having quantidade > 0;");
            stmt.setInt(1, tecnicoId);

            Produto produto = null;
            ServicoProdutoRelacional relacional = null;
            ServicoProdutoRelacionalRelatorio relacionalRelatorio = null;
            List<ServicoProdutoRelacionalRelatorio> produtosLista = new ArrayList<ServicoProdutoRelacionalRelatorio>();

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("Material");

                produto = new Produto();
                produto.setNome(nome);

                BigDecimal quantidade = rs.getBigDecimal("Quantidade");

                relacional = new ServicoProdutoRelacional();
                relacional.setProduto(produto);
                relacional.setQuantidade(quantidade);

                relacionalRelatorio = new ServicoProdutoRelacionalRelatorio(relacional);
                produtosLista.add(relacionalRelatorio);
            }

            rs.close();
            stmt.close();
            return produtosLista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EstoqueUsuarioRelatorio> getListaEstoqueDoTecnico(Integer tecnicoId) throws SQLException {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("select funcionario.nome as Nome, produtos.nome as Equipamento, "
                    + "estoque.estoque as Quantidade from tbtecnico tecnico "
                    + "inner join tbfuncionario funcionario on tecnico.funcionario_id = funcionario.id "
                    + "inner join tbestoqueusuario estoque on tecnico.id = estoque.tecnico_id "
                    + "inner join tbprodutos produtos on estoque.produto_id = produtos.id "
                    + "where tecnico.idSky = ?;");
            stmt.setInt(1, tecnicoId);

            List<EstoqueUsuarioRelatorio> lista = new ArrayList<EstoqueUsuarioRelatorio>();
            EstoqueUsuarioRelatorio estoqueUsuarioRelatorio = null;
            EstoqueUsuario estoqueUsuario = null;
            Tecnico tecnico = null;
            Funcionario funcionario = null;
            Produto produto = null;

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomeProduto = rs.getString("Equipamento");
                produto = new Produto();
                produto.setNome(nomeProduto);

                BigDecimal estoque = rs.getBigDecimal("Quantidade");
                String nome = rs.getString("Nome");

                estoqueUsuario = new EstoqueUsuario();
                tecnico = new Tecnico();
                funcionario = new Funcionario();

                funcionario.setNome(nome);
                tecnico.setFuncionario(funcionario);

                estoqueUsuario.setTecnico(tecnico);
                estoqueUsuario.setProduto(produto);
                estoqueUsuario.setEstoque(estoque);

                estoqueUsuarioRelatorio = new EstoqueUsuarioRelatorio(estoqueUsuario);
                lista.add(estoqueUsuarioRelatorio);
            }

            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EstoqueUsuarioRelatorio> getListaEstoqueDoTecnico() throws SQLException {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("select funcionario.nome as Nome, produtos.nome as Equipamento, "
                    + "estoque.estoque as Quantidade from tbtecnico tecnico "
                    + "inner join tbfuncionario funcionario on tecnico.funcionario_id = funcionario.id "
                    + "inner join tbestoqueusuario estoque on tecnico.id = estoque.tecnico_id "
                    + "inner join tbprodutos produtos on estoque.produto_id = produtos.id;");

            List<EstoqueUsuarioRelatorio> lista = new ArrayList<EstoqueUsuarioRelatorio>();
            EstoqueUsuarioRelatorio estoqueUsuarioRelatorio = null;
            EstoqueUsuario estoqueUsuario = null;
            Tecnico tecnico = null;
            Funcionario funcionario = null;
            Produto produto = null;

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomeProduto = rs.getString("Equipamento");
                produto = new Produto();
                produto.setNome(nomeProduto);

                BigDecimal estoque = rs.getBigDecimal("Quantidade");
                String nome = rs.getString("Nome");

                estoqueUsuario = new EstoqueUsuario();
                tecnico = new Tecnico();
                funcionario = new Funcionario();

                funcionario.setNome(nome);
                tecnico.setFuncionario(funcionario);

                estoqueUsuario.setTecnico(tecnico);
                estoqueUsuario.setProduto(produto);
                estoqueUsuario.setEstoque(estoque);

                estoqueUsuarioRelatorio = new EstoqueUsuarioRelatorio(estoqueUsuario);
                lista.add(estoqueUsuarioRelatorio);
            }

            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EstoqueRelatorio> getListaEstoqueGeral() {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("select produtos.nome, estoques.estoque from tbestoque estoques"
                    + " inner join tbprodutos produtos on estoques.produto_id = produtos.id;");
            List<EstoqueRelatorio> lista = new ArrayList<EstoqueRelatorio>();
            EstoqueRelatorio estoqueRelatorio = null;
            Estoque estoque = null;
            Produto produto = null;

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomeProduto = rs.getString("nome");
                produto = new Produto();
                produto.setNome(nomeProduto);

                BigDecimal quantidadeEstoque = rs.getBigDecimal("estoque");
                estoque = new Estoque();
                estoque.setEstoque(quantidadeEstoque);
                estoque.setProduto(produto);

                estoqueRelatorio = new EstoqueRelatorio(estoque);
                lista.add(estoqueRelatorio);
            }

            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MultaRelatorio> getListaMultas(String dataIni, String dataFim) {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("select funcionario.nome, erro.valor, vistoria.data from tbmulta multa"
                    + " inner join tbvistoria vistoria on multa.vistoria_id = vistoria.id"
                    + " inner join tberro erro on multa.erro_id = erro.id"
                    + " inner join tbos os on vistoria.os_id = os.id"
                    + " inner join tbtecnico tecnico on os.tecnico_id = tecnico.id"
                    + " inner join tbfuncionario funcionario on tecnico.funcionario_id = funcionario.id"
                    + " where vistoria.data between (str_to_date(?, '%d/ %m/ %Y')) and (str_to_date(?, '%d/ %m/ %Y'))"
                    + " order by funcionario.nome;");
            stmt.setString(1, dataIni);
            stmt.setString(2, dataFim);

            List<MultaRelatorio> lista = new ArrayList<MultaRelatorio>();
            MultaRelatorio multaRelatorio = null;
            Multa multa = null;
            Vistoria vistoria = null;
            Erro erro = null;
            OS os = null;
            Tecnico tecnico = null;
            Funcionario funcionario = null;

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomeFuncionario = rs.getString("nome");
                funcionario = new Funcionario();
                funcionario.setNome(nomeFuncionario);

                tecnico = new Tecnico();
                tecnico.setFuncionario(funcionario);

                os = new OS();
                os.setTecnico(tecnico);

                BigDecimal valor = rs.getBigDecimal("valor");
                erro = new Erro();
                erro.setValor(valor);

                Calendar rotaData = Calendar.getInstance();
                rotaData.setTime(rs.getDate("data"));

                vistoria = new Vistoria();
                vistoria.setData(rotaData);
                vistoria.setOs(os);

                multa = new Multa();
                multa.setErro(erro);
                multa.setVistoria(vistoria);

                multaRelatorio = new MultaRelatorio(multa);
                lista.add(multaRelatorio);
            }

            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
