/**
 * com.projetos.springpad.controller.pad.DeleteController
 * Apaga o registro identificado pelo `pad.id` (soft delete via status=DEL)
 */

package com.projetos.springpad.controller.pad;

import com.projetos.springpad.model.PadsModel;
import com.projetos.springpad.repository.PadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class DeleteController {

    @Autowired
    private PadsRepository padsRepository;

    @GetMapping("/apaga/{id}")
    public String deletePad(
            @PathVariable Long id,
            @CookieValue(value = "owner_uid", required = false) String ownerUid,
            RedirectAttributes redirectAttributes
    ) {
        // Busca o pad pelo ID
        Optional<PadsModel> optionalPad = padsRepository.findById(id);

        // Se não encontrado ou status não ON, redireciona para raiz (embora delete deva lidar com isso)
        if (optionalPad.isEmpty() || optionalPad.get().getStatus() != PadsModel.Status.ON) {
            return "redirect:/";
        }

        // Obtém os dados do registro
        PadsModel pad = optionalPad.get();

        // Verifica se o usuário logado é o owner
        boolean isOwner = false;
        if (ownerUid != null && !ownerUid.isEmpty() && pad.getOwnerModel() != null) {
            isOwner = ownerUid.equals(pad.getOwnerModel().getUid());
        }

        if (!isOwner) {
            // Não é owner: redireciona de volta para a view sem alterações
            return "redirect:/view/" + id;
        }

        // É owner: atualiza status para DEL (soft delete)
        pad.setStatus(PadsModel.Status.DEL);
        padsRepository.save(pad);

        // Adiciona mensagem flash para alert no home
        redirectAttributes.addFlashAttribute("successMessage", "\\\"" + pad.getTitle() + "\\\" excluído com sucesso!");

        // Redireciona para raiz
        return "redirect:/";
    }
}