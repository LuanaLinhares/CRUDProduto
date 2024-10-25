package com.example.CRUDProduto.controller;

import com.example.CRUDProduto.model.entity.Produto;
import com.example.CRUDProduto.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Transactional
@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository repository;

    @GetMapping("/form")
    public String form(Produto produto) {
        return "/produto/form";
    }

    @GetMapping("/list")
    public String listar(@RequestParam(value = "descricao", required = false) String descricao, ModelMap model) {
        if (descricao != null && !descricao.isEmpty()) {
            model.addAttribute("produtos", repository.findByDescricao(descricao));
        } else {
            model.addAttribute("produtos", repository.produtos());
        }
        return "/produto/list";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("produto") Produto produto) {
        repository.save(produto);
        return "redirect:/produto/list";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id) {
        repository.remove(id);
        return "redirect:/produto/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap model) {
        Produto produto = repository.produto(id);
        model.addAttribute("produto", produto);
        return "/produto/form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("produto") Produto produto) {
        repository.update(produto);
        return "redirect:/produto/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, ModelMap model) {
        Produto produto = repository.produto(id);
        if (produto == null) {
            // Se o produto não for encontrado, redireciona para a lista com uma mensagem de erro
            model.addAttribute("erro", "Produto não encontrado");
            return "redirect:/produto/list";
        }
        model.addAttribute("produto", produto);
        return "/produto/detail";
    }
}
