package br.com.workconnect.controller;

import br.com.workconnect.model.Tip;
import br.com.workconnect.model.User;
import br.com.workconnect.security.CustomUserDetails;
import br.com.workconnect.service.TipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tips")
public class TipController {

    private final TipService tipService;

    @GetMapping
    public String listTips(Model model,
                           @RequestParam(defaultValue = "0") int page) {

        Page<Tip> tipsPage = tipService.getTipsPaginated(page, 5);
        model.addAttribute("tipsPage", tipsPage);
        model.addAttribute("currentPage", page);
        return "tips/list";
    }

    @GetMapping("/new")
    public String newTipForm(Model model) {
        model.addAttribute("tip", new Tip());
        return "tips/new";
    }

    @PostMapping("/new")
    public String createTip(@Valid @ModelAttribute("tip") Tip tip,
                            BindingResult result,
                            @AuthenticationPrincipal CustomUserDetails loggedUser,
                            Model model) {

        if (result.hasErrors()) {
            return "tips/new";
        }

        User user = loggedUser.getUser();
        tipService.createTip(tip, user);

        return "redirect:/tips?created";
    }

    @GetMapping("/{id}")
    public String viewTip(@PathVariable Long id, Model model) {
        Tip tip = tipService.findById(id);
        model.addAttribute("tip", tip);
        return "tips/detail";
    }
}
