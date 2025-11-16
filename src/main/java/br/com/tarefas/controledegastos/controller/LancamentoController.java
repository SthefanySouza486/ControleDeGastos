package br.com.tarefas.controledegastos.controller;

import br.com.tarefas.controledegastos.model.Lancamento;
import br.com.tarefas.controledegastos.model.TipoLancamento;
import br.com.tarefas.controledegastos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class LancamentoController {

    @Autowired
    private LancamentoRepository repository;

    private void carregarLancamentos(Model model) {
        List<Lancamento> lancamentos = repository.findAll();
        lancamentos.sort(Comparator.comparing(Lancamento::getData).reversed());
        model.addAttribute("lancamentos", lancamentos);
    }

    @GetMapping("/")
    public String index(Model model) {
        carregarLancamentos(model);
        model.addAttribute("novoLancamento", new Lancamento());
        model.addAttribute("tipos", TipoLancamento.values());
        model.addAttribute("lancamentoParaEditar", new Lancamento());
        return "index";
    }

    @PostMapping("/lancamentos")
    public String addLancamento(@ModelAttribute Lancamento novoLancamento, Model model) {
        repository.save(novoLancamento);
        carregarLancamentos(model);
        return "index :: lista-lancamentos";
    }

    @DeleteMapping("/lancamentos/{id}")
    public String deleteLancamento(@PathVariable Long id, Model model) {
        repository.deleteById(id);
        carregarLancamentos(model);
        return "index :: lista-lancamentos";
    }

    @GetMapping("/lancamentos/editar/{id}")
    public String editLancamento(@PathVariable Long id, Model model) {
        Optional<Lancamento> lancamentoOpt = repository.findById(id);
        if (lancamentoOpt.isPresent()) {
            model.addAttribute("lancamentoParaEditar", lancamentoOpt.get());
            model.addAttribute("tipos", TipoLancamento.values());
            return "index :: form-edicao";
        }
        return "index :: lista-lancamentos";
    }

    @PutMapping("/lancamentos/{id}")
    public String updateLancamento(@PathVariable Long id, @ModelAttribute Lancamento lancamentoAtualizado, Model model) {
        Optional<Lancamento> lancamentoOpt = repository.findById(id);
        if (lancamentoOpt.isPresent()) {
            Lancamento lancamentoExistente = lancamentoOpt.get();
            lancamentoExistente.setDescricao(lancamentoAtualizado.getDescricao());
            lancamentoExistente.setValor(lancamentoAtualizado.getValor());
            lancamentoExistente.setTipoLancamento(lancamentoAtualizado.getTipoLancamento());
            lancamentoExistente.setData(lancamentoAtualizado.getData());
            repository.save(lancamentoExistente);
        }
        carregarLancamentos(model);
        return "index :: lista-lancamentos";
    }
}
