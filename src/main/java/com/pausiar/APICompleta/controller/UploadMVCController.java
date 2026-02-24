package com.pausiar.APICompleta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadMVCController {

    private final Path uploadDir = Paths.get("upload-dir");

    @GetMapping("/upload")
    public String mostrarForm(Model model) {

        List<String> files = new ArrayList<>();

        try {
            Files.createDirectories(uploadDir);

            try (var stream = Files.list(uploadDir)) {
                stream.forEach(path -> {
                    String nom = path.getFileName().toString();
                    files.add(nom);
                });
            }

        } catch (Exception e) {
            // Si falla la lectura, es mostra igualment la pàgina sense llista
        }

        model.addAttribute("files", files);
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String pujar(@RequestParam("file") MultipartFile file,
                        RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Fitxer buit");
            return "redirect:/upload";
        }

        try {
            Files.createDirectories(uploadDir);

            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                redirectAttributes.addFlashAttribute("message", "Nom de fitxer no vàlid");
                return "redirect:/upload";
            }
            String filename = StringUtils.cleanPath(originalFilename);

            if (filename.contains("..")) {
                redirectAttributes.addFlashAttribute("message", "Nom de fitxer no vàlid");
                return "redirect:/upload";
            }

            Path destination = uploadDir.resolve(filename).normalize();
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            redirectAttributes.addFlashAttribute("message", "Fitxer pujat: " + filename);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error guardant el fitxer");
        }

        return "redirect:/upload";
    }

    @PostMapping("/upload/delete/{filename:.+}")
    public String eliminar(@PathVariable String filename,
                           RedirectAttributes redirectAttributes) {

        try {
            Path filePath = uploadDir.resolve(filename).normalize();

            // Evitem eixir de la carpeta d'uploads
            if (!filePath.startsWith(uploadDir)) {
                redirectAttributes.addFlashAttribute("message", "Nom de fitxer no vàlid");
                return "redirect:/upload";
            }

            boolean deleted = Files.deleteIfExists(filePath);

            if (deleted) {
                redirectAttributes.addFlashAttribute("message", "Fitxer eliminat: " + filename);
            } else {
                redirectAttributes.addFlashAttribute("message", "El fitxer no existix");
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error eliminant el fitxer");
        }

        return "redirect:/upload";
    }
}

