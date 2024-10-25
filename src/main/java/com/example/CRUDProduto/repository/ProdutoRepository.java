package com.example.CRUDProduto.repository;

import com.example.CRUDProduto.model.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Produto produto){
        em.persist(produto);
    }

    public Produto produto(int id){
        return em.find(Produto.class, id);
    }
    public List<Produto> produtos(){
        Query query = em.createQuery("from Produto");
        return query.getResultList();
    }

    public void remove(int id){
        Produto p = em.find(Produto.class, id);
        em.remove(p);
    }
    public void update(Produto produto){
        em.merge(produto);
    }
    public List<Produto> findByDescricao(String descricao) {
        String jpql = "from Produto p where lower(p.descricao) like lower(:descricao)";
        Query query = em.createQuery(jpql);
        query.setParameter("descricao", "%" + descricao + "%");
        return query.getResultList();
    }
}
